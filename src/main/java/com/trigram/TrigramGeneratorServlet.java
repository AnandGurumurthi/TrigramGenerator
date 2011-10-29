package com.trigram;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet class which will receive the user input and generates the trigram
 *  
 * @author Anand
 *
 */
public class TrigramGeneratorServlet extends HttpServlet {

	private static final long serialVersionUID = -4167340506344932931L;
	private static final String ERROR_MSG = "Cannot function with empty text :( ";
	private static final Logger log = Logger.getLogger(TrigramGeneratorServlet.class.getName());
	
	/**
	 * Processes the POST request
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			Trigram trigram = new Trigram();
			String input = request.getParameter("inputText");
			request.setAttribute("input", input);
			if(input != null && input.trim().length() > 0) {
				request.setAttribute("output", trigram.generateTrigram(input));
			} else {
				request.setAttribute("output", ERROR_MSG);
			}
	        request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (ServletException e) {
			log.severe(e.getMessage());
		}
	}
	
	/**
	 * Forwards the GET requests to the POST method
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}
}
