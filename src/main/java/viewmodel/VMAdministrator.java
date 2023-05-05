package viewmodel;


import model.*;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class VMAdministrator {

    private Property<String> numeUtilizatorTextField;
    private Property<String> contUtilizatorTextField;
    private Property<String> parolaUtilizatorTextField;
    private Property<String> farmacieIdField;
    private Property<String> idField;
    private Property<DefaultTableModel> table;
    private Property<DefaultComboBoxModel<String>> rolOptions;
    private Property<String> selected;
    public ICommand comandaCreareUtilizator;
    public ICommand comandaActualizareUtilizator;
    public ICommand comandaCitireUtilziator;
    public ICommand comandaStergereUtilizator;
    public ICommand comandaAfisareUtilziatori;
    public ICommand comandaFiltrareListaUtilizatori;

    public VMAdministrator(){
         numeUtilizatorTextField = PropertyFactory.createProperty("nume", this, String.class);
         contUtilizatorTextField = PropertyFactory.createProperty("cont", this, String.class);
         parolaUtilizatorTextField =  PropertyFactory.createProperty("parola", this, String.class);
         farmacieIdField = PropertyFactory.createProperty("idFarmacie", this, String.class);
         idField = PropertyFactory.createProperty("id", this, String.class);
         table = PropertyFactory.createProperty("table", this, new DefaultTableModel());
         rolOptions = PropertyFactory.createProperty("rolOptions", this, new DefaultComboBoxModel<String>());
         selected = PropertyFactory.createProperty("selected", this, String.class);

        this.comandaActualizareUtilizator = new ActualizareUtilizator(this);
        this.comandaCreareUtilizator = new CreareUtilizator(this);
        this.comandaAfisareUtilziatori = new AfisareListaUtilziatori(this);
        this.comandaCitireUtilziator = new CitireUtilizator(this);
        this.comandaStergereUtilizator = new StergereUtilizator(this);
        this.comandaFiltrareListaUtilizatori = new FiltrareListaUtilizatori(this);
    }

    public String getNameTextField() {
        return numeUtilizatorTextField.get();
    }

    public String getUsernameTextField() {
        return contUtilizatorTextField.get();
    }

    public String getPasswordTextField() {
        return parolaUtilizatorTextField.get();
    }

    public int getFarmacieIdField() {
        return Integer.parseInt(farmacieIdField.get());
    }

    public int getIdField() {
        return Integer.parseInt(idField.get());
    }

    public DefaultTableModel getTable(){
        return table.get();
    }

    public void setTable(DefaultTableModel defaultTableModel) {
        table.set(defaultTableModel);
    }


    public DefaultComboBoxModel<String> getRolComboBox() {return rolOptions.get();}

    public int getIdSelectedRow() {
        return Integer.parseInt(selected.get());
    }

}
