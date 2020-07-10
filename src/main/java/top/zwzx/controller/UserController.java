package top.zwzx.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.zwzx.pojo.ResponseResult;
import top.zwzx.pojo.User;
import top.zwzx.service.IUserService;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author zx
 * @date 2020/7/9
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private IUserService userService;

    @RequestMapping("/checkUsername.do")
    @ResponseBody
    public ResponseResult<Void> checkUsername(String username) {
        System.out.println(username);
        ResponseResult<Void> rr = new ResponseResult<Void>();
        Boolean b = userService.checkUserName(username);
        if (b) {
            rr.setState(0);
            rr.setMessage("用户名不可使用");
        } else {
            rr.setState(1);
            rr.setMessage("用户名可以使用");
        }
        System.out.println(rr);
        return rr;
    }

    @RequestMapping("/submit.do")
    @ResponseBody
    public ResponseResult<Void> submitRegister(
            @RequestParam("uname") String username,
            @RequestParam("upwd") String password,
            String email,
            String phone
    ) {
        ResponseResult<Void> rr = new ResponseResult<Void>();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCreated_user(username);
        user.setCreated_time(new Date());
        user.setModified_user(username);
        user.setModified_time(new Date());
        try {
            userService.submitRegister(user);
            rr.setState(1);
            rr.setMessage("注册成功");
        } catch (Exception e) {
            rr.setState(0);
            rr.setMessage(e.getMessage());
        }
        System.out.println(rr);
        return rr;
    }

    @RequestMapping("/showLogin.do")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/login.do")
    @ResponseBody
    public ResponseResult<Void> login(String username, String password, HttpSession session) {
        System.out.println(username);
        ResponseResult<Void> rr = new ResponseResult<Void>();

        try {
            User user=userService.login(username,password);
            session.setAttribute("user",user);
            rr.setState(1);
            rr.setMessage("登陆成功");
        } catch (Exception e) {
            rr.setState(0);
            rr.setMessage(e.getMessage());
        }
        System.out.println(rr);
        return rr;
    }
    @RequestMapping("/exit.do")
    public String exit(HttpSession session){
//        session失效
        session.invalidate();
        return "redirect:../main/showIndex.do";
    }

    @RequestMapping("/showRegister.do")
    public String showRegister() {
        return "register";
    }
    @RequestMapping("/showPassword.do")
    public String showPassword(){
        return "personal_password";
    }
    @RequestMapping("updatePassword.do")
    @ResponseBody
    public ResponseResult<Void> updatePassword(String oldPassword,String newPassword,HttpSession session){
        ResponseResult<Void> rr = new ResponseResult<Void>();
    try{
        User user=(User) session.getAttribute("user");
        Integer id=null;
        if(user!=null){
            id=user.getId();
        }
        userService.changePassword(id,oldPassword,newPassword);
        rr.setState(1);
        rr.setMessage("修改成功");
    }catch (Exception e){
        rr.setState(0);
        rr.setMessage("修改失败");
    }
        return rr;
    }

}
