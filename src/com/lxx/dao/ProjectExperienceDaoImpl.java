package com.lxx.dao;

import com.lxx.Bean.ProjectExperience;
import com.lxx.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectExperienceDaoImpl {

    // 新增项目经验
    public void addProjectExperience(ProjectExperience experience) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "INSERT INTO project_experience (uid, project_name, describes) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, experience.getUid());
            pstmt.setString(2, experience.getProjectName());
            pstmt.setString(3, experience.getDescribes());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 修改项目经验
    public void updateProjectExperience(ProjectExperience experience) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "UPDATE project_experience SET project_name=?, describes=? WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, experience.getProjectName());
            pstmt.setString(2, experience.getDescribes());
            pstmt.setInt(3, experience.getId());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除项目经验
    public void deleteProjectExperience(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "DELETE FROM project_experience WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 根据ID查询项目经验
    public ProjectExperience getProjectExperienceById(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ProjectExperience experience = null;

        try {
            conn = DButil.getConnection();
            String sql = "SELECT * FROM project_experience WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                experience = new ProjectExperience();
                experience.setId(rs.getInt("id"));
                experience.setUid(rs.getInt("uid"));
                experience.setProjectName(rs.getString("project_name"));
                experience.setDescribes(rs.getString("describes"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return experience;
    }

    // 根据UID查询所有项目经验
    public List<ProjectExperience> getAllProjectExperiencesByUid(int uid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<ProjectExperience> experiences = new ArrayList<>();

        try {
            conn = DButil.getConnection();
            String sql = "SELECT * FROM project_experience WHERE uid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, uid);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ProjectExperience exp = new ProjectExperience();
                exp.setId(rs.getInt("id"));
                exp.setUid(rs.getInt("uid"));
                exp.setProjectName(rs.getString("project_name"));
                exp.setDescribes(rs.getString("describes"));
                experiences.add(exp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return experiences;
    }
}
