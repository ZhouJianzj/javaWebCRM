package com.zj.settings.service;

import com.zj.settings.doMain.User;
import com.zj.settings.exception.IPException;
import com.zj.settings.exception.MyException;
import com.zj.settings.exception.PriceException;


public interface UserLoginService {
   /**
    * 使用动态代理实现他的实现类，用到工厂factory
    * @param user 多个参数需要传递
    * @return 查询到的结果返回为一个user对象
    */
   User login(User user) throws MyException;
}
