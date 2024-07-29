package cn.sxgan.base.qr;

import cn.sxgan.common.anno.RequestAroundLog;
import cn.sxgan.common.anno.WorkTime;
import cn.sxgan.common.consts.FilePathConst;
import cn.sxgan.common.utils.file.FileUtils;
import cn.sxgan.common.utils.qrcode.QRCodeUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Description: 二维码测试接口
 * @Author: sxgan
 * @Date: 2024-07-19 22:46
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/qr")
@Tag(name = "springboot案例/QRCode二维码生成", description = "QRCode二维码生成")
public class QRCodeTestController {
    
    /**
     * qr生成普通黑白二维码
     */
    @Operation(
            summary = "qr生成普通黑白二维码",
            description = "qr生成普通黑白二维码"
    )
    @GetMapping("/default/qrcode")
    @RequestAroundLog
    public void getDefaultQR(HttpServletResponse response) {
        BufferedImage bufferedImage = QRCodeUtils.getInstance().setBaseConfig("https://gitee.com/sxgan?time=" +
                        new Date().getTime(), 1,
                200, 200, ErrorCorrectionLevel.H).build();
        ServletOutputStream outputStream = null;
        // 设置响应头
        response.setContentType("image/png");
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(bufferedImage, "png", outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * qr生成带logo黑白二维码
     */
    @Operation(
            summary = "qr生成带logo黑白二维码",
            description = "qr生成带logo黑白二维码"
    )
    @GetMapping("/logo/qrcode")
    @RequestAroundLog
    public void getLogoQR(HttpServletResponse response) {
        String logoFile = FilePathConst.ROOT_DIR + "/a-doc/file/images/qrlogo.png";
        BufferedImage bufferedImage = QRCodeUtils.getInstance()
                .setBaseConfig("https://gitee.com/sxgan?time=" +
                        new Date().getTime(), 1, 300, 300, ErrorCorrectionLevel.H)
                .setLogo(new File(logoFile))
                .setBarcodeFormat(BarcodeFormat.QR_CODE)
                .build();
        ServletOutputStream outputStream = null;
        // 设置响应头
        response.setContentType("image/png");
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(bufferedImage, "png", outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * qr生成带logo黑白二维码
     */
    @Operation(
            summary = "qr生成上传logo黑白二维码",
            description = "qr生成上传logo黑白二维码",
            parameters = {
                    @Parameter(name = "logoFile", description = "Logo文件", content = @Content(mediaType = "application/octet-stream", schema = @Schema(contentSchema = MultipartFile.class)))
            }
    )
    @PostMapping("/loadlogo/qrcode")
    @WorkTime("qr生成上传logo黑白二维码")
    public void getUploadLogoQR(@RequestParam("logoFile") MultipartFile logoFile, HttpServletResponse response) {
        ServletOutputStream outputStream = null;
        // 设置响应头
        // response.setContentType("image/png");
        try {
            File file = FileUtils.convertToFile(logoFile.getBytes());
            BufferedImage bufferedImage = QRCodeUtils.getInstance()
                    .setBaseConfig("https://gitee.com/sxgan?time=" +
                            new Date().getTime(), 1, 300, 300, ErrorCorrectionLevel.H)
                    .setLogo(file)
                    .setBarcodeFormat(BarcodeFormat.QR_CODE)
                    .build();
            outputStream = response.getOutputStream();
            ImageIO.write(bufferedImage, "png", outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}

