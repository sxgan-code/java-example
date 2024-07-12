package cn.sxgan.common.mappers;

import cn.sxgan.common.entity.SysUser;
import cn.sxgan.common.entity.query.SysUserQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    
    List<SysUser> selectUserByCondition(SysUserQuery sysUserQuery);
}