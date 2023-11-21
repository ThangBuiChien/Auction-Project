package auction.controllers;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;
import auction.data.BuyerDB;
import auction.business.Buyer;
 
@WebServlet("/userLogin")
public class UsersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        String url = "/index.jsp";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "register";  // default action
        }
        
        
        
        if (action.equals("register")) { 
            
            //Get imformation
            String newEmail = request.getParameter("email");
            String newPassword = request.getParameter("password");
            
            //Create new buyer with information
            Buyer buyer = new Buyer();
            buyer.setEmail(newEmail);
            buyer.setPassword(newPassword);
            
            //save to database
            String message;
            if (BuyerDB.emailExists(newEmail)) {
                message = "This email address already exists.<br>" +
                          "Please enter another email address.";
            }
            else {
                message = "Create new account succesfully, please login in";
                BuyerDB.insert(buyer);
            }
            
            BuyerDB.insert(buyer);
            
            //Announce succesfull and send to login.jsp
            request.setAttribute("message", message);
            
            url = "/simpleRegister.jsp";

            
            
            

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