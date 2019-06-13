
function login_onclick() {
    var input_username = document.getElementById("username");
    var input_pwd = document.getElementById("pwd");
    var username = input_username.value;
    var password = input_pwd.value;

    if(username.length ==0)
    {
        alert("用户名不能为空！");
        return false;
    }
    if(password.length==0)
    {
        alert("密码不能为空！");
        return false;
    }
    if (!(username.match(/^[_a-zA-Z\d]{8,15}$/) || username.match(/^[A-Za-z0-9]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/))) {
        alert("用户名不合法！");
        return false;
    }
    password = $.md5(password);
    $.post("", {
        username: username,
        pwd: password
    }, function (data, status) {
        if (data.success)
            alert("登录成功！");
        else {
            alert("登录失败：" + data.message);
        }
    }).fail(function(){
        alert("发生错误！");
    })
}

function register_onclick() {
    var input_username = document.getElementById("username");
    var input_pwd = document.getElementById("pwd");
    var input_confirm = document.getElementById("confirm");
    var input_email = document.getElementById("email");

    var username = input_username.value;
    var password = input_pwd.value;
    var confirm = input_confirm.value;
    var email=input_email.value;

    if(username.length ==0)
    {
        alert("用户名不能为空！");
        return false;
    }
    if(password.length==0)
    {
        alert("密码不能为空！");
        return false;
    }
    if(confirm.length==0)
    {
        alert("重新输入密码不能为空！");
        return false;
    }

    if(confirm!=password)
    {
        alert("二次输入密码不一致！");
        return false;
    }

    if(email.length==0)
    {
        alert("电子邮箱不能为空！");
        return false;
    }

    if (!username.match(/^[_a-zA-Z\d]{8,15}$/)) {
        alert("用户名不合法！");
        return false;
    }

    if(!email.match(/^[A-Za-z0-9]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/)){
        alert("邮箱不合法！");
        return false;
    }

    password = $.md5(password);
    var userid = (new Date()).valueOf();

    $.post("/register", {
        userid: userid,
        username: username,
        pwd: password,
        email:email,
    }, function (data, status) {
        if (data.success)
            alert("注册成功！");
        else {
            alert("注册失败：" + data.message);
        }
    }).fail(function(){
        alert("发生错误！");
    })
}