package com.zj.settings.web.controller;

import com.zj.settings.doMain.User;
import com.zj.settings.exception.MyException;
import com.zj.settings.factory.UserLoginFactory;
import com.zj.settings.proxyHandle.UserLoginServcieProxy;
import com.zj.settings.service.UserLoginService;
import com.zj.settings.util.DateUtil;
import com.zj.settings.util.ProxyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class UserControllerImpl implements UserController {
    @Override
    @RequestMapping("user/login")
    @ResponseBody
    public User login(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws MyException {
        String email = request.getParameter("email");
        String psd = request.getParameter("psd");
        String ip = request.getRemoteAddr();
        UserLoginFactory userLoginFactory = new UserLoginFactory();
        UserLoginService proxy = (UserLoginService) ProxyUtil.getProxy(userLoginFactory, new UserLoginServcieProxy(userLoginFactory));
        User user = new User();
        user.setEmail(email);
        user.setIp(ip);
        user.setPsd(psd);
        user.setPriceDate(DateUtil.getDate());

        User login = proxy.login(user);
//        存入会话层
        session = request.getSession();
        session.setAttribute("user",login);
        return login;
    }
}
