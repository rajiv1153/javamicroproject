import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdateTodoServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ToDoData toDoData=new ToDoData();
        toDoData.setId(Integer.parseInt(request.getParameter("id")));
        //System.out.println(toDoData.getId());
        try{
            request.getSession().setAttribute("todoData", new ToDoService().retrieveTodo(toDoData));
        }catch (SQLException a){
            a.printStackTrace();
        }
        System.out.println(toDoData.getId());
        request.getRequestDispatcher("/editTodo.jsp?id=todoData.getId();").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        ToDoData toDoData=new ToDoData();
        ToDoService toDoService=new ToDoService();
        toDoData.setDescription(request.getParameter("desc"));
        toDoData.setDone(Boolean.parseBoolean(request.getParameter("isdone")));
        toDoData.setId(Integer.parseInt(request.getParameter("id")));
        try{
            toDoData.setDuedate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("targetdate")));
        }catch (ParseException a){
            a.printStackTrace();
        }
        try {
            toDoService.update(toDoData);
        }catch (SQLException b){
            b.printStackTrace();
        }
        response.sendRedirect("showTodo");

    }
}

