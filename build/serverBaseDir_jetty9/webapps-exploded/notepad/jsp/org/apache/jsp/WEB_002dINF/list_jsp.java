package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>Notebook!</h1><hr>\r\n");
      out.write("Today is: ");
      out.print( new java.util.Date());
      out.write("\r\n");
      out.write("<hr align=\"left\" width=\"325\" size=5>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    checkobj=0;\r\n");
      out.write("    function checkAvail(obj) {\r\n");
      out.write("        if (obj.checked) checkobj++;\r\n");
      out.write("            else checkobj--;\r\n");
      out.write("    }\r\n");
      out.write("    function delete_notes() {\r\n");
      out.write("    \tvalid = true;\r\n");
      out.write("        if (checkobj<=0) {\r\n");
      out.write("            alert (\"Please, select one or more notes to delete.\");\r\n");
      out.write("            valid = false;\r\n");
      out.write("        }\r\n");
      out.write("        return valid;\r\n");
      out.write("    }\r\n");
      out.write("    function edit_notes() {\r\n");
      out.write("    \tvalid = true;\r\n");
      out.write("        if (checkobj<=0 || checkobj>=2) {\r\n");
      out.write("            alert (\"Please, select one note to editing.\");\r\n");
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
      out.write("<form action=\"ActionDo\" name=\"submits\">\r\n");
      out.write("<button name=\"action\" type=\"submit\" value=\"create\" class=\"new\">create</button>\r\n");
      out.write("<button name=\"action\" type=\"submit\" value=\"edit\" onclick=\"return edit_notes();\" class=\"new\">edit</button>\r\n");
      out.write("<button name=\"action\" type=\"submit\" value=\"delete\" onclick=\"return delete_notes();\" class=\"new\">delete</button>\r\n");
      out.write("<br><br>\r\n");
      out.write("\r\n");
      out.write("<table cellspacing=\"0\">\r\n");
      out.write("<tr>\r\n");
      out.write("    <th>&nbsp;</th><th>Title</th><th>Body</th>\r\n");
      out.write("   </tr>\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("note");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${notes}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("    <tr>\r\n");
          out.write("<td width=\"20\"><input type=\"checkbox\" name=\"noteId\" id=\"ch\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${note.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" onclick=\"checkAvail(this)\">\r\n");
          out.write("</td>\r\n");
          out.write("<td width=\"180\"><label for=\"ch\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${note.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</label></td>\r\n");
          out.write("<td width=\"200\"><label for=\"ch\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${note.body}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</label></td>\r\n");
          out.write("    </tr>\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
