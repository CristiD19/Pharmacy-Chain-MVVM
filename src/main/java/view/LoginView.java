package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.*;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;
import viewmodel.VMLogin;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {
    //AngajatView angajatView = new AngajatView();
    //AdministratorView administratorView = new AdministratorView();
    //ManagerView managerView = new ManagerView();
    @Bind(value = "text", target = "usernameTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField usernameTextField;
    @Bind(value = "text", target = "passwordTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField passwordTextField;
    private JPanel contentPane;
    private JLabel usernamelNewLabel;
    private JLabel passwordlNewLabel_1;
    private JButton btnLogin;
    private JButton btnRegister;
    private JLabel blovoNewLabel;
    private JTextField textField;
    private JComboBox rolOptions;
    private JTextField idFarmacie;

    public LoginView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        usernamelNewLabel = new JLabel("Nume:");
        usernamelNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usernamelNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        usernamelNewLabel.setBounds(206, 88, 106, 35);
        contentPane.add(usernamelNewLabel);

        passwordlNewLabel_1 = new JLabel("Cont:");
        passwordlNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        passwordlNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 18));
        passwordlNewLabel_1.setBounds(206, 133, 106, 35);
        contentPane.add(passwordlNewLabel_1);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnLogin.setFont(new Font("Calibri", Font.BOLD, 18));
        btnLogin.setBounds(176, 338, 136, 35);
        contentPane.add(btnLogin);

        btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Calibri", Font.BOLD, 18));
        btnRegister.setBounds(420, 339, 136, 32);
        contentPane.add(btnRegister);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(391, 136, 149, 28);
        contentPane.add(usernameTextField);
        usernameTextField.setColumns(10);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(391, 187, 149, 28);
        contentPane.add(passwordTextField);
        passwordTextField.setColumns(10);

        blovoNewLabel = new JLabel("LoginView");
        blovoNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        blovoNewLabel.setFont(new Font("Calibri", Font.BOLD, 28));
        blovoNewLabel.setBounds(261, 10, 205, 32);
        contentPane.add(blovoNewLabel);

        JLabel lblNewLabel = new JLabel("Parola:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        lblNewLabel.setBounds(206, 185, 106, 35);
        contentPane.add(lblNewLabel);

        JLabel lblRol = new JLabel("Rol:");
        lblRol.setHorizontalAlignment(SwingConstants.CENTER);
        lblRol.setFont(new Font("Calibri", Font.BOLD, 18));
        lblRol.setBounds(206, 230, 106, 35);
        contentPane.add(lblRol);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(391, 91, 149, 28);
        contentPane.add(textField);

        Rol[] rolChoice = new Rol[] {Rol.ANGAJAT, Rol.ADMINISTRATOR, Rol.MANAGER};
        rolOptions = new JComboBox<Rol>(rolChoice);
        rolOptions.setFont(new Font("Calibri", Font.BOLD, 18));
        rolOptions.setBounds(391, 232, 149, 28);
        contentPane.add(rolOptions);

        JLabel lblIdulFarmaciei = new JLabel("Id-ul Farmaciei:");
        lblIdulFarmaciei.setHorizontalAlignment(SwingConstants.CENTER);
        lblIdulFarmaciei.setFont(new Font("Calibri", Font.BOLD, 18));
        lblIdulFarmaciei.setBounds(206, 275, 136, 35);
        contentPane.add(lblIdulFarmaciei);

        idFarmacie = new JTextField();
        idFarmacie.setFont(new Font("Tahoma", Font.PLAIN, 18));
        idFarmacie.setColumns(10);
        idFarmacie.setBounds(391, 275, 149, 28);
        contentPane.add(idFarmacie);


        VMLogin viewModelLogin = new VMLogin();
        try{
            Binder.bind(this, viewModelLogin);
        } catch(Exception ex) {
            System.out.println("\nError with binding at LogIn\n");
            ex.printStackTrace();
        }

        btnLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewModelLogin.loginComanda.execute();
            }
        });

   }



    public void btnLoginListener(ActionListener actionListener){
        this.btnLogin.addActionListener(actionListener);
    }

    public void btnRegisterListener(ActionListener actionListener){
        this.btnRegister.addActionListener(actionListener);
    }







}

