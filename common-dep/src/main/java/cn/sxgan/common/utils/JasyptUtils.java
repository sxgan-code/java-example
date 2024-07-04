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
        log.info("请输入全局密匙：");
        String key = scanner.nextLine();
        log.info("请输入你的操作：1.加密 2.解密 3.修改全局秘钥 4.退出");
        while (scanner.hasNextLine()) {
            String operation = scanner.nextLine();
            if (operation.equals("1")) {
                log.info("请输入要加密的字符串：");
                String plaintext = scanner.nextLine(); // 从文件读取一行数据
                String ciphertext = encrypt(plaintext, key);
                log.info("加密后的字符串为：");
                System.out.println(ciphertext);
            } else if (operation.equals("2")) {
                log.info("请输入要解密的字符串：");
                String plaintext = scanner.nextLine();
                String decrypted = decrypt(plaintext, key);
                log.info("解密后的字符串为：");
                System.out.println(decrypted);
            } else if (operation.equals("3")) {
                log.info("请输入你的更新密匙：");
                key = scanner.nextLine();
                log.info("全局密匙已经更改为-->{}", key);
            } else if (operation.equals("4")) {
                break;
            }
            log.info("请输入你的操作：1.加密 2.解密 3.修改全局秘钥 4.退出");
        }
        scanner.close();
    }
    
    /**
     * 加密
     *
     * @param plaintext 明文
     * @return 加密后数据
     */
    public static String encrypt(String plaintext, String key) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        // 指定算法
        config.setAlgorithm("PBEWithMD5AndDES");
        // 指定秘钥，和yml配置文件中保持一致
        config.setPassword(key);
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
    public static String decrypt(String data, String key) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPassword(key);
        encryptor.setConfig(config);
        // 解密数据
        return encryptor.decrypt(data);
    }
}