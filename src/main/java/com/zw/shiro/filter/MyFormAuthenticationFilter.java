package com.zw.shiro.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter
{
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){
    try {
            // 先判断是否是登录操作
            if (isLoginSubmission(request, response)) {
                return false;
            }
        } catch (Exception e) {

        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

}