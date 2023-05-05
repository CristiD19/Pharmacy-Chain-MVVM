package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DiscriminatorValue(value = "ANGAJAT")
public class Angajat extends Utilizator{

    @ManyToOne
    private Farmacie farmacie;

    public Angajat(){}

    public Angajat(String nume, String cont, String parola, Farmacie farmacie) {
        super(nume, cont, parola);
        this.farmacie = farmacie;
    }

    public Farmacie getFarmacie() {
        return farmacie;
    }

    public void setFarmacie(Farmacie farmacie) {
        this.farmacie = farmacie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Angajat angajat = (Angajat) o;
        return Objects.equals(farmacie, angajat.farmacie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), farmacie);
    }
}
