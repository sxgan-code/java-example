/**
 * @Description: 公共校验工具
 * @Author: sxgan
 * @Date: 2024/3/2 20:04
 * @Version: 1.0
 **/

/**
 * 检查字符串是否为所传类型，当类型正确返回true
 * @param str
 * @param type
 */
export enum VerifyTypeEnum {
    PHONE = 'phone', TEL = 'tel', CARD = 'card', PWD = 'pwd', POSTAL = 'postal',
    QQ = 'QQ', EMAIL = 'email', MONEY = 'money', URL = 'URL', IP = 'IP',
    DATE = 'date', NUMBER = 'number', ENGLISH = 'english', CHINESE = 'chinese',
    LOWER = 'lower', UPPER = 'upper', HTML = 'HTML',
}

export const verifyCheckStr = (str: string, type: VerifyTypeEnum) => {
    switch (type) {
        case 'phone':   //手机号码
            return /^1[3|4|5|6|7|8|9][0-9]{9}$/.test(str);
        case 'tel':     //座机
            return /^(0\d{2,3}-\d{7,8})(-\d{1,4})?$/.test(str);
        case 'card':    //身份证
            return /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(str);
        case 'pwd':     //密码以字母开头，长度在6~18之间，只能包含字母、数字和下划线
            return /^[a-zA-Z]\w{5,17}$/.test(str)
        case 'postal':  //邮政编码
            return /[1-9]\d{5}(?!\d)/.test(str);
        case 'QQ':      //QQ号
            return /^[1-9][0-9]{4,9}$/.test(str);
        case 'email':   //邮箱
            return /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/.test(str);
        case 'money':   //金额(小数点2位)
            return /^\d*(?:\.\d{0,2})?$/.test(str);
        case 'URL':     //网址
            return /(http|ftp|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&:/~\+#]*[\w\-\@?^=%&/~\+#])?/.test(str)
        case 'IP':      //IP
            return /((?:(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d))/.test(str);
        case 'date':    //日期时间
            return /^(\d{4})\-(\d{2})\-(\d{2}) (\d{2})(?:\:\d{2}|:(\d{2}):(\d{2}))$/.test(str) || /^(\d{4})\-(\d{2})\-(\d{2})$/.test(str)
        case 'number':  //数字
            return /^[0-9]$/.test(str);
        case 'english': //英文
            return /^[a-zA-Z]+$/.test(str);
        case 'chinese': //中文
            return /^[\\u4E00-\\u9FA5]+$/.test(str);
        case 'lower':   //小写
            return /^[a-z]+$/.test(str);
        case 'upper':   //大写
            return /^[A-Z]+$/.test(str);
        case 'HTML':    //HTML标记
            return /<("[^"]*"|'[^']*'|[^'">])*>/.test(str);
        default:
            return true;
    }
}

/**
 * 身份证校验
 * @param sId
 */
export const isCardID = (sId: any) => {
    if (!/(^\d{15}$)|(^\d{17}(\d|X|x)$)/.test(sId)) {
        console.log('你输入的身份证长度或格式错误')
        return false
    }
    //身份证城市
    let aCity: any = {
        11: "北京",
        12: "天津",
        13: "河北",
        14: "山西",
        15: "内蒙古",
        21: "辽宁",
        22: "吉林",
        23: "黑龙江",
        31: "上海",
        32: "江苏",
        33: "浙江",
        34: "安徽",
        35: "福建",
        36: "江西",
        37: "山东",
        41: "河南",
        42: "湖北",
        43: "湖南",
        44: "广东",
        45: "广西",
        46: "海南",
        50: "重庆",
        51: "四川",
        52: "贵州",
        53: "云南",
        54: "西藏",
        61: "陕西",
        62: "甘肃",
        63: "青海",
        64: "宁夏",
        65: "新疆",
        71: "台湾",
        81: "香港",
        82: "澳门",
        91: "国外"
    };
    if (!aCity[parseInt(sId.substr(0, 2))]) {
        console.log('你的身份证地区非法')
        return false
    }

    // 出生日期验证
    let sBirthday = (sId.substr(6, 4) + "-" + Number(sId.substr(10, 2)) + "-" + Number(sId.substr(12, 2))).replace(/-/g, "/"),
        d = new Date(sBirthday);
    if (sBirthday != (d.getFullYear() + "/" + (d.getMonth() + 1) + "/" + d.getDate())) {
        console.log('身份证上的出生日期非法')
        return false
    }

    // 身份证号码校验
    let sum = 0,
        weights = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2],
        codes = "10X98765432";
    for (let i = 0; i < sId.length - 1; i++) {
        sum += sId[i] * weights[i];
    }
    let last = codes[sum % 11]; //计算出来的最后一位身份证号码
    if (sId[sId.length - 1] != last) {
        console.log('你输入的身份证号非法')
        return false
    }

    return true
}

/**
 * VUE验证邮箱
 * @param s
 */
export const isEmail = (s: string) => {
    return /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(s)
}
/**
 * VUE验证手机号码
 * @param s
 */
export const isMobile = (s: string) => {
    return /^1[0-9]{10}$/.test(s)
}
/**
 * VUE验证电话号码
 * @param s
 */
export const isPhone = (s: string) => {
    return /^([0-9]{3,4}-)?[0-9]{7,8}$/.test(s)
}
/**
 * VUE验证是否url地址
 * @param s
 */
export const isURL = (s: string) => {
    return /^http[s]?:\/\/.*/.test(s)
}
/**
 * VUE验证是否字符串
 * @param o
 */
export const isString = (o: string) => {
    return Object.prototype.toString.call(o).slice(8, -1) === 'String'
}
/**
 * VUE验证是否数字
 * @param o
 */
export const isNumber = (o: string) => {
    return Object.prototype.toString.call(o).slice(8, -1) === 'Number'
}
/**
 * VUE验证是否boolean
 * @param o
 */
export const isBoolean = (o: string) => {
    return Object.prototype.toString.call(o).slice(8, -1) === 'Boolean'
}
/**
 * VUE验证是否函数
 * @param o
 */
export const isFunction = (o: string) => {
    return Object.prototype.toString.call(o).slice(8, -1) === 'Function'
}
/**
 * VUE验证是否为null
 * @param o
 */
export const isNull = (o: string) => {
    return Object.prototype.toString.call(o).slice(8, -1) === 'Null'
}
/**
 * VUE验证是否undefined
 * @param o
 */
export const isUndefined = (o: string) => {
    return Object.prototype.toString.call(o).slice(8, -1) === 'Undefined'
}
/**
 * VUE验证是否对象
 * @param o
 */
export const isObj = (o: string) => {
    return Object.prototype.toString.call(o).slice(8, -1) === 'Object'
}
/**
 * VUE验证是否数组
 * @param o
 */
export const isArray = (o: string) => {
    return Object.prototype.toString.call(o).slice(8, -1) === 'Array'
}
/**
 * VUE验证是否时间
 * @param o
 */
export const isDate = (o: string) => {
    return Object.prototype.toString.call(o).slice(8, -1) === 'Date'
}
/**
 * VUE验证是否正则
 * @param o
 */
export const isRegExp = (o: string) => {
    return Object.prototype.toString.call(o).slice(8, -1) === 'RegExp'
}
/**
 * VUE判断是否错误对象
 * @param o
 */
export const isError = (o: string) => {
    return Object.prototype.toString.call(o).slice(8, -1) === 'Error'
}
/**
 * VUE判断是否Symbol函数
 * @param o
 */
export const isSymbol = (o: string) => {
    return Object.prototype.toString.call(o).slice(8, -1) === 'Symbol'
}
/**
 * VUE判断是否Promise对象
 * @param o
 */
export const isPromise = (o: string) => {
    return Object.prototype.toString.call(o).slice(8, -1) === 'Promise'
}
/**
 * VUE判断是否Set对象
 * @param o
 */
export const isSet = (o: string) => {
    return Object.prototype.toString.call(o).slice(8, -1) === 'Set'
}
export const ua = navigator.userAgent.toLowerCase();
/**
 * VUE判断是否是移动端
 */
export const isDeviceMobile = () => {
    return /android|webos|iphone|ipod|balckberry/i.test(ua)
}
/**
 * VUE判断是否是QQ浏览器
 */
export const isQQBrowser = () => {
    return !!ua.match(/mqqbrowser|qzone|qqbrowser|qbwebviewtype/i)
}
/**
 * VUE判断是否是爬虫
 */
export const isSpider = () => {
    return /adsbot|googlebot|bingbot|msnbot|yandexbot|baidubot|robot|careerbot|seznambot|bot|baiduspider|jikespider|symantecspider|scannerlwebcrawler|crawler|360spider|sosospider|sogou web sprider|sogou orion spider/.test(ua)
}
/**
 * VUE判断是否ios
 */
export const isIos = () => {
    let u = navigator.userAgent;
    if (u.indexOf('Android') > -1 || u.indexOf('Linux') > -1) {  //安卓手机
        return false
    } else if (u.indexOf('iPhone') > -1) {//苹果手机
        return true
    } else if (u.indexOf('iPad') > -1) {//iPad
        return false
    } else if (u.indexOf('Windows Phone') > -1) {//winphone手机
        return false
    } else {
        return false
    }
}
/**
 * VUE判断是否为PC端
 */
export const isPC = () => {
    let userAgentInfo = navigator.userAgent;
    let Agents = ["Android", "iPhone",
        "SymbianOS", "Windows Phone",
        "iPad", "iPod"];
    let flag = true;
    for (let v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) {
            flag = false;
            break;
        }
    }
    return flag;
}
