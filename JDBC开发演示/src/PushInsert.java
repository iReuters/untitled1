import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.*;

public class PushInsert {
    public static void main(String[] args) throws SQLException {
        //1.将deiver注册到jvm
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);

        //2.服务器之间建立连接通道
        //jdbc:mysql://服务器所在ip地址:服务器端口号/数据库
        String url = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(url, "root", "ztfasdf123");

        //3.在通道上创建交通工具
        String sql = "insert into minemachine(id, name, hashrate, temp, pow) values(7, '580', 30, 51, '89w')";
        String sql1 = "delete from minemachine where id=7";
        PreparedStatement ps = connection.prepareStatement(sql);

        //4.通过交通工具将sql命令推送到mysql服务器上并带回执行结果
        int result = ps.executeUpdate();

        //5.销毁相关资源
        if (ps != null) {
            ps.close();
        }

        if (connection != null) {
            connection.close();
        }
        System.out.println(result);
    }
}
