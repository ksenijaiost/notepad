import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by iost1 on 02.06.2016.
 */

@WebServlet("/ActionEdit")
public class ActionEdit extends HttpServlet {

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String action = req.getParameter("action");
        String noteId = req.getParameter("noteId");
        String title = req.getParameter("title");
        String noteBody = req.getParameter("noteBody");
        int nId = Integer.parseInt(noteId);
        switch (action) {
            case "delete":
                NoteDAO.instance.deleteById(nId);
                break;
            case "save":
                try {
                    NoteDAO.instance.reSave(nId,title,noteBody);
                } catch (SQLException e) {
                    e.printStackTrace(); throw new RuntimeException();
                }
                break;
        }
        String contextPath = getServletContext().getContextPath();
        res.sendRedirect(contextPath);
    }
}
