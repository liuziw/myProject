package com.zw.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/4/9 11:57
 */
public class TestMap {

    public static void main(String [] args){
        Map<Integer,Integer> map = new HashMap<>(1000000);
        Long start = System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            map.put(i,i);
        }
        Long end = System.currentTimeMillis();
        System.out.println("spend:"+(end-start));
    }
}
