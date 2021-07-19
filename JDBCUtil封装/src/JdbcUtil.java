import java.sql.*;

/**
 * 1.注册数据库服务器提供Driver接口实现类
 * 2.创建一个连接通道交给Connection接口的实例对象
 * 3.创建一个交通工具
 * 4.由交通工具在Java工程与数据库服务器之间进行传输，推送sql命令并带回执行结果
 * 5.销毁资源
 */

public class JdbcUtil {
    private Connection connection = null;
    private PreparedStatement ps = null;
    //在当前类文件第一次被加载到JVM时，JVM会自动调用当前类文件静态语句块。
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Driver接口实现类已注册");
    }

    //封装Connection对象创建细节
    public Connection createCon() {

        String url = "jdbc:mysql://localhost:3306/test";
        try {
            connection = DriverManager.getConnection(url, "root", "ztfasdf123");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("connection对象创建失败");
        }
        return connection;
    }

    //封装PreparedStatement对象创建细节
    public PreparedStatement createPs(String sql) {

        try {
            ps = createCon().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }

    //销毁资源
    public void close() {
        try {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //销毁资源
    public void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        close();
        }
    }

