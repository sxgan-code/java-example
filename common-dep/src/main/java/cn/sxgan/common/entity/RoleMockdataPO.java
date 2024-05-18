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
* @Description: 角色实体
* @Author: sxgan
* @Date: 2024/5/18 19:16
* @Version: 1.0
**/
@Getter
@Setter
@Accessors(chain = true)
@TableName("mock_role")
public class RoleMockdataPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("role_code")
    private Integer roleCode;

    @TableField("description")
    private String description;

    @TableField("create_date")
    private Date createDate;

    @TableField("update_date")
    private Date updateDate;
}
