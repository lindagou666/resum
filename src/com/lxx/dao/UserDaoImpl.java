package com.lxx.dao;

import com.lxx.Bean.User;
import com.lxx.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl {

    // 新增用户
    public void addUser(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "INSERT INTO user (u_id, name, phone, age, sex, job_name, education, school_name, username, password, hobby) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPhone());
            pstmt.setInt(4, user.getAge());
            pstmt.setString(5, user.getSex());
            pstmt.setString(6, user.getJobName());
            pstmt.setString(7, user.getEducation());
            pstmt.setString(8, user.getSchoolName());
            pstmt.setString(9, user.getUsername());
            pstmt.setString(10, user.getPassword());
            pstmt.setString(11, user.getHobby());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 根据用户名查询用户
    public User getUserByUsername(String username) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = DButil.getConnection();
            String sql = "SELECT * FROM user WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUId(rs.getString("u_id"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getString("sex"));
                user.setJobName(rs.getString("job_name"));
                user.setEducation(rs.getString("education"));
                user.setSchoolName(rs.getString("school_name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setHobby(rs.getString("hobby"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    // 修改用户信息
    public void updateUser(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "UPDATE user SET name=?, phone=?, age=?, sex=?, job_name=?, education=?, school_name=?, username=?, password=?, hobby=? WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPhone());
            pstmt.setInt(3, user.getAge());
            pstmt.setString(4, user.getSex());
            pstmt.setString(5, user.getJobName());
            pstmt.setString(6, user.getEducation());
            pstmt.setString(7, user.getSchoolName());
            pstmt.setString(8, user.getUsername());
            pstmt.setString(9, user.getPassword());
            pstmt.setString(10, user.getHobby());
            pstmt.setInt(11, user.getId());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除用户
    public void deleteUser(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "DELETE FROM user WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 根据ID查询用户
    public User getUserById(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = DButil.getConnection();
            String sql = "SELECT * FROM user WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUId(rs.getString("u_id"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getString("sex"));
                user.setJobName(rs.getString("job_name"));
                user.setEducation(rs.getString("education"));
                user.setSchoolName(rs.getString("school_name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setHobby(rs.getString("hobby"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
