package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.MovieDao;
import dto.Movie;

@WebServlet("/insert-movie")
@MultipartConfig
public class InsertMovie extends HttpServlet{
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("insert.html").forward(req, resp);
		}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	String language=req.getParameter("language");
	double rating=Double.parseDouble(req.getParameter("rating"));
	Part picture=req.getPart("picture");
	String genre=req.getParameter("genre");
	try {
//		double rating=Double.parseDouble(req.getParameter("rating"));
//	if(language==null || genre==null) {
//		resp.getWriter().print("<h align='center'>Enter Language and Genre</h1>");
//		req.getRequestDispatcher("home.html").include(req, resp);
//
//	}
//	else {
//		resp.getWriter().print(name+" "+language+" "+rating+" "+picture+" "+genre);
//	}
	
	Movie movie=new Movie();
	movie.getLanguage();
	movie.setGenre(genre);
	movie.setName(name);
	movie.setRating(rating);
	byte[] image=new byte[picture.getInputStream().available()];
	picture.getInputStream().read(image);
	movie.setPicture(image);
	
	MovieDao dao=new MovieDao();
	dao.saveMovie(movie);
	
	resp.getWriter().print("<h1 align='center'>Movie Added Sucess</h1>");
	req.getRequestDispatcher("insert.html").include(req, resp);
	
	}
	  
	catch(NumberFormatException e) {
		resp.getWriter().print("<h1 align='centre'>Enter Proper Rating</h1>");
		req.getRequestDispatcher("insert.html").include(req, resp);
	}
//	resp.getWriter().print(name+" "+language+" "+rating+" "+picture+" "+genre);
	
}
}
