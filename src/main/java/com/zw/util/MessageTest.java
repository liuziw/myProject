package com.zw.util;

import com.shouyi.SMGP_API.SmsClient;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/1/3 10:35
 */
public class MessageTest {

    public static void main(String [] args){
        SmsClient smsClient = new SmsClient();
        int loginStatus = smsClient.Login("125.88.123.137",3058,"02025123","2Mg3eQ7p",30);
        int [] arr = smsClient.SendSms("15549830302","15111481499","导演你好",true,new StringBuilder(""));
        System.out.println(arr[0]);
    }
}
