package cn.sxgan.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 入学实体
 * @Author: sxgan
 * @Date: 2024/5/18 19:18
 * @Version: 1.0
 **/
@Getter
@Setter
@Accessors(chain = true)
@TableName("school_enrollments")
public class EnrollmentsPO implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    @TableId
    private Integer studentId;
    
    @TableField("class_id")
    private Integer classId;
    
    @TableField("enrollment_date")
    private Date enrollmentDate;
    
    @TableField("grade")
    private Double grade;
}
