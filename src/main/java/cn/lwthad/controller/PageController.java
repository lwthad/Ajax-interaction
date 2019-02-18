package cn.lwthad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /**
     *  初始页面跳转
     *      已经在springmvc中配置视图解析器
     *          <property name="prefix" value="/WEB-INF/jsp/" />
     *          <property name="suffix" value=".jsp" />
     * @return
     */
    @RequestMapping("/")
    public String showPage(){
        return "index";     // 原型是/WEB-INF/jsp/index.jsp
    }

    /**
     *  显示jsp页面
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(String page){
        return page;
    }
}
