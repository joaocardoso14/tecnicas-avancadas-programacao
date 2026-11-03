
package Model;

import Connection.Conexao;
import ValorObject.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class PessoasModelo {
    public ArrayList<Pessoa> buscarDadosBD(){
        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection con = new Conexao().conectar();
            if (con != null) {
                String comando = "SELECT id,nome,salario FROM pessoas";
                ps = con.prepareStatement(comando);
                rs = ps.executeQuery();
                ArrayList<Pessoa> listaResultados = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    double salario = rs.getDouble("salario");
                    Pessoa p = new Pessoa();
                    p.setId(id);
                    p.setNome(nome);
                    p.setSalario(salario);
                    listaResultados.add(p);
                }
                return listaResultados;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro " + erro);
            return null;
        }
    }
}
