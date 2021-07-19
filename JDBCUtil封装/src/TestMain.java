import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        JdbcUtil util = new JdbcUtil();
        Scanner request = new Scanner(System.in);
        String sql1 = "select * from university";
        PreparedStatement ps = util.createPs(sql1);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String loc = rs.getString(3);
                String level = rs.getString(4);
                System.out.println(id + " " + name + " " + loc + " " + level);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }


    }

}
