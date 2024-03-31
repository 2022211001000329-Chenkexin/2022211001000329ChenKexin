package com.chenkexin.week2.demo;



import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;



public class HelloWorldServlet extends HttpServlet {
    public void  doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter writer=response.getWriter();
        writer.println("Name:Chen Kexin");
        writer.println("ID:2022211001000329");
        writer.println("Date and TimeSun Mar 10 19:21:56 CST 2024");

    }
public void doPost(HttpServletRequest request,HttpServletResponse response){}



}
