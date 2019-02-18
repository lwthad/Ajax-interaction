//import cn.lwthad.mapper.UserMapper;
//import cn.lwthad.pojo.User;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.mybatis.spring.SqlSessionFactoryBean;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
//public class mybatisTest {
//    private SqlSessionFactoryBean sessionFactory;
//    private static SqlSession session;
//    private UserMapper userMapper;
//
//    @Before
//    public void setup() {
//        String resource = "spring/applicationContext-dao.xml";
//        InputStream is = null;
//        try {
//            is = Resources.getResourceAsStream(resource);
//            sessionFactory = new SqlSessionFactoryBuilder().build(is);
//            session = sessionFactory.openSession();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void getObjects() {
//        // 分页查询
//        // 获取 映射 借口 对象 ;
//        userMapper = session.getMapper(UserMapper.class);
//        User user = userMapper.selectByPrimaryKey(100);
//
//        System.out.println(user + "测试成功");
//    }
//
//    @After
//    public void result() {
//        if (sessionFactory != null) {
//            sessionFactory = null;
//        }
//        if (session != null) {
//            session = null;
//
//        }
//    }
//}
