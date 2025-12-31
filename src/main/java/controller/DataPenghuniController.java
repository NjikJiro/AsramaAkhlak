package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.List;
import model.Penghuni;
import model.User;
import view.DataPenghuniFrame;
import view.HomepageFrame;
/**
 *
 * @author Adyadma Renjiro
 */
public class DataPenghuniController {
    private HomepageFrame homepage;
    private User user;

    public DataPenghuniController(HomepageFrame homepage, User user) {
        this.homepage = homepage;
        this.user = user;
    }

    public void showDataPenghuni() {

        List<Penghuni> data;

        if (user.getRole().equalsIgnoreCase("penghuni")) {
            data = Penghuni.getDataPublik();
        } else {
            data = Penghuni.getSemuaData();
        }

        
        DataPenghuniFrame frame = new DataPenghuniFrame(data, user.getRole(), homepage);
        frame.setVisible(true);
        homepage.setVisible(false);
    }
}
