/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resenas01;

import antlr.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.fpauer.filters.Config;
//import org.fpauer.json.JSONObject;
/**
 *
 * @author usuario
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        // get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        if(user.isEmpty() || pwd.isEmpty())
        {            
        	emitMessage("Login error", request, response);
        	return;
        }
        
        StringBuilder sUrl = new StringBuilder();
        sUrl.append("http://localhost:8080/Resenas01")
        .append("/webresources/user/").append("juan@gmail.com").append("/").append("123");
		
		URL url = new URL(sUrl.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		int responseCode = -1;
		
		try
		{
                    responseCode = conn.getResponseCode();
		}
		catch(ConnectException e)
		{
                    emitMessage("Failed to load HTTP: " + sUrl.toString(), request, response);
                    return;
		}
		
		if (responseCode != 200) {

			if (responseCode == 401) 
			{
				emitMessage("LOGIN ERROR", request, response);
			}
			else
			{
				emitMessage("Failed : " + sUrl.toString() + "HTTP error code : " + responseCode, request, response);
			}
		}
		else
		{
                    
//			JSONObject json = Utils.INSTANCE.getResponseData(conn);
                        String data = "";
                        try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                                String output = null;
                                while ((output = br.readLine()) != null) {
                                        data += output;
                                }
                               
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
			conn.disconnect();
			
	        if ( !data.isEmpty() && data.contains("lookup") ) {
//	        	String value = "{\"Status\":\"OK\",\"acessToken\":\"juan@gmail.com\",\"userData\":"+json.get("lookup").toString()+"}";
	        	Cookie accessCookie = new Cookie( "User", "juan@gmail.com");
	            accessCookie.setMaxAge(30*60);
	            accessCookie.setPath("/");
	            response.addCookie(accessCookie);

            	HttpSession session = request.getSession();
            	if( session != null && session.getAttribute("callback") != null )
            	{
            		response.sendRedirect(session.getAttribute("callback").toString());
            	}
            	else 
	            	response.sendRedirect("LoginSuccess.jsp");
            	
	        } else {
	        	emitMessage("ERROr", request, response);
	        }
		}
    }

    private RequestDispatcher emitMessage(String message, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
    	try
		{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>"+message+"</font>");
            rd.include(request, response);
            return rd;
		}			
		catch(NullPointerException e)
		{
			throw new ServletException(message);
		}
    }
 
    

}
