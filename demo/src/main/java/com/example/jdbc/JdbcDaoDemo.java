package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDaoDemo {
    public static void main(String[] args) throws Exception {
        StudentDao dao = new StudentDao();
        Student s1 = dao.getName(13);
        System.out.println(s1);

        Student s2 = new Student("krishna", 1);
        System.out.println(dao.insertStudent(s2.rollno, s2.sname));
    }
}

class StudentDao{
    public Student getName(int rollno){
        try{    
            Student s = new Student(rollno);

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens", "root", "2022");
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select sname from Student where rollno=" + rollno+";");
            rs.next();
            s.sname = rs.getString("sname");

            st.close();
            con.close();

            return s;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public boolean insertStudent(int rollno, String sname){
        try {
            Student s = new Student(sname, rollno);

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens", "root", "2022");
            PreparedStatement pst = con.prepareStatement("insert into Student values(?,?);");
            pst.setInt(1, rollno);
            pst.setString(2, sname);

            int count = pst.executeUpdate();

            pst.close();
            con.close();

            return count>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

class Student{
    String sname;
    int rollno;

    public Student(int rollno){
        this.rollno = rollno;
    }
    

    public Student(String sname, int rollno) {
        this.sname = sname;
        this.rollno = rollno;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{");
        sb.append("sname=").append(sname);
        sb.append(", rollno=").append(rollno);
        sb.append('}');
        return sb.toString();
    }


}