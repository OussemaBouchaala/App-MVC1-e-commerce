package presentation.controller;

import com.app.metier.GestionProduit;
import com.app.metier.Produit;
import com.app.metier.User;

import javax.servlet.http.*;
import com.app.metier.IGPM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/Home")
public class Home extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session == null ||session.getAttribute("user")==null){
            response.sendRedirect("Login");}
        else {
            IGPM gestionProduit=new GestionProduit();
            User user=(User)session.getAttribute("user");
        ArrayList<Produit> produits=gestionProduit.getProduits(user.getId());
        request.setAttribute("produits",produits);
        getServletContext().getRequestDispatcher("/WEB-INF/forbidden/home.jsp").forward(request, response);}





    }

}
