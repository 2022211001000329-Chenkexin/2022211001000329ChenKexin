package com.chenkexin.week4;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfigDemoServlet", urlPatterns = "/config", initParams = {
        @WebInitParam(name = "name1", value = "Chenkexin"),
        @WebInitParam(name = "studentId1", value = "2022211001000329")
})

public class ConfigDemoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletConfig config = getServletConfig();

         String name = config.getInitParameter("name");
         String student_id = config.getInitParameter("student_id");
        String name1 = config.getInitParameter("name1");
        String studentId1 = config.getInitParameter("studentId1");

        PrintWriter writer = resp.getWriter();
        writer.println("<br> Task1-Get init parameters defined in web.xml");
         writer.println("<br><br> name:" + name);
         writer.println("<br> student_id:" + student_id);
        writer.println("<br> Task2-Get init parameters from @WebServlet");
        writer.println("<br><br> name1:" + name1);
        writer.println("<br> studentId1:" + studentId1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        // POST请求的处理逻辑可以放在这里
    }
}