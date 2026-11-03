
package Controller;

import ValorObject.Pessoa;
import Model.PessoasModelo;

import java.util.ArrayList;

public class PessoasController {
    public ArrayList<Pessoa> buscarDados(){
        PessoasModelo pm = new PessoasModelo();
        return pm.buscarDadosBD();
    }
}
