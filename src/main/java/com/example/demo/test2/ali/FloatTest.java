package com.example.demo.test2.ali;

import java.math.BigDecimal;
import java.text.Bidi;

/**
 * @ClassName FloatTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/9  8:38 上午
 * @Version 1.0
 */
public class FloatTest {

    public static void main(String[] args) {
        System.out.println("wrong way.......");
        float g = 1.0f-0.9f;
        float h = 0.9f-0.8f;
        System.out.println(g ==h);

        Float G = Float.valueOf(g);
        Float H = Float.valueOf(h);
        System.out.println(G.equals(H));

        Float m = new Float(g);
        Float n = new Float(h);
        System.out.println(m.equals(n));

        System.out.println("right way........");
        double diff = 1e-6;
        if(Math.abs(g-h) < diff){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");
        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);

        System.out.println(x.equals(y));

        System.out.println("diff..........");
        float ff = 0.9f;
        double dd = 0.9d;
        System.out.println(ff/1.0);
        System.out.println(dd/1.0);

    }

}
