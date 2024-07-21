package cn.sxgan.common.utils.file;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @Description: 文件方法公共工具类
 * @Author: sxgan
 * @Date: 2024-07-21 18:37
 * @Version: 1.0
 **/

public class FileUtils {
    
    /**
     * 将字节数组转换为文件
     *
     * @param data 字节数组
     * @return 文件
     * @throws IOException IO异常
     */
    public static File convertToFile(byte[] data) throws IOException {
        // 使用java.nio.file.Files类创建一个临时文件
        Path tempFilePath = Files.createTempFile("prefix", "suffix");
        File tempFile = tempFilePath.toFile();
        
        // 将二进制数据写入到临时文件中
        try (FileOutputStream fos = new FileOutputStream(tempFile);
             InputStream is = new ByteArrayInputStream(data)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        }
        
        // 返回创建的临时文件对象
        return tempFile;
    }
    
}
