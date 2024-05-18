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
* @Description: 学生实体
* @Author: sxgan
* @Date: 2024/5/18 19:16
* @Version: 1.0
**/
@Getter
@Setter
@Accessors(chain = true)
@TableName("school_student")
public class StudentsPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("sex")
    private Integer sex;

    @TableField("email")
    private String email;

    @TableField("class_id")
    private Integer classId;

    @TableField("enrollment_date")
    private Date enrollmentDate;
}
