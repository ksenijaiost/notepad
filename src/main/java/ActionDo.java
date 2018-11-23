/**
 * Created by iost1 on 25.04.2016.
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ActionDo")
public class ActionDo extends HttpServlet {

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String action = req.getParameter("action");

        String[] noteIds = req.getParameterValues("noteId");

        if (action != null) {
            switch (action) {
                case "delete":
                    if (noteIds != null) {
                        for (String n : noteIds) {
                            int nId = Integer.parseInt(n);
                            NoteDAO.instance.deleteById(nId);
                        }
                    }
                    String contextPath = getServletContext().getContextPath();
                    res.sendRedirect(contextPath);
                    break;

                case "create":
                    req.getRequestDispatcher("/WEB-INF/createnote.jsp").forward(req, res);
                    break;

                case "edit":
                    if (noteIds == null) {
                        String contextPath1 = getServletContext().getContextPath();
                        res.sendRedirect(contextPath1);
                    } else {
                        switch (noteIds.length) {
                            case 1:
                                String noteId = req.getParameter("noteId");
                                int nId = Integer.parseInt(noteId);
                                Note note;
                                try {
                                    note = NoteDAO.instance.openById(nId);
                                } catch (SQLException e) {
                                    e.printStackTrace(); throw new RuntimeException();
                                }
                                req.setAttribute("note", note);
                                req.getRequestDispatcher("/WEB-INF/editnote.jsp").forward(req, res);
                                break;
                            default:
                                String contextPath1 = getServletContext().getContextPath();
                                res.sendRedirect(contextPath1);
                                break;
                        }
                    }
                    break;
            }
        }
        else {
            String contextPath = getServletContext().getContextPath();
            res.sendRedirect(contextPath);
        }
    }

}
