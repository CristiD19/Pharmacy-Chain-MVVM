package view;

import model.Administrator;
import model.Rol;
import model.Utilizator;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;
import viewmodel.VMAdministrator;
import viewmodel.VMLogin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.List;

public class AdministratorView extends JFrame  {

    private JPanel contentPane;
    @Bind(value = "model", target = "table.value", type = BindingType.TARGET_TO_SOURCE)
    private JTable table;
    @Bind(value = "text", target = "numeUtilizatorTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField numeUtilizatorTextField ;
    @Bind(value = "text", target = "contUtilizatorTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField contUtilizatorTextField ;
    @Bind(value = "text", target = "parolaUtilizatorTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField parolaUtilizatorTextField ;
    @Bind(value = "text", target = "farmacieIdField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField farmacieIdField;
    private JButton btnCreareUtilizator;
    private JButton btnCitireUtilizator;
    private JButton btnStergeUtilizator;
    private JButton btnActualizareUtilizator;
    private JButton btnListaUtilizatori;
    @Bind(value = "model", target = "rolOptions.value", type = BindingType.BI_DIRECTIONAL)
    private JComboBox rolOptions;
    private JLabel lblid;
    @Bind(value = "text", target = "idField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField idField;
    @Bind(value = "text", target = "selected.value", type = BindingType.BI_DIRECTIONAL)
    private JLabel selected;
    private JButton btnFiltrareUtilizatori;



    public AdministratorView(Administrator administrator) {

        selected = new JLabel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1050, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Tabel Administrator");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(324, 10, 239, 54);
        contentPane.add(lblNewLabel);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {"Rol_utilizator", "Id", "Cont", "Nume", "Parola"},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[]{
                        "Rol_utilizator", "Id", "Cont", "Nume", "Parola"
                }
        ));
        table.setBounds(24, 74, 441, 291);
        contentPane.add(table);

        btnCreareUtilizator = new JButton("Creare Utilizator");
        btnCreareUtilizator.setFont(new Font("Calibri", Font.BOLD, 14));
        btnCreareUtilizator.setBounds(10, 397, 170, 35);
        contentPane.add(btnCreareUtilizator);

        btnCitireUtilizator = new JButton("Citire Utilizator");
        btnCitireUtilizator.setFont(new Font("Calibri", Font.BOLD, 14));
        btnCitireUtilizator.setBounds(190, 397, 179, 35);
        contentPane.add(btnCitireUtilizator);

        btnStergeUtilizator = new JButton("Sterge Utilizator");
        btnStergeUtilizator.setFont(new Font("Calibri", Font.BOLD, 14));
        btnStergeUtilizator.setBounds(550, 397, 147, 35);
        contentPane.add(btnStergeUtilizator);

        btnActualizareUtilizator = new JButton("Actualizare Utilizator");
        btnActualizareUtilizator.setFont(new Font("Calibri", Font.BOLD, 14));
        btnActualizareUtilizator.setBounds(379, 397, 161, 35);
        contentPane.add(btnActualizareUtilizator);

        JLabel clientNameLabel = new JLabel("Nume:");
        clientNameLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientNameLabel.setBounds(520, 88, 83, 28);
        contentPane.add(clientNameLabel);

        JLabel clientAddressLabel = new JLabel("Cont:");
        clientAddressLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientAddressLabel.setBounds(520, 126, 83, 28);
        contentPane.add(clientAddressLabel);

        JLabel clientEmailLabel = new JLabel("Parola:");
        clientEmailLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientEmailLabel.setBounds(520, 164, 83, 28);
        contentPane.add(clientEmailLabel);

        JLabel clientAgeLabel = new JLabel("Rol:");
        clientAgeLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientAgeLabel.setBounds(520, 202, 83, 28);
        contentPane.add(clientAgeLabel);

        numeUtilizatorTextField = new JTextField();
        numeUtilizatorTextField.setBounds(705, 85, 125, 31);
        contentPane.add(numeUtilizatorTextField);
       // numeUtilizatorTextField.setColumns(10);

        contUtilizatorTextField = new JTextField();
        contUtilizatorTextField.setBounds(705, 123, 125, 31);
        contentPane.add(contUtilizatorTextField);
       // contUtilizatorTextField.setColumns(10);

        parolaUtilizatorTextField = new JTextField();
        parolaUtilizatorTextField.setBounds(705, 161, 125, 31);
        contentPane.add(parolaUtilizatorTextField);
        //parolaUtilizatorTextField.setColumns(10);

        btnListaUtilizatori = new JButton("Lista Utilizatori");
        btnListaUtilizatori.setFont(new Font("Calibri", Font.BOLD, 14));
        btnListaUtilizatori.setBounds(707, 397, 161, 35);
        contentPane.add(btnListaUtilizatori);


        String[] stringChoices = new String[]{"ANGAJAT", "ADMINISTRATOR", "MANAGER"};
        rolOptions = new JComboBox<String>(stringChoices);
        rolOptions.setFont(new Font("Calibri", Font.BOLD, 18));
        rolOptions.setBounds(705, 200, 125, 28);
        contentPane.add(rolOptions);

        JLabel lblFarmacieid = new JLabel("FarmacieId:");
        lblFarmacieid.setFont(new Font("Calibri", Font.BOLD, 14));
        lblFarmacieid.setBounds(520, 253, 83, 28);
        contentPane.add(lblFarmacieid);

        farmacieIdField = new JTextField();
        farmacieIdField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        farmacieIdField.setColumns(10);
        farmacieIdField.setBounds(705, 247, 125, 31);
        contentPane.add(farmacieIdField);

        lblid = new JLabel("Id:");
        lblid.setFont(new Font("Calibri", Font.BOLD, 14));
        lblid.setBounds(520, 303, 83, 28);
        contentPane.add(lblid);

        idField = new JTextField();
        idField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        idField.setColumns(10);
        idField.setBounds(705, 297, 125, 31);
        contentPane.add(idField);

        btnFiltrareUtilizatori = new JButton("Filtrare Utilizatori");
        btnFiltrareUtilizatori.setFont(new Font("Calibri", Font.BOLD, 14));
        btnFiltrareUtilizatori.setBounds(878, 402, 148, 28);
        contentPane.add(btnFiltrareUtilizatori);

        VMAdministrator viewModelAdmin = new VMAdministrator();
        try{
            Binder.bind(this, viewModelAdmin);
        } catch(Exception ex) {
            System.out.println("\nError with binding at Admin\n");
            ex.printStackTrace();
        }

            this.btnListaUtilizatoriListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    viewModelAdmin.comandaAfisareUtilziatori.execute();
                }
            });


            this.btnCreareUtilizatorListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewModelAdmin.comandaCreareUtilizator.execute();
                }
            });


                this.btnCitireUtilizatorListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    viewModelAdmin.comandaCitireUtilziator.execute();

                    }
                });


            this.btnActualizareUtilizatorListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String value = (String) table.getValueAt(table.getSelectedRow(), 1);
                    selected.setText(value);
                    viewModelAdmin.comandaActualizareUtilizator.execute();
                }
            });


            this.btnStergeUtilizatorListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String value = (String) table.getValueAt(table.getSelectedRow(), 1);
                    selected.setText(value);
                    viewModelAdmin.comandaStergereUtilizator.execute();
                }
            });

            this.btnFiltrareUtilizatoriListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewModelAdmin.comandaFiltrareListaUtilizatori.execute();
                }
            });

    }


    public void btnFiltrareUtilizatoriListener(ActionListener actionListener){
        this.btnFiltrareUtilizatori.addActionListener(actionListener);
    }

    public void btnCreareUtilizatorListener(ActionListener actionListener) {
        this.btnCreareUtilizator.addActionListener(actionListener);
    }

    public void btnListaUtilizatoriListener(ActionListener actionListener) {
        this.btnListaUtilizatori.addActionListener(actionListener);
    }

    public void btnCitireUtilizatorListener(ActionListener actionListener){
        this.btnCitireUtilizator.addActionListener(actionListener);
    }

    public void btnStergeUtilizatorListener(ActionListener actionListener){
        this.btnStergeUtilizator.addActionListener(actionListener);
    }

    public void btnActualizareUtilizatorListener(ActionListener actionListener){
        this.btnActualizareUtilizator.addActionListener(actionListener);
    }



}

