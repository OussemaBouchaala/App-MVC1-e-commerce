package presentation.controller;
import com.app.DAO.gestionProduitDAO;
import com.app.metier.GerstionUser;

import com.app.metier.Produit;
import com.app.metier.User;
import com.app.metier.IGUM;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Login")
public class Login extends HttpServlet {
    public IGUM gestionUser=new GerstionUser();
    public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        if(request.getParameter("email")==null){
            getServletContext().getRequestDispatcher("/WEB-INF/forbidden/login.jsp").forward(request, response);
        }
        else {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = gestionUser.validateUser(email, password);

            if (user != null) {

                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                String encodedURL = response.encodeRedirectURL("Home");
                response.sendRedirect(encodedURL);

            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/forbidden/error.jsp").forward(request, response);
            }

        }



    }
}
