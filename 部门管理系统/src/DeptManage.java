import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DeptManage {
    /**
     * 1.添加部门
     * 2.查询部门
     * 3.删除部门
     * 4.更新部门
     */
    public static void main(String[] args) throws Exception {
        Scanner request = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(url, "root", "ztfasdf123");
        int flag = 0;
        String sql_1 = "insert into dept(deptno,dname,loc) values(?,?,?)";
        String sql_2 = "select * from dept";
        PreparedStatement ps = connection.prepareStatement(sql_1);
        String deptNo, dname, loc;
        System.out.println("**********欢迎使用中石油部门管理系统**********");
        System.out.println("**********1.添加部门**********");
        System.out.println("**********2.查询部门**********");
        System.out.println("**********3.删除部门**********");
        System.out.println("**********4.更新部门**********");
        System.out.println("**********请输入操作**********");
        flag = request.nextInt();

        switch (flag) {
            case 1:
                System.out.println("**********请输入部门编号**********");
                deptNo = request.next();
                System.out.println("**********请输入部门名称**********");
                dname = request.next();
                System.out.println("**********请输入部门位置**********");
                loc = request.next();
                ps.setInt(1, Integer.valueOf(deptNo));
                ps.setString(2, dname);
                ps.setString(3, loc);
                ps.executeUpdate();
                System.out.println("**********添加成功**********");
                ResultSet rs = ps.executeQuery(sql_2);
                System.out.println("**********部门数据**********");
                while (rs.next()) {
                    int deptNo1 = rs.getInt(1);
                    String dname1 = rs.getString(2);
                    String loc1 = rs.getString(3);
                    System.out.println(deptNo1 + " " + dname1 + " " + loc1);
                }
                ps.close();
                connection.close();
                break;
            case 2:

                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}
