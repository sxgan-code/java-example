/// @filename: CommonUtils.ts
import router from "@/router/index"

const sourceDir = import.meta.env.VITE_APP_ENV === 'development' ? 'public' : 'dist'

/*路由跳转指定地址*/
export function goToRouter(path: string) {
    router.push({path: path})
}

export enum HrefTypeEnum {
    LOCAL_HREF = 'local_router',
    ONLINE_HREF = 'online_href'
}

export function goToHref(type: HrefTypeEnum, address: string) {
    if (type === HrefTypeEnum.LOCAL_HREF) {
        router.push({path: address})
    } else {
        window.open(address)
    }
}

/**
 * 这是一个睡眠方法
 * @param ms
 */
export async function sleep(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms))
}

/**
 * VUE随机数范围
 * @param min
 * @param max
 */
export const random = (min: number, max: number) => {
    return Math.floor(min + Math.random() * ((max + 1) - min))
}

/**
 * VUE去除html标签
 * @param str
 */
export const removeHtmltag = (str: string) => {
    return str.replace(/<[^>]+>/g, '')
}
/**
 * VUE获取url参数
 * @param name
 */
export const getQueryString = (name: string) => {
    const reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    const search = window.location.search.split('?')[1] || '';
    const r = search.match(reg) || [];
    return r[2];
}
/**
 * VUE动态引入js
 * @param src
 */
export const injectScript = (src: string) => {
    const s = document.createElement('script');
    s.type = 'text/javascript';
    s.async = true;
    s.src = src;
    const t = document.getElementsByTagName('script')[0];
    t.parentNode?.insertBefore(s, t);
}
/**
 * VUE根据url地址下载
 * @param url
 */
export const download = (url: string) => {
    var isChrome = navigator.userAgent.toLowerCase().indexOf('chrome') > -1;
    var isSafari = navigator.userAgent.toLowerCase().indexOf('safari') > -1;
    if (isChrome || isSafari) {
        var link = document.createElement('a');
        link.href = url;
        if (link.download !== undefined) {
            var fileName = url.substring(url.lastIndexOf('/') + 1, url.length);
            link.download = fileName;
        }
        if (document.createEvent) {
            var e = document.createEvent('MouseEvents');
            e.initEvent('click', true, true);
            link.dispatchEvent(e);
            return true;
        }
    }
    if (url.indexOf('?') === -1) {
        url += '?download';
    }
    window.open(url, '_self');
    return true;
}
/**
 * VUE判断el是否包含某个class
 * @param el
 * @param className
 */
export const hasClass = (el: any, className: string) => {
    let reg = new RegExp('(^|\\s)' + className + '(\\s|$)')
    return reg.test(el.className)
}
/**
 * VUE添加el某个class
 * @param el
 * @param className
 */
export const addClass = (el: any, className: string) => {
    if (hasClass(el, className)) {
        return
    }
    let newClass = el.className.split(' ')
    newClass.push(className)
    el.className = newClass.join(' ')
}
/**
 * VUE去除el某个class
 * @param el
 * @param className
 */
export const removeClass = (el: any, className: string) => {
    if (!hasClass(el, className)) {
        return
    }
    let reg = new RegExp('(^|\\s)' + className + '(\\s|$)', 'g')
    el.className = el.className.replace(reg, ' ')
}

/**
 * VUE滚动到顶部
 */
export const scrollToTop = () => {
    const c = document.documentElement.scrollTop || document.body.scrollTop;
    if (c > 0) {
        window.requestAnimationFrame(scrollToTop);
        window.scrollTo(0, c - c / 8);
    }
}
/**
 * VUE判断el是否在视口范围内
 * @param el
 * @param partiallyVisible
 */
export const elementIsVisibleInViewport = (el: any, partiallyVisible = false) => {
    const {top, left, bottom, right} = el.getBoundingClientRect();
    const {innerHeight, innerWidth} = window;
    return partiallyVisible
        ? ((top > 0 && top < innerHeight) || (bottom > 0 && bottom < innerHeight)) &&
        ((left > 0 && left < innerWidth) || (right > 0 && right < innerWidth))
        : top >= 0 && left >= 0 && bottom <= innerHeight && right <= innerWidth;
}
/**
 * VUE洗牌算法随机
 * @param arr
 */
export const shuffle = (arr: any) => {
    var result = [],
        random;
    while (arr.length > 0) {
        random = Math.floor(Math.random() * arr.length);
        result.push(arr[random])
        arr.splice(random, 1)
    }
    return result;
}
/**
 * VUE拦截粘贴板
 * @param value
 */
export const copyTextToClipboard = (value: string) => {
    var textArea = document.createElement("textarea");
    textArea.style.background = 'transparent';
    textArea.value = value;
    document.body.appendChild(textArea);
    textArea.select();
    try {
        var successful = document.execCommand('copy');
    } catch (err) {
        console.log('Oops, unable to copy');
    }
    document.body.removeChild(textArea);
}
/**
 * VUE严格的身份证校验
 * @param sId
 */
export const isCardID = (sId: any) => {
    if (!/(^\d{15}$)|(^\d{17}(\d|X|x)$)/.test(sId)) {
        console.log('你输入的身份证长度或格式错误')
        return false
    }
    //身份证城市
    var aCity: any = {
        11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江",
        31: "上海", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北",
        43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏",
        61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外"
    };
    if (!aCity[parseInt(sId.substr(0, 2))]) {
        console.log('你的身份证地区非法')
        return false
    }

    // 出生日期验证
    var sBirthday = (sId.substr(6, 4) + "-" + Number(sId.substr(10, 2)) + "-" + Number(sId.substr(12, 2))).replace(/-/g, "/"),
        d = new Date(sBirthday)
    if (sBirthday != (d.getFullYear() + "/" + (d.getMonth() + 1) + "/" + d.getDate())) {
        console.log('身份证上的出生日期非法')
        return false
    }

    // 身份证号码校验
    var sum = 0,
        weights = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2],
        codes = "10X98765432"
    for (var i = 0; i < sId.length - 1; i++) {
        sum += sId[i] * weights[i];
    }
    var last = codes[sum % 11]; //计算出来的最后一位身份证号码
    if (sId[sId.length - 1] != last) {
        console.log('你输入的身份证号非法')
        return false
    }
    return true
}

/**
 * VUE将阿拉伯数字翻译成中文的大写数字
 * @param num
 */
export const numberToChinese = (num: number) => {
    var AA = new Array("零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十");
    var BB = new Array("", "十", "百", "仟", "萬", "億", "点", "");
    var a: any = ("" + num).replace(/(^0*)/g, "").split("."),
        k = 0,
        re = "";
    for (var i = a[0].length - 1; i >= 0; i--) {
        switch (k) {
            case 0:
                re = BB[7] + re;
                break;
            case 4:
                if (!new RegExp("0{4}//d{" + (a[0].length - i - 1) + "}$")
                    .test(a[0]))
                    re = BB[4] + re;
                break;
            case 8:
                re = BB[5] + re;
                BB[7] = BB[5];
                k = 0;
                break;
        }
        if (k % 4 == 2 && a[0].charAt(i + 2) != 0 && a[0].charAt(i + 1) == 0)
            re = AA[0] + re;
        if (a[0].charAt(i) != 0)
            re = AA[a[0].charAt(i)] + BB[k % 4] + re;
        k++;
    }
    if (a.length > 1) // 加上小数部分(如果有小数部分)
    {
        re += BB[6];
        for (var i = 0; i < a[1].length; i++)
            re += AA[a[1].charAt(i)];
    }
    if (re == '一十')
        re = "十";
    if (re.match(/^一/) && re.length == 3)
        re = re.replace("一", "");
    return re;
}
/**
 * VUE将数字转换为大写金额
 * @param Num
 */
export const changeToChinese = (num: any) => {
    //判断如果传递进来的不是字符的话转换为字符
    if (typeof num == "number") {
        num = new String(num);
    }
    ;
    num = num.replace(/,/g, "") //替换tomoney()中的“,”
    num = num.replace(/ /g, "") //替换tomoney()中的空格
    num = num.replace(/￥/g, "") //替换掉可能出现的￥字符
    if (isNaN(num)) { //验证输入的字符是否为数字
        //alert("请检查小写金额是否正确");
        return "";
    }
    ;
    //字符处理完毕后开始转换，采用前后两部分分别转换
    var part = String(num).split(".");
    var newchar = "";
    //小数点前进行转化
    for (var i = part[0].length - 1; i >= 0; i--) {
        if (part[0].length > 10) {
            return "";
            //若数量超过拾亿单位，提示
        }
        var tmpnewchar: string = ""
        var perchar: any = part[0].charAt(i);
        switch (perchar) {
            case "0":
                tmpnewchar = "零" + tmpnewchar;
                break;
            case "1":
                tmpnewchar = "壹" + tmpnewchar;
                break;
            case "2":
                tmpnewchar = "贰" + tmpnewchar;
                break;
            case "3":
                tmpnewchar = "叁" + tmpnewchar;
                break;
            case "4":
                tmpnewchar = "肆" + tmpnewchar;
                break;
            case "5":
                tmpnewchar = "伍" + tmpnewchar;
                break;
            case "6":
                tmpnewchar = "陆" + tmpnewchar;
                break;
            case "7":
                tmpnewchar = "柒" + tmpnewchar;
                break;
            case "8":
                tmpnewchar = "捌" + tmpnewchar;
                break;
            case "9":
                tmpnewchar = "玖" + tmpnewchar;
                break;
        }
        switch (part[0].length - i - 1) {
            case 0:
                tmpnewchar = tmpnewchar + "元";
                break;
            case 1:
                if (perchar != 0) tmpnewchar = tmpnewchar + "拾";
                break;
            case 2:
                if (perchar != 0) tmpnewchar = tmpnewchar + "佰";
                break;
            case 3:
                if (perchar != 0) tmpnewchar = tmpnewchar + "仟";
                break;
            case 4:
                tmpnewchar = tmpnewchar + "万";
                break;
            case 5:
                if (perchar != 0) tmpnewchar = tmpnewchar + "拾";
                break;
            case 6:
                if (perchar != 0) tmpnewchar = tmpnewchar + "佰";
                break;
            case 7:
                if (perchar != 0) tmpnewchar = tmpnewchar + "仟";
                break;
            case 8:
                tmpnewchar = tmpnewchar + "亿";
                break;
            case 9:
                tmpnewchar = tmpnewchar + "拾";
                break;
        }
        var newchar = tmpnewchar + newchar;
    }
    //小数点之后进行转化
    if (num.indexOf(".") != -1) {
        if (part[1].length > 2) {
            // alert("小数点之后只能保留两位,系统将自动截断");
            part[1] = part[1].substr(0, 2)
        }
        for (i = 0; i < part[1].length; i++) {
            tmpnewchar = ""
            perchar = part[1].charAt(i)
            switch (perchar) {
                case "0":
                    tmpnewchar = "零" + tmpnewchar;
                    break;
                case "1":
                    tmpnewchar = "壹" + tmpnewchar;
                    break;
                case "2":
                    tmpnewchar = "贰" + tmpnewchar;
                    break;
                case "3":
                    tmpnewchar = "叁" + tmpnewchar;
                    break;
                case "4":
                    tmpnewchar = "肆" + tmpnewchar;
                    break;
                case "5":
                    tmpnewchar = "伍" + tmpnewchar;
                    break;
                case "6":
                    tmpnewchar = "陆" + tmpnewchar;
                    break;
                case "7":
                    tmpnewchar = "柒" + tmpnewchar;
                    break;
                case "8":
                    tmpnewchar = "捌" + tmpnewchar;
                    break;
                case "9":
                    tmpnewchar = "玖" + tmpnewchar;
                    break;
            }
            if (i == 0) tmpnewchar = tmpnewchar + "角";
            if (i == 1) tmpnewchar = tmpnewchar + "分";
            newchar = newchar + tmpnewchar;
        }
    }
    //替换所有无用汉字
    while (newchar.search("零零") != -1)
        newchar = newchar.replace("零零", "零");
    newchar = newchar.replace("零亿", "亿");
    newchar = newchar.replace("亿万", "亿");
    newchar = newchar.replace("零万", "万");
    newchar = newchar.replace("零元", "元");
    newchar = newchar.replace("零角", "");
    newchar = newchar.replace("零分", "");
    if (newchar.charAt(newchar.length - 1) == "元") {
        newchar = newchar + "整"
    }
    return newchar;
}
/**
 * VUE判断一个元素是否在数组中
 * @param arr
 * @param val
 */
export const contains = (arr: any, val: any) => {
    return arr.indexOf(val) != -1 ? true : false;
}
/**
 * VUE数组排序，{type} 1：从小到大 2：从大到小 3：随机
 * @param arr
 * @param type
 */
export const sort = (arr: any, type = 1) => {
    return arr.sort((a: number, b: number) => {
        switch (type) {
            case 1:
                return a - b;
            case 2:
                return b - a;
            case 3:
                return Math.random() - 0.5;
            default:
                return arr;
        }
    })
}
/**
 * VUE去重
 * @param arr
 */
export const unique = (arr: any) => {
    if (Array.hasOwnProperty('from')) {
        return Array.from(new Set(arr));
    } else {
        var n: any = {}, r: any = [];
        for (var i = 0; i < arr.length; i++) {
            if (!n[arr[i]]) {
                n[arr[i]] = true;
                r.push(arr[i]);
            }
        }
        return r;
    }
}

/**
 * VUE删除其中一个元素
 * @param arr
 * @param ele
 */
export const remove = (arr: any, ele: any) => {
    var index = arr.indexOf(ele);
    if (index > -1) {
        arr.splice(index, 1);
    }
    return arr;
}
/**
 * VUE将类数组转换为数组
 * @param ary
 */
export const formArray = (ary: any) => {
    var arr = [];
    if (Array.isArray(ary)) {
        arr = ary;
    } else {
        arr = Array.prototype.slice.call(ary);
    }
    ;
    return arr;
}
/**
 * VUE最大值计算
 * @param arr
 */
export const max = (arr: any) => {
    return Math.max.apply(null, arr);
}
/**
 * VUE最小值计算
 * @param arr
 */
export const min = (arr: any) => {
    return Math.min.apply(null, arr);
}
/**
 * VUE求和计算
 * @param arr
 */
export const sum = (arr: number[]) => {
    return arr.reduce((pre: number, cur: number) => {
        return pre + cur
    })
}
/**
 * VUE平均值计算
 * @param arr
 */
export const average = (arr: number[]) => {
    return sum(arr) / arr.length
}
/**
 * VUE去除空格,type: 1-所有空格 2-前后空格 3-前空格 4-后空格
 * @param str
 * @param type
 */
export const trim = (str: string, type: number) => {
    type = type || 1
    switch (type) {
        case 1:
            return str.replace(/\s+/g, "");
        case 2:
            return str.replace(/(^\s*)|(\s*$)/g, "");
        case 3:
            return str.replace(/(^\s*)/g, "");
        case 4:
            return str.replace(/(\s*$)/g, "");
        default:
            return str;
    }
}
/**
 * VUE字符转换，type: 1:首字母大写 2：首字母小写 3：大小写转换 4：全部大写 5：全部小写
 * @param str
 * @param type
 */
export const changeCase = (str: string, type: number) => {
    type = type || 4
    switch (type) {
        case 1:
            return str.replace(/\b\w+\b/g, function (word) {
                return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();

            });
        case 2:
            return str.replace(/\b\w+\b/g, function (word) {
                return word.substring(0, 1).toLowerCase() + word.substring(1).toUpperCase();
            });
        case 3:
            return str.split('').map(function (word) {
                if (/[a-z]/.test(word)) {
                    return word.toUpperCase();
                } else {
                    return word.toLowerCase()
                }
            }).join('')
        case 4:
            return str.toUpperCase();
        case 5:
            return str.toLowerCase();
        default:
            return str;
    }
}
/**
 * VUE检测密码强度
 * @param str
 */
export const checkPwd = (str: string) => {
    var Lv = 0;
    if (str.length < 6) {
        return Lv
    }
    if (/[0-9]/.test(str)) {
        Lv++
    }
    if (/[a-z]/.test(str)) {
        Lv++
    }
    if (/[A-Z]/.test(str)) {
        Lv++
    }
    if (/[\.|-|_]/.test(str)) {
        Lv++
    }
    return Lv;
}

/**
 * VUE在字符串中插入新字符串
 * @param soure
 * @param index
 * @param newStr
 */
export const insertStr = (soure: string, index: number, newStr: string) => {
    var str = soure.slice(0, index) + newStr + soure.slice(index);
    return str;
}
/**
 * VUE判断两个对象是否键值相同
 * @param a
 * @param b
 */
export const isObjectEqual = (a: any, b: any) => {
    var aProps = Object.getOwnPropertyNames(a);
    var bProps = Object.getOwnPropertyNames(b);

    if (aProps.length !== bProps.length) {
        return false;
    }

    for (var i = 0; i < aProps.length; i++) {
        var propName = aProps[i];

        if (a[propName] !== b[propName]) {
            return false;
        }
    }
    return true;
}
/**
 * VUE 16进制颜色转RGBRGBA字符串
 * @param val
 * @param opa
 */
export const colorToRGB = (val: string, opa: string) => {

    var pattern = /^(#?)[a-fA-F0-9]{6}$/; //16进制颜色值校验规则
    var isOpa = typeof opa == 'number'; //判断是否有设置不透明度

    if (!pattern.test(val)) { //如果值不符合规则返回空字符
        return '';
    }

    var v = val.replace(/#/, ''); //如果有#号先去除#号
    var rgbArr = [];
    var rgbStr = '';

    for (var i = 0; i < 3; i++) {
        var item = v.substring(i * 2, i * 2 + 2);
        var num = parseInt(item, 16);
        rgbArr.push(num);
    }

    rgbStr = rgbArr.join();
    rgbStr = 'rgb' + (isOpa ? 'a' : '') + '(' + rgbStr + (isOpa ? ',' + opa : '') + ')';
    return rgbStr;
}

/**
 * 判断所传值是否为空
 * 使用示例：
 * isEmpty(null)); // true
 * isEmpty(undefined)); // true
 * isEmpty('')); // true
 * isEmpty([])); // true
 * isEmpty({})); // true
 * isEmpty('Hello')); // false
 * isEmpty([1, 2, 3])); // false
 * isEmpty({ key: 'value' })); // false
 * @param value
 */
export function isEmpty(value: any): boolean {
    // 检查值是否为空
    return (
        value === null ||
        value === undefined ||
        value === '' ||
        (Array.isArray(value) && value.length === 0) ||
        (typeof value === 'object' && Object.keys(value).length === 0)
    );
}

/**
 * 判断所传值是否为空,空则返回旧值，否则返回所传值
 * @param newVal 新值
 * @param oldVal 旧值
 */
export function isEmptyReturnOldData(newVal: any, oldVal: any): any {
    // 检查值是否为空
    return (newVal === null ||
        newVal === undefined ||
        newVal === '' ||
        (Array.isArray(newVal) && newVal.length === 0) ||
        (typeof newVal === 'object' && Object.keys(newVal).length === 0)
    ) ? oldVal : newVal;
}

/**
 * 判断两个对象是否一致
 * @param o1
 * @param o2
 */
export const objectIsEqual = (o1: any, o2: any): boolean => {
    for (const key of Object.keys(o1)) { //遍历对象的key
        // 找到公共的key
        if (o1[key] !== o2[key]) {
            return false;
        }

    }
    return true;
}