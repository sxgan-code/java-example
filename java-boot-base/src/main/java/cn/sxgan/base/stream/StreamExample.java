package cn.sxgan.base.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: 关于Stream流的案例
 * @Author: sxgan
 * @Date: 2024-06-20 15:56
 * @Version: 1.0
 **/
@Slf4j
public class StreamExample {
    static List<Person> personList = new ArrayList<Person>();
    
    static {
        personList.add(new Person("Tom", 22, 7900, "male", "New York"));
        personList.add(new Person("Jack", 24, 7000, "male", "Washington"));
        personList.add(new Person("Lily", 27, 7800, "female", "Washington"));
        personList.add(new Person("Anni", 23, 8200, "female", "New York"));
        personList.add(new Person("Owen", 22, 9500, "male", "New York"));
        personList.add(new Person("Alisa", 21, 6900, "female", "New York"));
    }
    
    public static void main(String[] args) {
        // example_1();
        // example_2();
        // example_3();
        // example_4();
        // example_5();
        // example_6();
        // example_7();
        example_8();
        
    }
    
    
    /**
     * 1、案例一：遍历查找匹配
     */
    private static void example_1() {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(item -> log.info(item.toString()));
        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 2).findFirst();
        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 3).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x < 6);
        log.info("匹配第一个值：{}", findFirst.get());
        log.info("匹配任意一个值：{}", findAny.get());
        log.info("是否存在大于6的值：{}", anyMatch);
    }
    
    /**
     * 2、筛选（filter）
     */
    private static void example_2() {
        List<Integer> list = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        Stream<Integer> stream = list.stream();
        // 筛选出Integer集合中大于7的元素，并打印出来
        stream.filter(x -> x > 7).forEach(item -> log.info(item.toString()));
        
        // 筛选员工中工资高于8000的人，并形成新的集合。形成新集合依赖collect（收集），后文有详细介绍。
        List<Person> personList = StreamExample.personList;
        List<String> fiterList = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName)
                .collect(Collectors.toList());
        log.info("高于8000的员工姓名：{}", fiterList);
    }
    
    /**
     * 3、聚合（max/min/count)
     */
    private static void example_3() {
        // 获取String集合中最长的元素。
        List<String> list = Arrays.asList("abcdef", "ab", "abc", "abcdefg", "a");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        log.info("最长的字符串：{}", max.get());
        // 获取集合中工资的最大值的员工。
        List<Person> personList = StreamExample.personList;
        Optional<Person> salaryMax1 = personList.stream().max(Comparator.comparing(Person::getSalary));
        
        // 自定义排序
        Optional<Person> salaryMax2 = personList.stream().max(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getSalary() - p2.getSalary();
            }
        });
        log.info("自然排序的最大值：{}", salaryMax1.get());
        log.info("自定义排序的最大值：{}", salaryMax2.get());
        // 员工工资最大值
        Optional<Person> salaryMax3 = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        log.info("员工工资最大值：" + salaryMax3.get().getSalary());
        
        // 计算工资大于7500的员工人数
        long count = personList.stream().filter(x -> x.getSalary() > 7500).count();
        log.info("工资大于7500的员工人数：{}", count);
    }
    
    /**
     * 4、映射(map/flatMap)
     */
    private static void example_4() {
        // 4.1、英文字符串数组的元素全部改为大写。整数数组每个元素+3。
        String[] strArr = {"abcd", "bcdd", "defde", "fTr"};
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> intListNew = intList.stream().map(x -> x + 3).collect(Collectors.toList());
        log.info("每个元素大写：{}", strList);
        log.info("每个元素+3：{}", intListNew);
        // 4.2、将员工的薪资全部增加10000。
        // 不改变原来员工集合的方式
        List<Person> personListNew = personList.stream().map(person -> {
            Person personNew = new Person(person.getName(), 0, 0, null, null);
            personNew.setSalary(person.getSalary() + 10000);
            return personNew;
        }).collect(Collectors.toList());
        log.info("一次改动前：{}-->{}", personList.get(0).getName(), personList.get(0).getSalary());
        log.info("一次改动后：{}-->{}", personListNew.get(0).getName(), personListNew.get(0).getSalary());
        // 改变原来员工集合的方式
        List<Person> personListNew2 = personList.stream().map(person -> {
            person.setSalary(person.getSalary() + 10000);
            return person;
        }).collect(Collectors.toList());
        log.info("二次改动前：{}-->{}", personList.get(0).getName(), personListNew.get(0).getSalary());
        log.info("二次改动后：{}-->{}", personListNew2.get(0).getName(), personListNew.get(0).getSalary());
        
        // 4.3、将两个字符数组合并成一个新的字符数组。
        List<String> list = Arrays.asList("a,b,c,d", "1,2,3,4");
        List<String> listNew = list.stream().flatMap(s -> {
            // 将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());
        
        log.info("处理前的集合：{}", list);
        log.info("处理后的集合：{}", listNew);
    }
    
    /**
     * 5、归约(reduce)
     */
    private static void example_5() {
        // 5.1、求Integer集合的元素之和、乘积和最大值。
        List<Integer> list = Arrays.asList(1, 3, 5, 6, 11, 4);
        // 求和方式1
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
        // 求和方式2
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        // 求和方式3
        Integer sum3 = list.stream().reduce(0, Integer::sum);
        
        // 求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);
        
        // 求最大值方式1
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);
        // 求最大值写法2
        Integer max2 = list.stream().reduce(1, Integer::max);
        
        log.info("list求和：方式一：{},方式二：{},方式三：{}", sum.get(), sum2.get(), sum3);
        log.info("list求积：{}", product.get());
        log.info("list求最大值：方式一：{},方式二：{}", max.get(), max2);
        
        
        // 5.2、求所有员工的工资之和和最高工资。
        // 求工资之和方式1：
        Optional<Integer> sumSalary = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        // 求工资之和方式2：
        /* reduce参数解释：
        identity – 组合函数的身份值
        accumulator – 一种关联的、不干扰的、无状态的函数，用于将附加元素合并到结果中
        combiner – 一个用于组合两个值的关联、不干扰、无状态的函数，必须与累加器函数兼容 */
        Integer sumSalary2 = personList.stream().reduce(0, (s, p) -> s += p.getSalary(),
                (s1, s2) -> s1 + s2);
        // 求工资之和方式3：
        Integer sumSalary3 = personList.stream().reduce(0, (s, p) -> s += p.getSalary(), Integer::sum);
        
        
        // 求最高工资方式1：
        Integer maxSalary = personList.stream().reduce(0, (m, p) -> m > p.getSalary() ? m : p.getSalary(),
                Integer::max);
        // 求最高工资方式2：
        Integer maxSalary2 = personList.stream().reduce(0, (m, p) -> m > p.getSalary() ? m : p.getSalary(),
                (m1, m2) -> m1 > m2 ? m1 : m2);
        
        
        log.info("工资之和：方式一：{},方式二：{},方式三：{}", sumSalary.get(), sumSalary2, sumSalary3);
        log.info("最高工资：方式一：{},方式二：{}", maxSalary, maxSalary2);
    }
    
    /**
     * 6、收集(collect)
     */
    private static void example_6() {
        // 6.1、toList/toSet/toMap的使用
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        // 收集能被2整除的数
        List<Integer> listNew = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        Set<Integer> set = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());
        // 收集工资大于8000的人
        Map<?, Person> map = personList.stream().filter(p -> p.getSalary() > 8000)
                .collect(Collectors.toMap(Person::getName, p -> p));
        log.info("toList:{}", listNew);
        log.info("toSet:{}", set);
        log.info("toMap:{}", map);
        
        // 6.2、统计(count/averaging)
        // 求员工总数
        Long count = personList.stream().collect(Collectors.counting());
        // 求员工平均工资
        Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        // 求最高工资
        Optional<Integer> max = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        // 求工资之和
        Integer sum = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        // 一次性统计所有信息,用于收集计数、最小值、最大值、总和和平均值等统计数据的状态对象。
        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));
        log.info("员工总数：{}", count);
        log.info("员工平均工资：{}", average);
        log.info("员工最高工资：{}", max.get());
        log.info("员工工资总和：{}", sum);
        log.info("员工工资所有统计：{}", collect);
        
        // 6.3、分组(partitioningBy/groupingBy)
        // 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        // 将员工按性别分组
        Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        // 将员工先按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> group2 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        log.info("员工按薪资是否大于8000分组情况：{}", part);
        log.info("员工按性别分组情况：{}", group);
        log.info("员工按性别、地区：{}", group2);
        
        // 6.3、接合(joining)
        // 通过逗号拼接所有员工姓名
        String names = personList.stream().map(p -> p.getName()).collect(Collectors.joining(","));
        log.info("所有员工的姓名：{}", names);
        // 通过-拼接所有字母
        List<String> list2 = Arrays.asList("A", "B", "C");
        String string = list2.stream().collect(Collectors.joining("-"));
        log.info("拼接后的字符串：{}", string);
        
        // 6.4、规约(reducing)
        // 团队集体迟到每人罚款100，每个员工减去罚款后的薪资之和
        Integer sumSal = personList.stream().collect(Collectors.reducing(0, Person::getSalary, (i, j) -> (i + j - 100)));
        log.info("每个员工扣除罚款后薪资总和：" + sumSal);
        
        // stream的reduce
        Optional<Integer> sumSal2 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        log.info("员工薪资总和：" + sumSal2.get());
    }
    
    
    /**
     * 7、排序(sorted)
     */
    private static void example_7() {
        // 按工资升序排序（自然排序）
        List<String> newList = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName)
                .collect(Collectors.toList());
        // 按工资倒序排序
        List<String> newList2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed())
                .map(Person::getName).collect(Collectors.toList());
        // 先按工资再按年龄升序排序
        List<String> newList3 = personList.stream()
                .sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName)
                .collect(Collectors.toList());
        // 先按工资再按年龄自定义排序（降序）
        List<String> newList4 = personList.stream().sorted((p1, p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());
        
        log.info("按工资升序排序：{}", newList);
        log.info("按工资降序排序：{}", newList2);
        log.info("先按工资再按年龄升序排序：{}", newList3);
        log.info("先按工资再按年龄自定义降序排序：{}", newList4);
        
    }
    
    /**
     * 8、提取/组合
     */
    private static void example_8() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"d", "e", "f", "g"};
        
        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        // concat:合并两个流 distinct：去重
        List<String> newList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit：限制从流中获得前5个数据
        List<Integer> collect = Stream.iterate(1, x -> x + 2).limit(5).collect(Collectors.toList());
        // skip：跳过前1个数据，且只获得5个数
        List<Integer> collect2 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());
        
        log.info("流合并：{}", newList);
        log.info("limit：{}", collect);
        log.info("skip：{}", collect2);
    }
}

/**
 * @Description: 泛型比较器允许我们在不同类型的对象上使用相同的比较规则。
 * @Author: sxgan
 * @Date: 2024/6/20 16:35
 * @Version: 1.0
 **/
class GenericComparator<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T obj1, T obj2) {
        return obj1.compareTo(obj2);
    }
}