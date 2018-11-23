import java.sql.*;
import java.util.*;

/**
 * Created by iost1 on 11.04.2016.
 */

public class NoteDAO {

// Проверить содержимое БД
//   public static void main(String[] args) {
//        try {
//            Class.forName("org.hsqldb.jdbc.JDBCDriver");
//        } catch (Exception e) {
//            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
//
//            Statement stmt = connection.createStatement();
//            ResultSet res = stmt.executeQuery("SELECT id,title,body FROM Note"); //SELECT * FROM NoteDB
//            while (res.next()) {
//                long id = res.getLong("id");
//                String title = res.getString("title");
//                String body = res.getString("body");
//                System.out.println(id+" "+title+" "+body);
//            }
//            res.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
//    }

    public static final NoteDAO instance = new NoteDAO();

    //открытие всей таблицы с заметками
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

    //открытие конкретной заметки (для edit)
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
            throw new RuntimeException(); //ОШИБКА
        }
        return note;
    }

    //сохранение в create
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

    //пересохранение в edit
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

   //удаление по id (отмеченные заметки или из edit)
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
    
    //------------------------------------------------------------------------------------------------------------------
//    private Map<String,Note> noteMap = new HashMap<>();
//
//    public static final NoteDAO instance = new NoteDAO();
//
//    private NoteDAO() {
//        noteMap.put("0", new Note("0", "note0", "body0"));
//        noteMap.put("1", new Note("1", "note1", "body1"));
//        noteMap.put("2", new Note("2", "note2", "body2"));
//        noteMap.put("3", new Note("3", "note3", "body3"));
//    }
//
//    public List<Note> list() {
//        return new ArrayList<>(noteMap.values());
//    }

//    public void deleteById (String noteId) {
//        noteMap.remove(noteId);
//    }

//    int idInt = 100;
//    public void saveNew (String title, String noteBody) {
//        idInt = idInt+1;
//        String noteId = Integer.toString(idInt);
//        noteMap.put(noteId,new Note(noteId,title,noteBody));
//    }

//    public void reSave (String nId, String title, String noteBody) {
//        noteMap.put(nId,new Note(nId,title,noteBody));
//    }

//    public Note openById (String noteId){
//        return noteMap.get(noteId);
//    }
}