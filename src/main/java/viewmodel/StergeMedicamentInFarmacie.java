package viewmodel;

import model.*;

public class StergeMedicamentInFarmacie implements ICommand {
    private VMAngajat vmAngajat;

    public StergeMedicamentInFarmacie() {
    }

    public StergeMedicamentInFarmacie(VMAngajat vmAngajat) {
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
        MedicamentPersistent medicamentPersistent = new MedicamentPersistent();
        Angajat angajat = (Angajat) utilizatorPersistent.cautareUtilizatorDupaId(vmAngajat.getSelectedIdAngajat());
        Farmacie farmacie = angajat.getFarmacie();
        int idFromMedicamentInFarmacie = vmAngajat.getSelectedTable2();
        farmacie.stergeMedicament(farmaciePersistent.cautareMedicamentInFarmacieDupaId(idFromMedicamentInFarmacie));
        farmaciePersistent.stergeMedicamentInFarmacie(idFromMedicamentInFarmacie);

    }
}
