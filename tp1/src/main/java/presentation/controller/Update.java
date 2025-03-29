package presentation.controller;

import com.app.metier.GestionProduit;
import com.app.metier.IGPM;
import com.app.metier.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Update")
public class Update extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        IGPM gestionProduit=new GestionProduit();
        if(session == null ||session.getAttribute("user")==null){
            response.sendRedirect("Login");}
        else{
        if(request.getParameter("name")!=null){
            String name=request.getParameter("name");
            String description=request.getParameter("description");
            int prix=Integer.parseInt(request.getParameter("prix"));
            String image=request.getParameter("image");
            int id=Integer.parseInt(request.getParameter("id"));

            gestionProduit.modifProduit(id, name, description,prix,image);
            String encodedURL = response.encodeRedirectURL("Home");
            response.sendRedirect(encodedURL);
        }
        else {


        if(request.getParameter("id")==null){
            String encodedURL = response.encodeRedirectURL("Home");
            response.sendRedirect(encodedURL);

        }
        else {
            Produit produit= gestionProduit.getProduit(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("produit",produit);
            getServletContext().getRequestDispatcher("/WEB-INF/forbidden/update.jsp").forward(request, response);
        }
        }



        }
    }
    }

