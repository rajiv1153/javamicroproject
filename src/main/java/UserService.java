import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
   private ConnectDb connectDb=new ConnectDb();


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


    public int save(UserData userData) throws SQLException{
        String query ="INSERT INTO users(name,username,password) VALUES(?,?,?)";
        Connection connection=connectDb.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,userData.getName());
        preparedStatement.setString(2,userData.getUsername());
        preparedStatement.setString(3,userData.getPassword());
        preparedStatement.execute();
        System.out.println("INsertion sucessful");
        int id=getId(userData);
        connection.close();
        return id;
    }
    public boolean checkuser(UserData userData) throws SQLException{
        String query="SELECT * FROM users WHERE username=? and password=?";
        Connection connection=connectDb.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,userData.getUsername());
        preparedStatement.setString(2,userData.getPassword());
        ResultSet resultSet=preparedStatement.executeQuery();
        if (resultSet.next()){
            String username= resultSet.getString("username");
            String name=resultSet.getString("name");
            String password=resultSet.getString("password");
            if ((username.equalsIgnoreCase(userData.getUsername()) && password.equalsIgnoreCase(userData.getPassword()))){
                System.out.println("login Sucessful");
                int id1=getId(userData);
                userData.setId(id1);
                userData.setName(name);
                userData.setUsername(username);
                userData.setPassword(password);
                return true;
            }
            else{
                System.out.println("user not found");
                return false;
            }
        }return false;
    }

}
