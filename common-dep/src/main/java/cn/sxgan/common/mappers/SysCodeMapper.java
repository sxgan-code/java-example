package cn.sxgan.common.mappers;

import cn.sxgan.common.entity.SysCode;
import cn.sxgan.common.entity.SysCodeQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface SysCodeMapper extends BaseMapper<SysCode> {
    
    List<SysCode> selectConfigByCondition(SysCodeQuery sysCodeQuery);
}