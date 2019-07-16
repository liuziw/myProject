package com.zw.controller;

import com.zw.common.UserStateEnum;
import com.zw.domain.User;
import com.zw.service.OrganizationService;
import com.zw.service.RoleService;
import com.zw.service.UserServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/9.
 */
@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController{

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private RoleService roleService;

    @InitBinder("demo")
    public void initBinder(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("demo.");
    }


    @RequiresPermissions("sys:demo:demo")
    @RequestMapping("demo")
    public String demo() {

        return "sys/echarts/demo";
    }
}
