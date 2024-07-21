/**
 * @Description: 文件上传下载公共接口
 * @Author: sxgan
 * @Date: 2024/7/21 19:51
 * @Version: 1.0
 **/
import {ContentTypeEnum} from "@/api/common-types.ts";
import request from "@/utils/http.ts";

/**
 * @description 上传Logo文件生成二维码
 * @param data
 * @return 二进制文件流
 */
export function uploadFileGenQRApi(data: any): Promise<any> {
    var formData = new FormData();
    formData.append('logoFile', data)
    console.log(formData);
    return request({
        url: "/qr/loadlogo/qrcode",
        method: "post",
        data: formData,
        headers: {
            "Content-Type": ContentTypeEnum.APP_OCTET_STREAM,
        },
        responseType: ContentTypeEnum.BLOB
    });
}