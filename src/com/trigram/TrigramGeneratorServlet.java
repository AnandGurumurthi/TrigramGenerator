package com.trigram;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TrigramGeneratorServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");		
		Trigram trigram = new Trigram();
		resp.getWriter().println(trigram.generateTrigram(" I wish I may I wish I might"));
	}
}
