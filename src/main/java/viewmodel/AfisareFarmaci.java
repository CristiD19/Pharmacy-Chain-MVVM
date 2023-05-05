package viewmodel;

import model.Farmacie;
import model.FarmaciePersistent;
import model.MedicamentInFarmacie;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AfisareFarmaci implements ICommand{

    private VMManager vmManager;

    public AfisareFarmaci() {
    }

    public AfisareFarmaci(VMManager vmManager) {
        this.vmManager = vmManager;
    }

    public VMManager vmManager() { return  vmManager;}

    public void setVmAngajat(VMManager vmManager) {
        this.vmManager = vmManager;
    }

    @Override
    public void execute() {
        FarmaciePersistent farmaciePersistent = new FarmaciePersistent();
        List<Farmacie> farmacieList = farmaciePersistent.listaFarmacii();

        String[] columns =  new String[] {
                "Id", "Nume"
        };
        int rowIndex = 1;
        int noRows = farmacieList.size();
        String [][] data = new String[noRows + 1][2];

        data[0][0] = "Id";
        data[0][1] = "Nume";


        for (Farmacie farmacie: farmacieList)
        {
            data[rowIndex][0] = farmacieList.get(rowIndex - 1).getId() + "";
            data[rowIndex][1] = farmacieList.get(rowIndex - 1).getName();

            rowIndex++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        vmManager.setTable_1(defaultTableModel);
    }

}
