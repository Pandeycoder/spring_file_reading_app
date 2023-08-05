package pandey.com.dao;

import org.springframework.stereotype.Repository;
import pandey.com.bean.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Repository
public class BookDaoImpl implements BookDao {
   private static final String DB_DRIVER="oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_User="pandey";
    private static final String DB_pwd="coder";
    @Override
    public int insertBook(Book book) {
        try(Connection con= DriverManager.getConnection(DB_URL,DB_User,DB_pwd);){

            PreparedStatement psmt=con.prepareStatement("insert into Book values(?,?,?)");
            psmt.setInt(1,book.getId());
            psmt.setString(2,book.getName());
            psmt.setDouble(3,book.getPrice());
            int count=psmt.executeUpdate();

            return count;


        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }
}
