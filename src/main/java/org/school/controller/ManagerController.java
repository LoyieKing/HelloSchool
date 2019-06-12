package org.school.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.school.model.entity.UserModel;
import org.school.model.result.Group;
import org.school.service.IGroupService;
import org.school.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IGroupService groupService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("manager");
        view.addObject("info", request.getAttribute("login"));

        try {
            view.addObject("users", userService.ListAll());
        } catch (Exception e) {
            view.addObject("users", e);
        }

        try {
            view.addObject("groups", groupService.ListAll());
        } catch (Exception e) {
            view.addObject("groups", e);
        }


        return view;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public HashMap<String, Object> adduser(@RequestBody String userstr) {
        HashMap<String, Object> result = new HashMap<String, Object>();

        if (userstr == null) {
            result.put("success", false);
            return result;
        }
        userstr = userstr.trim();
        if (userstr.length() == 0) {
            result.put("success", false);
            return result;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        if (userstr.contains("[")) {
            UserModel[] users;
            try {
                users = objectMapper.readValue(userstr, UserModel[].class);
            } catch (Exception e) {
                result.put("success", false);
                result.put("message", "数据格式不合法");
                return result;
            }

            try {
                for (UserModel user : users) {

                    userService.Register(user);
                }

            } catch (Exception e) {
                result.put("success", false);
                result.put("message", "注册时发生错误：" + e.getMessage());
            }
            result.put("success", true);
        } else {
            UserModel user;
            try {
                user = objectMapper.readValue(userstr, UserModel.class);
            } catch (Exception e) {
                result.put("success", false);
                result.put("message", "数据格式不合法");
                return result;
            }

            try {
                userService.Register(user);

            } catch (Exception e) {
                result.put("success", false);
                result.put("message", "注册时发生错误：" + e.getMessage());
            }
            result.put("success", true);
        }
        return result;
    }

    @RequestMapping(value = "/group",method = RequestMethod.PUT)
    public HashMap<String,Object> groupnew(HttpServletRequest request, @RequestBody Group group)
    {
        HashMap<String,Object> result = new HashMap<String, Object>();
        try {
            groupService.AddGroup(group);
            result.put("success",true);
        }
        catch (Exception e)
        {
            result.put("success",false);
            result.put("message",e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/group",method = RequestMethod.POST)
    public HashMap<String,Object> groupupdate(HttpServletRequest request, @RequestBody Group group)
    {
        HashMap<String,Object> result = new HashMap<String, Object>();
        try {
            groupService.UpdateGroup(group);
            result.put("success",true);
        }
        catch (Exception e)
        {
            result.put("success",false);
            result.put("message",e.getMessage());
        }
        return result;
    }


}
