package top.zwzx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zx
 * @date 2020/7/10
 **/
@Controller
@RequestMapping("/main")
public class MainController {
    @RequestMapping("/showIndex.do")
    public String showIndex(){
        return "index";
    }

}
