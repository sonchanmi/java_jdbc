package com.ohgiraffers.section01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Application01 {
    public static void main(String[] args) {

        // 데이터 베이스와 연결하기 위한 접속 정보들을 관리하는 객체
       Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","songpa","songpa");
            System.out.println(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
