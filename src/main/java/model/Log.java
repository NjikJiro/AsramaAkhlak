/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import config.DatabaseConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adyadma Renjiro
 */
public class Log {

    private LocalDateTime waktu;
    private String status;
    private int idUser;
    private String namaUser;

    public static List<Log> getData() {
        List<Log> list = new ArrayList<>();

        String sql = """
        SELECT 
            l.waktu,
            l.status,
            l.id_user,
            u.nama AS nama_user
        FROM log_kehadiran l
        JOIN user u ON l.id_user = u.id_user
        ORDER BY l.waktu DESC
    """;

        try (Connection c = DatabaseConfig.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Log(
                        rs.getTimestamp("waktu").toLocalDateTime(),
                        rs.getString("status"),
                        rs.getInt("id_user"),
                        rs.getString("nama_user")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Log(LocalDateTime waktu, String status, int idUser, String namaUser) {
        this.waktu = waktu;
        this.status = status;
        this.idUser = idUser;
        this.namaUser = namaUser;
    }

    public LocalDateTime getWaktu() {
        return waktu;
    }

    public void setWaktu(LocalDateTime waktu) {
        this.waktu = waktu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }
    
    

}
