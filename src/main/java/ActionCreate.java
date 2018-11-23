import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by iost1 on 13.05.2016.
 */

@WebServlet("/ActionCreate")
public class ActionCreate extends HttpServlet{

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String action = req.getParameter("action");

        String title = req.getParameter("title");
        String noteBody = req.getParameter("noteBody");

        if (action.equals("save")) {
            if (!isBlank(noteBody)) {
                    if (isBlank(title)) {
                    title = "note";
                }
                try {
                    NoteDAO.instance.newSave(title, noteBody);
                } catch (SQLException e) {
                    e.printStackTrace(); throw new RuntimeException();
                }
            }
        }
        String contextPath = getServletContext().getContextPath();
        res.sendRedirect(contextPath);
    }

    private boolean isBlank(String title) {
        return title == null || title.replaceAll("\\s", "").length() == 0;
    }
}
