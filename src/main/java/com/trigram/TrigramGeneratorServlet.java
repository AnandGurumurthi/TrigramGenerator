package com.trigram;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TrigramGeneratorServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");		
		
		String input = request.getParameter("inputText");
		response.getWriter().println("User Input \n\n"+ input+ "\n\n");
		
		Trigram trigram = new Trigram();
		response.getWriter().println("Response \n\n"+trigram.generateTrigram(input));
	}
}
