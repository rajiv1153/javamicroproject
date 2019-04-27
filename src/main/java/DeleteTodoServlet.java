import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteTodoServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        ToDoData toDoData=new ToDoData();
        ToDoService toDoService=new ToDoService();
        toDoData.setId(Integer.parseInt(request.getParameter("id")));
         try{
             toDoService.delete(toDoData);
         }catch (SQLException s){
             s.printStackTrace();
         }
         response.sendRedirect("showTodo");
    }
}
