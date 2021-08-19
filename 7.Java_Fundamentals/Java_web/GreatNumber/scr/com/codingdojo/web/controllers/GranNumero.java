package com.codingdojo.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codingdojo.web.models.Comparador;

/**
 * Servlet implementation class GranNumero
 */
@WebServlet("/GranNumero")
public class GranNumero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GranNumero() {
        super();
        // TODO Auto-generated constructor stub
    }
    
  
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/index.jsp");
		view.forward(request,response);
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Comparador c=new Comparador();
		

		Integer adivinar= Integer.parseInt(request.getParameter("adivinar"));

		
		session.setAttribute("denuevo",c.isPlayagain());
		
		if(session.getAttribute("a")==null) {
			session.setAttribute("a", c.generarAleatorio());
		}
		
		
		
		
		if(adivinar==(int) session.getAttribute("a")) {
			session.setAttribute("a", c.generarAleatorio());
			session.setAttribute("respuesta", "Correcto");
		}
		else if(adivinar>(int) session.getAttribute("a")) {
			session.setAttribute("respuesta", "Demasiado grande");
		}
		else {
			session.setAttribute("respuesta","Demasiado chico");
		}
	
		response.sendRedirect("GranNumero");
	}

}
