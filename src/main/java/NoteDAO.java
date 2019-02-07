import java.sql.*;
import java.util.*;

/**
 * Created by iost1 on 11.04.2016.
 */

public class NoteDAO {
    
    public static final NoteDAO instance = new NoteDAO();

    //load notes
    public List<Note> list() throws SQLException {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (Exception e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            throw new RuntimeException();
        }
        Connection connection = null;
        List<Note> NoteList = null;
        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");

            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT id,title,body FROM Note"); //SELECT * FROM NoteDB
            NoteList = new ArrayList<>();
            while (res.next()) {
                long id = res.getLong("id");
                String title = res.getString("title");
                String body = res.getString("body");
                Note note = new Note(id, title, body);
                NoteList.add(note);
            }
            res.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return NoteList;
    }

    //open note (edit)
    public Note openById(int nId) throws SQLException { //ResultSetMetaData
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (Exception e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            throw new RuntimeException();
        }
        Connection connection = null;
        Note note;
        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");

            PreparedStatement pstmt = connection.prepareStatement("SELECT title,body FROM Note WHERE id = ?");
            pstmt.setInt(1, nId);
            ResultSet res = pstmt.executeQuery();
            res.next();
            String title = res.getString("title");
            String body = res.getString("body");
            long id = (long) (nId);
            note = new Note(id, title, body);
            res.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(); //ÎØÈÁÊÀ
        }
        return note;
    }

    //save (create)
    public void newSave (String noteTitle, String noteBody) throws SQLException {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver" );
        } catch (Exception e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Note (title,body) VALUES (?,?)");
            pstmt.setString(1,noteTitle);
            pstmt.setString(2,noteBody);
            pstmt.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //resave (edit)
    public void reSave (int id, String noteTitle, String noteBody) throws SQLException { 
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver" );
        } catch (Exception e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");

            PreparedStatement pstmt = connection.prepareStatement("UPDATE Note SET title = ?,body = ? WHERE id = ?");
                pstmt.setString(1,noteTitle);
                pstmt.setString(2,noteBody);
                pstmt.setInt(3, id);
                pstmt.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   //delete by id (marked or from edition)
    public void deleteById (int id) {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver" );
        } catch (Exception e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");

            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Note WHERE id = ?");
            pstmt.setInt(1,id);
            pstmt.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   
