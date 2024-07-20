package cn.sxgan.common.utils.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 二维码生成工具类
 * @Author: sxgan
 * @Date: 2024-07-19 22:06
 * @Version: 1.0
 **/
@Slf4j
public class QRCodeUtils {
    
    /* 设置级别 */
    private ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.M;
    
    private BarcodeFormat barcodeFormat = BarcodeFormat.QR_CODE;
    
    private int margin = 1;
    
    private int width = 300;
    
    private int height = 300;
    
    private String content;
    
    private File logoFile;
    
    
    private QRCodeUtils() {
    }
    
    
    public static QRCodeUtils getInstance() {
        return new QRCodeUtils();
    }
    
    
    private static final String CHARSET = "utf-8";
    
    /**
     * 初始化二维码配置
     *
     * @param content 内容:例如URL、文本等
     * @param margin  外边距
     * @param width   宽度
     * @param height  高度
     * @param level   纠错级别
     * @return QRCodeUtils
     */
    public QRCodeUtils setBaseConfig(String content,
                                     int margin,
                                     int width,
                                     int height,
                                     ErrorCorrectionLevel level) {
        if (StringUtils.isBlank(content)) {
            return null;
        }
        this.content = content;
        if (margin > 0) {
            this.margin = margin;
        }
        if (width > 0) {
            this.width = width;
        }
        if (height > 0) {
            this.height = height;
        }
        if (level != null) {
            this.errorCorrectionLevel = level;
        }
        return this;
    }
    
    /**
     * 设置logo
     *
     * @param logoFile logoFile
     * @return QRCodeUtils
     */
    public QRCodeUtils setLogo(File logoFile) {
        if (logoFile != null) {
            this.logoFile = logoFile;
        }
        return this;
    }
    
    /**
     * 设置logo
     *
     * @param barcodeFormat 二维码类型
     * @return QRCodeUtils
     */
    public QRCodeUtils setBarcodeFormat(BarcodeFormat barcodeFormat) {
        if (barcodeFormat != null) {
            this.barcodeFormat = barcodeFormat;
        }
        return this;
    }
    
    /**
     * 构建二维码
     *
     * @return BufferedImage
     */
    public BufferedImage build() {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Map<EncodeHintType, Object> map = new HashMap<>();
        map.put(EncodeHintType.ERROR_CORRECTION, errorCorrectionLevel);
        map.put(EncodeHintType.CHARACTER_SET, CHARSET);
        map.put(EncodeHintType.MARGIN, margin);
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(this.content, this.barcodeFormat, this.width, this.height, map);
            int w = bitMatrix.getWidth();
            int h = bitMatrix.getHeight();
            BufferedImage bufferImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < w; x++) {
                for (int y = 0; y < h; y++) {
                    bufferImg.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }
            if (logoFile != null) {
                return addLogo(bufferImg, logoFile);
            }
            return bufferImg;
        } catch (WriterException e) {
            log.error("二维码生成失败:", e);
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 添加logo
     *
     * @param bufferImg bufferImg
     * @param logoFile  logo文件
     * @return BufferedImage
     */
    private BufferedImage addLogo(BufferedImage bufferImg, File logoFile) {
        
        try {
            BufferedImage logo = ImageIO.read(logoFile);
            int width = bufferImg.getWidth();
            int height = bufferImg.getHeight();
            int scaleX = width / 4;
            int scaleY = height / 4;
            // 使用平滑缩放算法对原logo图像进行缩放得到一个全新的图像。
            Image scaledLogo = logo.getScaledInstance(scaleX, scaleY, Image.SCALE_SMOOTH);
            
            Graphics2D graphics = bufferImg.createGraphics();
            int x = (width - scaleX) / 2;
            int y = (height - scaleY) / 2;
            
            // 使用一个宽度为4像素的基本笔触
            graphics.setStroke(new BasicStroke(4f));
            // 设置阴影颜色
            Color shadowColor = new Color(0, 0, 0, 100);
            Color color = new Color(255, 255, 255, 255);
            // 绘制白底
            RoundRectangle2D bg = new RoundRectangle2D.Double(x - 8, y - 8, scaleX + 16, scaleY + 16, 10, 10);
            graphics.setColor(color);
            graphics.fill(bg);
            // 绘制阴影
            RoundRectangle2D shadow = new RoundRectangle2D.Double(x - 6, y - 6, scaleX + 12, scaleY + 12, 10, 10);
            graphics.setColor(shadowColor);
            graphics.fill(shadow);
            // 图片白边框
            Shape shape = new RoundRectangle2D.Double(x - 3, y - 3, scaleX + 6, scaleY + 6, 10, 10);
            graphics.setColor(color);
            graphics.fill(shape);
            // 给logo画圆角矩形
            graphics.draw(shape);
            graphics.drawImage(scaledLogo, x, y, null);
            
            // 释放画笔
            graphics.dispose();
            return bufferImg;
        } catch (IOException e) {
            log.error("二维码添加logo失败:", e);
            throw new RuntimeException(e);
        }
    }
    
    
}
