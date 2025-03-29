package presentation.controller;

import com.app.metier.GestionProduit;
import com.app.metier.IGPM;
import com.app.metier.Produit;
import com.app.metier.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/Search")
public class Search extends HttpServlet {
    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session == null ||session.getAttribute("user")==null){
            response.sendRedirect("Login");}
        else {
            IGPM gestionProduit=new GestionProduit();
            User user=(User)session.getAttribute("user");
            ArrayList<Produit> produits=gestionProduit.rechercherProduit(user.getId(),request.getParameter("search"));
            request.setAttribute("produits",produits);
            getServletContext().getRequestDispatcher("/WEB-INF/forbidden/home.jsp").forward(request, response);}

    }
}
