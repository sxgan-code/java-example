import type {AxiosResponse} from "axios";

/**
 * 扩展响应字段与后端对齐
 */
export interface ResponseResult<T> extends AxiosResponse<T> {
    /**
     * response timestamp.
     */
    timestamp: number;
    /**
     * response message.
     */
    message: string;

    /**
     * response data size.
     */
    total: number;
}

export enum ContentTypeEnum {
    // Application
    APP_XHTML_XML = 'application/xhtml+xml', //XHTML格式
    APP_XML = 'application/xml', // XML数据格式
    APP_ATOM_XML = 'application/atom+xml', //Atom XML聚合格式
    APP_JSON = 'application/json', // JSON数据格式
    APP_PDF = 'application/pdf', //pdf格式
    APP_MSWORD = 'application/msword', // Word文档格式
    APP_OCTET_STREAM = 'application/octet-stream', // 二进制流数据（如常见的文件下载）
    APP_X_WWW_FORM_URLENCODED = 'application/x-www-form-urlencoded', // <form encType=””>中默认的encType，form表单数据被编码为key/value格式发送到服务器（表单默认的提交数据的格式）
    // 图片文字相关
    TEXT_HTML = 'text/html',
    TEXT_PLAIN = 'text/plain', // 纯文本格式
    TEXT_XML = 'text/xml',
    IMAGE_GIF = 'image/gif',
    IMAGE_JPEG = 'image/jpeg',
    IMAGE_PNG = 'image/png',
    // 文件上传
    MULTIPART_FORM_DATA = 'multipart/form-data', // 需要在表单中进行文件上传时，就需要使用该格式
    // 文件下载
    // 流类型 文件扩展名 Content-Type(Mime-Type)
    BLOB = 'blob',
    ALL = 'application/octet-stream ',//（ 二进制流，不知道下载文件类型）
    TIF = 'image/tiff',
    AVI = 'video/avi',
    AWF = 'application/vnd.adobe.workflow',
    BIZ = 'text/xml',
    CLASS = 'java/*',
    CSI = 'application/x-csi',
    CSS = 'text/css',
    DOC = 'application/msword',
    DTD = 'text/xml',
    EXE = 'application/x-msdownload',
    GIF = 'image/gif',
    HTM = 'text/html',
    HTML = 'text/html',
    HTX = 'text/html',
    ICB = 'application/x-icb',
    ICON = 'image/x-icon',
    ICO = 'application/x-ico',
    JAVA = 'java/*',
    JFIF = 'image/jpeg',
    JPEG = 'image/jpeg',
    JPE = 'application/x-jpe',
    JPG = 'image/jpeg',
    MML = 'text/xml',
    MND = 'audio/x-musicnet-download',
    MNS = 'audio/x-musicnet-stream',
    MOCHA = 'application/x-javascript',
    MP3 = 'audio/mp3',
    MP4 = 'video/mpeg4',
    ODC = 'text/x-ms-odc',
    PNG = 'image/png',
    X_PNG = 'application/x-png',
    POT = 'application/vnd.ms-powerpoint',
    PPA = 'application/vnd.ms-powerpoint',
    PPM = 'application/x-ppm',
    PPS = 'application/vnd.ms-powerpoint',
    PPT = 'application/x-ppt',
    PRF = 'application/pics-rules',
    PRN = 'application/x-prn',
    PRT = 'application/x-prt',
    PS = 'application/x-ps',
    RGB = 'application/x-rgb',
    VDX = 'application/vnd.visio',
    WAV = 'audio/wav',
    WAX = 'audio/x-ms-wax',
    WM = 'video/x-ms-wm',
    WMV = 'video/x-ms-wmv',
    WMX = 'video/x-ms-wmx',
    WSC = 'text/scriptlet',
    WSDL = 'text/xml',
    WVX = 'video/x-ms-wvx',
    IPA = 'application/vnd.iphone',
    APK = 'application/vnd.android.package-archive',
    XAP = 'application/x-silverlight-app'
}