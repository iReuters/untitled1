import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PushUpdate {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(url, "root", "ztfasdf123");
        String sql = "update minemachine set pow='260w' where name='2080ti'";
        PreparedStatement ps = connection.prepareStatement(sql);
        int result = ps.executeUpdate();
        System.out.println(result);
        if (ps != null) {
            ps.close();
        }

        if (connection != null) {
            connection.close();
        }
    }
}
