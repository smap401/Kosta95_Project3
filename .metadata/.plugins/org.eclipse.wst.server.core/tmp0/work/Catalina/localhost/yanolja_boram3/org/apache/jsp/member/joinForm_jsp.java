/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.59
 * Generated at: 2015-04-30 08:51:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class joinForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>회원가입 페이지</title>\r\n");
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
      out.write("function idcheck(){\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tvar id=document.joinform.userid.value;\r\n");
      out.write("\twindow.open('./member/idcheck.jsp?userid='+id,'win',width=\"300\", heigth=\"200\");\r\n");
      out.write("}\r\n");
      out.write("function CheckData(){\r\n");
      out.write("\t/* var title= document.myform.title;\r\n");
      out.write("\tvar content = document.myform.content; */\r\n");
      out.write("\t\r\n");
      out.write("\tvar id= document.joinform.userid.value;\r\n");
      out.write("\tif(id.length<4){\r\n");
      out.write("\t\talert(\"아이디가 너무 짧습니다.\");\r\n");
      out.write("\t\tdocument.joinform.userid.focus();\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tvar pic= document.joinform.profile_pic.value;\r\n");
      out.write("\tif(pic==\"\"){\r\n");
      out.write("\t\talert(\"사진을 첨부하여 주십시오.\");\r\n");
      out.write("\t\tdocument.joinform.profile_pic.focus();\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar nam= document.joinform.name.value;\r\n");
      out.write("\tif(nam==\"\"){\r\n");
      out.write("\t\talert(\"이름을 입력해주십시오.\");\r\n");
      out.write("\t\tdocument.joinform.name.focus();\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar pwd= document.joinform.pwd.value;\r\n");
      out.write("\tif(pwd==\"\"){\r\n");
      out.write("\t\talert(\"비밀번호를 입력해주십시오.\");\r\n");
      out.write("\t\tdocument.joinform.pwd.focus();\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}else if(pwd.length<5){\r\n");
      out.write("\t\talert(\"비밀번호를 4자리 이상 입력해주십시오.\");\r\n");
      out.write("\t\tdocument.joinform.pwd.focus();\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvar chpwd= document.joinform.pwd1.value;\r\n");
      out.write("\tif(chpwd==\"\"){\r\n");
      out.write("\t\talert(\"비밀번호확인을 입력해주십시오.\");\r\n");
      out.write("\t\tdocument.joinform.pwd1.focus();\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}if(pwd!=chpwd){\r\n");
      out.write("\t\talert(\"비밀번호를 동일하게 입력해주십시오.\");\r\n");
      out.write("\t\tdocument.joinform.pwd1.focus();\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar ph= document.joinform.phone.value;\r\n");
      out.write("\tif(ph==\"\"){\r\n");
      out.write("\t\talert(\"전화번호를 입력해주십시오.\");\r\n");
      out.write("\t\tdocument.joinform.phone.focus();\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvar mail= document.joinform.email.value;\r\n");
      out.write("\tif(mail==\"\"){\r\n");
      out.write("\t\talert(\"이메일을 입력해주십시오.\");\r\n");
      out.write("\t\tdocument.joinform.email.focus();\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tdocument.joinform.submit();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form name=\"joinform\" action=\"./MemberJoinAction.me\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("<center>\r\n");
      out.write("<table border=1>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"2\" align=center>\r\n");
      out.write("\t\t\t<b><font size=5>회원가입 페이지</font></b>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>아이디 : </td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"userid\"/></td>\r\n");
      out.write("\t\t<td><input type=\"button\" name=\"useridcheck\" onclick=\"idcheck()\"/></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>프로필사진 : </td>\r\n");
      out.write("\t\t<td><input type=\"file\" name=\"profile_pic\"/></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>이름 : </td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"name\"/></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>비밀번호 : </td>\r\n");
      out.write("\t\t<td><input type=\"password\" name=\"pwd\"/></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>비밀번호 확인 : </td>\r\n");
      out.write("\t\t<td><input type=\"password\" name=\"pwd1\"/></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>전화번호(숫자만) : </td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"phone\" /></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>이메일 주소 : </td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"email\" size=30/></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>응원하는 팀 : </td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"team_no_fk\" value=\"0\" checked/>무소속\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"team_no_fk\" value=\"1\"/>삼성\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"team_no_fk\" value=\"2\"/>넥센\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"team_no_fk\" value=\"3\"/>NC\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"team_no_fk\" value=\"4\"/>LG\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"team_no_fk\" value=\"5\"/>SK\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"team_no_fk\" value=\"6\"/>두산\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"team_no_fk\" value=\"7\"/>롯데\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"team_no_fk\" value=\"8\"/>KIA\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"team_no_fk\" value=\"9\"/>한화\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"team_no_fk\" value=\"10\"/>KT\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"2\" align=center>\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"회원가입\" onclick=\"CheckData()\">\r\n");
      out.write("\t\t\t<!-- <a href=\"javascript:joinform.submit()\">회원가입</a>&nbsp;&nbsp; -->\r\n");
      out.write("\t\t\t<a href=\"javascript:joinform.reset()\">다시작성</a>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</center>\r\n");
      out.write("</form>\r\n");
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
