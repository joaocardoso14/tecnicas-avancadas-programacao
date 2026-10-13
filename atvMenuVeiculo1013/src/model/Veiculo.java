
package model;

import javax.swing.JOptionPane;

public class Veiculo {
    
    private int id;
    private String modelo;
    private String marca;
    private String placa;
    private String cor;
    private String ano;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    public boolean gravar(){
        JOptionPane.showMessageDialog(null, 
                "SUCESSSSOSOSOSOSOSOOSOSOSO: "
        );
        
        return true;
    }
    
}
