package presentation.controller;

import com.app.metier.GestionProduit;
import com.app.metier.IGPM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);

        if(session == null ||session.getAttribute("user")==null){
            response.sendRedirect("Login");}
        else {
        if(request.getParameter("id")==null){
            String encodedURL = response.encodeRedirectURL("Home");
    response.sendRedirect(encodedURL);
}
else {

    int id = Integer.parseInt(request.getParameter("id"));
    IGPM gestionProduit = new GestionProduit();
    gestionProduit.supprimerProduit(id);
            String encodedURL = response.encodeRedirectURL("Home");
            response.sendRedirect(encodedURL);

}


    }
    }
}
