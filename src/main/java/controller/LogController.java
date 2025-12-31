/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Log;
import model.User;
import view.HomepageFrame;
import view.LogFrame;

/**
 *
 * @author Adyadma Renjiro
 */
public class LogController {
     private HomepageFrame homepage;
     private User user;

    public LogController(HomepageFrame homepage, User user) {
        this.homepage = homepage;
        this.user = user;
    }
    
    public void showLog(){
        List<Log> data  = Log.getData();
                
        LogFrame frame = new LogFrame(data, user ,homepage);
        frame.setVisible(true);
        homepage.setVisible(false);
    }
}
