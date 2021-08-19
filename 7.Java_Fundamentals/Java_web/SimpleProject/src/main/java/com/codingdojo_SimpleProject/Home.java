package com.codingdojo_SimpleProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Obtener los valores para los parámetros de consulta
	        String userName = request.getParameter("firstName");
	        String userLastName = request.getParameter("lastName");
	        String userLanguage = request.getParameter("favoriteLanguage");
	        String userHomeTown = request.getParameter("homeTown");
	        
	        if(userName==null) {
	        	userName="Unknown";
	        }
	        if(userLastName==null) {
	        	userLastName="Unknown";
	        }
	        if(userLanguage==null) {
	        	userLanguage="Unknown";
	        }
	        if(userHomeTown==null) {
	        	userHomeTown="Unknown";
	        }
	        
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.write("<h1>Welcome " + userName +" "+userLastName+"</h1>");
	        out.write("<h2>Your favorite language is: "+userLanguage+"</h2>");
	        out.write("<h2>Your HomeTown is : " + userHomeTown+"</h2>");
	    }
	//http://localhost:8080/SimpleProject/Home?firstName=Sebastian&lastName=Villasenor&favoriteLanguage=Java&homeTown=Concepcion
	}