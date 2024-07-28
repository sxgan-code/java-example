package cn.sxgan.common.utils.file;

import cn.sxgan.common.consts.FilePathConst;
import cn.sxgan.common.utils.StrUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 文件方法公共工具类
 * @Author: sxgan
 * @Date: 2024-07-21 18:37
 * @Version: 1.0
 **/
public class FileUtils {
    public static String FILENAME_PATTERN = "[a-zA-Z0-9_\\-\\|\\.\\u4e00-\\u9fa5]+";
    
    /**
     * 写入文件到指定目录
     */
    public static void uploadFile(String data, String name) {
        String filePath = FilePathConst.ROOT_DIR + "/a-doc/upload/file/" + name;
        writeADocument(data, filePath, true);
    }
    
    /**
     * 向一个文件写入字符内容
     *
     * @param data 写入的内容
     * @param path 文件路径
     * @param type 写入方式（true:追加，false:覆盖）
     */
    public static void writeADocument(String data, String path, boolean type) {
        try {
            FileWriter fileWriter = new FileWriter(path, type);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(data);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 写入一个图片
     *
     * @param data
     * @param dirurl
     * @param url
     * @param type
     * @return
     */
    public static String writeAImage(byte[] data, String dirurl, String url, boolean type) {
        String path = dirurl + url;
        String relativePath = url.replaceAll("\\\\", "/");
        
        try {
            // 添加如下代码
            path = java.net.URLDecoder.decode(path, "utf-8");
            File file = new File(path);
            
            file.mkdirs();
            if (!file.exists()) {
                file.createNewFile();
            } else {
                file.delete();
                file.createNewFile();
            }
            FileOutputStream fileWriter = new FileOutputStream(path, type);
            BufferedOutputStream bw = new BufferedOutputStream(fileWriter);
            bw.write(data);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativePath;
    }
    
    /**
     * 加载指定路径的文件，按行输出List数组
     *
     * @param path 文件路径
     * @return List<String>
     */
    public static List<String> loadFileToList(String path) {
        List<String> result = new ArrayList<String>();
        File file = new File(path);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            // 创建流对象
            BufferedReader br = new BufferedReader(fr);
            // 定义字符串,保存读取的一行文字
            String line = null;
            // 循环读取,读取到最后返回null
            while ((line = br.readLine()) != null) {
                result.add(line);
                System.out.print(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    
    /**
     * 获取文件夹下所有文件
     *
     * @param dir
     * @return
     */
    public static List<File> listAllFiles(File dir) {
        List<File> fileList = new ArrayList<>();
        File[] files = dir.listFiles();
        
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    fileList.addAll(listAllFiles(file));
                } else {
                    fileList.add(file);
                }
            }
        }
        
        return fileList;
    }
    
    
    /**
     * 复制文件到指定文件夹下
     *
     * @param sourceFile
     * @param targetDir
     */
    public static File copyFileToDir(File sourceFile, String targetDir) throws IOException {
        String[] split = sourceFile.getName().split("\\.");
        String fileName = sourceFile.getName();
        if (split.length == 2) {
            String name = StrUtils.trim(split[0], '-').trim();
            fileName = name + "." + split[1];
        }
        File file = new File(targetDir + File.separator + fileName);
        Files.copy(sourceFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        return file;
    }
    
    /**
     * 文件名根据文件路径获取后缀名
     *
     * @param filePath 字符串路径
     * @return 后缀名
     */
    public static String getFileExtension(String filePath) {
        // 路径处理
        filePath = filePath.replaceAll("\\\\", "/");
        if (filePath.contains("/")) {
            String[] split = filePath.split("/");
            filePath = split[split.length - 1];
        }
        if (filePath.contains(".")) {
            String[] split = filePath.split("\\.");
            return split[split.length - 1];
        }
        return "";
    }
    
    /**
     * 文件名根据文件路径获取后缀名
     *
     * @param file 文件类型路径
     * @return 后缀名
     */
    public static String getFileExtension(File file) {
        String filePath = file.getAbsolutePath();
        return getFileExtension(filePath);
    }
    
    
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
    
    
    /**
     * 输出指定文件的byte数组
     *
     * @param filePath 文件路径
     * @param os       输出流
     * @return
     */
    public static void writeBytes(String filePath, OutputStream os) throws IOException {
        FileInputStream fis = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException(filePath);
            }
            fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int length;
            while ((length = fis.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            IOUtils.close(os);
            IOUtils.close(fis);
        }
    }
    
    
    /**
     * 删除文件
     *
     * @param filePath 文件
     * @return
     */
    public static boolean deleteFile(String filePath) {
        boolean flag = false;
        File file = new File(filePath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            flag = file.delete();
        }
        return flag;
    }
    
    /**
     * 文件名称验证
     *
     * @param filename 文件名称
     * @return true 正常 false 非法
     */
    public static boolean isValidFilename(String filename) {
        return filename.matches(FILENAME_PATTERN);
    }
    
    /**
     * 检查文件是否可下载
     *
     * @param resource 需要下载的文件
     * @return true 正常 false 非法
     */
    public static boolean checkAllowDownload(String resource) {
        // 禁止目录上跳级别
        if (StringUtils.contains(resource, "..")) {
            return false;
        }
        
        // 检查允许下载的文件规则
        if (ArrayUtils.contains(MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION, FileTypeUtils.getFileType(resource))) {
            return true;
        }
        
        // 不在允许下载的文件规则
        return false;
    }
    
    /**
     * 下载文件名重新编码
     *
     * @param request  请求对象
     * @param fileName 文件名
     * @return 编码后的文件名
     */
    public static String setFileDownloadHeader(HttpServletRequest request, String fileName) throws UnsupportedEncodingException {
        final String agent = request.getHeader("USER-AGENT");
        String filename = fileName;
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            filename = new String(fileName.getBytes(), "ISO8859-1");
        } else if (agent.contains("Chrome")) {
            // google浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
    
    /**
     * 下载文件名重新编码
     *
     * @param response     响应对象
     * @param realFileName 真实文件名
     * @return
     */
    public static void setAttachmentResponseHeader(HttpServletResponse response, String realFileName) throws UnsupportedEncodingException {
        String percentEncodedFileName = percentEncode(realFileName);
        
        StringBuilder contentDispositionValue = new StringBuilder();
        contentDispositionValue.append("attachment; filename=")
                .append(percentEncodedFileName)
                .append(";")
                .append("filename*=")
                .append("utf-8''")
                .append(percentEncodedFileName);
        
        response.setHeader("Content-disposition", contentDispositionValue.toString());
    }
    
    /**
     * 百分号编码工具方法
     *
     * @param s 需要百分号编码的字符串
     * @return 百分号编码后的字符串
     */
    public static String percentEncode(String s) throws UnsupportedEncodingException {
        String encode = URLEncoder.encode(s, StandardCharsets.UTF_8.toString());
        return encode.replaceAll("\\+", "%20");
    }
    
    /**
     * 获取图像后缀
     *
     * @param photoByte 图像数据
     * @return 后缀名
     */
    public static String getFileExtendName(byte[] photoByte) {
        String strFileExtendName = "jpg";
        if ((photoByte[0] == 71) && (photoByte[1] == 73) && (photoByte[2] == 70) && (photoByte[3] == 56)
                && ((photoByte[4] == 55) || (photoByte[4] == 57)) && (photoByte[5] == 97)) {
            strFileExtendName = "gif";
        } else if ((photoByte[6] == 74) && (photoByte[7] == 70) && (photoByte[8] == 73) && (photoByte[9] == 70)) {
            strFileExtendName = "jpg";
        } else if ((photoByte[0] == 66) && (photoByte[1] == 77)) {
            strFileExtendName = "bmp";
        } else if ((photoByte[1] == 80) && (photoByte[2] == 78) && (photoByte[3] == 71)) {
            strFileExtendName = "png";
        }
        return strFileExtendName;
    }
    
    /**
     * 获取文件名称 /profile/upload/2022/04/16/ruoyi.png -- ruoyi.png
     *
     * @param fileName 路径名称
     * @return 没有文件路径的名称
     */
    public static String getName(String fileName) {
        if (fileName == null) {
            return null;
        }
        int lastUnixPos = fileName.lastIndexOf('/');
        int lastWindowsPos = fileName.lastIndexOf('\\');
        int index = Math.max(lastUnixPos, lastWindowsPos);
        return fileName.substring(index + 1);
    }
    
    /**
     * 获取不带后缀文件名称 /profile/upload/2022/04/16/ruoyi.png -- ruoyi
     *
     * @param fileName 路径名称
     * @return 没有文件路径和后缀的名称
     */
    public static String getNameNotSuffix(String fileName) {
        if (fileName == null) {
            return null;
        }
        String baseName = FilenameUtils.getBaseName(fileName);
        return baseName;
    }
    
}
