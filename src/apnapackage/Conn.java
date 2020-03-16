package apnapackage;
import org.junit.Test;

import javax.swing.*;
import java.sql.*;

import static org.junit.Assert.assertEquals;

public class Conn {

    Connection co = null;
    Statement sql;
    Connection con2;
    public Conn() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


            con2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1", "system", "Oracle_1");
            sql = con2.createStatement();


        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("kuch to rola hye");
        }

    }}

