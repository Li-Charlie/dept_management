package crmsys1111.Utils;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 创建 SqlSession 所用
 */
public class MyBatisUtils {

    private static SqlSessionFactory sqlSessionFactory = null;
    /*
      读取配置文件是一个很耗时的操作，希望只执行一次就行，所以放入静态代码块（只执行一次）。
     */
    static {
        String resource = "Configuration.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession createSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public static void closeAll(SqlSession sqlSession){
        if (sqlSession != null){
            sqlSession.close();
        }
    }
}
