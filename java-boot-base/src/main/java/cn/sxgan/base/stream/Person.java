package cn.sxgan.base.stream;

import lombok.Data;

/**
 * @Description: 员工类
 * @Author: sxgan
 * @Date: 2024-06-20 15:41
 * @Version: 1.0
 **/
@Data
public class Person {
    private String name; // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; // 性别
    private String area; // 地区
    
    
    // 构造方法
    public Person(String name, int age, int salary, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }
}
