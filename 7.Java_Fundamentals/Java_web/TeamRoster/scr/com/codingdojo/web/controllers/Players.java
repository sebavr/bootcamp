package com.codingdojo.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codingdojo.web.models.Player;
import com.codingdojo.web.models.Roster;
import com.codingdojo.web.models.Team;



/**
 * Servlet implementation class Players
 */
@WebServlet("/players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Players() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int index = Integer.parseInt(request.getParameter("id"));
		System.out.println(index);
		Roster roster = (Roster) session.getAttribute("roster");
		Team t = roster.getTeam(index);
		session.setAttribute("team", t);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/NewPlayer.jsp");
	    view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int index = Integer.parseInt(request.getParameter("id"));
		
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println(first_name);
		System.out.println(last_name);
		System.out.println(age);
		
		session.setAttribute("first_name", first_name);
		session.setAttribute("last_name", last_name);
		session.setAttribute("age", age);
		
		Player p = new Player(first_name, last_name, age);
		Team team = (Team) session.getAttribute("team");
		team.addplayer(p);
		
		System.out.println("Player added");
		System.out.println(index);
		response.sendRedirect("/TeamRoster/teams?id=" + index);
	}

}