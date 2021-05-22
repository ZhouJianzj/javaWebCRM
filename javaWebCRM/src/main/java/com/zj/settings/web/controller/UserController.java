package com.zj.settings.web.controller;

import com.zj.settings.doMain.User;
import com.zj.settings.exception.MyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public interface UserController {
    User login(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws MyException;
}
