package cn.sxgan.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户实体
 * @Author: sxgan
 * @Date: 2024/5/18 19:14
 * @Version: 1.0
 **/
@Getter
@Setter
@Accessors(chain = true)
@ToString
@TableName("mock_user")
public class UserMockdataPO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    
    @TableField("user_name")
    private String userName;
    
    @TableField("age")
    private Integer age;
    
    @TableField("email")
    private String email;
    
    @TableField("gender")
    private String gender;
    
    @TableField("ethnicity")
    private String ethnicity;
    
    @TableField("job_title")
    private String jobTitle;
    
    @TableField("address")
    private String address;
    
    @TableField("create_date")
    private Date createDate;
    
    @TableField("city")
    private String city;
}
