package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createnote_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>New note</h1><hr>\r\n");
      out.write("Today is: ");
      out.print( new java.util.Date());
      out.write("\r\n");
      out.write("<hr align=\"left\" width=\"325\" size=5>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    function validate_texts() {\r\n");
      out.write("\t    valid = true;\r\n");
      out.write("        if ( document.creation.title.value.trim() == \"\" ) {\r\n");
      out.write("            alert ( \"Please, write title.\" );\r\n");
      out.write("            valid = false;\r\n");
      out.write("        }\r\n");
      out.write("        if ( document.creation.noteBody.value.trim() == \"\" ) {\r\n");
      out.write("            alert ( \"Please, write your text.\" );\r\n");
      out.write("            valid = false;\r\n");
      out.write("        }\r\n");
      out.write("        return valid;\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("   TABLE { width: 400px; border: 1px solid black;  border-bottom: none; }\r\n");
      out.write("   TD, TH { padding: 3px; }\r\n");
      out.write("   TH { text-align: left; background: black; color: white; border: 1px solid white; }\r\n");
      out.write("   TD { border-bottom: 1px solid black; }\r\n");
      out.write("  </style>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("    button.new {\r\n");
      out.write("       padding: 3px 7px;\r\n");
      out.write("       color: #fff;\r\n");
      out.write("        -moz-border-radius: 5px;\r\n");
      out.write("        -webkit-border-radius: 5px;\r\n");
      out.write("       border-radius:  5px;\r\n");
      out.write("       border: 2px solid #666;\r\n");
      out.write("       background: -moz-linear-gradient(#f2f2f2, #777, #404040, #252525);\r\n");
      out.write("       background: -webkit-gradient(linear, 0 0, 0  100%, from(#f2f2f2), to(#252525), color-stop(0.6, #777), color-stop(0.6,  #404040));\r\n");
      out.write("      }\r\n");
      out.write("  </style>\r\n");
      out.write("\r\n");
      out.write("<form action=\"ActionCreate\" method=\"post\" name=\"creation\">\r\n");
      out.write("<button name=\"action\" type=\"submit\" value=\"save\" onclick=\"return validate_texts();\" class=\"new\">save</button>\r\n");
      out.write("<button type=\"reset\" value=\"reset\" class=\"new\">reset</button>\r\n");
      out.write("<button name=\"action\" type=\"submit\" value=\"cancel\" class=\"new\">cancel</button>\r\n");
      out.write("<br>\r\n");
      out.write("<table cellspacing=\"0\">\r\n");
      out.write("<tr><th>Title:</th><th><input placeholder=\"write title here\" name=\"title\" type=\"text\" size=\"50\"></th></tr>\r\n");
      out.write("<tr><th>Your text:</th><br>\r\n");
      out.write("<th><textarea placeholder=\"write your text here\" rows=\"10\" cols=\"52\" name=\"noteBody\"></textarea></th></tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
