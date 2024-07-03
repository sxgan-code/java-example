package cn.sxgan.base.excel.easyexcel;

import cn.sxgan.common.entity.UserMockdataPO;
import cn.sxgan.common.mappers.BdExpUserMockdataMapper;
import cn.sxgan.common.response.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: easyexcel导出文件
 * @Author: sxgan
 * @Date: 2024-07-03 22:30
 * @Version: 1.0
 **/
@Service

public class ExportFileService {
    
    @Resource
    BdExpUserMockdataMapper bdExpUserMockdataMapper;
    
    public ResponseResult<String> exportUserExcel(HttpServletResponse response) {
        List<UserMockdataPO> userMockdataPOS = bdExpUserMockdataMapper.selectList(new QueryWrapper<>());
        return ResponseResult.success();
    }
    
}
