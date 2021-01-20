package week01;

import week01.list.CustomArray;

import java.util.ArrayList;

/**
 * @description: {@link TestWeek01 } 作为第一周的测试类
 * @author: PowerZzzD
 * @date: 2021/1/19 15:10
 * @version: v1.0
 */
public class TestWeek01 {


    public static void main(String[] args) {
        testArrayDel();

        ArrayList<String> list = new ArrayList<>();
        list.iterator();
    }


    public static void testArrayDel() {
        CustomArray customArray = new CustomArray(5);
        customArray.add("第1个吃苹果的人");
        customArray.add("第2个吃苹果的人");
        customArray.add("第3个吃苹果的人");
        customArray.add("第4个吃苹果的人");
        customArray.add("第5个吃苹果的人");

        customArray.delBySubscript(4);

        customArray.add("第3个吃苹果的人");
        customArray.add("第n个吃苹果的人");

        System.out.println(customArray.toString());
        System.out.println("当前数组大小:" + customArray.getSize());

    }


    public static void testArrayAdd() {
        //测试自定义的数组
        CustomArray customArray = new CustomArray(10);
        customArray.add("第1个吃苹果的人");
        customArray.add("第2个吃苹果的人");
        customArray.add("第3个吃苹果的人");
        customArray.add("第4个吃苹果的人");
        customArray.add("第5个吃苹果的人");
        customArray.add("第6个吃苹果的人");
        customArray.add("第7个吃苹果的人");
        customArray.add("第8个吃苹果的人");
        customArray.add("第9个吃苹果的人");
        customArray.add("第10个吃苹果的人");
        customArray.add("第11个吃苹果的人");
        System.out.println(customArray.toString());
        System.out.println("当前数组大小:" + customArray.getSize());
    }
}
