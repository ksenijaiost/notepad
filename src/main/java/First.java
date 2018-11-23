/**
 * Created by iost1 on 29.02.2016.
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/")
public class First extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<Note> list = null;
        try {
            list = NoteDAO.instance.list();
        } catch (SQLException e) {
            e.printStackTrace(); throw new RuntimeException();
        }
        req.setAttribute("notes", list);

        req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, res);
    }
}