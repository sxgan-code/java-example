package cn.sxgan.base.auth.api;

import cn.sxgan.base.auth.entity.UserSessionInfo;
import cn.sxgan.common.entity.vo.SysUserVO;
import cn.sxgan.common.response.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 案例-权限校验控制器接口
 * @Author: sxgan
 * @Date: 24/7/12 17:32
 * @Version: 1.0
 **/
@Tag(name = "springboot案例/权限验证", description = "权限验证")
public interface IAuthControllerApi {
    
    @Operation(summary = "获取邮箱验证码", description = "请求邮箱验证码",
            parameters = {
                    @Parameter(name = "userSessionInfo", description = "用户会话对象", content = @Content(mediaType = "application/json", schema = @Schema(contentSchema = UserSessionInfo.class)))
            },
            responses = {
                    @ApiResponse(description = "返回验证码", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                    @ApiResponse(responseCode = "400", description = "返回400时错误")
            })
    ResponseResult<String> sendVerifyCode(UserSessionInfo userSessionInfo);
    
    @Operation(summary = "注册", description = "注册接口",
            parameters = {
                    @Parameter(name = "userSessionInfo", description = "用户会话对象", content = @Content(mediaType = "application/json", schema = @Schema(contentSchema = UserSessionInfo.class)))
            },
            responses = {
                    @ApiResponse(description = "返回注册结果", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                    @ApiResponse(responseCode = "400", description = "返回400时错误")
            })
    ResponseResult<Map<String, String>> signup(UserSessionInfo userSessionInfo);
    
    @Operation(summary = "获取登录图片验证码", description = "获取登录图片验证码",
            responses = {
                    @ApiResponse(description = "返回数据及Base64图片", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                    @ApiResponse(responseCode = "700~800", description = "系统权限校验业务错误")
            })
    ResponseResult<HashMap> getVerifyCodeImg(HttpServletResponse response);
    
    @Operation(summary = "登陆", description = "登陆接口",
            parameters = {
                    @Parameter(name = "userSessionInfo", description = "用户会话对象", content = @Content(mediaType = "application/json", schema = @Schema(contentSchema = UserSessionInfo.class)))
            },
            responses = {
                    @ApiResponse(description = "返回登录结果", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                    @ApiResponse(responseCode = "700~800", description = "系统权限校验业务错误")
            })
    ResponseResult<Map<String, String>> signin(UserSessionInfo userSessionInfo);
    
    @Operation(summary = "获取当前登录用户信息", description = "获取用户详细信息",
            responses = {
                    @ApiResponse(description = "返回用户信息视图对象", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SysUserVO.class))),
                    @ApiResponse(responseCode = "700", description = "返回700时错误")
            })
    ResponseResult<SysUserVO> getSysUserInfo();
    
    @Operation(summary = "更新用户", description = "更新用户",
            parameters = {
                    @Parameter(name = "sysUserVO", description = "用户信息视图对象", content = @Content(mediaType = "application/json", schema = @Schema(contentSchema = SysUserVO.class)))
            },
            responses = {
                    @ApiResponse(description = "返回提示信息", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                    @ApiResponse(responseCode = "707", description = "返回707时错误")
            })
    ResponseResult<String> updateSysUserInfo(SysUserVO sysUserVO);
}