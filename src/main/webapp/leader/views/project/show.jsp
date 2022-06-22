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
                            <h1 class="h3 mb-2 text-gray-800 d-inline-block">Thông tin dự án</h1>
                            <a class="btn btn-sm btn-primary ml-auto d-inline-block float-right" href="${context}/tasks/new?idDuAn=${duAn.getId()}">Thêm nhân viên</a>
                        </div>
                    </div>
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
                                    <div class="row">
                                        <div class="col-sm-12">

                                            <table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
                                                <tr class="text-primary text-center">
                                                    <th rowspan="2">ID</th>
                                                    <th rowspan="2">Tên dự án</th>
                                                    <th rowspan="2">Leader</th>
                                                    <th colspan="5">Nhân viên</th>
                                                </tr>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Họ tên</th>
                                                    <th>Công việc</th>
                                                    <th>Tiến độ</th>
                                                    <th class="text-center">Thao tác</th>
                                                </tr>
                                                <tr>
                                                    <td rowspan="<c:out value = "${soNhanVien}"/>">${duAn.getId()}</td>
                                                    <td rowspan="<c:out value = "${soNhanVien}"/>">${duAn.getTenDuAn()}</td>
                                                    <td rowspan="<c:out value = "${soNhanVien}"/>">${duAn.getLeader().getHoTen()}</td>
                                                </tr>
                                                <c:forEach var="thongTinDuAn" items="${danhSachThongTinDuAn}">
                                                    <tr>
                                                        <td>${thongTinDuAn.getNguoiDung().getId()}</td>
                                                        <td>${thongTinDuAn.getNguoiDung().getHoTen()} </td>
                                                        <td>${thongTinDuAn.getCongViec()}</td>
                                                        <td>${thongTinDuAn.getTienDo().toString()}%</td>
                                                        <td class="text-center">
                                                            <a class="btn btn-sm btn-info" href="${context}/tasks/edit?idDuAn=${duAn.getId()}&idNhanVien=${thongTinDuAn.getNguoiDung().getId()}">Cập nhật</a>
                                                            <a class="btn btn-sm btn-danger" href="${context}/tasks/destroy?idDuAn=${duAn.getId()}&idNhanVien=${thongTinDuAn.getNguoiDung().getId()}"
                                                               onclick="if (!(confirm('Xác nhận xóa ${duAn.getTenDuAn()}'))) return false">Xóa bỏ</a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
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

