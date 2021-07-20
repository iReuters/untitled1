import dao.DeptDao;
import entity.Dept;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        DeptDao deptDao = new DeptDao();
//        int result = 0;
//        result = deptDao.add("3", "审计", "2楼209");
//        System.out.println(result);
//        result = deptDao.delete("3");
//        System.out.println(result);
        List<Dept> list = deptDao.findAll();
        for (Dept dept: list) {
            System.out.println(dept.getDeptno() + " " + dept.getDname() + " " + dept.getLoc());
        }
    }
}
