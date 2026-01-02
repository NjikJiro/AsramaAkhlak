package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.List;
import model.Penghuni;
import model.User;
import view.DataPenghuniFrame;
import view.AdminDataPenghuniFrame;
import view.HomepageFrame;
import view.AdminHomeFrame;

/**
 *
 * @author Adyadma Renjiro
 */
public class DataPenghuniController {

    private User user;
    private HomepageFrame homePenghuni;
    private AdminHomeFrame homeAdmin;

    // untuk penghuni
    public DataPenghuniController(HomepageFrame home, User user) {
        this.homePenghuni = home;
        this.user = user;
    }

    // untuk admin / penjaga
    public DataPenghuniController(AdminHomeFrame home, User user) {
        this.homeAdmin = home;
        this.user = user;
    }

    public void showDataPenghuni() {

        List<Penghuni> data;

        if (user.getRole().equalsIgnoreCase("penghuni")) {
            data = Penghuni.getDataPublik();

            DataPenghuniFrame frame = new DataPenghuniFrame(data, homePenghuni);
            frame.setVisible(true);
            homePenghuni.setVisible(false);

        } else {
            data = Penghuni.getSemuaData();

            AdminDataPenghuniFrame frame = new AdminDataPenghuniFrame(data, homeAdmin);
            frame.setVisible(true);
            homeAdmin.setVisible(false);
        }
    }
}
