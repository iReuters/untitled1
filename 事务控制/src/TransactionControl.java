import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionControl {

    public static void main(String[] args) throws Exception{
        String sql1 = "delete from university where id = 7";
        String sql2 = "delete from university whers id = 45";
        String sql3 = "delete from university where id = 2";

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(url, "root", "ztfasdf123");
        connection.setAutoCommit(false);

        PreparedStatement ps = connection.prepareStatement(sql3);

        try {
            ps.executeUpdate(sql1);
            ps.executeUpdate(sql2);

            connection.commit();
        }catch (SQLException e) {
            //由connection通知mysql服务器将本次操作中所有表文件备份覆盖文件，取消本次操作
            System.out.println("取消");
            connection.rollback();
        } finally {
            ps.close();
            connection.close();
        }



    }

}
