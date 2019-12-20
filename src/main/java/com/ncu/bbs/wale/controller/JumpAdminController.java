package com.ncu.bbs.wale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author WaleGarrett
 * @Date 2019/12/18 16:43
 */
@Controller
@RequestMapping("/jumps")
public class JumpAdminController {

    @RequestMapping("/toAdminPost")
    public String toAdminPost(){
        return "adminPost";
    }
}
