<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome!</title>
    <link rel="stylesheet" href="/static/css/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/css/page_login.css">
    <script src="/static/js/jquery-3.4.1.min.js"></script>
    <script src="/static/js/md5.js"></script>
    <script src="/static/js/page_login.js"></script>
</head>

<body background="/static/pics/bg.jpg">
    <div class="center login-box">
        <div class="header">
            <h1>登录</h1>
        </div>
        <div class="textbox">
            <i class="fa fa-user"></i>
            <input type="text" name="username" id="username" autocomplete="off" placeholder="用户名" maxlength="16" />
        </div>
        <div class="textbox">
            <i class="fa fa-lock"></i>
            <input type="password" name="pwd" id="pwd" placeholder="密码" maxlength="16" />
        </div>
        <input class="button" type="button" value="登录" onclick="login_onclick()" />
        
        <div class="href">
            <i class="fa fa-mail-forward"></i>
            <a href="register.html">游客注册</a>
        </div>

    </div>
</body>

</html>