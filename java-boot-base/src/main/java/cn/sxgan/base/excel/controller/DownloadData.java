package cn.sxgan.base.excel.controller;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Description: 下载头
 * @Author: sxgan
 * @Date: 2024-07-03 23:56
 * @Version: 1.0
 **/
@Data
public class DownloadData {
    @ExcelProperty("headuserId")
    private String headuserId;
    @ExcelProperty("headuserName")
    private String headuserName;
    @ExcelProperty("headage")
    private String headage;
    @ExcelProperty("heademail")
    private String heademail;
    @ExcelProperty("headgender")
    private String headgender;
    @ExcelProperty("headethnicity")
    private String headethnicity;
    @ExcelProperty("headjobTitle")
    private String headjobTitle;
    @ExcelProperty("headaddress")
    private String headaddress;
    @ExcelProperty("headcreateDate")
    private String headcreateDate;
    @ExcelProperty("headcity")
    private String headcity;
}
