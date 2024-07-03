package com.sankuai.sm3.demos.sm3;

public interface SM3Service {
    void sm3(byte[] input, int ilen, byte[] output);
}