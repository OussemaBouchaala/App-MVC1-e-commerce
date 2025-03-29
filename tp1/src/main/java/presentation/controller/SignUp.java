package presentation.controller;

import com.app.metier.IGUM;
import com.app.metier.GerstionUser;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
    public IGUM gestionUser=new GerstionUser();
    public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        if(request.getParameter("email")==null){
            getServletContext().getRequestDispatcher("/WEB-INF/forbidden/signup.jsp").forward(request, response);
        }
        else {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nom= request.getParameter("nom");

        gestionUser.saveUser(email,password,nom);
            response.sendRedirect("Login");}


    }
}
