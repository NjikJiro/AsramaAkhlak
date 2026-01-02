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

    private String isi, status, idUser, namaUser;
    private int idPengaduan;

    public static List<Pengaduan> getData() {
        List<Pengaduan> list = new ArrayList<>();

        String sql = """
            SELECT p.id_pengaduan, p.isi, p.status, p.id_user, u.nama AS nama_user
            FROM pengaduan p JOIN user u ON p.id_user = u.id_user
        """;

        try (Connection c = DatabaseConfig.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Pengaduan(
                        rs.getInt("id_pengaduan"),
                        rs.getString("isi"),
                        rs.getString("status"),
                        rs.getString("id_user"),
                        rs.getString("nama_user")
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

    public static boolean updateStatus(int idPengaduan, String status) {

        String sql = "UPDATE pengaduan SET status = ? WHERE id_pengaduan = ?";

        try (Connection c = DatabaseConfig.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, idPengaduan);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Pengaduan(int idPengaduan, String isi, String status, String idUser, String nama) {
        this.idPengaduan = idPengaduan;
        this.isi = isi;
        this.status = status;
        this.idUser = idUser;
        this.namaUser = nama;
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

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public int getIdPengaduan() {
        return idPengaduan;
    }

}
