package com.jdhs.project.system.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jdhs.common.utils.StringUtils;
import com.jdhs.framework.shiro.service.RegisterService;
import com.jdhs.framework.web.controller.BaseController;
import com.jdhs.framework.web.domain.AjaxResult;
import com.jdhs.project.system.config.service.IConfigService;
import com.jdhs.project.system.user.domain.User;

/**
 * 注册验证
 * 
 * @author jdhs
 */
@Controller
public class RegisterController extends BaseController
{
    @Autowired
    private RegisterService registerService;

    @Autowired
    private IConfigService configService;

    @GetMapping("/register")
    public String register()
    {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public AjaxResult ajaxRegister(User user)
    {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser"))))
        {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
