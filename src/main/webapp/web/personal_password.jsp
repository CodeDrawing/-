<%--
  Created by IntelliJ IDEA.
  User: zxsmac
  Date: 2020/7/10
  Time: 3:43 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/orders.css" rel="Stylesheet"/>
    <link href="../css/header.css" rel="Stylesheet"/>
    <link href="../css/footer.css" rel="Stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
</head>
<body>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
    </ul>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <jsp:include page="left.jsp"></jsp:include>
    <!-- 右边栏-->
    <!--个人信息头部-->
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span ><a href="personage.html">我的信息</a></span>
            <span class="rs_header_active"><a href="personal_password.html">安全管理</a></span>
        </div>

        <!--安全管理 -->
        <div class="rs_content">
            <p class="change_password_title">更改密码</p>
            <div class="new_password">
                <span class="word">输入旧密码：</span><input name="oldPassword" id="oldPassword" type="password"/><span class="change_hint" id="oldPasswordSpan"></span>
            </div>
            <div class="new_password">
                <span class="word">输入新密码：</span><input name="newPassword" id="newPassword" type="password"/><span class="change_hint" id="newPasswordSpan"></span>
            </div>
            <div class="confirm_password">
                <span class="word">确认新密码：</span><input  name="newPassword" id="confirmPassword" type="password"/><span class="confirm_hint" id="confirmPasswordSpan"></span>
            </div>
            <div class="save_password" onclick="updatePassword()">
                保存更改
            </div>
        </div>


    </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
            <p class="footer1"><img src="../images/footer/logo.png" alt="" class=" footLogo"/></p>
            <p class="footer2"><img src="../images/footer/footerFont.png" alt=""/></p>
        </div>
        <div class="foot_left lf">
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="../images/footer/wechat.png" alt=""/>
                    <img src="../images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>学子商城客户端</p>
            <img src="../images/footer/ios.png" class="lf">
            <img src="../images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="../images/footer/erweima.png">
        </div>
        <!-- 页面底部-备案号 #footer -->
        <div class="record">
            &copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx
        </div>
    </div>

</div>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>
</html>
<script type="text/javascript">
    function checkPasswordLength(pwd) {
        return pwd.length>=6&&pwd.length<=9;
    }
    function checkEqualsPwd() {
        //获取新密码
        var newPasswordValue=$("#newPassword").val();
        var confirmPasswordValue=$("#confirmPassword").val();
        return newPasswordValue==confirmPasswordValue;
    }
//      旧密码框长度的验证
    $("#oldPassword").blur(function () {
    //    获取旧密码
        var oldPasswordValue=$("#oldPassword").val();
        if(checkPasswordLength(oldPasswordValue)){
            $("#oldPasswordSpan").html("密码格式正确");
            $("#oldPasswordSpan").css("color","green");
        }else{
            $("#oldPasswordSpan").html("密码格式不正确");
            $("#oldPasswordSpan").css("color","red");
        }
    })
    //新密码长度
    $("#newPassword").blur(function () {
        //    获取新密码
        var newPasswordValue=$("#newPassword").val();
        if(checkPasswordLength(newPasswordValue)){
            $("#newPasswordSpan").html("密码格式正确");
            $("#newPasswordSpan").css("color","green");
        }else{
            $("#newPasswordSpan").html("密码格式不正确");
            $("#newPasswordSpan").css("color","red");
        }
    })

    //新旧密码相同验证
    $("#confirmPassword").blur(function () {

        if(checkEqualsPwd()){
            $("#confirmPasswordSpan").html("密码相同");
            $("#confirmPasswordSpan").css("color","green");
        }else{
            $("#confirmPasswordSpan").html("密码不相同");
            $("#confirmPasswordSpan").css("color","red");
        }
    });
    //报存修改
    function updatePassword() {
        var oldPasswordValue=$("#oldPassword").val();
        var newPasswordValue=$("#newPassword").val();
        if(checkEqualsPwd(oldPasswordValue)&&checkPasswordLength(newPasswordValue)&&checkEqualsPwd()){
            $.ajax({
                url:"${pageContext.request.contextPath}/user/updatePassword.do",
                data: "oldPassword="+oldPasswordValue+
                        "&newPassword="+newPasswordValue,
                type:"post",
                dataType:"json",
                success:function(ojb){
                    if(ojb.state==0){
                        alert(obj.message);
                    }else{
                        alert(obj.message);
                        location="${pageContext.request.contextPath}/user/showLogin.do";
                    }
                }
            })
        }
    }
</script>