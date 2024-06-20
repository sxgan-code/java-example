package cn.sxgan.base.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Description: 集合的Stream流的几种创建方式
 * @Author: sxgan
 * @Date: 2024-06-20 15:12
 * @Version: 1.0
 **/
public class CreateStream {
    public static void main(String[] args) {
        // 1、通过Array数组的方式创建
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        // 创建一个顺序流
        Stream<String> stream1 = list.stream();
        // 创建一个并行流
        Stream<String> parallelStream = list.parallelStream();
        
        // 2、使用java.util.Arrays.stream(T[] array)方法用数组创建流
        int[] array = {1, 3, 5, 6, 7};
        IntStream stream2 = Arrays.stream(array);
        
        // 3、使用Stream的静态方法：of()、iterate()、generate()
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5, 6);
        // 从1开始，每个值2,最多生成10个
        Stream<Integer> stream4 = Stream.iterate(1, (x) -> x + 2).limit(10);
        stream4.forEach(System.out::println);
        // 生成随机的三个数
        Stream<Double> stream5 = Stream.generate(Math::random).limit(3);
        stream5.forEach(System.out::println);
        
        // 转并行流
        List<Integer> numList = Arrays.asList(11, 22, 33, 44, 55, 66);
        Optional<Integer> findFirst = numList.stream().parallel().filter(x -> x > 20).findFirst();
        System.out.println(findFirst.orElse(-1));
        
    }
    
    
}
