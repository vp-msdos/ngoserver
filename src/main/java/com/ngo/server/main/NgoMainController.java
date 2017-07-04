package com.ngo.server.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ngo.server.connection.ConnectionPool;
import com.ngo.server.pojos.Emp;
import com.ngo.server.utilities.NgoProperty;

/**
 * Servlet implementation class NgoMainController
 */
public class NgoMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NgoMainController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:Vishwas ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NgoProperty.loadNgoProperties();
		String json = request.getParameter("OBJ");
		Gson gson = new Gson();
		Emp names = gson.fromJson(json,Emp.class);
		response.setContentType("text/text");
        response.setCharacterEncoding( "UTF-8" );
        PrintWriter out = response.getWriter();
        out.append(names.getId()+" "+names.getEmpName());
        out.close();
		//doGet(request, response);
	}

}
