package com.hcl.tests.middle; 

import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaseMiddle1 extends HttpServlet {

private List<String> encodingList = Arrays.asList(new String[]{"UTF-8"});

static final String DB_URL = "jdbc:mysql://localhost/EMP";
static final String USER = "username";
static final String PASS = "password";

@Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

String ip = "127.0.0.1";


 InetAddress addr = InetAddress.getByName(ip);
 String encoding = encodingList.get(0);

 assert encodingList.remove(encoding);

 String userName = request.getParameter("user");
 PreparedStatement pstmt;
 Connection con;
 try {

 con = DriverManager.getConnection(DB_URL,USER,PASS);

 pstmt = con.prepareStatement("select FNAME, LNAME, SSN " + "from USERS where UNAME=" + userName);
 ResultSet rs3 = pstmt.executeQuery();
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }

 }
