package cn.sxgan.base.excel.controller;

import cn.sxgan.base.excel.easyexcel.ExportFileService;
import cn.sxgan.common.anno.WorkTime;
import cn.sxgan.common.entity.UserMockdataPO;
import cn.sxgan.common.mappers.BdExpUserMockdataMapper;
import com.alibaba.excel.EasyExcel;
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
import java.util.List;

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
    ExportFileService exportFileService;
    
    @Resource
    BdExpUserMockdataMapper bdExpUserMockdataMapper;
    
    @Operation(summary = "获取全部用户excel", description = "获取全部用户excel")
    @GetMapping("/getUserExcelFile")
    @WorkTime(value = "导出用户Excel")
    public void exportUser(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        
        // EasyExcel.write(fileName)
        
        //         // 这里放入动态头
        //         .head(head()).sheet("模板")
        //         // 当然这里数据也可以用 List<List<String>> 去传入
        //         .doWrite(data());
        EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());
    }
    
    private List<List<String>> data() {
        List<UserMockdataPO> userMockdataPOS = bdExpUserMockdataMapper.selectList(new QueryWrapper<>());
        List<List<String>> data = new ArrayList<>();
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
            data.add(col);
        }
        return data;
    }
    
    private List<List<String>> head() {
        List<List<String>> list = new ArrayList<List<String>>();
        // List<String> headuserId = new ArrayList<String>();
        // List<String> headuserName = new ArrayList<String>();
        // List<String> headage = new ArrayList<String>();
        // List<String> heademail = new ArrayList<String>();
        // List<String> headgender = new ArrayList<String>();
        // List<String> headethnicity = new ArrayList<String>();
        // List<String> headjobTitle = new ArrayList<String>();
        // List<String> headaddress = new ArrayList<String>();
        // List<String> headcreateDate = new ArrayList<String>();
        // List<String> headcity = new ArrayList<String>();
        // headuserId.add("userId");
        // headuserName.add("userName");
        // headage.add("age");
        // heademail.add("email");
        // headgender.add("gender");
        // headethnicity.add("ethnicity");
        // headjobTitle.add("jobTitle");
        // headaddress.add("address");
        // headcreateDate.add("createDate");
        // headcity.add("city");
        // list.add(headuserId);
        // list.add(headuserName);
        // list.add(headage);
        // list.add(heademail);
        // list.add(headgender);
        // list.add(headethnicity);
        // list.add(headjobTitle);
        // list.add(headaddress);
        // list.add(headcreateDate);
        // list.add(headcity);
        List<String> username = new ArrayList<String>();
        username.add("名字");
        List<String> age = new ArrayList<String>();
        age.add("年龄");
        list.add(username);
        list.add(age);
        return list;
    }
    
    
}
