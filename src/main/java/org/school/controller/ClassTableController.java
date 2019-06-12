package org.school.controller;


import org.school.model.entity.UserModel;
import org.school.model.result.Event;
import org.school.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/classtable")
public class ClassTableController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("query");
        modelAndView.addObject("events",
                userService.GetClassTable((UserModel) request.getSession().getAttribute("login")));
        return modelAndView;
    }

}
