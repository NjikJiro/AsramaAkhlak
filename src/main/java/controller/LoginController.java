/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import model.User;
import view.HomepageFrame;
import view.LoginFrame;

public class LoginController {

    private LoginFrame view;

    public LoginController(LoginFrame view) {
        this.view = view;
    }

    public void login(String username, String password) {

        User user = User.login(username, password);

        if (user != null) {
            view.dispose();
            new HomepageFrame(user.getNama()).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(
                    view,
                    "Username atau password salah",
                    "Login Gagal",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
