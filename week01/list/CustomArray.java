package week01.list;

import java.util.StringJoiner;

/**
 * @description: {@link CustomArray }自定义集合类
 * @author: PowerZzzD
 * @date: 2021/1/19 14:41
 * @version: v1.0
 */
public class CustomArray{

    /**
     * 默认初始化大小 10
     */
    private static final int DEFAULT_SIZE = 10;

    /**
     * 数组扩容倍数 扩容公式 size * reSize
     */
    private static final int RESIZE_MULTIPLE = 2;

    /**
     * 集合大小
     */
    public int size = 0;

    /**
     * 当前数组可以操作的下标
     */
    private int currentIndex = 0;

    /**
     * 集合初始化数组
     */
    private String[] array;


    public CustomArray() {
    }

    public CustomArray(int size) {
        this.size = size;
    }

    /**
     * @Description: add方法是 添加数组元素
     * @param: [value]
     * @paramType: [java.lang.String]
     * @return: void
     * @author: PowerZzzD
     * @date: 2021/1/19 14:42
     * @version: v1.0
     */
    public synchronized void add(String value) {
        //初始化数组
        if (size == 0 && null == array) {
            array = new String[DEFAULT_SIZE];
            size = DEFAULT_SIZE;
        }
        if (null == array && size > 0) {
            array = new String[size];
        }

        //数据已经满了 需要扩容
        if (currentIndex >= size) {
            array = reSize(array);
        }

        //为数组添加数据
        array[currentIndex++] = value;
    }


    /**
     * @Description: getValueBySubscript方法是 通过下标获取集合参数值
     * @param: [index]
     * @paramType: [int]
     * @return: java.lang.String
     * @author: PowerZzzD
     * @date: 2021/1/19 14:48
     * @version: v1.0
     */
    public String getValueBySubscript(int index) {

        //定位下标 是否 超标
        if (index > size - 1) {
            throw new StringIndexOutOfBoundsException("数组下标越界");
        }

        return array[index];
    }

    /**
     * @Description: del方法是 通过下标删除值
     * @param: [index]
     * @paramType: [int]
     * @return: void
     * @author: PowerZzzD
     * @date: 2021/1/19 14:49
     * @version: v1.0
     */
    public synchronized void delBySubscript(int index) {
        //定位下标 是否 超标
        if (index > size - 1) {
            throw new StringIndexOutOfBoundsException("数组下标越界");
        }

        //删除数据
        array[index] = null;
        currentIndex--;

        //特殊情况处理
        if (index == size - 1) {
            return;
        }

        //移动数据
        for (int i = 0; i < size; i++) {
            if (index < i) {
                String variable = array[i];
                array[i - 1] = variable;
                array[i] = null;
            }
        }
    }

    /**
     * @Description: getSize方法是 获取集合的大小
     * @return: int
     * @author: PowerZzzD
     * @date: 2021/1/19 15:09
     * @version: v1.0
     */
    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        StringJoiner str = new StringJoiner(",", "[", "]");
        for (int i = 0; i < size; i++) {
            if (null == array[i]) {
                continue;
            }
            str.add(array[i]);
        }
        return str.toString();
    }

    /**
     * @Description: reSize方法是 扩容数组大小
     * @param: [source]
     * @paramType: [java.lang.String[]]
     * @return: java.lang.String[]
     * @author: PowerZzzD
     * @date: 2021/1/19 16:20
     * @version: v1.0
     */
    private String[] reSize(String[] source) {
        //根据当前数组大小 计算扩容之后新数组大小
        size = size * RESIZE_MULTIPLE;
        String[] target = new String[size];

        //将源数组写入到 新的数组
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }

        return target;
    }

    /**
     * @Description: iterator方法是 获取迭代的数组 自己玩去吧
     * @param: []
     * @paramType: []
     * @return: java.lang.String[]
     * @author: PowerZzzD
     * @date: 2021/1/19 17:12
     * @version: v1.0
     */
    public String[] iterator() {
        return array;
    }




}
