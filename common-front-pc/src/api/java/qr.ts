import request from '@/utils/http.ts';
import {getNowTimeOfFormData} from "@/utils/common-utils.ts";

/**
 * 获取普通二维码
 *
 * @returns
 */
export function getDefaultQrCodeApi(): Promise<Blob> {
    return request({
        url: "/qr/default/qrcode",
        method: "get",
        data: getNowTimeOfFormData(),
        headers: {
            "Content-Type": "application/json;charset=utf-8",
        },
        responseType: 'blob'
    });
}

/**
 * 获取普通二维码
 *
 * @returns
 */
export function getLogoQrCodeApi(): Promise<Blob> {
    return request({
        url: "/qr/logo/qrcode",
        method: "get",
        data: getNowTimeOfFormData(),
        headers: {
            "Content-Type": "application/json;charset=utf-8",
        },
        responseType: 'blob'
    });
}