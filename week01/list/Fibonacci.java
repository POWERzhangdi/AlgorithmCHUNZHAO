package week01.list;

/**
 * @description: {@link Fibonacci }
 * 题目:
 * 您正在爬楼梯。它需要采取n步骤才能达到顶峰。 每次您都可以爬升1或爬升2。您可以通过几种不同的方式登顶？
 * @author: PowerZzzD
 * @date: 2021/1/20 18:15
 * @version: v1.0
 */
public class Fibonacci {

    /**
     * 解题思路：
     * (1) 假设 当前台阶为1 登顶方法 只有1种 走1步 f(1) = 1
     * (2) 假设 当前台阶为2 登顶方法 只有2种 一步走1个台阶 一步走2个台阶 f(2) = 2
     * (3) 假设 当前台阶为3 登顶方法 只有3种 一步1个台阶 一步3个台阶 {一步1个台阶 + 一步2个台阶 or 一步2个台阶 + 一步1个台阶} 即为一种方法 f(3) = f(1) + f(2)
     * (4) 假设 当前台阶为4 登顶方法 只有5种 一步1个台阶 一步5个台阶 {一步1个台阶 + 一步2个台阶 + 一步1个台阶 or 一步2个台阶 + 一步1个台阶 + 一步1个台阶 or 一步1个台阶 + 一步1个台阶 + 一步2个台阶}
     * 一步1个台阶 + 一步4个台阶 {一步3个台阶 + 一步2个台阶 or 一步2个台阶 + 一步3个台阶}  f(4) = f(2) + f(3)
     * (5) 通过上面的规律总结出：爬上3台阶的方式等于 (1)(2)之和
     * 爬上4台阶的方式等于 (2)(3)之和
     * 假设我们有n个台阶  f(n) = f(n - 1 ) + f(n - 2)
     */
    public static void fibonacciM(int num) {

        //初始化台阶数量 num 等于多少就是多少个台阶
        int[] taiJie = new int[num];
        // {1,2,3,4,5}

        int count = 0;
        for (int i = 0; i <= taiJie.length; i++) {

            //第一个台阶
            if (i == 0) {
                count = 1;
                if (taiJie.length - 1 == i) {
                    break;
                }
            } else if (i == 1) {
                //第二个台阶
                count = 2;
                if (taiJie.length - 1 == i) {
                    break;
                }
            } else {
                count = (i - 1) + (i - 2);
            }

        }

        System.out.println(count);
    }


    public static void main(String[] args) {
        fibonacciM(5);
    }

}
