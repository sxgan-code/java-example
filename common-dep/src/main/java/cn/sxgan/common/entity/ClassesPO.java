package cn.sxgan.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
* @Description: 课程实体
* @Author: sxgan
* @Date: 2024/5/18 19:15
* @Version: 1.0
**/
@Getter
@Setter
@Accessors(chain = true)
@TableName("school_course")
public class ClassesPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("teacher")
    private String teacher;

    @TableField("start_date")
    private Date startDate;

    @TableField("end_date")
    private Date endDate;
}
