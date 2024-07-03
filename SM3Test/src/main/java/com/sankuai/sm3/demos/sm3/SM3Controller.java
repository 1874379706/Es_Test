package com.sankuai.sm3.demos.sm3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author WXY
 * @Description 测试通过接口的方式访问sm3
 * @Date 2024-06-29 21:34
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/sm3")
public class SM3Controller {

    public static void main(String[] args) {
        SM3Util util = new SM3Util();
        byte[] input = "abc".getBytes();
        byte[] output = new byte[32];
        try {
            util.sm3(input, input.length, output);
        }catch (Exception e){
            System.out.println("e:  " + e);
        }
    }
    @PostMapping("/encrypt")
    public String encrypt(@RequestBody EncryptionRequest request) {
        System.out.println("data: " + request.getData());
        byte[] input = request.getData().getBytes();
        byte[] output = new byte[32];
        SM3Util util = new SM3Util();
        try {
            util.sm3(input, input.length, output);
        }catch (Exception e){
            System.out.println("e:  " + e);
        }
        

        // 返回加密结果的十六进制字符串
        StringBuilder hexString = new StringBuilder();
        for (byte b : output) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
