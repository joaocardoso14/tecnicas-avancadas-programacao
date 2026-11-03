
import java.sql.Connection; // *
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
        
        
public class Listar extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Listar.class.getName());

    public Listar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlunos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Curso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAlunos);

        jLabel1.setText("Tabela Alunos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*public Connection conectar (){
        Connection con = null; // Conexão Java - BD
        String bd = "etec";
        String usuario = "root";
        String senha = "";
        PreparedStatement ps; // estruturar o SQL
        String sql;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + bd,
                    usuario, senha);
            
            sql = "insert into alunos (nome,curso) values (?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, "Laurona");
            ps.setString(2, "ADS");
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Inserido com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao tentar inserir");
            }
            con.close();
        }catch(SQLException | ClassNotFoundException erro){
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }*/
            
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new Listar().setVisible(true));
        
 
        String bd = "etec";
        String usuario = "root";
        String senha = "";
        
        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection con = /*new Conexao().conectar()*/ null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + bd,
                    usuario, senha);
            
            if (con != null) {
                String comando = "SELECT id,nome,curso FROM alunos";
                ps = con.prepareStatement(comando);
                // efetua a busca e armazena na variável rs
                rs = ps.executeQuery();
 
                // Excluindo todas as linhas da tabela
                DefaultTableModel dtm = (DefaultTableModel) tblAlunos.getModel();
                int l = tblAlunos.getRowCount();
                for (int i = l - 1; i >= 0; --i) {
                    dtm.removeRow(i);
                }
 
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String curso = rs.getString("curso");
                    dtm.addRow(new Object[]{id, nome, curso});
                }
 
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao buscar");
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlunos;
    // End of variables declaration//GEN-END:variables
}
