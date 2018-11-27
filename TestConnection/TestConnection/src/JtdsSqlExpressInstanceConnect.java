import java.sql.*;

public class JtdsSqlExpressInstanceConnect
{
    public static void main(String[] args) 
    {
        DB db = new DB();
        db.dbConnect(
     "jdbc:jtds:sqlserver://localhost:1433/harris","sa","password123");
    }
}
 
class DB
{
    public DB() {}
 
    public void dbConnect(String db_connect_string, 
  String db_userid, String db_password)
    {
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
    db_connect_string, db_userid, db_password);
            System.out.println("connected");
            
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery("SELECT SEQ_COUNT FROM harris.dbo.CL_SEQ_TABLE");
            r.next();
            int count = r.getInt("SEQ_COUNT") ;
            r.close() ;
            System.out.println("MyTable has " + count + " row(s).");

             
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
};

