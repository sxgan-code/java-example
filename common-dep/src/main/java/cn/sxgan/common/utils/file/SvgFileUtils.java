package cn.sxgan.common.utils.file;

import cn.sxgan.common.utils.StrUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @Description: Svg文件处理工具
 * @Author: sxgan
 * @Date: 2024-07-28 20:25
 * @Version: 1.0
 **/

public class SvgFileUtils {
    public static void main(String[] args) {
        File fileDir = new File("D:/Note/ElegantProject/DevResources/IconFonts/HarmonyOS_Icons");
        List<File> files = FileUtils.listAllFiles(fileDir);
        files.forEach(file -> svgFileToVueFile(file));
    }
    
    /**
     * 将svg文件转换为vue文件
     *
     * @param file 文件全路径
     */
    public static void svgFileToVueFile(File file) {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(file.getPath());
            Element rootElement = document.getRootElement();
            StringBuffer sb = new StringBuffer();
            String par = "<script setup lang=\"ts\">\n" +
                    "const props = defineProps({\n" +
                    "  fill: {type: String, default: '#FFFFFF', required: false},\n" +
                    "  width: {type: String, default: '2rem', required: false},\n" +
                    "  height: {type: String, default: '2rem', required: false},\n" +
                    "})" +
                    "</script>\n" +
                    "<template>\n";
            sb.append(par);
            String svgStr = rootElement.asXML();
            sb.append(svgStr);
            String next = "\n</template>\n" +
                    "<style scoped lang=\"scss\">\n" +
                    "svg {\n" +
                    "  width: v-bind(width);\n" +
                    "  height: v-bind(height);\n" +
                    "}\n" +
                    "</style>";
            sb.append(next);
            String titleStringValue = file.getName().split("\\.")[0];
            titleStringValue = titleStringValue.replaceAll(" ", "_");
            titleStringValue = StrUtils.underscoreToAllCamelCase("icon_" + titleStringValue.trim(), "-");
            titleStringValue = StrUtils.underscoreToAllCamelCase(titleStringValue, "_");
            FileUtils.uploadFile(sb.toString(), titleStringValue + ".vue");
            
            FileUtils.uploadFile("import " + titleStringValue + " from \"@/components/icons/huawei/" + titleStringValue + ".vue\";\n", "AllImport.txt");
            FileUtils.uploadFile("<" + titleStringValue + "/>\n", "AllName.txt");
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        
    }
}
