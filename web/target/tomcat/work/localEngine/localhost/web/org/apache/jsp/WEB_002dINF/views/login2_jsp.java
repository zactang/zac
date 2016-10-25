package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.zac.web.bean.vo.DateVo;
import com.zac.web.util.DateUtil;
import java.util.*;

public final class login2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <!-- BEGIN HEADER -->\r\n");
      out.write(" <div class=\"header navbar navbar-inverse navbar-fixed-top \">\r\n");
      out.write("  <!-- BEGIN TOP NAVIGATION BAR -->\r\n");
      out.write("  <div class=\"navbar-inner\">\r\n");
      out.write("   <div class=\"container-fluid\">\r\n");
      out.write("    <!-- BEGIN LOGO -->\r\n");
      out.write("    <div class=\"span12\">\r\n");
      out.write("     <div class=\"page-title-system\"> <!-- <img src=\"#\"  /> -->后台管理系统  </div>\r\n");
      out.write("     <div class=\"user_info hidden-phone hidden-tablet\">Write less, do more!</div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"color-panel hidden-phone hidden-tablet\"> </div>\r\n");
      out.write("   </div>\r\n");
      out.write("  </div>\r\n");
      out.write(" </div>\r\n");
      out.write(" <!-- END HEADER -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--  <div class=\"navbar navbar-duomi navbar-static-top\" > </div>  -->\r\n");
      out.write("    <div class=\"container-fluid\" style=\"padding-top:85px\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-2\">\r\n");
      out.write("                <ul id=\"main-nav\" class=\"nav nav-tabs nav-stacked\" style=\"\">\r\n");
      out.write("                    <li class=\"active\"> <a href=\"#\">  <i class=\"glyphicon glyphicon-th-large\"></i>  首页 </a> </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#systemSetting\" class=\"nav-header collapsed\" data-toggle=\"collapse\">\r\n");
      out.write("                            <i class=\"glyphicon glyphicon-cog\"></i> 系统管理 <span class=\"pull-right glyphicon glyphicon-chevron-down\"></span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <ul id=\"systemSetting\" class=\"nav nav-list collapse secondmenu\" style=\"height: 0px;\">\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"glyphicon glyphicon-user\"></i>用户管理</a></li>\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"glyphicon glyphicon-th-list\"></i>菜单管理</a></li>\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"glyphicon glyphicon-asterisk\"></i>角色管理</a></li>\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"glyphicon glyphicon-edit\"></i>修改密码</a></li>\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"glyphicon glyphicon-eye-open\"></i>日志查看</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li> <a href=\"#\"> <i class=\"glyphicon glyphicon-credit-card\"></i>  物料管理 </a> </li>\r\n");
      out.write("                    <li> <a href=\"#\"> <i class=\"glyphicon glyphicon-globe\"></i> 分发配置 <span class=\"label label-warning pull-right\">5</span>  </a>  </li>\r\n");
      out.write("                    <li> <a href=\"#\"> <i class=\"glyphicon glyphicon-calendar\"></i> 图表统计  </a> </li>\r\n");
      out.write("                    <li> <a href=\"#\"> <i class=\"glyphicon glyphicon-fire\"></i> 关于系统 </a> </li>\r\n");
      out.write(" \r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-10\" > \r\n");
      out.write("            \r\n");
      out.write("            <!-- start 主窗口 -->\r\n");
DateVo[] dts=DateUtil.getMonthDetail();
      out.write("\r\n");
      out.write("  <table class=\"table\" border=\"1\" >\r\n");
      out.write("   <tr>\r\n");
      out.write("    <th width=\"25\" height=\"16\" valign=\"middle\" align=\"center\"><font color=\"red\">日</font></th>\r\n");
      out.write("    <th width=\"25\" height=\"16\" valign=\"middle\" align=\"center\">一</th>\r\n");
      out.write("    <th width=\"25\" height=\"16\" valign=\"middle\" align=\"center\">二</th>\r\n");
      out.write("    <th width=\"25\" height=\"16\" valign=\"middle\" align=\"center\">三</th>\r\n");
      out.write("    <th width=\"25\" height=\"16\" valign=\"middle\" align=\"center\">四</th>\r\n");
      out.write("    <th width=\"25\" height=\"16\" valign=\"middle\" align=\"center\"> 五</th>\r\n");
      out.write("    <th width=\"25\" height=\"16\" valign=\"middle\" align=\"center\"><font color=\"red\">六</font></th>\r\n");
      out.write("   </tr>\r\n");
      out.write("   ");
 for (int j = 0; j < 6; j++) {
      out.write("\r\n");
      out.write("   <tr>\r\n");
      out.write("    ");
 for (int i = j * 7; i < (j + 1) * 7; i++) { 
      out.write("\r\n");
      out.write("    <td width=\"15%\" height=\"16\" valign=\"middle\" align=\"center\">\r\n");
      out.write("    ");
if (dts[i]!=null){
    	if (dts[i].isToday()){ 
      out.write("\r\n");
      out.write("    \t<font color=\"red\">");
      out.print(dts[i].getDay());
      out.write(" </font>\r\n");
      out.write("     \t");
}else{
      out.write("\r\n");
      out.write("     \t");
      out.print(dts[i].getDay());
      out.write("\r\n");
      out.write("    \t");
}
      out.write("\t\r\n");
      out.write("    ");
}
      out.write("\r\n");
      out.write("    \r\n");
      out.write("     \t\r\n");
      out.write("     ");

       }
      }
     
      out.write("\r\n");
      out.write("    </td>\r\n");
      out.write("   </tr>\r\n");
      out.write("  </table>\r\n");
      out.write("            <!-- end -->\r\n");
      out.write("            \r\n");
      out.write("             </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/views/login2.jsp(7,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/views/login2.jsp(7,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/login2.jsp(7,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}
