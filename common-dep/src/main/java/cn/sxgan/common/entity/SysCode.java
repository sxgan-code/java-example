package cn.sxgan.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "sys_code")
@Schema(name = "SysCode", description = "系统代码配置实体")
public class SysCode {
    // 指定主键使用数据库ID自增策略
    @TableId(type = IdType.AUTO)
    @Schema(description = "配置ID", type = "String")
    private Long configId;
    @Schema(description = "配置的key", type = "String")
    private String configKey;
    @Schema(description = "配置的值。如果有多个，用逗号隔开", type = "String")
    private String configValue;
    @Schema(description = "配置类型", type = "String")
    private String configType;
    @Schema(description = "配置说明", type = "String")
    private String description;
    @Schema(description = "配置创建时间", type = "String")
    private Date createTime;
    @Schema(description = "配置更新时间", type = "String")
    private Date updateTime;
    @Schema(description = "删除标志：0-未删除，1-已删除", type = "Integer")
    private Integer delFlag;
}