package com.zw.proxy;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/5/10 17:25
 */
public interface IConfig {

    @Value("db.url")
    String dbUrl();

    @Value("db.validation")
    boolean isValidated();

    @Value("db.pool.size")
    int poolSize();

}