package com.sankuai.sm3.demos.sm3;

public class SM3Util {
    // 加载本地库
    static {
        System.load("H:\\Java\\ES\\ES_Test\\SM3Test\\src\\main\\java\\com\\sankuai\\sm3\\demos\\c\\sm3util.dll");
    }

    // 声明本地方法
    public native void sm3(byte[] input, int ilen, byte[] output);

    // 测试方法
    public static void main(String[] args) {
        SM3Util util = new SM3Util();
        byte[] input = "22645nnqq".getBytes();
        byte[] output = new byte[32];

        util.sm3(input, input.length, output);
        // 打印输出
        for (byte b : output) {
            System.out.printf("%02x", b);
        }
        System.out.println();
    }
}