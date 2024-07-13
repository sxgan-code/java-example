package cn.sxgan.common.utils;

import cn.sxgan.common.consts.CommonConst;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

@Slf4j
@Component
public class VerifyCodeUtils {
    private int w = 100;
    private int h = 30;
    private final SecureRandom r = new SecureRandom();
    // {"宋体", "华文楷体", "黑体", "华文新魏", "华文隶书", "微软雅黑", "楷体_GB2312"}
    private final String[] fontNames = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
    // 背景色
    private final Color bgColor = new Color(183, 201, 187);
    /*  返回验证码图片上的文本 */
    // 验证码上的文本
    @Getter
    private String text;
    
    @Getter
    private String Base64ImageStr;
    
    @Getter
    private String vToken;
    
    
    public VerifyCodeUtils() throws IOException {
        BufferedImage imageBI = this.getImage();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(imageBI, "png", baos);
        this.vToken = CommonUtils.generateRandomCode(10);
        this.Base64ImageStr = CommonConst.BASE64_HEAD_STR + Base64.getEncoder().encodeToString(baos.toByteArray());
    }
    
    // 生成随机的颜色
    private Color randomColor() {
        int red = r.nextInt(150);
        int green = r.nextInt(150);
        int blue = r.nextInt(150);
        return new Color(red, green, blue);
    }
    
    // 生成随机的字体
    private Font randomFont() {
        int index = r.nextInt(fontNames.length);
        String fontName = fontNames[index];// 生成随机的字体名称
        int style = r.nextInt(4);// 生成随机的样式, 0(无样式), 1(粗体), 2(斜体), 3(粗体+斜体)
        int size = r.nextInt(5) + 24; // 生成随机字号, 24 ~ 28
        return new Font(fontName, style, size);
    }
    
    // 画干扰线
    private void drawLine(BufferedImage image) {
        int num = 3;// 一共画3条
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; i++) {// 生成两个点的坐标，即4个值
            int x1 = r.nextInt(w);
            int y1 = r.nextInt(h);
            int x2 = r.nextInt(w);
            int y2 = r.nextInt(h);
            g2.setStroke(new BasicStroke(1.5F));
            g2.setColor(Color.BLUE); // 干扰线是蓝色
            g2.drawLine(x1, y1, x2, y2);// 画线
        }
    }
    
    // 随机生成一个字符
    private char randomChar() {
        // 可选字符
        String codes = "1234567890abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
        int index = r.nextInt(codes.length());
        return codes.charAt(index);
    }
    
    // 创建BufferedImage
    private BufferedImage createImage() {
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(this.bgColor);
        g2.fillRect(0, 0, w, h);
        return image;
    }
    
    /**
     * 调用这个方法得到验证码
     */
    public BufferedImage getImage() {
        BufferedImage image = createImage();// 创建图片缓冲区
        Graphics2D g2 = (Graphics2D) image.getGraphics();// 得到绘制环境
        StringBuilder sb = new StringBuilder();// 用来装载生成的验证码文本
        // 向图片中画4个字符
        for (int i = 0; i < 4; i++) {// 循环四次，每次生成一个字符
            String s = randomChar() + "";// 随机生成一个字母
            sb.append(s); // 把字母添加到sb中
            float x = i * 1.0F * w / 4; // 设置当前字符的x轴坐标
            g2.setFont(randomFont()); // 设置随机字体
            g2.setColor(randomColor()); // 设置随机颜色
            g2.drawString(s, x, h - 5); // 画图
        }
        this.text = sb.toString(); // 把生成的字符串赋给了this.text
        drawLine(image); // 添加干扰线
        return image;
    }
    
}