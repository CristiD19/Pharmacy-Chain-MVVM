package viewmodel;

import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;
import viewmodel.ICommand;

public class VMLogin {
    private Property<String> usernameTextField;
    private Property<String> passwordTextField;
    public ICommand loginComanda;

    public VMLogin() {
        usernameTextField = PropertyFactory.createProperty("cont", this, String.class);
        passwordTextField = PropertyFactory.createProperty("parola", this, String.class);
        this.loginComanda = new ComandaLogin(this);
    }

    public String getUserTextField() {
        return usernameTextField.get();
    }

    public void setUserTextField(String userTextField) {
        this.usernameTextField.set(userTextField);
    }

    public String getPasswordTextField() {
        return passwordTextField.get();
    }

    public void setPasswordTextField(String passwordTextField) {
        this.passwordTextField.set(passwordTextField);
    }

    public ICommand getLoginCommand() {
        return loginComanda;
    }

    public void setLoginCommand(ICommand loginComanda) {
        this.loginComanda = loginComanda;
    }
}