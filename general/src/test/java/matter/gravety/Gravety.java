package matter.gravety;

import com.xiaoleilu.hutool.util.ArrayUtil;
import org.junit.Test;

/**
 * @author: minghua
 * @date: 2018/8/19 7:08
 * @modified By:
 */
public class Gravety {
    //5种商品标准重量
    int[] productArr = {100, 220, 350, 880, 1095};
    //组合结果
    int[] combination = new int[productArr.length];
    //最大误差
    int residual = 10;

    /**
     * 传入总减少重量
     * 最终求解combination 数组
     *
     * @param totlaWeight
     */
    public void getCombination(int totlaWeight) {
        int[] maxProb = new int[productArr.length];
        for (int var1 = 0; var1 < productArr.length; var1++) {
            int weight = productArr[var1];
//            if ((weight - totlaWeight) > residual) {
//                System.out.println("去除" + weight);
//                combination[var1] = 0;
//                maxProb[var1] = 0;
//            }
            if (totlaWeight / weight > 0) {
                maxProb[var1] = totlaWeight / weight;
            }
        }
        System.out.println(ArrayUtil.toString(productArr));
        System.out.println(ArrayUtil.toString(combination));
        System.out.println(ArrayUtil.toString(maxProb));

        //[3, 1, 1, 0, 0]
        /*
         * 1、遍历可能最大数组
         * 2、针对最大可能数组中的每个值，循环其余元素
         */
        //1-5(数组长度)
        for (int i = 0; i < maxProb.length; i++) {
            if (maxProb[i] != 0) {
                System.out.println("遍历元素" + i);
                //1-6[i 位元素值]
                for (int count = 1; count <= maxProb[i]; count++) {
                    //int weight1 = count * productArr[var2];

                    for (int var4 = i + 1; var4 <= maxProb.length; var4++) {
                        //if (var4)
                        System.out.print(count + "-");
                        System.out.print(var4);
                        System.out.print("  ");
                    }
                }
            }

        }

    }

    public void arrayMultiply(int[]... ararys) {
        int length = ararys.length;
        for (int[] array : ararys) {
            System.out.println(ArrayUtil.toString(array));
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
                for (int j = 0; j < length; j++) {
                    System.out.println(ararys[j]);
                }
            }
        }


    }

    @Test
    public void testArrayMultiply() {
        int[] array1 = {0, 1, 2, 3, 4, 5, 6};
        int[] array2 = {0, 1, 2};
        int[] array3 = {0, 1, 2, 3};

        arrayMultiply(array1, array2, array3);
    }

    @Test
    public void test() {
        this.getCombination(670);
    }

}
