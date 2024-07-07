package cn.sxgan.base.excel.poi;

import cn.sxgan.common.consts.FilePath;
import cn.sxgan.common.entity.UserMockdataPO;
import cn.sxgan.common.mappers.BdExpUserMockdataMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: POI方式导出Excel
 * @Author: sxgan
 * @Date: 2024-07-05 23:29
 * @Version: 1.0
 **/
@Slf4j
@Service
public class PoiExportExcelService {
    
    @Resource
    BdExpUserMockdataMapper bdExpUserMockdataMapper;
    
    public void exportExcel(HttpServletResponse response) {
        try {
            String tempFile = FilePath.USER_EXCEL_TEMP_FILE_DIR + "用户清单模版.xlsx";
            // 制作数据
            Workbook wb = WorkbookFactory.create(new FileInputStream(tempFile));
            List<UserMockdataPO> userMockdataPOS = bdExpUserMockdataMapper.selectList(new QueryWrapper<>());
            wb = initData(wb, userMockdataPOS);
            // 导出
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("POI-获取全部用户excel通过模版", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            wb.write(response.getOutputStream());
            response.getOutputStream().flush();
            
        } catch (Exception e) {
            log.error("导出Excel异常", e);
        }
        
    }
    
    private Workbook initData(Workbook wb, List<UserMockdataPO> userMockdataPOS) {
        List<List<String>> list = new ArrayList<>();
        
        for (UserMockdataPO userMockdataPO : userMockdataPOS) {
            List<String> col = new ArrayList<>();
            col.add(userMockdataPO.getUserId().toString());
            col.add(userMockdataPO.getUserName().toString());
            col.add(userMockdataPO.getAge().toString());
            col.add(userMockdataPO.getEmail().toString());
            col.add(userMockdataPO.getGender().toString());
            col.add(userMockdataPO.getEthnicity().toString());
            col.add(userMockdataPO.getJobTitle().toString());
            col.add(userMockdataPO.getAddress().toString());
            col.add(userMockdataPO.getCreateDate().toString());
            col.add(userMockdataPO.getCity().toString());
            list.add(col);
        }
        
        Sheet sheet = wb.getSheet("用户列表");
        for (int i = 0; i < list.size(); i++) {
            Row row = sheet.getRow(i + 2);
            if (row == null) {
                row = sheet.createRow(i + 2);
            }
            
            for (int j = 0; j < list.get(i).size(); j++) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    cell = row.createCell(j);
                }
                cell.setCellValue(list.get(i).get(j));
            }
        }
        return wb;
    }
}
