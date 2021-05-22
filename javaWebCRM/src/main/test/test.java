import com.zj.settings.dao.UserDao;
import com.zj.settings.doMain.User;
import com.zj.settings.exception.IPException;
import com.zj.settings.exception.MyException;
import com.zj.settings.factory.UserLoginFactory;
import com.zj.settings.proxyHandle.UserLoginServcieProxy;
import com.zj.settings.service.UserLoginService;
import com.zj.settings.util.DateUtil;
import com.zj.settings.util.MD5Util;
import com.zj.settings.util.ProxyUtil;
import com.zj.settings.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class test {
    @Test
    public void testMybatis(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
    }
    @Test
    public void testDate(){
        System.out.println(DateUtil.getDate());
    }
    @Test
    public void testMD5(){
        String zhouJian = MD5Util.getMD5("zhouJian", false, 32);
        System.out.println(zhouJian);
        System.out.println(zhouJian.length());
    }

    /**
     * 测试动态代理
     */
    @Test
    public void testProxy() throws MyException {
        UserLoginService userLoginServcie = new UserLoginFactory();
        InvocationHandler invocationHandler = new UserLoginServcieProxy(userLoginServcie);
        UserLoginService o = (UserLoginService) Proxy.newProxyInstance(userLoginServcie.getClass().getClassLoader(),
                userLoginServcie.getClass().getInterfaces(), invocationHandler);
        User user = new User();
        user.setIp("127.0.0.1");
        user.setEmail("2998390669@qq.com");
        user.setPsd("123123");

        userLoginServcie.login(user);
    }

    /**
     * 测试自己的工具类实现动态代理
     */
    @Test
    public void testProxyUtil() throws MyException {
        UserLoginFactory userLoginFactory = new UserLoginFactory();
//        注意的是在自定义proxyhandle的时候需要转递factory参数
        UserLoginService proxy = (UserLoginService)ProxyUtil.getProxy(userLoginFactory,new UserLoginServcieProxy(userLoginFactory));
        User user = new User();
        user.setIp("127.0.0.1");
        user.setEmail("2998390669@qq.com");
        user.setPsd("123123");
        proxy.login(user);

    }

    /**
     * 测试异常
     * @throws IPException
     */
    @Test
    public void testException() throws IPException {
        if (true){
            IPException ipE = new IPException("ip地址不对");

            throw ipE;
        }
    }
}
