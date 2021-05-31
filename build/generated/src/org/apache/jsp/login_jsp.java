package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Đăng nhập</title>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            *{\n");
      out.write("    padding: 0px;\n");
      out.write("    margin: 0px;\n");
      out.write("    font-family: sans-serif;\n");
      out.write("    box-sizing: border-box;\n");
      out.write("}\n");
      out.write("header{\n");
      out.write("    background-color: #cccccc;\n");
      out.write("    min-height: 70px;\n");
      out.write("    padding: 15px;\n");
      out.write("}\n");
      out.write("main{\n");
      out.write("    background-color: #dddddd;\n");
      out.write("    min-height: 300px;\n");
      out.write("    padding: 7.5px 15px;\n");
      out.write("}\n");
      out.write("footer{\n");
      out.write("    background-color: #cccccc;\n");
      out.write("    min-height: 70px;\n");
      out.write("    padding: 15px;\n");
      out.write("}\n");
      out.write(".container{\n");
      out.write("    width: 100%;\n");
      out.write("    max-width: 1200px;\n");
      out.write("    margin-left: auto;\n");
      out.write("    margin-right: auto;\n");
      out.write("}\n");
      out.write(".login-form{\n");
      out.write("    width: 100%;\n");
      out.write("    max-width: 400px;\n");
      out.write("    margin: 20px auto;\n");
      out.write("    background-color: #ffffff;\n");
      out.write("    padding: 15px;\n");
      out.write("    border: 2px dotted #cccccc;\n");
      out.write("    border-radius: 10px;\n");
      out.write("}\n");
      out.write("h1{\n");
      out.write("    color: #009999;\n");
      out.write("    font-size: 20px;\n");
      out.write("    margin-bottom: 30px;\n");
      out.write("}\n");
      out.write(".input-box{\n");
      out.write("    margin-bottom: 10px;\n");
      out.write("}\n");
      out.write(".input-box input{\n");
      out.write("    padding: 7.5px 15px;\n");
      out.write("    width: 100%;\n");
      out.write("    border: 1px solid #cccccc;\n");
      out.write("    outline: none;\n");
      out.write("}\n");
      out.write(".btn-box{\n");
      out.write("    text-align: right;\n");
      out.write("    margin-top: 30px;\n");
      out.write("}\n");
      out.write(".btn-box button{\n");
      out.write("    padding: 7.5px 15px;\n");
      out.write("    border-radius: 2px;\n");
      out.write("    background-color: #009999;\n");
      out.write("    color: #ffffff;\n");
      out.write("    border: none;\n");
      out.write("    outline: none;\n");
      out.write("}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <main>\n");
      out.write("            <div class=\"container\">\n");
      out.write("            <div class=\"login-form\">\n");
      out.write("                <form action=\"LoginServlet\" method=\"post\">\n");
      out.write("                    <h1>Hệ thống thanh toán tiền nước</h1>\n");
      out.write("                    <div class=\"input-box\">\n");
      out.write("                        <i ></i>\n");
      out.write("                        <label><b>Tên đăng nhập</b></label>\n");
      out.write("                        <input type=\"text\"  name=\"username\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-box\">\n");
      out.write("                        <i ></i>\n");
      out.write("                        <label><b>Mật khẩu</b></label>\n");
      out.write("                        <input type=\"password\" name=\"password\">\n");
      out.write("                    </div>\n");
      out.write("                    <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${wrong}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                    <div class=\"btn-box\">\n");
      out.write("                        \n");
      out.write("                        <button type=\"reset\">\n");
      out.write("                            Hủy\n");
      out.write("                        </button>\n");
      out.write("                        <button type=\"submit\">\n");
      out.write("                            Đăng nhập\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("        </main>\n");
      out.write("      \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
