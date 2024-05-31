package com.lxx.dao;

import com.lxx.Bean.WorkExperience;
import com.lxx.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkExperienceDaoImpl {

    // 新增工作经历
    public void addWorkExperience(WorkExperience experience) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "INSERT INTO work_experience (u_id, company_name, job_name, start_time, end_time, describes, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, experience.getUId());
            pstmt.setString(2, experience.getCompanyName());
            pstmt.setString(3, experience.getJobName());
            pstmt.setString(4, experience.getStartTime());
            pstmt.setString(5, experience.getEndTime());
            pstmt.setString(6, experience.getDescribes());
            pstmt.setString(7, experience.getAddress());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 修改工作经历
    public void updateWorkExperience(WorkExperience experience) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "UPDATE work_experience SET company_name=?, job_name=?, start_time=?, end_time=?, describes=?, address=? WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, experience.getCompanyName());
            pstmt.setString(2, experience.getJobName());
            pstmt.setString(3, experience.getStartTime());
            pstmt.setString(4, experience.getEndTime());
            pstmt.setString(5, experience.getDescribes());
            pstmt.setString(6, experience.getAddress());
            pstmt.setInt(7, experience.getId());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除工作经历
    public void deleteWorkExperience(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "DELETE FROM work_experience WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 根据ID查询工作经历
    public WorkExperience getWorkExperienceById(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        WorkExperience experience = null;

        try {
            conn = DButil.getConnection();
            String sql = "SELECT * FROM work_experience WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                experience = new WorkExperience();
                experience.setId(rs.getInt("id"));
                experience.setUId(rs.getInt("u_id"));
                experience.setCompanyName(rs.getString("company_name"));
                experience.setJobName(rs.getString("job_name"));
                experience.setStartTime(rs.getString("start_time"));
                experience.setEndTime(rs.getString("end_time"));
                experience.setDescribes(rs.getString("describes"));
                experience.setAddress(rs.getString("address"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return experience;
    }

    // 根据用户ID查询所有工作经历
    public List<WorkExperience> getWorkExperiencesByUid(int uId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<WorkExperience> experiences = new ArrayList<>();

        try {
            conn = DButil.getConnection();
            String sql = "SELECT * FROM work_experience WHERE u_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, uId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                WorkExperience exp = new WorkExperience();
                exp.setId(rs.getInt("id"));
                exp.setUId(rs.getInt("u_id"));
                exp.setCompanyName(rs.getString("company_name"));
                exp.setJobName(rs.getString("job_name"));
                exp.setStartTime(rs.getString("start_time"));
                exp.setEndTime(rs.getString("end_time"));
                exp.setDescribes(rs.getString("describes"));
                exp.setAddress(rs.getString("address"));
                experiences.add(exp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return experiences;
    }
}
