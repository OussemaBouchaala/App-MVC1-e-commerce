package presentation.controller;

import com.project.metier.GestionClient;
import com.project.metier.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private GestionClient gestionClient;

    @Override
    public void init() throws ServletException {
        try {
            gestionClient = new GestionClient();  // Initialize the service class
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Client client = gestionClient.validateClient(email, password); // Using GestionClient

        if (client != null) {
            // Start Session & Store Client Info
            HttpSession session = request.getSession();
            session.setAttribute("client", client);
            session.setAttribute("loggedIn", true);

            // Redirect to Home Page (index.jsp)
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            // Redirect back to login with error message
            response.sendRedirect("login.jsp?error=Invalid email or password");
        }
    }
}
