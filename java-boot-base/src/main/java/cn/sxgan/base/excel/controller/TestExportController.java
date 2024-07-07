package cn.sxgan.base.excel.controller;

import cn.sxgan.base.excel.easyexcel.EasyExportFileService;
import cn.sxgan.base.excel.poi.PoiExportExcelService;
import cn.sxgan.common.anno.WorkTime;
import cn.sxgan.common.mappers.BdExpUserMockdataMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
    EasyExportFileService easyExportFileService;
    
    @Autowired
    PoiExportExcelService poiExportExcelService;
    
    @Resource
    BdExpUserMockdataMapper bdExpUserMockdataMapper;
    
    @Operation(summary = "EasyExcel-下载用户Excel通过固定类表头", description = "获取全部用户excel")
    @GetMapping("/exportUserByFixedClass")
    @WorkTime(value = "EasyExcel-下载用户Excel-固定类表头")
    public void exportUserByFixed(HttpServletResponse response) throws IOException {
        easyExportFileService.exportUserByFixed(response);
        
    }
    
    @Operation(summary = "EasyExcel-下载用户Excel通过动态代码生成表头", description = "获取全部用户excel")
    @GetMapping("/exportUserByDynamicHead")
    @WorkTime(value = "下载用户Excel-通过EasyExcel动态代码生成表头")
    public void exportUserByDynamicHead(HttpServletResponse response) throws IOException {
        easyExportFileService.exportUserByDynamicHead(response);
        
    }
    
    @Operation(summary = "EasyExcel-下载用户Excel通过EasyExcel模版下载", description = "获取全部用户excel")
    @GetMapping("/getUserExcelFileByTemp")
    @WorkTime(value = "获取全部用户excel通过模版的方式")
    public void exportUserByTemp(HttpServletResponse response) throws IOException {
        easyExportFileService.exportUserByTemp(response);
        
    }
    
    @Operation(summary = "POI-获取全部用户excel通过模版", description = "获取全部用户excel")
    @GetMapping("/getUserExcelFileByTempAndPoi")
    @WorkTime(value = "获取全部用户excel通过POI导出")
    public void getUserExcelFileByTempAndPoi(HttpServletResponse response) throws IOException {
        poiExportExcelService.exportExcel(response);
        
    }
    
    
}
