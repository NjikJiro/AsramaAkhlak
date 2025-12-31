/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Adyadma Renjiro
 */
import java.util.List;
import model.Pengaduan;
import model.User;
import view.PengaduanFrame;
import view.HomepageFrame;

public class PengaduanController {

    private HomepageFrame homepage;
    private User user;

    public PengaduanController(HomepageFrame homepage, User user) {
        this.homepage = homepage;
        this.user = user;
    }

    public void showPengaduan() {
        List<Pengaduan> data;

        data = Pengaduan.getData();

        PengaduanFrame frame = new PengaduanFrame(data, user, homepage);
        frame.setVisible(true);
        homepage.setVisible(false);
    }

}
