package com.zw.controller;


import com.zw.domain.Menu;
import com.zw.domain.Module;
import com.zw.domain.User;
import com.zw.service.ModuleService;
import com.zw.service.UserServiceImpl;
import com.zw.shiro.bind.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@CrossOrigin
@Controller
public class IndexController extends BaseController{

    @Autowired
    private ModuleService moduleService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/")
    public String index(@CurrentUser User loginUser, Model model) {
        /*Set<String> permissions = userService.findPermissions(loginUser.getUsername());
        List<Resource> menus = resourceService.findMenus(permissions);
        model.addAttribute("menus", menus);*/
        return "index";
    }

    @ResponseBody
    @RequestMapping(value="/leftJson")
    public List leftJson(HttpServletResponse hr,@CurrentUser User loginUser){
        hr.setContentType("application/json;charset=UTF-8");
        Set<String> permissions = userService.findPermissions(loginUser.getUsername());
        List<Module> menus = moduleService.findMenus(permissions,loginUser.getId());
        List<Menu> list = new ArrayList<>();
        for(Module r : menus){
            if(r.getPid().intValue()==0){
                Menu m = new Menu(r.getId(),r.getName(),r.getUrl());
                setChild(m,menus);
                list.add(m);
            }
        }
        return list;
    }




    private void setChild(Menu menu,List<Module> list){
        List<Menu> ml = new ArrayList<>();
        for(Module r : list){
            if(r.getPid().intValue() == menu.getId()){
                Menu m = new Menu(r.getId(),r.getName(),r.getUrl());
                setChild(m,list);
                ml.add(m);
            }
        }
        menu.setChild(ml);
    }

}
