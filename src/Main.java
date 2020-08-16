import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        Connection cnx;
        String urlCnx = "jdbc:postgresql://192.168.56.2/geografia";
        Statement sentencia;
        String sql = "INSERT INTO ccaa (código,nombre) VALUES ('99','Javalandia')";
        int insertado;

        try{
            Class.forName("org.postgresql.Driver");
            cnx = DriverManager.getConnection(urlCnx,"censo","620312786");
            sentencia = cnx.createStatement();
            insertado = sentencia.executeUpdate(sql);
            System.out.println("Se han insertado " + insertado +" fila(s)");

        }
        catch (ClassNotFoundException e) {
            System.out.println("No encontro la clase");
        }
        catch (SQLException e){
            System.out.println("Error de SQL");
        }
    }
}
