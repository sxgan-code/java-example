package cn.sxgan.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * @Description: 实时监听文件改动
 * @Author: sxgan
 * @Date: 2024-06-17 23:36
 * @Version: 1.0
 **/
@Slf4j
public class WatchFileUtils {
    final private static String ROOT_DIR = System.getProperty("user.dir");
    final private static String FILE_DIR = ROOT_DIR + "/a-doc/test/watch/";
    
    public static void main(String[] args) {
        final Path path = Paths.get(FILE_DIR);
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE);
            
            while (true) {
                final WatchKey key = watchService.take();
                for (WatchEvent<?> watchEvent : key.pollEvents()) {
                    final WatchEvent.Kind<?> kind = watchEvent.kind();
                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        continue;
                    }
                    log.info("监听到变化。。。。。。。。");
                    // 该目录下创建了文件
                    if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                        log.info("当前目录新建了文件");
                    }
                    // 修改事件
                    if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                        log.info("当前目录下有文件修改");
                    }
                    // 删除文件
                    if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                        log.info("当前目录下有文件删除了");
                    }
                    final WatchEvent<Path> watchEventPath = (WatchEvent<Path>) watchEvent;
                    final Path filename = watchEventPath.context();
                    log.info("{}----->{}", kind, filename);
                }
                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
            
        } catch (IOException | InterruptedException ex) {
            System.err.println(ex);
        }
        
        
    }
}
