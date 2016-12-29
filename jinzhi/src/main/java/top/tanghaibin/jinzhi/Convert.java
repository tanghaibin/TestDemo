package top.tanghaibin.jinzhi;

import org.junit.Test;

/**
 * Created by tanghaibin on 2016/12/29.
 *
 * 进制转换
 * B代表二进制
 * O代表八进制
 * D代表十进制
 * H代表十六进制
 */
public class Convert {

    /**
     * 二进制转十进制
     * 二进制为：1110
     * 转换：从最低位开始换算
     *  数字*2的所在的顺序的次方（从右往左排）
     *  0 * (2^0) = 0
     *  1 * (2^1) = 2
     *  1 * (2^2) = 4
     *  1 * (2^3) = 8
     *
     *  然后相加：所得十进制为14
     */
    @Test
    public void B2D() {
        //10100
//        int d = (int) (0 * Math.pow(2, 0) + 1 * Math.pow(2, 1) + 1 * Math.pow(2, 2) + 1 * Math.pow(2, 3));
        int d = (int) (0 * Math.pow(2, 0) + 0 * Math.pow(2, 1) + 1 * Math.pow(2, 2) + 0 * Math.pow(2,3) + 1 * Math.pow(2, 4));
        System.out.println(d);//out 14
    }

    /**
     * 八进制转十进制
     * 二进制数位1110
     * 转换：从最低位开始计算
     *  数字 * 8的所在顺序的次方（从右往左）
     *  0 * 8^0 = 0
     *  1 * 8^1 = 8
     *  1 * 8^2 = 64
     *  1 * 8^3 = 512
     *
     *  相加：所得十进制为584
     */
    @Test
    public void O2D() {
        int d = (int) (0 * Math.pow(8, 0) + 1 * Math.pow(8, 1) + 1 * Math.pow(8, 2) + 1 * Math.pow(8, 3));
        System.out.println(d);//out 584
    }

    /**十六进制转十进制
     * 0123456789ABCDEF
     * 十六进制：2BE
     *  转换：从最低位开始计算
     *      数字 * 16^的所在次方（从右往左）
     *  E=14 B=11
     *  14 * 16^0 = 14
     *  11 * 16^1 = 176
     *  2 * 16^2 = 512
     *  相加：所得十进制为702
     */
    @Test
    public void H2D() {
        int d = (int) (14 * Math.pow(16, 0) + 11 * Math.pow(16, 1) + 2 * Math.pow(16, 2));
        System.out.println(d);//out 702
    }
}
