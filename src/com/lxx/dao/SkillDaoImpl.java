package com.lxx.dao;

import com.lxx.Bean.Skill;
import com.lxx.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl {

    // 新增技能
    public void addSkill(Skill skill) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "INSERT INTO skills (u_id, name, proficiency) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, skill.getUId());
            pstmt.setString(2, skill.getName());
            pstmt.setString(3, skill.getProficiency());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 修改技能
    public void updateSkill(Skill skill) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "UPDATE skills SET name=?, proficiency=? WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, skill.getName());
            pstmt.setString(2, skill.getProficiency());
            pstmt.setInt(3, skill.getId());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除技能
    public void deleteSkill(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "DELETE FROM skills WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 根据ID查询技能
    public Skill getSkillById(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Skill skill = null;

        try {
            conn = DButil.getConnection();
            String sql = "SELECT * FROM skills WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                skill = new Skill();
                skill.setId(rs.getInt("id"));
                skill.setUId(rs.getInt("u_id"));
                skill.setName(rs.getString("name"));
                skill.setProficiency(rs.getString("proficiency"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }

    // 根据用户ID查询所有技能
    public List<Skill> getSkillsByUid(Integer uId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Skill> skills = new ArrayList<>();

        try {
            conn = DButil.getConnection();
            String sql = "SELECT * FROM skills WHERE u_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, uId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Skill s = new Skill();
                s.setId(rs.getInt("id"));
                s.setUId(rs.getInt("u_id"));
                s.setName(rs.getString("name"));
                s.setProficiency(rs.getString("proficiency"));
                skills.add(s);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return skills;
    }
}
