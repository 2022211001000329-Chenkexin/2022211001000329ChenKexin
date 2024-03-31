package com.chenkexin.week5;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "loginServlet",value = "/login",initParams = {
        @WebInitParam(name = "driver",value = "com.mysql.cj.jdbc.Driver"),
        @WebInitParam(name = "url",value ="jdbc:mysql://127.0.0.1:3306/userdb"),
        @WebInitParam(name = "username",value = "root"),
        @WebInitParam(name = "password",value = "666888")

},loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("userName");
        String password = req.getParameter("Password");
        PrintWriter writer = resp.getWriter();
        String sql = "SELECT * FROM usertable WHERE username = ? AND password = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 假设con是已经初始化好的数据库连接对象
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);

            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            ;
            if (rs.next()) {
                writer.println("Login Success!!!");
                writer.println("Welcome ," + username);
            } else {
                writer.println("Username or Password Error");
            }
        } catch (SQLException e) {
            writer.println("Error during login: " + e.getMessage());
        } finally {
            // 关闭资源
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                // 注意：这里通常还需要关闭连接con，但如果con是连接池中的连接，则不应关闭它
            } catch (SQLException ex) {
                // 处理资源关闭时的异常
            }
        }




    }}