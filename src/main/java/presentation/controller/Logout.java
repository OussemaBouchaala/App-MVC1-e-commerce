package presentation.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// Logout servlet (e.g., Logout.java)
@WebServlet("/logout")
public class Logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidate the session to log the user out
        HttpSession session = request.getSession(false);
        // In your LogoutServlet.java
        System.out.println("DEBUG: User attempting to log out");
        System.out.println("DEBUG: Session before logout: " + session.getAttribute("loggedIn"));

        // After your logout logic
        System.out.println("DEBUG: Logout completed, redirecting to home page");

        // If a session exists, invalidate it
        session.invalidate();


        // Redirect to home page after logout
        response.sendRedirect("index.jsp");
    }
}

