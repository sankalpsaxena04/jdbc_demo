import java.sql.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/sans";
        String uname = "root2";
        String pass = "San";
        String query = "select * from students";
        String query2 = "insert into students values (?,?)";

        //Class.forName("com.mysql.jdbc.Driver");       //deprecated
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        PreparedStatement ps = con.prepareStatement(query2);
        ps.setString(2,"nyay");
        ps.setInt(1,5);
        int count_updated = st.executeUpdate("insert into students values (4,'"+uname+"')");
        int count_update2 = ps.executeUpdate();

        //rs.next();
        System.out.println(count_updated+ " "+ count_update2);
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            String name = rs.getString(2);
            System.out.println(name);

        }
        st.close();
        con.close();
    }
}