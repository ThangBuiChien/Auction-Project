
    package auction.controllers;

    import java.io.IOException;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

    import javax.servlet.annotation.WebServlet;

    import auction.data.*;

    import auction.business.*;

    import java.util.List;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpSession;

    @WebServlet("/cart")
    public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        String url = "/index.jsp";
        
        // get current action
        String action = request.getParameter("action");
            if (action == null) {
                action = "cart";  // default action
            }
            if (action.equals("cart"))
            { 
                Buyer currentBuyer = (Buyer) session.getAttribute("buyer");
                Long currrentBuyerID = currentBuyer .getId();
                String productIDString = request.getParameter("productID");
                //Cart cart = (Cart) session.getAttribute("cart");
                if (productIDString != null && !productIDString.isEmpty()) {
                    int productID = Integer.parseInt(productIDString);
                    Cart cart = (Cart) session.getAttribute("cart");
                    if (cart == null) {
                        cart = new Cart();
                    }
                    
                    Product product = new Product();
                    product.setID(productID);
                    
                    url = "/simpleCart.jsp";
                }
                
                
            }

            getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }   

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

   
}