/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Adyadma Renjiro
 */
import config.DatabaseConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Penghuni {

    private String nama, jurusan, noTelp, noKamar, asal;

    // constructor + getter (dipersingkat)

    // DATA PUBLIK (untuk Penghuni)
    public static List<Penghuni> getDataPublik() {
        List<Penghuni> list = new ArrayList<>();

        String sql = """
            SELECT kamar, nama, jurusan
            FROM user WHERE role = 'Penghuni'
        """;

        try (Connection c = DatabaseConfig.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Penghuni(
                    rs.getString("nama"),
                    rs.getString("jurusan"),
                    rs.getString("kamar")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // DATA LENGKAP (Admin / Penjaga)
    public static List<Penghuni> getSemuaData() {
        List<Penghuni> list = new ArrayList<>();

        String sql = "SELECT nama, jurusan, no_telepon, asal, kamar FROM user WHERE role = 'Penghuni'";

        try (Connection c = DatabaseConfig.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Penghuni(
                    rs.getString("nama"),
                    rs.getString("jurusan"),
                    rs.getString("no_telepon"),
                    rs.getString("kamar"),
                    rs.getString("asal")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    //admin
    public Penghuni(String nama, String jurusan, String noTelp, String noKamar, String asal) {
        this.nama = nama;
        this.jurusan = jurusan;
        this.noTelp = noTelp;
        this.noKamar = noKamar;
        this.asal = asal;
    }

    //publik
    public Penghuni(String nama, String jurusan, String noKamar) {
        this.nama = nama;
        this.jurusan = jurusan;
        this.noKamar = noKamar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getNoKamar() {
        return noKamar;
    }

    public void setNoKamar(String noKamar) {
        this.noKamar = noKamar;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }
    
    
}