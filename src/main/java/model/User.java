/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Adyadma Renjiro
 */
public class User {
private int idUser;
    private String username;
    private String nama;
    private String role;

    public User(int idUser, String username, String nama, String role) {
        this.idUser = idUser;
        this.username = username;
        this.nama = nama;
        this.role = role;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public String getNama() {
        return nama;
    }

    public String getRole() {
        return role;
    }

    /**
     * LOGIN CHECK KE DATABASE
     * (Model langsung akses DB)
     */
    public static User login(String username, String password) {

        String sql = """
            SELECT id_user, username, nama, role
            FROM user
            WHERE username = ? AND password = ?
        """;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                    rs.getInt("id_user"),
                    rs.getString("username"),
                    rs.getString("nama"),
                    rs.getString("role")
                );
            }

        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
        }

        return null;
    }
}
