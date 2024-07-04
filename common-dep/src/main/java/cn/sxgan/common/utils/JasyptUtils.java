package cn.sxgan.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

import java.util.Scanner;

@Slf4j
public class JasyptUtils {
    public static void main(String[] args) {
        // 创建 Scanner 对象输入源
        Scanner scanner = new Scanner(System.in);
        log.info("请输入要加密的字符串：");
        while (scanner.hasNextLine()) {
            String plaintext = scanner.nextLine(); // 从文件读取一行数据
            String ciphertext = encrypt(plaintext);
            log.info("加密后的字符串为：");
            System.out.println(ciphertext);
            if (plaintext.equals("exit")) {
                break;
            }
            log.info("请输入要加密的字符串：");
        }
        scanner.close();
    }
    
    /**
     * 加密
     *
     * @param plaintext 明文
     * @return 加密后数据
     */
    public static String encrypt(String plaintext) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        // 指定算法
        config.setAlgorithm("PBEWithMD5AndDES");
        // 指定秘钥，和yml配置文件中保持一致
        config.setPassword("haha");
        encryptor.setConfig(config);
        // 生成加密数据
        return encryptor.encrypt(plaintext);
    }
    
    /**
     * 解密
     *
     * @param data 加密后数据
     * @return 明文
     */
    public static String decrypt(String data) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPassword("haha");
        encryptor.setConfig(config);
        // 解密数据
        return encryptor.decrypt(data);
    }
}