import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException,IOException{
        System.out.println("hello");
     UserData userData=new UserData();
     UserService userService=new UserService();
     String name=request.getParameter("name");
     String username=request.getParameter("username");
     String password=request.getParameter("pwd");
     userData.setName(name);
     userData.setUsername(username);
     userData.setPassword(password);
     try{
        int id= userService.save(userData);
        userData.setId(id);

     }
     catch (SQLException e){
         e.printStackTrace();
     }
   // RequestDispatcher requestDispatcher=request.getRequestDispatcher()
        HttpSession httpSession=request.getSession(true);
        httpSession.setAttribute("id",userData.getId());
        httpSession.setAttribute("Name",userData.getName());
        httpSession.setAttribute("Username",userData.getUsername());
        response.sendRedirect("/welcome.jsp");
        }

    }

