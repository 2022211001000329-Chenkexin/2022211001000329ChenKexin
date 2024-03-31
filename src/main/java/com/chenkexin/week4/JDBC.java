
package com.chenkexin.week4;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@WebServlet(name = "helloServlet",value = "/hello-servlet",initParams = {
        @WebInitParam(name = "driver",value = "com.mysql.cj.jdbc.Driver"),
        @WebInitParam(name = "url",value ="jdbc:mysql://127.0.0.1:3306/userdb"),
        @WebInitParam(name = "username",value = "root"),
        @WebInitParam(name = "password",value = "666888")

},loadOnStartup = 1)
public class JDBC extends HttpServlet {
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

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}