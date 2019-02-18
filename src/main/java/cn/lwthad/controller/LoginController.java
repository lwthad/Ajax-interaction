package cn.lwthad.controller;

import cn.lwthad.Common.CommonResult;
import cn.lwthad.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/admin/check_login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password){

        CommonResult result = loginService.login(username, password);
        return result;
    }

    /**
     *  登陆校验
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/admin/check_login1", method = RequestMethod.POST)
    @ResponseBody
    public String login1(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password){

        String result = loginService.login1(username, password);
        return result;
    }
}
