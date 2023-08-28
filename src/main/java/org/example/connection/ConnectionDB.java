package org.example.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionDB {
    private static final String url = "sua_url";
    private static final String user = "seu_usuario";
    private static final String password = "sua_senha";
    public static Connection connect(){
        try{
            Connection connection = DriverManager.getConnection(url,user,password);

            if (connection != null){
                System.out.println("\nConectado ao servidor PostgreSQL com sucesso!\n");
            }
            else{
                System.out.println("A conexão com o servidor PostgreSQL falhou.");
            }
            return connection;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}