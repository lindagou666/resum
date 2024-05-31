package com.lxx.dao;

import com.lxx.Bean.ColleagueEvaluation;
import com.lxx.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColleagueEvaluationDaoImpl {

    // 新增同事评价
    public void addEvaluation(ColleagueEvaluation evaluation) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "INSERT INTO colleague_evaluation (uid, company_name, leader, describes) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, evaluation.getUid());
            pstmt.setString(2, evaluation.getCompanyName());
            pstmt.setString(3, evaluation.getLeader());
            pstmt.setString(4, evaluation.getDescribe());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 修改同事评价
    public void updateEvaluation(ColleagueEvaluation evaluation) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "UPDATE colleague_evaluation SET company_name=?, leader=?, describes=? WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, evaluation.getCompanyName());
            pstmt.setString(2, evaluation.getLeader());
            pstmt.setString(3, evaluation.getDescribe());
            pstmt.setInt(4, evaluation.getId());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除同事评价
    public void deleteEvaluation(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DButil.getConnection();
            String sql = "DELETE FROM colleague_evaluation WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 根据ID查询同事评价
    public ColleagueEvaluation getEvaluationById(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ColleagueEvaluation evaluation = null;

        try {
            conn = DButil.getConnection();
            String sql = "SELECT * FROM colleague_evaluation WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                evaluation = new ColleagueEvaluation();
                evaluation.setId(rs.getInt("id"));
                evaluation.setUid(rs.getInt("uid"));
                evaluation.setCompanyName(rs.getString("company_name"));
                evaluation.setLeader(rs.getString("leader"));
                evaluation.setDescribe(rs.getString("describes"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return evaluation;
    }

    // 根据UID查询所有同事评价
    public List<ColleagueEvaluation> getAllEvaluationsByUid(int uid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<ColleagueEvaluation> evaluations = new ArrayList<>();

        try {
            conn = DButil.getConnection();
            String sql = "SELECT * FROM colleague_evaluation WHERE uid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, uid);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ColleagueEvaluation eval = new ColleagueEvaluation();
                eval.setId(rs.getInt("id"));
                eval.setUid(rs.getInt("uid"));
                eval.setCompanyName(rs.getString("company_name"));
                eval.setLeader(rs.getString("leader"));
                eval.setDescribe(rs.getString("describes"));
                evaluations.add(eval);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return evaluations;
    }
}
