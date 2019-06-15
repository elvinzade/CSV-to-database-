import java.io.*;
import java.math.BigDecimal;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try

        {
            Class.forName("oracle.jdbc.OracleDriver");
            String jdbcUrl = "jdbc:oracle:thin:@//localhost:1521/orclpdb";
            String username = "HR";
            String password = "hr";
            con = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database yarandi");
        } catch(
                ClassNotFoundException e)

        {
            e.printStackTrace();
        } catch(
                SQLException e)

        {
            e.printStackTrace();
        }


        String insert = "insert into ishci " +
                "values(?, ?, ?, ?)";
        try (
                BufferedReader in = new BufferedReader(new FileReader("src/emp.csv"));

        ) {
            int i = 0;
            String line;
            String[] values = new String[4];
            while ((line = in.readLine()) != null) {
                values = line.split(",");
                    ps = con.prepareStatement(insert);
                    ps.setInt(1, Integer.valueOf(values[0]));
                    ps.setString(2, values[1]);
                    ps.setString(3, values[2]);
                    ps.setInt(4, Integer.valueOf(values[3]));
                    ps.executeUpdate();


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }




    }
 }

