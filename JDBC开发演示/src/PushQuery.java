import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PushQuery {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(url, "root", "ztfasdf123");

        String sql = "select * from minemachine";
        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int hashrate = rs.getInt("hashrate");
            int temp = rs.getInt("temp");
            String pow = rs.getString("pow");
            System.out.println(id + " " + name + " " + hashrate + " " + temp + " " + pow);
        }
    }
}
