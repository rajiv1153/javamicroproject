import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException , IOException {
        UserData userData=new UserData(request.getParameter("username"),request.getParameter("password"));
        UserService userService=new UserService();
        boolean check=false;
        try{
            check=userService.checkuser(userData);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        if (check){
            HttpSession httpSession=request.getSession(true);
            httpSession.setAttribute("id",userData.getId());
            httpSession.setAttribute("Name",userData.getName());
            httpSession.setAttribute("Username",userData.getUsername());
          //  System.out.println(httpSession.getAttribute("Name"));
            //System.out.println(userData.getUsername());
            //System.out.println("hellowelcome");
           //request.getRequestDispatcher("/welcome.jsp").forward(request,response);
           response.sendRedirect("/welcome.jsp");

        }
        else{
            //request.getRequestDispatcher("/index.jsp").forward(request,response);
            request.getSession().setAttribute("loginMessage","username or password wrong");
            response.sendRedirect("/index.jsp");
        }
    }
}
