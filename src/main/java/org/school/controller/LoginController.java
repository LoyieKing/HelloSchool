package org.school.controller;

import org.school.model.entity.UserModel;
import org.school.model.entity.UserType;
import org.school.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/login")
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
    public Map<String,Object> login(HttpServletRequest request)
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

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> register(HttpServletRequest request)
    {
        Map<String,Object> result = new HashMap<String, Object>();
        String userid = request.getParameter("userid");
        String password = request.getParameter("pwd");
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        if(userid==null||password==null||username==null)
        {
            result.put("success",false);
            result.put("message","参数不足！");
            return result;
        }
        userid = userid.trim().toLowerCase();
        password = password.toLowerCase();
        if(!userid.matches("^[_a-z\\d]{8,15}$"))
        {
            result.put("success",false);
            result.put("message","用户ID不合法！");
            return result;
        }
        if(!password.matches("^[a-z\\d]{32,32}$"))
        {
            result.put("success",false);
            result.put("message","密码不合法");
            return result;
        }
        if(email!=null&&!email.matches("^[A-Za-z0-9]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$"))
        {
            result.put("success",false);
            result.put("message","邮箱不合法");
            return result;
        }

        UserModel user = new UserModel();
        user.setUserId(userid);
        user.setPassword(password);
        user.setUserName(username);
        user.setEmail(email);
        user.setUserType(UserType.VISITOR);

        try {
            userService.Register(user);
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
