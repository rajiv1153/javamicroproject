import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ToDoServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        System.out.println("add todo");
        UserData userData=new UserData();
        ToDoData toDoData=new ToDoData();
        ToDoService toDoService=new ToDoService();

        HttpSession httpSession=request.getSession();
        if (httpSession.getAttribute("Username")==null){
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
        String username= httpSession.getAttribute("Username").toString();
        int i =Integer.parseInt(httpSession.getAttribute("id").toString());
        userData.setId(i);
        userData.setUsername(username);
        toDoData.setDescription(request.getParameter("desc"));
       // toDoData.setDuedate(request.getParameter(("duedate")));
        try{
            toDoData.setDuedate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("duedate")));
        }catch (ParseException p){
            p.printStackTrace();
        }
         try {
             toDoService.save(toDoData,userData);
         }catch (SQLException s){
             s.printStackTrace();
         }response.sendRedirect("showTodo");
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        System.out.println("do get showtodo");
        ToDoService toDoService=new ToDoService();
        UserData userData=new UserData();
        HttpSession httpSession=request.getSession(true);
        if (httpSession.getAttribute("Username")==null){
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
        String username=httpSession.getAttribute("Username").toString();
         userData.setUsername(username);
         try{
             request.getSession().setAttribute("todo",toDoService.retrieve(userData));
         }catch (SQLException a){
             a.printStackTrace();
         }
         request.getRequestDispatcher("/showTodo.jsp").forward(request,response);
    }

}
