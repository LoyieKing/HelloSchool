package org.school.controller;



import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Driver;
import org.springframework.http.HttpRequest;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping
    public String index(HttpServletRequest request) {
        return "index";
    }
}
