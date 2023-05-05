package viewmodel;

import model.Medicament;
import model.MedicamentInFarmacie;
import model.MedicamentPersistent;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListaMedicamente implements ICommand{
    private VMAngajat vmAngajat;

    public ListaMedicamente() {
    }

    public ListaMedicamente(VMAngajat vmAngajat) {
        this.vmAngajat = vmAngajat;
    }

    public VMAngajat getVmAngajat() {
        return vmAngajat;
    }

    public void setVmAngajat(VMAngajat vmAngajat) {
        this.vmAngajat = vmAngajat;
    }

    @Override
    public void execute() {

        MedicamentPersistent medicamentPersistent = new MedicamentPersistent();
        List<Medicament> medicamentList =  medicamentPersistent.listaMedicament();



        String[] columns =  new String[] {
                "Id", "Disponibilitate", "Nume", "Pret", "Producator", "Valabilitate"
        };
        int rowIndex = 1;
        int noRows = medicamentList.size();
        String [][] data = new String[noRows + 1][6];

        data[0][0] = "Id";
        data[0][1] = "Disponibilitate";
        data[0][2] = "Nume";
        data[0][3] = "Pret";
        data[0][4] = "Producator";
        data[0][5] = "Valabilitate";

        for (Medicament medicamentInFarmacie: medicamentList)
        {
            data[rowIndex][0] = medicamentList.get(rowIndex - 1).getId() + "";
            data[rowIndex][1] = medicamentList.get(rowIndex - 1).isDisponibil().toString();
            data[rowIndex][2] = medicamentList.get(rowIndex - 1).getNume();
            data[rowIndex][3] = String.valueOf(medicamentList.get(rowIndex - 1).getPret());
            data[rowIndex][4] = medicamentList.get(rowIndex - 1).getProducator();
            data[rowIndex][5] = String.valueOf(medicamentList.get(rowIndex - 1).isValabil());

            rowIndex++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        vmAngajat.setTable(defaultTableModel);
    }

}
