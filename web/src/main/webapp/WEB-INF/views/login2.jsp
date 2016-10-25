<%@page import="com.zac.web.bean.vo.DateVo"%>
<%@page import="com.zac.web.util.DateUtil"%>
<%@page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />





 <!-- BEGIN HEADER -->
 <div class="header navbar navbar-inverse navbar-fixed-top ">
  <!-- BEGIN TOP NAVIGATION BAR -->
  <div class="navbar-inner">
   <div class="container-fluid">
    <!-- BEGIN LOGO -->
    <div class="span12">
     <div class="page-title-system"> <!-- <img src="#"  /> -->后台管理系统  </div>
     <div class="user_info hidden-phone hidden-tablet">Write less, do more!</div>
    </div>

    <div class="color-panel hidden-phone hidden-tablet"> </div>
   </div>
  </div>
 </div>
 <!-- END HEADER -->



<!--  <div class="navbar navbar-duomi navbar-static-top" > </div>  -->
    <div class="container-fluid" style="padding-top:85px">
        <div class="row">
            <div class="col-md-2">
                <ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
                    <li class="active"> <a href="#">  <i class="glyphicon glyphicon-th-large"></i>  首页 </a> </li>
                    <li>
                        <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
                            <i class="glyphicon glyphicon-cog"></i> 系统管理 <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                        </a>
                        <ul id="systemSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                            <li><a href="#"><i class="glyphicon glyphicon-user"></i>用户管理</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-th-list"></i>菜单管理</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>角色管理</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-edit"></i>修改密码</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>日志查看</a></li>
                        </ul>
                    </li>
                    <li> <a href="#"> <i class="glyphicon glyphicon-credit-card"></i>  物料管理 </a> </li>
                    <li> <a href="#"> <i class="glyphicon glyphicon-globe"></i> 分发配置 <span class="label label-warning pull-right">5</span>  </a>  </li>
                    <li> <a href="#"> <i class="glyphicon glyphicon-calendar"></i> 图表统计  </a> </li>
                    <li> <a href="#"> <i class="glyphicon glyphicon-fire"></i> 关于系统 </a> </li>
 
                </ul>
            </div>
            <div class="col-md-10" > 
            
            <!-- start 主窗口 -->
<%DateVo[] dts=DateUtil.getMonthDetail();%>
  <table class="table" border="1" >
   <tr>
    <th width="25" height="16" valign="middle" align="center"><font color="red">日</font></th>
    <th width="25" height="16" valign="middle" align="center">一</th>
    <th width="25" height="16" valign="middle" align="center">二</th>
    <th width="25" height="16" valign="middle" align="center">三</th>
    <th width="25" height="16" valign="middle" align="center">四</th>
    <th width="25" height="16" valign="middle" align="center"> 五</th>
    <th width="25" height="16" valign="middle" align="center"><font color="red">六</font></th>
   </tr>
   <% for (int j = 0; j < 6; j++) {%>
   <tr>
    <% for (int i = j * 7; i < (j + 1) * 7; i++) { %>
    <td width="15%" height="16" valign="middle" align="center">
    <%if (dts[i]!=null){
    	if (dts[i].isToday()){ %>
    		<font color="red"><%=dts[i].getDay()%> </font>
     	<%}else{%>
     			<%=dts[i].getDay()%>
    	<%}%>	
    <%}%>
    
     	
     <%
       }
      }
     %>
    </td>
   </tr>
  </table>
            <!-- end -->
            
             </div>
        </div>
    </div>
  