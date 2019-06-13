<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="/static/css/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/css/page_register.css">
    <script src="/static/js/jquery-3.4.1.min.js"></script>
    <script src="/static/js/md5.js"></script>
    <script src="/static/js/page_login.js"></script>
</head>


<body background="/static/pics/bg.jpg">
    <div class="center register-box">
        <div class="header">
            <h1>注册</h1>
        </div>

        <div class="textbox">
            <i class="fa fa-user"></i>
            <input type="text" name="username" id="username" autocomplete="off" placeholder="昵称" maxlength="16" />
         </div>

        <div class="textbox">
            <i class="fa fa-lock"></i>
            <input type="password" name="pwd" id="pwd" placeholder="密码" maxlength="16" />
        </div>

        <div class="textbox">
            <i class="fa fa-lock"></i>
            <input type="password" name="confirm" id="confirm" placeholder="确认密码" maxlength="16" />
        </div>

        <div class="textbox">
            <i class="fa fa-envelope"></i>
            <input type="text" name="email" id="email" autocomplete="off" placeholder="电子邮箱" maxlength="16" />
        </div>
        
        <input class="button" type="button" value="注册" onclick="register_onclick()" />
        
        <div class="href">
            <i class="fa fa-mail-reply"></i>
            <a href="login.html">返回登录页面</a>
        </div>

    </div>
</body>
</html>