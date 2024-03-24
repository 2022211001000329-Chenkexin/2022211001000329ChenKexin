package com.chenkexin.week3.demo;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() {
        ServletConfig config=getServletConfig();
        String driver= config.getInitParameter("driver");
        String url= config.getInitParameter("url");
        String password= config.getInitParameter("password");
        String username= config.getInitParameter("username");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
//            System.out.println("init()-->"+con);
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String sql1 = "INSERT INTO usertable(username,password,email,gender,birthDate) VALUES(?,?,?,?,?);";
        //插入语句
        PreparedStatement pstmt1;
        try {
            pstmt1 = con.prepareStatement(sql1);
            String username= req.getParameter("username");
            String password= req.getParameter("password");
            String email= req.getParameter("email");
            String gender= req.getParameter("gender");
            String birthDate= req.getParameter("birthDate");
            pstmt1.setString(1, username);
            pstmt1.setString(2, password);
            pstmt1.setString(3, email);
            pstmt1.setString(4, gender);
            pstmt1.setString(5, birthDate);
            int count1 = pstmt1.executeUpdate();
            if (count1 > 0) {
                System.out.println("入录成功");
            } else {
                System.out.println("入录失败");
            }
            pstmt1.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //获取对象
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            // 查询数据
            String sql = "SELECT * FROM usertable"; // 假设你要查询的表是usertable
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            // 设置响应内容类型和编码
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                // 输出HTML头部
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>User Table</title>");
                out.println("</head>");
                out.println("<body>");

                // 输出表格
                out.println("<table border='1'>");
                out.println("<tr>");
                // 输出表头
                out.println("<th>ID</th>");
                out.println("<th>Username</th>");
                out.println("<th>password</th>");
                out.println("<th>Email</th>");
                out.println("<th>Gender</th>");
                out.println("<th>Birthdate</th>");

                out.println("</tr>");

                // 遍历结果集，输出每一行数据
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt("id") + "</td>"); // 假设id是整型字段
                    out.println("<td>" + rs.getString("username") + "</td>");
                    out.println("<td>" + rs.getString("password") + "</td>");
                    out.println("<td>" + rs.getString("email") + "</td>");
                    out.println("<td>" + rs.getString("gender") + "</td>"); // 假设id是整型字段
                    out.println("<td>" + rs.getDate("birthdate") + "</td>");


                    out.println("</tr>");
                }

                // 输出表格尾部和HTML尾部
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace(); // 在实际开发中，应该使用日志记录而不是直接打印堆栈跟踪
            // 处理异常，可能返回错误页面给客户端
        } finally {
            // 关闭资源
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }}
}



