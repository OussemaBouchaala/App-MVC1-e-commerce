package presentation.controller;

import com.project.metier.GestionClient;
import com.project.metier.Client;
import com.project.metier.GestionProduit;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private GestionClient gestionClient;

    @Override
    public void init() {
        try {
            gestionClient = new GestionClient(); // Inject DAO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Input Validation
        if (username == null || email == null || password == null ||
                username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            response.sendRedirect("register.jsp?error=Please fill all fields");
            return;
        }

        // Create a Client object
        Client newClient = new Client(username, email, password);

        // Save to Database using ClientDAO
        boolean success = gestionClient.addClient(newClient);

        if (success) {
            response.sendRedirect("login.jsp?message=Registration successful");
        } else {
            response.sendRedirect("register.jsp?error=Registration failed");
        }
    }
}
