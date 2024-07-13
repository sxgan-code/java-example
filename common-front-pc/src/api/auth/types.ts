/**
 * 登录请求参数
 */
export interface LoginData {
    /**
     * 邮箱
     */
    email: string;
    /**
     * 密码
     */
    password: string;
    /**
     * 确认密码
     */
    rePassword?: string;

    /**
     * 验证码
     */
    verifyCode?: string;
    /**
     * 图片验证码文本
     */
    imgVerifyCode?: string;
    /**
     * 图片验证码token
     */
    vToken?: string;

    /**
     * 记住我
     */
    rememberMe?: boolean;


}

/**
 * 登录响应
 */
export interface LoginResult {
    /**
     * 访问token
     */
    token?: string;

    /* 图片验证vToken */
    verToken: string;

    /*图片*/
    base64Img: string;
}

/**
 * 验证码响应
 */
export interface VerifyCodeResult {
    /**
     * 验证码
     */
    verifyCode: string;
}

/**
 * SysUserVO，用户信息视图对象
 */
export interface SysUserVO {
    /**
     * 是否登录
     */
    isLogin?: boolean;
    /**
     * 头像路径
     */
    avatar?: string;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    delFlag?: string;
    /**
     * 部门ID
     */
    deptId?: string | null;
    /**
     * 用户邮箱
     */
    email?: string;
    /**
     * 手机号码
     */
    phoneNumber?: string;
    /**
     * 个性签名
     */
    personalSign?: string;
    /**
     * 备注
     */
    remark?: string;
    /**
     * 用户性别（0男 1女 2未知）
     */
    sex?: string;
    /**
     * 帐号状态（0正常 1停用）
     */
    status?: string;
    /**
     * 用户ID
     */
    userId?: string;
    /**
     * 用户昵称
     */
    userName?: string;
    /**
     * 用户类型（00系统用户 01普通用户）
     */
    userType?: string;
}

/**
 * UpdateUserData，请求用户更新数据
 */
export interface UpdateUserData {
    /**
     * 用户邮箱
     */
    email: string;
    /**
     * 个性签名
     */
    personalSign?: string;
    /**
     * 用户昵称
     */
    userName: string;
}