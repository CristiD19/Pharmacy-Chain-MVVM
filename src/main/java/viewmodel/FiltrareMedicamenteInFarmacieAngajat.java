package viewmodel;

import model.*;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FiltrareMedicamenteInFarmacieAngajat implements ICommand{
    private VMAngajat vmAngajat;

    public FiltrareMedicamenteInFarmacieAngajat() {
    }

    public FiltrareMedicamenteInFarmacieAngajat(VMAngajat vmAngajat) {
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

        UtilizatorPersistent utilizatorPersistent = new UtilizatorPersistent();
        FarmaciePersistent farmaciePersistent = new FarmaciePersistent();
        Angajat angajat = (Angajat) utilizatorPersistent.cautareUtilizatorDupaId(vmAngajat.getSelectedIdAngajat());
        List<MedicamentInFarmacie> medicamentInFarmacieList = farmaciePersistent.filtrareMedicamente(angajat.getFarmacie().getId());

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
        vmAngajat.setTable_1(defaultTableModel);
    }


}
