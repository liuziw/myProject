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
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private RoleService roleService;

    @InitBinder("user")
    public void initBinder(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }
    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "sys/user/showUser";
    }

    @RequiresPermissions("sys:user:list")
    @RequestMapping("list")
    public String list(Model model,User user) {
        Map<String,Object> map = new HashMap<>();
        map.put("t",user);
        dataList = userService.selectByPager(pager,map);
        UserStateEnum[] stateEnums = UserStateEnum.values();
        model.addAttribute("stateEnums", stateEnums);
        model.addAttribute("dataList", dataList);
        System.out.println("test4...");
        return "sys/user/list";
    }


    @RequiresPermissions("sys:user:save")
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String add(Model model) {
        setCommonData(model);
        model.addAttribute("user", new User());
        model.addAttribute("op", "新增");
        return "user/edit";
    }

    @RequiresPermissions("sys:user:save")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(User user, RedirectAttributes redirectAttributes) {
        userService.save(user);
        redirectAttributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/user";
    }

    @RequiresPermissions("sys:user:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer id, Model model) {
        setCommonData(model);
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("op", "修改");
        return "user/edit";
    }

    @RequiresPermissions("sys:user:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(User user, RedirectAttributes redirectAttributes) {
        userService.update(user);
        redirectAttributes.addFlashAttribute("msg", "修改成功");
        return "redirect:/user";
    }

    @RequiresPermissions("sys:user:delete")
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(Integer id,RedirectAttributes redirectAttributes) {
        userService.deleteById(id);
        redirectAttributes.addFlashAttribute("message","删除成功！");
        return "redirect:list";
    }

    @RequiresPermissions("sys:user:update")
    @RequestMapping(value = "/{id}/changePassword", method = RequestMethod.GET)
    public String showChangePasswordForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("op", "修改密码");
        return "user/changePassword";
    }

    @RequiresPermissions("sys:user:update")
    @RequestMapping(value = "/{id}/changePassword", method = RequestMethod.POST)
    public String changePassword(@PathVariable("id") Integer id, String newPassword, RedirectAttributes redirectAttributes) {
        userService.changePassword(id, newPassword);
        redirectAttributes.addFlashAttribute("msg", "修改密码成功");
        return "redirect:/user";
    }

    private void setCommonData(Model model) {
        model.addAttribute("organizationList", organizationService.findAll());
        model.addAttribute("roleList", roleService.findAll());
    }

}
