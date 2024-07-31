package cn.sxgan.common.utils.file.watch;

import org.apache.commons.io.monitor.FileAlterationMonitor;

/**
 * @Description: 测试文件监听
 * @Author: sxgan
 * @Date: 2024-07-31 16:16
 * @Version: 1.0
 **/

public class FileListenerMainTest {
    public static void main(String[] args) {
        try {
            // 这里的业务代码要在系统启动时候就开始执行监听，并且该类都是做成单利模式，这里只是演示使用api就没有做的那么复杂
            FileListenerMonitor test = FileListenerMonitor.getInstance();
            
            FileAlterationMonitor monitor = test.getMonitor();
            monitor.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
