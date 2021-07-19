import java.sql.*;

public class BatchInsert {
    public static void main(String[] args) throws Exception {
        String[] name = {"'北大'", "'清华'", "'天大'", "'矿大'"};
        String[] loc = {"'北京'", "'北京'", "'天津'", "'徐州'"};
        String[] level = {"'985 211'", "'985 211'", "'985 211'", "'211'"};
        String sql;
        PreparedStatement ps;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(url, "root", "ztfasdf123");
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "university", null);

        if(!resultSet.next()) {
            sql = "create table university(id int primary key , name varchar(20), loc varchar(20), level varchar(20))";
            ps = connection.prepareStatement(sql);
        }

        for (int i = 0; i < 4; i++) {
            sql = "insert into university(id, name, loc, level) values(" + i + "," + name[i] + "," + loc[i] + "," + level[i] + ")";
            System.out.println(sql);
            ps = connection.prepareStatement(sql);
            ps.executeUpdate(sql);
        }
        sql = "select * from university";
        ps = connection.prepareStatement(sql);
        ResultSet rs  = ps.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            String name1 = rs.getString("name");
            String loc1 = rs.getString("loc");
            String level1 = rs.getString("level");
            System.out.println(id + " " + name1 + " " + loc1 + " " + level1);
        }

    }
}
