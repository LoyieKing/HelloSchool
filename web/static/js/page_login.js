
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
    if (!(username.match(/^[_a-zA-Z\\d]{8,15}$/) || username.match(/^[A-Za-z0-9]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$/))) {
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