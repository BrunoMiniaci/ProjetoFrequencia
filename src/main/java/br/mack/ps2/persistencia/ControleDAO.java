package br.mack.ps2.persistencia;

import br.mack.ps2.entidades.Controle;
import java.util.List;

public interface ControleDAO {
    boolean create (Controle controle);
    List<Controle> read ();
}
