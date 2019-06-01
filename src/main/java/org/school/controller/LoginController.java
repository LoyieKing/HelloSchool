package org.school.controller;

import org.school.model.UserModel;
import org.school.service.IUserService;
import org.school.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index()
    {
        return "login";
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> index(HttpServletRequest request)
    {
        Map<String,Object> result = new HashMap<String, Object>();
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        if(username==null||password==null)
        {
            result.put("success",false);
            result.put("message","参数不足！");
            return result;
        }
        username = username.trim().toLowerCase();
        password = password.toLowerCase();
        if(!(username.matches("^[_a-z\\d]{8,15}$")||username.matches("^[A-Za-z0-9]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")))
        {
            result.put("success",false);
            result.put("message","用户名不合法！");
            return result;
        }
        if(!password.matches("^[a-z\\d]{32,32}$"))
        {
            result.put("success",false);
            result.put("message","密码不合法");
            return result;
        }
        UserModel user;
        try {
            user = userService.Login(username, password);
        }
        catch (Exception error)
        {
            result.put("success",false);
            result.put("message",error.getMessage());
            return result;
        }
        request.setAttribute("login",user);
        result.put("success",true);
        result.put("info",user);
        return result;
    }

}
