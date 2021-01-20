package week01.list;

/**
 * @description: {@link ZeroMove } 移动零
 * 题目：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 *
 * 疑问点? moveZerosV2()方法 我认为 最后赋值的zero 不算是 数组里面的资源 虽然zero 对于计算没有影响，
 * 但是 重新赋值的参数 已经不属于原数组里面的原始参数了
 *
 * @author: PowerZzzD
 * @date: 2021/1/20 10:26
 * @version: v1.0
 */
public class ZeroMove {


    /**
        解题思路：
        (1) 先定义 index = 0 作为 起始值的下标
        (2) 判断非zero的数字 通过index下标交换参数，把非zero数字移动到index下标的位置
        (3) 给当前的 i 位置的数字 重新 赋值成zero
        (4) 重复步骤 2 3
     */
    public static void moveZerosV2(int[] nums) {

        //重新定义的下标
        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                if (i != index) {
                    nums[index] = nums[i];

                    /*
                    这里我认为打破了相对顺序的规则了 赋值 nums[i] = 0,不算是源里面的数据移动
                    赋值的0 属于外来资源 而不是原本数据里面的0
                     */
                    nums[i] = 0;
                }
                index++;
            }

        }

    }


    /**
        解题思路：
        (1) 先找出第一个zero的位置 记录 firstZeroIndex
        (2) 如果firstZeroIndex = -1 的话证明此数组没有 zero的数字 不需要移动
        (3) 依据firstZeroIndex 作为起始值进行循环
        (4) 判断非zero的数字 是:交换index的数字到 zero的位置，将 zero的值param赋值到index的位置
        (5) 重复步骤4
     */
    public static void moveZeros(int[] nums) {

        //初始值 zero的位置
        int firstZeroIndex = -1;

        //找到第一个zero的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                firstZeroIndex = i;
                break;
            }
        }

        if (firstZeroIndex == -1) {
            return;
        }

        for (int index = firstZeroIndex + 1; index < nums.length; index++) {

            if (nums[index] != 0) {

                int param = nums[firstZeroIndex];
                nums[firstZeroIndex] = nums[index];
                nums[index] = param;

                firstZeroIndex++;
            }

        }

    }


    public static void main(String[] args) {

        int[] source = {0, 1, 0, 3, 12};

        //moveZeros(source);

        moveZerosV2(source);

        for (int i = 0; i < source.length; i++) {
            System.out.println(source[i]);
        }
    }

}
