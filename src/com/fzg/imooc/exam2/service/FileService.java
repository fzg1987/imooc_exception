package com.fzg.imooc.exam2.service;

import com.fzg.imooc.exam2.entity.File;
import com.fzg.imooc.exam2.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileService {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    // 将文件保存到数据库中
    public void save(File file){
        try {
            String sql = "insert into tb_file(fname,fcontent) values (?,?)";
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,file.getFname());
            pstmt.setBytes(2,file.getFcontent());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs,pstmt,conn);
        }
    }
}
