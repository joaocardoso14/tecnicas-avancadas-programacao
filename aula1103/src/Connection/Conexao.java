
package Connection;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    
    private final String bd = "fatec";
    private final String usuario = "root";
    private final String senha = "";
    
    public Connection conectar() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/" + bd, usuario, senha);
        } catch(ClassNotFoundException erro){
            System.out.print("Erro na conexão: " + erro);
            return null;
        }
    }
}
