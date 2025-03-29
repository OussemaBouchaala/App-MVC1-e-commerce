package presentation.controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.metier.GestionProduit;
import com.project.metier.Produit;

@WebServlet("/product")
public class ProduitC extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private GestionProduit gestionProduit;

    @Override
    public void init() {
        try {
            gestionProduit = new GestionProduit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) action = "list";

        switch (action) {
            case "new":
                request.getRequestDispatcher("produit-form.jsp").forward(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                Produit produit = gestionProduit.getProduitById(id);
                request.setAttribute("produit", produit);
                request.getRequestDispatcher("produit-form.jsp").forward(request, response);
                break;
            case "delete":
                int deleteId = Integer.parseInt(request.getParameter("id"));
                gestionProduit.deleteProduit(deleteId);
                response.sendRedirect("cart.jsp");
                break;
            default:
                List<Produit> produits = gestionProduit.getAllProduits();
                request.setAttribute("produits", produits);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String priceStr = request.getParameter("prix");
        String image = request.getParameter("image");

        String action = request.getParameter("action");
        System.out.println(id + " " + name + " " + description + " " + priceStr + " " + image + " " + action);
        if ("addToCart".equals(action)) {
            addToCart(request, response);
        } else {
            // Handle other actions or delegate to doGet
            // Input validation
            if (name == null || name.trim().isEmpty()) {
                request.setAttribute("error", "Product name is required.");
                request.getRequestDispatcher("produit-form.jsp").forward(request, response);
                return;
            }

            if (description == null || description.trim().isEmpty()) {
                request.setAttribute("error", "Product description is required.");
                request.getRequestDispatcher("produit-form.jsp").forward(request, response);
                return;
            }

            if (priceStr == null || priceStr.trim().isEmpty()) {
                request.setAttribute("error", "Product price is required.");
                request.getRequestDispatcher("produit-form.jsp").forward(request, response);
                return;
            }

            double prix = 0;
            try {
                prix = Double.parseDouble(priceStr.trim());  // Parsing price
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Invalid price format.");
                request.getRequestDispatcher("produit-form.jsp").forward(request, response);
                return;
            }

            Produit produit = new Produit(id, name, description, prix, image);

            // Add or update product
            if (id == 0) {
                boolean newP = gestionProduit.addProduit(produit);
            } else {
                gestionProduit.updateProduit(produit);
            }
        }



        response.sendRedirect("cart.jsp");  // Redirect to the product list
    }

    public void addToCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter("id"));

        Produit produit = gestionProduit.getProduitById(productId);
        if (produit == null) {
            response.sendRedirect("index.jsp?error=Product not found");
            return;
        }

        List<Produit> cart = (List<Produit>) session.getAttribute("userCart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        cart.add(produit);
        session.setAttribute("userCart", cart);

        response.sendRedirect("cart.jsp"); // Redirect to home page to update cart count
    }


}
