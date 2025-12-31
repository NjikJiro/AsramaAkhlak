/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 *
 */
import config.DatabaseConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pengaduan {

    private String isi, status, idUser;

    public static List<Pengaduan> getData() {
        List<Pengaduan> list = new ArrayList<>();

        String sql = """
            SELECT isi, status, id_user
            FROM pengaduan
        """;

        try (Connection c = DatabaseConfig.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Pengaduan(
                        rs.getString("isi"),
                        rs.getString("status"),
                        rs.getString("id_user")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static boolean insertPengaduan(String isi, int idUser) {

        String sql = """
        INSERT INTO pengaduan (isi, status, id_user)
        VALUES (?, 'Diterima', ?)
    """;

        try (Connection c = DatabaseConfig.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, isi);
            ps.setInt(2, idUser);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Pengaduan(String isi, String status, String idUser) {
        this.isi = isi;
        this.status = status;
        this.idUser = idUser;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

}
