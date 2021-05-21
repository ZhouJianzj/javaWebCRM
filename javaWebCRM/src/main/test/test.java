import com.zj.settings.dao.UserDao;
import com.zj.settings.util.DateUtil;
import com.zj.settings.util.MD5Util;
import com.zj.settings.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class test {
    @Test
    public void testMybatis(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.select();
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
}
