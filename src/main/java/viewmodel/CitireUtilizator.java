package viewmodel;

import model.Utilizator;
import model.UtilizatorPersistent;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CitireUtilizator implements ICommand{

    private VMAdministrator vmAdministrator;

    public CitireUtilizator() {
    }

    public CitireUtilizator(VMAdministrator vmAdministrator) {
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
        Utilizator utilizator = utilizatorPersistent.cautareUtilizatorDupaId(vmAdministrator.getIdField());

        String[] columns = new String[] {
                "Rol_utilizator", "Id", "Cont", "Nume", "Parola"};
        String [][] data = new String[2][5];

        data[0][0] = "Rol_utilizator";
        data[0][1] = "Id";
        data[0][2] = "Cont";
        data[0][3] = "Nume";
        data[0][4] = "Parola";

        data[1][0] = utilizator.getClass().getSimpleName().toString() + "";
        data[1][2] = utilizator.getNume();
        data[1][3] = utilizator.getCont();
        data[1][4] = utilizator.getParola();
        data[1][1] = Integer.toString(utilizator.getId());


        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        vmAdministrator.setTable(defaultTableModel);
    }


}
