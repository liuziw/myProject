package com.zw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zw.util.DataList;
import com.zw.util.Pager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


public class BaseController {


    protected DataList dataList;

    protected List list;
    protected Map<String,Object> paramMap;

    @Resource
    protected Pager pager;



    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;




    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    @ModelAttribute
    public void setAttribute(HttpServletRequest request,Model model,Integer mid,Pager pager){
        paramMap = new HashMap<String,Object>();
        model.addAttribute("basePath", request.getContextPath());
        if(mid!=null){
        	 /*request.getSession().setAttribute("currentPosition", moduleService.getCurrentPosition(mid));
        	 request.getSession().setAttribute("modulName", moduleService.selectByPrimaryKey(mid).getName());*/
        }
        if(pager!=null){
            this.pager.setCurrentPage(pager.getCurrentPage()+"");
        }
    }

}
