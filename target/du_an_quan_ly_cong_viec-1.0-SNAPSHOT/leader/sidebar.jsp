<%@ page import="com.example.quan_ly_cong_viec.util.AuthUtil" %>
<%@ page import="com.example.quan_ly_cong_viec.model.NguoiDung" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
    <div class="sidebar-brand-icon rotate-n-15">
        <i class="fas fa-laugh-wink"></i>
    </div>
    <div class="sidebar-brand-text mx-3">Dashboard</div>
</a>

<!-- Divider -->
<hr class="sidebar-divider my-0">

<!-- Nav Item - Dashboard -->
<li class="nav-item">
    <a class="nav-link" href="${context}/employees">
        <i class="fas fa-fw fa-table"></i>
        <span>Danh sách nhân viên</span></a>
</li>

<li class="nav-item">
    <a class="nav-link" href="${context}/projects">
        <i class="fas fa-fw fa-folder"></i>
        <span>Quản lý dự án</span></a>
</li>

<%
    AuthUtil authUtil = new AuthUtil();
    NguoiDung nguoiDung = authUtil.getNguoiDungFromCookie(request);
    request.setAttribute("idCaNhan", nguoiDung.getId());
%>

<li class="nav-item">
    <a class="nav-link" href="${context}/employees/show?id=${idCaNhan}">
        <i class="fas fa-user fa-sm fa-fw"></i>
        <span>Thông tin cá nhân</span></a>
</li>

</ul>
