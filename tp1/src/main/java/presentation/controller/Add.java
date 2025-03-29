package presentation.controller;

import com.app.metier.GestionProduit;
import com.app.metier.IGPM;
import com.app.metier.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Add")
public class Add extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);

        if(session == null ||session.getAttribute("user")==null){
            response.sendRedirect("Login");}
        else {
        if(request.getParameter("name")==null){
            getServletContext().getRequestDispatcher("/WEB-INF/forbidden/add.jsp").forward(request, response);
        }
        else{
            String name=request.getParameter("name");
            String description=request.getParameter("description");
            int prix=Integer.parseInt(request.getParameter("prix"));
            String image=request.getParameter("image");
            IGPM gestionProduit=new GestionProduit();
            User user=(User)session.getAttribute("user");
            gestionProduit.ajouterProduit(name,description,user.getId(),prix,image);
            response.sendRedirect("Home");
        }
    }
    }
}
