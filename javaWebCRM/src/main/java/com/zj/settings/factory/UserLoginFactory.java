package com.zj.settings.factory;

import com.zj.settings.dao.UserDao;
import com.zj.settings.doMain.User;
import com.zj.settings.exception.IPException;
import com.zj.settings.exception.LockException;
import com.zj.settings.exception.MyException;
import com.zj.settings.exception.PriceException;
import com.zj.settings.service.UserLoginService;
import com.zj.settings.util.SqlSessionUtil;




/**
 * 使用动态代理的时候基本的业务需要写到factory类中
 */

public class UserLoginFactory implements UserLoginService {
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
    @Override
    public User login(User user) throws MyException {
        User select = userDao.select(user);
        if (select == null){
            throw new MyException("登录失败！");
        }
        if (user.getPriceDate().compareTo(select.getPriceDate()) < 0){
                throw new PriceException("date异常");

        }
        if (!(user.getIp().contains(select.getIp()))){
                throw new IPException("ip异常");

        }
        if (select.getLockState() == 1){
            throw new LockException("账号已锁定");
        }
        return select;
    }
}
