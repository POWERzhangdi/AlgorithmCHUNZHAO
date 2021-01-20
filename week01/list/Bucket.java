package week01.list;

/**
 * @description: {@link Bucket }
 * 题目: 给你 n 个非负整数 a1，a2，...，an，
 * 每个数代表坐标中的一个点(i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * @author: PowerZzzD
 * @date: 2021/1/20 15:47
 * @version: v1.0
 */
public class Bucket {


    /**
     * 解题思路：
     * (1) 第一层for循环 i 正序遍历
     * (2) 第二层for循环 j 倒序遍历
     * (3) i 跟 j 差值 就是 水桶的长 length = j - i
     * (4) 判断 i 跟 j 的high值，也就是数组里面的值,水桶能装多少水取决于i 跟 j 谁最矮,木桶理论
     * (5) 通过max 参数记录每一次计算的容器大小 跟 上一次的max 比较 赋值max
     * (6) 重复步骤 3 4 5
     */
    public static void bucketArea(int nums[]) {

        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = nums.length - 1; j > 0; j--) {

                int right = nums[i];
                int left = nums[j];

                int area = 0;
                if (right > left) {
                    area = (j - i) * left;
                } else {
                    area = (j - i) * right;
                }

                max = Math.max(max, area);
            }
        }

        System.out.println(max);
    }

    /**
     * 解题思路:
     * (1) i 为右边坐标初始点 ， 最左边 j 为结尾点
     * (2) 循环遍历 nums 数组
     * (3) 判断 i的高度 跟 j的高度 ,依据木桶理论得出 最小高度为容器高 height
     * (4) 开始移动 i 坐标 到下一个坐标 i++，如果是 i(height) > j(height),就移动j的坐标到下一个坐标 j--
     * (5) 计算 max 容积 {这里 (j - i + 1) 是因为上面i++ 操作 导致计算 多加 1，所以这里多减了一个 1，需要填平多减去的1}
     * (6) 重复步骤 3 4 5
     */
    public static void bucketArea2(int nums[]) {
        int j = nums.length - 1;
        int max = 0;
        for (int i = 0; i < j; ) {
            int height = 0;

            if (nums[i] < nums[j]) {
                height = nums[i++];
            } else {
                height = nums[j--];
            }

            //这里 i + 1 是因为 前面 i++进行了移动计算这里 做+1操作算是 填平多计算的参数 1
            int area = (j - i + 1) * height;
            max = Math.max(max, area);
        }
        System.out.println(max);
    }

    public static void main(String[] args) {

        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        //bucketArea(nums);
        bucketArea2(nums);
    }

}
