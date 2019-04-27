import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDb {
    private static final String username="root";
    private static final String password="";
    private static final String hostname="localhost:3304";

    public Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        Connection connection= DriverManager.getConnection("jdbc:mysql://"+hostname+"/todo",username,password);
        System.out.println("Database Connection sucessful");
        return connection;
    }}


