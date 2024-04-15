package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDao;
import dto.Movie;

@WebServlet("/fetch-rating")	
public class fechMoviesByRating extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Fetch-by-rating.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double rating = Double.parseDouble(req.getParameter("rating"));
		MovieDao dao = new MovieDao();
		List<Movie> list = dao.fetchMoviesByRating(rating);
		if (list.isEmpty()) {
			resp.getWriter().print("<h1 style='colour:red' align:'center'>No Movies Found</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		} else {
			req.setAttribute("list", list);
			req.getRequestDispatcher("Fetchall.jsp").forward(req, resp);
		}
	}
}
