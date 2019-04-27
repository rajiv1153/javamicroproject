import com.sun.org.apache.regexp.internal.REUtil;
import com.sun.xml.internal.bind.v2.TODO;

import javax.servlet.http.Cookie;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToDoService {
    ConnectDb connectDb=new ConnectDb();
    public int getId(UserData userData) throws SQLException{
        String query= "SELECT id FROM users WHERE username=?";
        Connection connection=connectDb.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        //preparedStatement.setString(1, userData.getName());
        preparedStatement.setString(1,userData.getUsername());
        ResultSet resultSet=preparedStatement.executeQuery();
        if (resultSet.next()){
            int id=resultSet.getInt("id");
            return id;

        }
        return 0;
    }

    public void save (ToDoData toDoData,UserData userData) throws SQLException{
        Connection connection =connectDb.getConnection();
        userData.setId(getId(userData));

        String TodoQuery="INSERT INTO todolist(description,isdone,targetdate,userid) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(TodoQuery);
        preparedStatement.setString(1,toDoData.getDescription());
        preparedStatement.setBoolean(2,false);
        //String date=toDoData.getDuedate();
        //String d=date.toString();
        //System.out.println(d);
        //System.out.println(toDoData.getDuedata());
        //System.out.println(date.toString());
        Date date=toDoData.getDuedate();
        java.sql.Date date1=new java.sql.Date(date.getTime());
        //System.out.println(date1.toString());
        preparedStatement.setDate(3,date1);
        preparedStatement.setInt(4,userData.getId());
        System.out.println(toDoData.getDescription());
        System.out.println(toDoData.getId());
        preparedStatement.execute();
        System.out.println("Todo added succssfully");
        connection.close();

    }
    public List<ToDoData> retrieve(UserData userData) throws SQLException{

        userData.setId(getId(userData));
        System.out.println(userData.getId());
        String query="SELECT * FROM todolist WHERE userid=?";
        Connection connection=connectDb.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1,userData.getId());
        ResultSet resultSet= preparedStatement.executeQuery();
        List<ToDoData>toDoDataList=new ArrayList<>();
        while (resultSet.next()){
            ToDoData toDoData1=new ToDoData();
            String desc= resultSet.getString("description");
            boolean done=resultSet.getBoolean("isdone");
            Date date=resultSet.getDate("targetdate");
            int id=resultSet.getInt("id");
            System.out.println(desc);
            toDoData1.setDescription(desc);
            toDoData1.setDuedate(date);
            toDoData1.setDone(done);
            toDoData1.setId(id);
            toDoDataList.add(toDoData1);
            System.out.println(toDoData1.getDescription());
        }
        return toDoDataList;
    }
     public void delete(ToDoData toDoData) throws SQLException{
        String query="DELETE FROM todolist WHERE id=?";
         Connection connection=connectDb.getConnection();
         PreparedStatement preparedStatement=connection.prepareStatement(query);
         preparedStatement.setInt(1,toDoData.getId());
         preparedStatement.execute();
         System.out.println("TOdo deleted sucessfully");
     }
     public ToDoData retrieveTodo(ToDoData toDoData) throws SQLException{
        String query="SELECT * FROM todolist WHERE id=?";
        Connection connection=connectDb.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1,toDoData.getId());
        ResultSet resultSet=preparedStatement.executeQuery();
        if (resultSet.next()){
            toDoData.setDescription(resultSet.getString("description"));
            toDoData.setDuedate(resultSet.getDate("targetdate"));
            toDoData.setDone(resultSet.getBoolean("isdone"));
            return toDoData;
        }
        return null;
     }
     public void update(ToDoData toDoData) throws SQLException{
        String query= "UPDATE todolist SET description=?,isdone=?,targetdate=? WHERE id=?";
        Connection connection=connectDb.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1, toDoData.getDescription());
        preparedStatement.setBoolean(2,toDoData.getdone());
        Date date=toDoData.getDuedate();
        java.sql.Date date1=new java.sql.Date(date.getTime());
        preparedStatement.setDate(3,date1);
        preparedStatement.setInt(4,toDoData.getId());
        preparedStatement.execute();
        System.out.println("todo updated sucessfully");
     }
}
