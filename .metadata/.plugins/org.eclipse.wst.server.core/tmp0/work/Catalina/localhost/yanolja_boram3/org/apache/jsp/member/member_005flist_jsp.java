/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.59
 * Generated at: 2015-04-30 09:01:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.boram3.yanolja.DAO.*;
import com.boram3.yanolja.DTO.*;

public final class member_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	List memberlist = (List)request.getAttribute("memberlist");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"style/ico/favicon.ico\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("    <link href=\"style/css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"style/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"style/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"style/js/fancybox/jquery.fancybox.css\" rel=\"stylesheet\" />\r\n");
      out.write("<script>\r\n");
      out.write("function CallConfirm() {//사용자 정의 함수\r\n");
      out.write("\tif(window.confirm(\"삭제할까요\")){ \r\n");
      out.write("\t\tdocument.deleteok.submit();\r\n");
      out.write("\t\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("/* <form action=\"./MemberDeleteAction.me\" method=\"post\" name=\"deleteok\">\r\n");
      out.write("<td>\r\n");
      out.write("<input type=\"button\" value=\"삭제\" onclick=\"CallConfirm()\" >\r\n");
      out.write("</td>\r\n");
      out.write("</form> */\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body data-spy=\"scroll\" data-offset=\"0\" data-target=\"#theMenu\">\r\n");
      out.write("<!-- Menu -->\r\n");
      out.write("\t<nav class=\"menu\" id=\"theMenu\">\r\n");
      out.write("\t\t<div class=\"menu-wrap\">\r\n");
      out.write("\t\t\t<h1 class=\"logo\"><a href=\"index.html#home\">DSGN NYC</a></h1>\r\n");
      out.write("\t\t\t<i class=\"fa fa-times menu-close\"></i>\r\n");
      out.write("\t\t\t<a href=\"#home\" class=\"smoothScroll\">Home</a>\r\n");
      out.write("\t\t\t<a href=\"#about\" class=\"smoothScroll\">About</a>\r\n");
      out.write("\t\t\t<a href=\"#portfolio\" class=\"smoothScroll\">Portfolio</a>\r\n");
      out.write("\t\t\t<a href=\"#services\" class=\"smoothScroll\">Services</a>\r\n");
      out.write("\t\t\t<a href=\"#contact\" class=\"smoothScroll\">Contact</a>\r\n");
      out.write("\t\t\t<a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\r\n");
      out.write("\t\t\t<a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\r\n");
      out.write("\t\t\t<a href=\"#\"><i class=\"fa fa-dribbble\"></i></a>\r\n");
      out.write("\t\t\t<a href=\"#\"><i class=\"fa fa-envelope\"></i></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Menu button -->\r\n");
      out.write("\t\t<div id=\"menuToggle\"><i class=\"fa fa-bars\"></i></div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<center>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table border=1 width=300>\r\n");
      out.write("\t<tr align=center>\r\n");
      out.write("\t\t<td colspan=2>회원 목록</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

	for(int i=0;i<memberlist.size();i++){ 
	MemberBean member=(MemberBean)memberlist.get(i);
	
      out.write("\r\n");
      out.write("\t<tr align=center>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<a href=\"MemberViewAction.me?userid=");
      out.print(member.getUserid() );
      out.write("\">\r\n");
      out.write("\t\t\t\t");
      out.print(member.getUserid() );
      out.write("\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<form action=\"./MemberDeleteAction.me\" method=\"post\" name=\"deleteok\">\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<input type=\"button\" value=\"삭제\" onclick=\"CallConfirm()\" >\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("\t<form action=\"./MemberSearchAction.me\" method=\"post\">\r\n");
      out.write("\t<tr align=center>\r\n");
      out.write("\t\t<td colspan=2>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"searchMember\" />\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"검색\" />\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<tr align=center>\r\n");
      out.write("\t\t<td colspan=2>\r\n");
      out.write("\t\t\t<a href=\"./BoardList.bo\">[게시판 이동]</a>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\r\n");
      out.write("\t<script src=\"style/js/classie.js\"></script>\r\n");
      out.write("    <script src=\"style/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"style/js/smoothscroll.js\"></script>\r\n");
      out.write("\t<script src=\"style/js/jquery.stellar.min.js\"></script>\r\n");
      out.write("\t<script src=\"style/js/fancybox/jquery.fancybox.js\"></script>    \r\n");
      out.write("\t<script src=\"style/js/main.js\"></script>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\t$.stellar({\r\n");
      out.write("\t\t\t\thorizontalScrolling: false,\r\n");
      out.write("\t\t\t\tverticalOffset: 40\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("      $(function() {\r\n");
      out.write("        //    fancybox\r\n");
      out.write("          jQuery(\".fancybox\").fancybox();\r\n");
      out.write("      });\r\n");
      out.write("\t   </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
