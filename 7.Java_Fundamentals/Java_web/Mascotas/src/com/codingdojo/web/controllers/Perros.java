package com.codingdojo.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.codingdojo.web.models.Perro;

/**
 * Servlet implementation class Perros
 */
@WebServlet("/Perros")
public class Perros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Perros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Perro perro=new Perro();
		
		perro.setNombre(request.getParameter("name"));
		perro.setRaza(request.getParameter("breed"));
		perro.setpeso(Integer.parseInt(request.getParameter("weight")));
		
		//esto permite que lo agarremos del jsp
		request.setAttribute("perro",perro);
		
		
		//redirecciona a la vista
		RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/perro.jsp");
		view.forward(request,response);
		
		/*String raza= request.getParameter("breed");
		int edad =  Integer.parseInt(request.getParameter("age"));
		
		
		
	*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
