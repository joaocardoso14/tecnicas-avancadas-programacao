
package controller;

import model.Veiculo;

public class VeiculoController {
    
    public boolean efetuarGravação(int id, String modelo, String marca, String placa, String cor, String ano){
        Veiculo v = new Veiculo();
        v.setModelo(modelo);
        v.setMarca(marca);
        v.setPlaca(placa);
        v.setCor(cor);
        v.setAno(ano);
        
        return v.gravar();
    }
    
}
