package com.sankuai.sm3.demos.sm3;

import org.springframework.stereotype.Service;

@Service
public class SM3ServiceImpl implements SM3Service {
    static {
        // 加载本地库
        System.load("H:/Java/ES/ES_Test/SM3Test/src/main/resources/native/sm3util.dll");
    }

    @Override
    public native void sm3(byte[] input, int ilen, byte[] output);
}