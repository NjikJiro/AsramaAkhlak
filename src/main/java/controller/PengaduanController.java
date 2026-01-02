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

public class PengaduanController {

   public List<Pengaduan> getPengaduan() {
        return Pengaduan.getData();
    }

    public boolean tambahPengaduan(String isi, int idUser) {
        return Pengaduan.insertPengaduan(isi, idUser);
    }
    
    public boolean updateStatusPengaduan(int idPengaduan, String status) {
    return Pengaduan.updateStatus(idPengaduan, status);
}


}
