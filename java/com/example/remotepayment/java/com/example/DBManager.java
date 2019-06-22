package com.example.liuji.nfcdemo;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String dbURL = "jdbc:mysql://111.231.170.52:3306/softwareDB?serverTimezone=UTC";
    private static String userName = "root";
    private static String userPwd = "123456";

    /*
     * 注册老人账户
     * @param account
     * @return 操作是否成功
     */
    public boolean registNewParent(UserInfo userInfo) {
        String sql = "INSERT INTO userTable(id, userName, idCard, phone, passWord, role) VALUES " +
                "(?,?,?,?,?,?)";
        Object []args = {userInfo.getID(), userInfo.getUserName(), userInfo.getIdCard(), userInfo.getPhone(),
        userInfo.getPassword(),userInfo.getRole()};
        return executeUpdate(sql, args);
    }

    /**
     * @param userName 用户名
     * @param userInfo 返回的用户信息
     * @return 操作是否成功
     */
    public static boolean getUserInfo(String userName, UserInfo userInfo) {
        String sql = "SELECT * FROM ? WHERE ?=?";
        Object []args = {"userTable", "userName", userName};
        ResultSet resultSet = executeQuery(sql, args);
        boolean result = false;
        try {
            if(resultSet.next()) {
                userInfo.setID(resultSet.getInt(1));
                userInfo.setUserName(resultSet.getString(2));
                userInfo.setIdCard(resultSet.getString(3));
                userInfo.setPhone(resultSet.getString(4));
                userInfo.setPassword(resultSet.getString(5));
                userInfo.setRole(resultSet.getInt(6));
                result = true;
            }
            if(resultSet != null) {
                resultSet.close();
            }
            }catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /*
     * @param userInfo 用户信息
     * @param childInfo 返回的子女信息
     * @return 操作是否成功
     */
    public static boolean getChildInfo(UserInfo userInfo, ArrayList<BindingInfo> bindingInfo) {
        String sql = "SELECT * FROM ? WHERE ?=?";
        Object []args = {"bindingTable", "pid", userInfo.getID()};
        ResultSet resultSet = executeQuery(sql, args);
        boolean result = false;
        try {
            BindingInfo tempChildInfo = null;
            while(resultSet.next()) {
                tempChildInfo.setPid(resultSet.getInt(1));
                tempChildInfo.setChildName(resultSet.getString(2));
                tempChildInfo.setChildPhone(resultSet.getString(3));
                bindingInfo.add(tempChildInfo);
            }
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 添加订单信息
     * @param cartInfo 订单记录
     * @return 添加是否成功
     */
    public static boolean insertCartInfo(CartInfo cartInfo) {
        String sql = "INSERT INTO cartTable(cartID, shopperID, parentID,childID, " +
                "appleNumber, applePrice, pearNumber, pearPrice, bananaNumber, " +
                "bananaPrice, watermelonNumber,watermelonPrice, totalPrice, payFlag) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        Object []args = {cartInfo.getCartID(),cartInfo.getShopperID(),cartInfo.getParentID(),cartInfo.getAppleNumber(),
        cartInfo.getApplePrice(),cartInfo.getPearNumber(),cartInfo.getPearPrice(),cartInfo.getBananaNumber(),cartInfo.getBananaPrice(),
        cartInfo.getWatermelonNumber(),cartInfo.getWatermelonPrice(),cartInfo.getTotalPrice(),cartInfo.getPayFlag()};
        return  executeUpdate(sql, args);
    }
    /**
     * 获取数据库连接
     * @return
     */
    private static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbURL, userName, userPwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 执行查询操作
     * @param SQL
     * @param args
     * @return 查询结果
     */
    public static ResultSet executeQuery(String SQL, Object []args) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            conn = getConn();
            pStmt = conn.prepareStatement(SQL);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    pStmt.setObject(i + 1, args[i]);
                }
            }
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pStmt != null)
                    pStmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 执行增删改操作
     * @param SQL
     * @param args
     * @return 操作是否成功
     */
    public static boolean executeUpdate(String SQL, Object []args) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        try {
            conn = getConn();
            pStmt = conn.prepareStatement(SQL);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    pStmt.setObject(i + 1, args[i]);
                }
            }
            int result = pStmt.executeUpdate();
            if (result > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pStmt != null)
                    pStmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
