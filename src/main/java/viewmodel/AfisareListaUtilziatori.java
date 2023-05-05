package viewmodel;

import jdk.jshell.execution.Util;
import model.Utilizator;
import model.UtilizatorPersistent;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AfisareListaUtilziatori implements ICommand{

    private VMAdministrator vmAdministrator;

    public AfisareListaUtilziatori() {
    }

    public AfisareListaUtilziatori(VMAdministrator vmAdministrator) {
        this.vmAdministrator = vmAdministrator;
    }

    public VMAdministrator getVmAdmin() {
        return vmAdministrator;
    }

    public void setVmAdmin(VMAdministrator vmAdministrator) {
        this.vmAdministrator = vmAdministrator;
    }

    @Override
    public void execute() {

        UtilizatorPersistent utilizatorPersistent = new UtilizatorPersistent();

        String[] columns = new String[] {
                "Rol_utilizator", "Id", "Cont", "Nume", "Parola"};
        int rowIndex = 1;
        List<Utilizator> utilizatori = utilizatorPersistent.listaUtilizatori();
        int noRows = utilizatori.size();
        String [][] data = new String[noRows + 1][5];

        data[0][0] = "Rol_utilizator";
        data[0][1] = "Id";
        data[0][2] = "Cont";
        data[0][3] = "Nume";
        data[0][4] = "Parola";

        for (Utilizator utilizator: utilizatori)
        {
            data[rowIndex][0] = utilizator.getClass().getSimpleName().toString() + "";
            data[rowIndex][2] = utilizator.getNume();
            data[rowIndex][3] = utilizator.getCont();
            data[rowIndex][4] = utilizator.getParola();
            data[rowIndex][1] = Integer.toString(utilizator.getId());

            rowIndex++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        vmAdministrator.setTable(defaultTableModel);
    }

}
