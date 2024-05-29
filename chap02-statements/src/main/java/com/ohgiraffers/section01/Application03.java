package com.ohgiraffers.section01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application03 {
    public static void main(String[] args) {
        //스캐너로 입력받아서 처리


        Connection con = getConnection();

        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();
            System.out.println("조회하고자 하는 이름을 입력 해주세요");
            Scanner scr = new Scanner(System.in);
            String empName= scr.nextLine();
            String qury = " SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_NAME= '"+empName+"'";
            rset= stmt.executeQuery(qury);


            while(rset.next()) {
                System.out.println(rset.getString("EMP_ID")+ " "+ rset.getString("EMP_NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(stmt);
            close(rset);
        }


    }
}
