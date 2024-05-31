package com.lxx.dao;

import com.lxx.Bean.Honor;
import com.lxx.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HonorDaoImpl {

    // 新增荣誉
    public void addHonor(Honor honor) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "INSERT INTO honor (uid, honor, time) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, honor.getUid());
            pstmt.setString(2, honor.getHonor());
            pstmt.setString(3, honor.getTime());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 修改荣誉
    public void updateHonor(Honor honor) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "UPDATE honor SET honor=?, time=? WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, honor.getHonor());
            pstmt.setString(2, (honor.getTime()));
            pstmt.setInt(3, honor.getId());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除荣誉
    public void deleteHonor(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "DELETE FROM honor WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 根据ID查询荣誉
    public Honor getHonorById(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Honor honor = null;

        try {
            conn = DButil.getConnection();
            String sql = "SELECT * FROM honor WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                honor = new Honor();
                honor.setId(rs.getInt("id"));
                honor.setUid(rs.getInt("uid"));
                honor.setHonor(rs.getString("honor"));
                honor.setTime(rs.getString("time"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return honor;
    }

    // 根据UID查询所有荣誉
    public List<Honor> getAllHonorsByUid(int uid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Honor> honors = new ArrayList<>();

        try {
            conn = DButil.getConnection();
            String sql = "SELECT * FROM honor WHERE uid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, uid);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Honor h = new Honor();
                h.setId(rs.getInt("id"));
                h.setUid(rs.getInt("uid"));
                h.setHonor(rs.getString("honor"));
                h.setTime(rs.getString("time"));
                honors.add(h);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return honors;
    }
}
