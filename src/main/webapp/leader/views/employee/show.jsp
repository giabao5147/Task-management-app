<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<html>
<head>
    <title>Leader dashboard</title>
    <jsp:include page="../../header.jsp"/>
</head>
<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">
    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <jsp:include page="../../sidebar.jsp"/>
        <!-- End of Sidebar -->
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <jsp:include page="../../topbar.jsp"/>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-12">
                            <h1 class="h3 mb-2 text-gray-800 d-inline-block">Thông tin cá nhân</h1>
                            <a class="btn btn-sm btn-primary ml-auto d-inline-block float-right" href="${context}/employees/edit?id=${nguoiDung.getId()}">Cập nhật thông tin</a>
                        </div>
                    </div>
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
                                    <div class="row">
                                        <div class="col-sm-12">

                                            <table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
                                                <tr class="text-primary">
                                                    <th>ID</th>
                                                    <th>Họ tên</th>
                                                    <th>Phân Quyền</th>
                                                    <th>Số điện thoại</th>
                                                    <th>Email</th>
                                                    <th>Địa chỉ</th>
                                                </tr>
                                                <tr>
                                                    <td>${nguoiDung.getId()}</td>
                                                    <td>${nguoiDung.getHoTen()}</td>
                                                    <td>${nguoiDung.getPhanQuyen().getTenPhanQuyen()}</td>
                                                    <td>${nguoiDung.getSoDienThoai()}</td>
                                                    <td>${nguoiDung.getEmail()}</td>
                                                    <td>${nguoiDung.getDiaChi()}</td>
                                                </tr>
                                            </table>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
            <!-- Footer -->
            <jsp:include page="../../footer.jsp"/>
</body>
</html>