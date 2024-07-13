import request from "@/utils/http";
import type {LoginData, LoginResult, SysUserVO, VerifyCodeResult} from "./types";
import type {ResponseResult} from "@/api/common-types.ts";

/**
 * 获取验证码
 */
export function sendMailVerifyCode(data: LoginData): Promise<ResponseResult<VerifyCodeResult>> {
    const requestJsonData = JSON.stringify(data)
    return request({
        url: "auth/mailVerifyCode",
        method: "post",
        data: requestJsonData,
        headers: {
            "Content-Type": "application/json;charset=utf-8",
        },
    });
}

/**
 * 注册API
 *
 * @param data {LoginData}
 * @returns
 */
export function signupApi(data: LoginData): Promise<ResponseResult<LoginResult>> {
    const requestJsonData = JSON.stringify(data)
    const formData = new FormData();
    formData.append("username", data.email);
    formData.append("password", data.password);
    formData.append("verifyCode", data.verifyCode || "");
    return request({
        url: "/auth/signup",
        method: "post",
        data: requestJsonData,
        headers: {
            "Content-Type": "application/json;charset=utf-8",
        },
    });
}

/**
 * 获取图片验证码
 *
 * @param data {LoginData}
 * @returns 校验图片
 */
export function verifyCodeImgApi(): Promise<ResponseResult<LoginResult>> {
    return request({
        url: "/auth/verifyCodeImg",
        method: "get",
        headers: {
            "Content-Type": "application/json;charset=utf-8",
            "Use-Timestamp": true,
        },
    });
}

/**
 * 登录API
 *
 * @param data {LoginData}
 * @returns
 */
export function signinApi(data: LoginData): Promise<ResponseResult<LoginResult>> {
    const requestJsonData = JSON.stringify(data)
    const formData = new FormData();
    formData.append("username", data.email);
    formData.append("password", data.password);
    return request({
        url: "/auth/signin",
        method: "post",
        data: requestJsonData,
        headers: {
            "Content-Type": "application/json;charset=utf-8",
            // "Content-Type": "multipart/form-data",
        },
    });
}

/**
 * 根据token获取用户信息
 */
export function getUserInfoApi(): Promise<ResponseResult<SysUserVO>> {
    return request({
        url: "/auth/getSysUserInfo",
        method: "get",
        data: new Date().getTime(),
        headers: {
            "Content-Type": "application/json;charset=utf-8",
        },
    });
}

/**
 * 根据token更新用户信息
 */
export function updateUserInfoApi(data: SysUserVO): Promise<ResponseResult<string>> {
    const requestJsonData = JSON.stringify(data)
    return request({
        url: "/card/auth/updateSysUserInfo",
        method: "post",
        data: requestJsonData,
        headers: {
            "Content-Type": "application/json;charset=utf-8",
        },
    });
}

