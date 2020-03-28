package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Event;
import dao.EventDAO;

public class EventServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		 

        List<Event> eventList = new EventDAO().list();
 
        request.setAttribute("eventList", eventList);
 
        request.getRequestDispatcher("NewFile.jsp").forward(request, response);
    }
}
