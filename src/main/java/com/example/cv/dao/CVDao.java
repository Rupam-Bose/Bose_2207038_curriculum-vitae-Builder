package com.example.cv.dao;

import com.example.cv.DB.Database;
import com.example.cv.model.CVmodel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CVDao {

    public void insert(CVmodel cv) {
        String sql = """
                INSERT INTO cvs(name, email, phone, address, education,
                                 skills, work_experience, projects, image_path)
                VALUES(?,?,?,?,?,?,?,?,?)
                """;

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cv.getName());
            ps.setString(2, cv.getEmail());
            ps.setString(3, cv.getPhone());
            ps.setString(4, cv.getAddress());
            ps.setString(5, cv.getEducation());
            ps.setString(6, cv.getSkills());
            ps.setString(7, cv.getWorkExperience());
            ps.setString(8, cv.getProjects());
            ps.setString(9, cv.getImagePath());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(CVmodel cv) {
        String sql = """
                UPDATE cvs
                SET name=?, email=?, phone=?, address=?, education=?,
                    skills=?, work_experience=?, projects=?, image_path=?
                WHERE id=?
                """;

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cv.getName());
            ps.setString(2, cv.getEmail());
            ps.setString(3, cv.getPhone());
            ps.setString(4, cv.getAddress());
            ps.setString(5, cv.getEducation());
            ps.setString(6, cv.getSkills());
            ps.setString(7, cv.getWorkExperience());
            ps.setString(8, cv.getProjects());
            ps.setString(9, cv.getImagePath());
            ps.setInt(10, cv.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM cvs WHERE id=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CVmodel> findAll() {
        List<CVmodel> list = new ArrayList<>();
        String sql = "SELECT * FROM cvs ORDER BY id DESC";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CVmodel cv = new CVmodel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("education"),
                        rs.getString("skills"),
                        rs.getString("work_experience"),
                        rs.getString("projects"),
                        rs.getString("image_path")
                );
                list.add(cv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Optional<CVmodel> findById(int id) {
        String sql = "SELECT * FROM cvs WHERE id=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    CVmodel cv = new CVmodel(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            rs.getString("address"),
                            rs.getString("education"),
                            rs.getString("skills"),
                            rs.getString("work_experience"),
                            rs.getString("projects"),
                            rs.getString("image_path")
                    );
                    return Optional.of(cv);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}