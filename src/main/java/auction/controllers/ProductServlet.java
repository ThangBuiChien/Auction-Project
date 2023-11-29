package auction.controllers;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;
import auction.data.ProductDB;
import auction.business.Product;
import auction.business.Buyer;

@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        String url = "/index.jsp";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "loadProduct";  // default action
        }
        
        
        
        if (action.equals("loadProduct")) { 
            List<Product> loadProduct = ProductDB.selectProducts();
            
            request.setAttribute("product", loadProduct);
            
            session.setAttribute("products", loadProduct);

            //url = "/simpleProduct.jsp";
            
            url = "/simpleProduct.jsp";
            
            
            
            //Announce succesfull and send to login.jsp
            
        }
        else if (action.equals("addProduct")){
            Product newProduct = new Product();
            
            String productName = request.getParameter("productName");
            String tag = request.getParameter("tag");
            String description = request.getParameter("description");
            String startingBidPrice = request.getParameter("startingBidPrice");
            int intStartingBidPrice = Integer.parseInt(startingBidPrice);
            String buyNowPrice = request.getParameter("buyNowPrice");
            int intBuyNowPrice = Integer.parseInt(buyNowPrice);
            
            newProduct.setProductName(productName);
            newProduct.setTag(tag);
            newProduct.setDescription(description);
            newProduct.setStartingBidPrice(intStartingBidPrice);
            newProduct.setBuyNowPrice(intBuyNowPrice);
            
            ProductDB.insert(newProduct);
            
            //Load again the product
            
            List<Product> loadProduct = ProductDB.selectProducts();
            
            request.setAttribute("product", loadProduct);
            
            session.setAttribute("products", loadProduct);

            //url = "/simpleProduct.jsp";
            
            url = "/simpleProduct.jsp";
            
            
            
        }
        

        
        else if (action.equals("setBidPrice")){
            String strId = request.getParameter("productID");
            long id = Long.parseLong(strId);

            
            Buyer currentBuyer = (Buyer) session.getAttribute("user");
            String strNewBidPrice = request.getParameter("newBidPrice");
            
            int newBidPrice = Integer.parseInt(strNewBidPrice);
            
            String message = "";
            Product currentProduct = ProductDB.selectProduct(id);
            
            System.out.println("This is id: " + strId);
            
            if(newBidPrice > currentProduct.getCurrentPrice() ){
                currentProduct.setCurrentPrice(newBidPrice);
                currentProduct.setWinner(currentBuyer);
                message = "Update bid price succesful";
                ProductDB.update(currentProduct);
                
            }
            
            else{
                message = "Now bid price is not higer than current bid price, please choose a new bid price";

            }
            
            List<Product> loadProduct = ProductDB.selectProducts();
            
            request.setAttribute("product", loadProduct);           
            session.setAttribute("products", loadProduct);          
            request.setAttribute("message", message);
            

            //url = "/simpleProduct.jsp";
            
            url = "/simpleProduct.jsp"; 
            
            
            
            
            
                    
        }
        
        else if (action.equals("setFinalWinner")){
            String strId = request.getParameter("productID");
            long id = Long.parseLong(strId);
            
            Product currentProduct = ProductDB.selectProduct(id);
            
            currentProduct.setProductStatus(0);
            
            ProductDB.update(currentProduct);
            
            String message ="";
            message = "The winner is" + currentProduct.getWinner().getFirstName();
            
            List<Product> loadProduct = ProductDB.selectProducts();
            
            request.setAttribute("product", loadProduct);           
            session.setAttribute("products", loadProduct);          
            request.setAttribute("message", message);
            

            //url = "/simpleProduct.jsp";
            
            url = "/simpleProduct.jsp"; 
            
            

            
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