package com.codingdojo.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingdojo.web.models.Gato;



/**
 * Servlet implementation class Gatos
 */
@WebServlet("/Gatos")
public class Gatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gatos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Gato gato=new Gato();
		
		gato.setNombre(request.getParameter("name"));
		gato.setRaza(request.getParameter("breed"));
		gato.setpeso(Integer.parseInt(request.getParameter("weight")));
		
		//esto permite que lo agarremos del jsp
		request.setAttribute("gato",gato);
		
		
		//redirecciona a la vista
		RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/gatojsp.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
