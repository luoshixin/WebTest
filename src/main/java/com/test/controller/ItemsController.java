package com.test.controller;

import com.test.bean.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

public class ItemsController implements Controller{
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        List<Items> itemsList = new ArrayList<Items>();

        Items items0 = new Items();
        items0.setName("笔记本");
        items0.setPrice(3000f);
        items0.setDetail("这是一台很好的笔记本");
        itemsList.add(items0);

        Items items1 = new Items();
        items1.setName("台式机");
        items1.setPrice(5000f);
        items1.setDetail("这是一台台式机");
        itemsList.add(items1);

        ModelAndView modelAndView = new ModelAndView();
        // 相当于request的setAttribute
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
        return modelAndView;
    }
}
