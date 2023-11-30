    package auction.controllers;

    import java.io.*;
    import java.util.*;
    import javax.servlet.*;
    import javax.servlet.http.*;

    import javax.servlet.annotation.WebServlet;
    import auction.data.CartDB;
    import auction.data.ProductDB;
    import auction.business.Product;
    import auction.business.Bid;
    import auction.business.Cart;

    
/**
 *
 * @author memo
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {
    @Override
   protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext sc = getServletContext();
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "cart";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "/product.jsp";
        if (action.equals("cart")) {
            String productID = request.getParameter("productID");
           
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }
            List<Cart> listCart = CartDB.Insert;
           
            
            session.setAttribute("cart", cart);
            url = "/cart.jsp";
        }
        
        List<Product> listCart = ProductDB.selectProducts();

        request.setAttribute("products", listCart);    
        session.setAttribute("products", listCart);
                
        sc.getRequestDispatcher(url)
                .forward(request, response);
    }
    
    
   @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }   

}
