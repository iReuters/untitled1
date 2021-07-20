package dao;

import entity.Dept;
import util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 增删改查
 */

public class DeptDao {
    private String sql;
    private JdbcUtil util = new JdbcUtil();
    private int result = 0;
    public int add(String deptno, String dname, String loc) {
        sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
        util = new JdbcUtil();
        PreparedStatement ps = util.createPs(sql);
        result = 0;
        try {
            ps.setInt(1, Integer.parseInt(deptno));
            ps.setString(2, dname);
            ps.setString(3, loc);
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    public int delete(String deptno) {
        sql = "delete from dept where deptno=?";
        PreparedStatement ps = util.createPs(sql);
        try {
            ps.setInt(1, Integer.parseInt(deptno));
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    public List<Dept> findAll() {
        sql = "select * from dept";
        PreparedStatement ps = util.createPs(sql);
        List<Dept> list = new ArrayList<>();
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt(1));
                dept.setDname(rs.getString(2));
                dept.setLoc(rs.getString(3));
                list.add(dept);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return list;
    }


}
