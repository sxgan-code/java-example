package cn.sxgan.base.excel.controller;

import cn.sxgan.base.excel.easyexcel.EasyExportFileService;
import cn.sxgan.base.excel.poi.PoiExportExcelService;
import cn.sxgan.common.anno.WorkTime;
import cn.sxgan.common.consts.FilePath;
import cn.sxgan.common.entity.UserMockdataPO;
import cn.sxgan.common.mappers.BdExpUserMockdataMapper;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 测试导出功能
 * @Author: sxgan
 * @Date: 2024-07-03 22:35
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/export")
@Tag(name = "springboot整合/整合EasyExcel", description = "整合EasyExcel")
public class TestExportController {
    
    @Autowired
    EasyExportFileService exportFileService;
    
    @Autowired
    PoiExportExcelService poiExportExcelService;
    
    @Resource
    BdExpUserMockdataMapper bdExpUserMockdataMapper;
    
    
    @Operation(summary = "获取全部用户excel", description = "获取全部用户excel")
    @GetMapping("/getUserExcelFile")
    @WorkTime(value = "导出用户Excel")
    public void exportUserByFixed(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("动态生成表头", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        
        // EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());
        // 动态表头
        ExcelWriterBuilder write = EasyExcel.write(response.getOutputStream());
        write.head(head()).sheet("模板").doWrite(this::data);
    }
    
    @Operation(summary = "获取全部用户excel通过模版的方式", description = "获取全部用户excel")
    @GetMapping("/getUserExcelFileByTemp")
    @WorkTime(value = "获取全部用户excel通过模版的方式")
    public void exportUserByTemp(HttpServletResponse response) throws IOException {
        String tempFile = FilePath.USER_EXCEL_TEMP_FILE_DIR + "用户清单模版.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("通过固定模版生成", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        
        // 模版表头导出
        EasyExcel.write(response.getOutputStream()).withTemplate(tempFile).sheet("用户列表").doFill(this::data);
    }
    
    @Operation(summary = "获取全部用户excel通过POI导出", description = "获取全部用户excel")
    @GetMapping("/getUserExcelFileByTempAndPoi")
    @WorkTime(value = "获取全部用户excel通过POI导出")
    public void getUserExcelFileByTempAndPoi(HttpServletResponse response) throws IOException {
        poiExportExcelService.exportExcel(response);
        
    }
    
    private List<Map<String, Object>> data() {
        List<UserMockdataPO> userMockdataPOS = bdExpUserMockdataMapper.selectList(new QueryWrapper<>());
        List<Map<String, Object>> data = new ArrayList<>();
        for (UserMockdataPO userMockdataPO : userMockdataPOS) {
            Map<String, Object> col = new HashMap<>();
            col.put("userId", userMockdataPO.getUserId().toString());
            col.put("userName", userMockdataPO.getUserName().toString());
            col.put("age", userMockdataPO.getAge().toString());
            col.put("email", userMockdataPO.getEmail().toString());
            col.put("gender", userMockdataPO.getGender().toString());
            col.put("ethnicity", userMockdataPO.getEthnicity().toString());
            col.put("jobTitle", userMockdataPO.getJobTitle().toString());
            col.put("address", userMockdataPO.getAddress().toString());
            col.put("createDate", userMockdataPO.getCreateDate().toString());
            col.put("city", userMockdataPO.getCity().toString());
            data.add(col);
        }
        return data;
    }
    
    private List<List<String>> head() {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> headuserId = new ArrayList<String>();
        List<String> headuserName = new ArrayList<String>();
        List<String> headage = new ArrayList<String>();
        List<String> heademail = new ArrayList<String>();
        List<String> headgender = new ArrayList<String>();
        List<String> headethnicity = new ArrayList<String>();
        List<String> headjobTitle = new ArrayList<String>();
        List<String> headaddress = new ArrayList<String>();
        List<String> headcreateDate = new ArrayList<String>();
        List<String> headcity = new ArrayList<String>();
        headuserId.add("用户id");
        headuserName.add("用户名");
        headage.add("年龄");
        heademail.add("邮箱");
        headgender.add("性别");
        headethnicity.add("民族");
        headjobTitle.add("工作");
        headaddress.add("地址");
        headcreateDate.add("创建时间");
        headcity.add("城市");
        list.add(headuserId);
        list.add(headuserName);
        list.add(headage);
        list.add(heademail);
        list.add(headgender);
        list.add(headethnicity);
        list.add(headjobTitle);
        list.add(headaddress);
        list.add(headcreateDate);
        list.add(headcity);
        return list;
    }
    
}
