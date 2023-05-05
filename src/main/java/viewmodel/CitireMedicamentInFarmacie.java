package viewmodel;

import model.Angajat;
import model.FarmaciePersistent;
import model.MedicamentInFarmacie;
import model.UtilizatorPersistent;

import javax.swing.table.DefaultTableModel;

public class CitireMedicamentInFarmacie implements ICommand{
    private VMAngajat vmAngajat;

    public CitireMedicamentInFarmacie() {
    }

    public CitireMedicamentInFarmacie(VMAngajat vmAngajat) {
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
        MedicamentInFarmacie medicamentInFarmacie = farmaciePersistent.cautareMedicamentDupaNume(vmAngajat.getNumeMedicamentTextField(), angajat.getFarmacie().getId());


        String[] columns =  new String[] {
                "Id", "Disponibilitate", "Nume", "Pret", "Producator", "Valabilitate","Stoc"
        };

        int rowIndex = 1;
        String [][] data = new String[2][7];

        data[0][0] = "Id";
        data[0][1] = "Disponibilitate";
        data[0][2] = "Nume";
        data[0][3] = "Pret";
        data[0][4] = "Producator";
        data[0][5] = "Valabilitate";
        data[0][6] = "Stoc";


            data[1][0] = medicamentInFarmacie.getId() + "";
            data[1][1] = medicamentInFarmacie.getMedicament().isDisponibil().toString();
            data[1][2] = medicamentInFarmacie.getMedicament().getNume();
            data[1][3] = String.valueOf(medicamentInFarmacie.getMedicament().getPret());
            data[1][4] = medicamentInFarmacie.getMedicament().getProducator();
            data[1][5] = String.valueOf(medicamentInFarmacie.getMedicament().isValabil());
            data[1][6] = String.valueOf(medicamentInFarmacie.getStoc());



        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        vmAngajat.setTable_1(defaultTableModel);
        }



}
