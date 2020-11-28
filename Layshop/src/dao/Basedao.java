package dao;

import java.sql.*;

public class Basedao {
    static {
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public static Connection getconn() {
        //创建一个连接对象
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql:///Layshop?serverTimezone=UTC","root","123456");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conn;

    }

    public static int exectuIUD(String sql, Object[] params) {
        int count = 0;

        Connection conn = Basedao.getconn();

        //准备SQL
        PreparedStatement ps = null;

        //insert into user(''''''','') value(?, ?, ?)
        try {
            //准备SQL
            ps = conn.prepareStatement(sql);
            //绑定
            for(int i=0; i<params.length; i++) {
                ps.setObject(i+1, params[i]);
            }
           //执行
            count = ps.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            Basedao.closeall(null, ps, conn);

        }

        return count;
    }

    public static void closeall(ResultSet rs, PreparedStatement ps, Connection conn) {

        try {
            if(rs!=null)

                rs.close();
            if(ps!=null)
                ps.close();

            if(conn!=null)
                conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
