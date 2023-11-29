package auction.controllers;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;
import auction.data.BuyerDB;
import auction.business.Buyer;
import auction.business.Notification;
import auction.data.NotiDB;
 
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
                url = "/simpleRegister.jsp";

            }
            else {
                message = "Create new account succesfully, please login in";
                BuyerDB.insert(buyer);
                url = "/simpleLogin.jsp";
            }
            
            
            //Announce succesfull and send to login.jsp
            request.setAttribute("message", message);
            
        }
        else if (action.equals("login")){
            String currentEmail = request.getParameter("email");
            String currentPassword = request.getParameter("password");
            
            String message="";
            if(BuyerDB.checkPassword(currentEmail, currentPassword)){
                

                
                
                Buyer currentBuyer = BuyerDB.selectUser(currentEmail);
                
                //store current login succesfully to use 
                session.setAttribute("buyer", currentBuyer);
                
                //Load to main page 
                if("activate".equals(currentBuyer.getAccountStatus())){
                    message = "Login successfully";
                    session.setAttribute("user", currentBuyer);
                    url = "/simpleMainPage.jsp";
                    
                    
                }
                else{
                    url = "/simpleAddInfoBuyer.jsp";
                }
                
                

            }
            else {
                message = "Wrong account or password, please try again";
                url = "/simpleLogin.jsp";
            }
            
            request.setAttribute("message", message);
            
        }
        
        else if (action.equals("createNewAccount")){
            url = "/simpleRegister.jsp";
        }
        
        else if (action.equals("addInformation")){
            //Get imformation
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            String debitCardInfo = request.getParameter("debitCardInfo");
            
            //get the current buyer
            Buyer currentBuyer = (Buyer) session.getAttribute("buyer");
            
            //Add new value
            currentBuyer.setFirstName(firstName);
            currentBuyer.setLastName(lastName);
            currentBuyer.setAddress(address);
            currentBuyer.setDebitCardInfo(debitCardInfo);
            currentBuyer.setAccountStatus("activate");
            
            //Store to DB
            BuyerDB.update(currentBuyer);
            
            //
            String message = "Update succesfully!";
            request.setAttribute("message", message);
            
            url = "/simpleLogin.jsp";
        
        }
        
        else if (action.equals("loadNofi")){
            Buyer currentUser = (Buyer)session.getAttribute("user");
            String email = currentUser.getEmail();
            System.out.println("This is email from load Nofi" + email);
            List<Notification> tempNofi = NotiDB.selectNotifications(currentUser);
            
            request.setAttribute("nofi", tempNofi);
            
            url = "/simpleNotification.jsp";
            
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