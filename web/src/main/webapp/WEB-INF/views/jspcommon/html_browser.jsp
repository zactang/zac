<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String userAgent = request.getHeader("user-agent");
  if (userAgent != null) {
    if (userAgent.indexOf("Trident/4") > 0) {//Trident/4.0;
      out.println("<html lang=\"zh-cn\" class=\"ie8 ie\">");
    } else if (userAgent.indexOf("Trident/5") > 0) {//Trident/5.0
      out.println("<html lang=\"zh-cn\" class=\"ie9 ie\">");
    } else if (userAgent.indexOf("Trident/6") > 0) {//Trident/6.0
      out.println("<html lang=\"zh-cn\" class=\"ie10 ie\">");
    } else if (userAgent.indexOf("Trident") > 0) {//Trident
      out.println("<html lang=\"zh-cn\" class=\"ie\">");
    } else {
      out.println("<html lang=\"zh-cn\">");
    }
  } else {
    out.println("<html lang=\"zh-cn\">");
  }
%>
<!-- 
<%out.println("USER AGENT IS:" + userAgent);%> 
-->