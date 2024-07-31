package cn.sxgan.common.utils.file.watch;


import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

public class FileListener extends FileAlterationListenerAdaptor {
    
    /**
     * 轮询开始
     */
    @Override
    public void onStart(FileAlterationObserver observer) {
        super.onStart(observer);
    }
    
    /**
     * 轮询结束
     */
    @Override
    public void onStop(FileAlterationObserver observer) {
        super.onStop(observer);
    }
    
    /**
     * 目录创建
     */
    @Override
    public void onDirectoryCreate(File directory) {
        super.onDirectoryCreate(directory);
        System.out.println("onDirectoryCreate : " + directory.getPath() + " | " + directory.getName());
    }
    
    /**
     * 目录修改
     */
    @Override
    public void onDirectoryChange(File directory) {
        super.onDirectoryChange(directory);
        System.out.println("onDirectoryChange : " + directory.getPath() + " | " + directory.getName());
    }
    
    /**
     * 目录删除
     */
    @Override
    public void onDirectoryDelete(File directory) {
        super.onDirectoryDelete(directory);
        System.out.println("onDirectoryDelete : " + directory.getPath() + " | " + directory.getName());
    }
    
    /**
     * 文件创建
     */
    @Override
    public void onFileCreate(File file) {
        super.onFileCreate(file);
        System.out.println("onFileCreate : " + file.getPath() + " | " + file.getName());
    }
    
    /**
     * 文件修改
     */
    @Override
    public void onFileChange(File file) {
        System.out.println("修改了" + file.getPath());
        super.onFileChange(file);
        System.out.println("onFileChange : " + file.getPath() + " | " + file.getName());
    }
    
    /**
     * 文件删除
     */
    @Override
    public void onFileDelete(File file) {
        super.onFileDelete(file);
        System.out.println("onFileDelete : " + file.getPath() + " | " + file.getName());
    }
    
}
