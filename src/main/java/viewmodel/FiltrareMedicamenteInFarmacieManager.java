package viewmodel;

import model.FarmaciePersistent;
import model.MedicamentInFarmacie;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FiltrareMedicamenteInFarmacieManager implements ICommand{

    private VMManager vmManager;

    public FiltrareMedicamenteInFarmacieManager() {
    }

    public FiltrareMedicamenteInFarmacieManager(VMManager vmManager) {
        this.vmManager = vmManager;
    }

    public VMManager vmManager() { return  vmManager;}

    public void setVmAngajat(VMManager vmManager) {
        this.vmManager = vmManager;
    }

    @Override
    public void execute() {
        FarmaciePersistent farmaciePersistent = new FarmaciePersistent();
        List<MedicamentInFarmacie> medicamentInFarmacieList = farmaciePersistent.filtrareMedicamente(vmManager.getIdTabelFarmacie());

        String[] columns =  new String[] {
                "Id", "Disponibilitate", "Nume", "Pret", "Producator", "Valabilitate","Stoc"
        };
        int rowIndex = 1;
        int noRows = medicamentInFarmacieList.size();
        String [][] data = new String[noRows + 1][7];

        data[0][0] = "Id";
        data[0][1] = "Disponibilitate";
        data[0][2] = "Nume";
        data[0][3] = "Pret";
        data[0][4] = "Producator";
        data[0][5] = "Valabilitate";
        data[0][6] = "Stoc";

        for (MedicamentInFarmacie medicamentInFarmacie: medicamentInFarmacieList)
        {
            data[rowIndex][0] = medicamentInFarmacieList.get(rowIndex-1).getId() + "";
            data[rowIndex][1] = medicamentInFarmacieList.get(rowIndex-1).getMedicament().isDisponibil().toString();
            data[rowIndex][2] = medicamentInFarmacieList.get(rowIndex-1).getMedicament().getNume();
            data[rowIndex][3] = String.valueOf(medicamentInFarmacieList.get(rowIndex-1).getMedicament().getPret());
            data[rowIndex][4] = medicamentInFarmacieList.get(rowIndex-1).getMedicament().getProducator();
            data[rowIndex][5] = String.valueOf(medicamentInFarmacieList.get(rowIndex-1).getMedicament().isValabil());
            data[rowIndex][6] = String.valueOf(medicamentInFarmacieList.get(rowIndex-1).getStoc());

            rowIndex++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        vmManager.setTable(defaultTableModel);

    }
}
