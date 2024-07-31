package cn.sxgan.common.utils.file.watch;

import cn.sxgan.common.consts.FilePathConst;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileListenerMonitor {
    
    private FileListenerMonitor() {
    
    }
    
    private static FileListenerMonitor instance;
    
    public static final FileListenerMonitor getInstance() {
        if (instance == null) {
            synchronized (FileListenerMonitor.class) {
                if (instance == null) {
                    instance = new FileListenerMonitor();
                }
            }
        }
        return instance;
    }
    
    // 设置监听路径
    private final String monitorDir = FilePathConst.ROOT_DIR + "/a-doc/test/watch";
    
    // 设置轮询间隔
    private final long interval = TimeUnit.SECONDS.toMillis(3);
    
    public FileAlterationMonitor getMonitor() {
        System.out.println("当前监听目录为：" + FilePathConst.ROOT_DIR + "/a-doc/test/watch");
        // 创建过滤器
        // 1. 过滤可见目录
        // IOFileFilter directories = FileFilterUtils.and(FileFilterUtils.directoryFileFilter(), HiddenFileFilter.VISIBLE);
        // 2. 过滤以.txt结尾的文件，当该类型文件增删改时就会被监听到
        // IOFileFilter files = FileFilterUtils.and(FileFilterUtils.fileFileFilter(), FileFilterUtils.suffixFileFilter(".exe"));
        // 两个筛选条件满足一个时就监听
        // IOFileFilter filter = FileFilterUtils.or(directories, files);
        
        // 装配过滤器
        // FileAlterationObserver observer = new FileAlterationObserver(new File(monitorDir), filter);
        FileAlterationObserver observer = new FileAlterationObserver(new File(monitorDir));
        
        // 向监听者添加监听器，并注入业务服务
        observer.addListener(new FileListener());
        
        // 返回监听者
        return new FileAlterationMonitor(interval, observer);
    }
    
}
