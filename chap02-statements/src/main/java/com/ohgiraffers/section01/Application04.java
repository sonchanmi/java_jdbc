package com.ohgiraffers.section01;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application04 {
    public static void main(String[] args) {

        //조회한 객체를 DTO에 담기

        Connection con = getConnection();

        Statement stmt = null;
        ResultSet rset = null;

        Scanner scr = new Scanner(System.in);
        System.out.println("조회하실 사번을 입력 해주세요");
        String emId = scr.nextLine();

        String query= "SELECT * FROM EMPLOYEE WHERE EMP_ID = " + emId;

        EmployeeDTO selectEMP = null;

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if(rset.next()) {
              selectEMP =new EmployeeDTO();

              selectEMP.setEmpId(rset.getString("EMP_ID"));
              selectEMP.setEmpName(rset.getString("EMP_NAME"));
              selectEMP.setEmpNo(rset.getString("EMP_NO"));
                selectEMP.setEmail(rset.getString("EMAIL"));
                selectEMP.setPhone(rset.getString("PHONE"));
                selectEMP.setDeptCode(rset.getString("DEPT_CODE"));
                selectEMP.setJobCode(rset.getString("JOB_CODE"));
                selectEMP.setSalLevel(rset.getString("SAL_LEVEL"));
                selectEMP.setSalary(rset.getString("SALARY"));
                selectEMP.setBonus(rset.getString("BONUS"));
                selectEMP.setManagerId(rset.getString("MANAGER_ID"));
                selectEMP.setHireDate(rset.getDate("HIRE_DATE"));
                selectEMP.setEndDate(rset.getDate("ENT_DATE"));
                selectEMP.setEndYn(rset.getString("ENT_YN"));

            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(stmt);
            close(rset);

        }
        System.out.println(selectEMP.toString());


    }
}
