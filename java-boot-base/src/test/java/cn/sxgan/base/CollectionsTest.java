package cn.sxgan.base;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 集合方法测试类
 * @Author: sxgan
 * @Date: 2024-07-12 10:51
 * @Version: 1.0
 **/
@Slf4j
public class CollectionsTest {
    
    public static void main(String[] args) {
        testContainsAll();
    }
    
    public static void testContainsAll() {
        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        arr1.add("10002");
        arr1.add("10001");
        arr1.add("10003");
        arr2.add("10003");
        arr2.add("10001");
        log.info("包含结果-->{}", arr1.containsAll(arr2));
        arr2.add("10006");
        log.info("包含结果-->{}", arr1.containsAll(arr2));
    }
}
