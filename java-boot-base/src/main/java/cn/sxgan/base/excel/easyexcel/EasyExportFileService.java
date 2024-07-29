package cn.sxgan.base.excel.easyexcel;

import cn.sxgan.base.excel.controller.DownloadData;
import cn.sxgan.common.consts.FilePathConst;
import cn.sxgan.common.entity.UserMockdataPO;
import cn.sxgan.common.mappers.BdExpUserMockdataMapper;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.common.utils.JsonUtils;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: easyexcel导出文件
 * @Author: sxgan
 * @Date: 2024-07-03 22:30
 * @Version: 1.0
 **/
@Service

public class EasyExportFileService {
    
    private static final Logger log = LoggerFactory.getLogger(EasyExportFileService.class);
    @Resource
    BdExpUserMockdataMapper bdExpUserMockdataMapper;
    
    public ResponseResult<String> exportUserExcel(HttpServletResponse response) {
        List<UserMockdataPO> userMockdataPOS = bdExpUserMockdataMapper.selectList(new QueryWrapper<>());
        return ResponseResult.success();
    }
    
    public void exportUserByFixed(HttpServletResponse response) {
        try {
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("下载用户Excel-通过固定类表头", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());
            // 动态表头
            ExcelWriterBuilder write = EasyExcel.write(response.getOutputStream(), DownloadData.class);
            write.sheet("模板").doWrite(this::data);
            response.getOutputStream().flush();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public void exportUserByDynamicHead(HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("下载用户Excel-通过动态代码生成表头", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            // EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());
            // 动态表头
            ExcelWriterBuilder write = EasyExcel.write(response.getOutputStream());
            write.head(head()).sheet("模板").doWrite(this::data);
            response.getOutputStream().flush();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        
    }
    
    public void exportUserByTemp(HttpServletResponse response) {
        try {
            String tempFile = FilePathConst.USER_EXCEL_TEMP_FILE_DIR + "用户清单模版.xlsx";
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("EasyExcel-下载用户Excel通过EasyExcel模版下载", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            // 模版表头导出
            EasyExcel.write(response.getOutputStream()).withTemplate(tempFile).sheet("用户列表").doFill(this::data2);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private List<DownloadData> data() {
        List<UserMockdataPO> userMockdataPOS = bdExpUserMockdataMapper.selectList(new QueryWrapper<>());
        String jsonString = JsonUtils.toJsonString(userMockdataPOS);
        log.info("jsonString:{}", jsonString);
        List<DownloadData> data = new ArrayList<>();
        for (UserMockdataPO userMockdataPO : userMockdataPOS) {
            DownloadData downloadData = new DownloadData();
            downloadData.setHeaduserId(userMockdataPO.getUserId().toString());
            downloadData.setHeaduserName(userMockdataPO.getUserName().toString());
            downloadData.setHeadage(userMockdataPO.getAge().toString());
            downloadData.setHeademail(userMockdataPO.getEmail().toString());
            downloadData.setHeadgender(userMockdataPO.getGender().toString());
            downloadData.setHeadethnicity(userMockdataPO.getEthnicity().toString());
            downloadData.setHeadjobTitle(userMockdataPO.getJobTitle().toString());
            downloadData.setHeadaddress(userMockdataPO.getAddress().toString());
            downloadData.setHeadcreateDate(userMockdataPO.getCreateDate().toString());
            downloadData.setHeadcity(userMockdataPO.getCity().toString());
            data.add(downloadData);
        }
        return data;
    }
    
    private List<Map<String, Object>> data2() {
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
