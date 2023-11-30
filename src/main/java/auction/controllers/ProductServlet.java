package auction.controllers;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;
import auction.data.ProductDB;
import auction.data.NotiDB;

import auction.business.Product;
import auction.business.Buyer;
import auction.business.Notification;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


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
            List<Product> loadProduct = ProductDB.selectBiddingProducts();
            
            request.setAttribute("product", loadProduct);
            
            session.setAttribute("products", loadProduct);

            //url = "/simpleProduct.jsp";
            
            url = "/simpleProduct.jsp";
            
            
            
            //Announce succesfull and send to login.jsp
            
        }
        
        else if (action.equals("loadProductByUser")){
            Buyer currentUser = (Buyer)session.getAttribute("user");
            
            List<Product> loadProduct = ProductDB.selectWinningProductsByUser(currentUser);
            
            request.setAttribute("products", loadProduct);
            
            
            url = "/simpleWinningProduct.jsp";

            
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
            
            List<Product> loadProduct = ProductDB.selectBiddingProducts();
            
            request.setAttribute("product", loadProduct);
            
            session.setAttribute("products", loadProduct);

            //url = "/simpleProduct.jsp";
            System.out.println("Call FROM outside schedules, add product succesful!!!!!!!!");

            url = "/simpleProduct.jsp";
            
            
            ////////////Automatically call the GetFinalWinner
            int productID = newProduct.getID();
            
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            
             scheduler.schedule(() -> {
                 
             try{
                 
             System.out.println("Scheduled task executed at: " + System.currentTimeMillis());

                // This block of code will be executed one hour later
                // You can put your "setFinalWinner" logic here

                // Assuming product ID is available in newProduct
                //long productId = newProduct.getId(); // adjust this based on your actual implementation

                // Call the "setFinalWinner" logic here
                // Example:
                // setFinalWinnerLogic(productId);
                
           // long id = Long.parseLong(productID);
            
            //Product currentProduct = ProductDB.selectProduct(productID);
            Product currentProduct = newProduct;
            currentProduct.setProductStatus(1);
            
            ProductDB.update(currentProduct);
            
            String message ="";
            
            message = "The winner is" + currentProduct.getWinner().getFirstName();
            
            List<Product> loadProduct1 = ProductDB.selectBiddingProducts();
            
            request.setAttribute("product", loadProduct1);           
            session.setAttribute("products", loadProduct1);          
            request.setAttribute("message", message);
            
            //check if it run or not
            System.out.println("Call FROM inside schedules!!!!!!!!" + message);
             }
            catch (Exception e) {
                // Catch any exceptions and print the stack trace
                e.printStackTrace();
            }

            }, 100, TimeUnit.SECONDS);
            
            

            
            
            
            
            
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
            
            if(currentProduct.getProductStatus() == 0){
                if(newBidPrice > currentProduct.getCurrentPrice()  ){
                
                //Get notifaction to last owner
                Buyer lastWinner = currentProduct.getWinner();
                java.util.Date date = new java.util.Date();    
                String nofiMessage = "At " + date.toString() + " The bid price of "
                        + currentProduct.getProductName() +  " has changed";
                
                //Create new notification
                Notification newNofi = new Notification();
                newNofi.setUser(lastWinner);
                newNofi.setMessage(nofiMessage);
                
                NotiDB.insert(newNofi);
                
                
                
                
                
                //Set new price and new current winner
                currentProduct.setCurrentPrice(newBidPrice);
                currentProduct.setWinner(currentBuyer);
                message = "Update bid price succesful";
                ProductDB.update(currentProduct);
                
                
                
            }
                else{
                message = "Now bid price is not higer than current bid price, please choose a new bid price";

            }
            }
            else{
                message = "Bidding time is over!";

            }
            
            
            
            List<Product> loadProduct = ProductDB.selectBiddingProducts();
            
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
            
            currentProduct.setProductStatus(1);
            
            ProductDB.update(currentProduct);
            
            String message ="";
            message = "The winner is" + currentProduct.getWinner().getFirstName();
            
            List<Product> loadProduct = ProductDB.selectBiddingProducts();
            
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