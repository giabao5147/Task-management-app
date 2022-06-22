<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
                            <h1 class="h3 mb-2 text-gray-800 d-inline-block">Danh sách dự án</h1>
                            <a class="btn btn-sm btn-primary ml-auto d-inline-block float-right" href="${context}/projects/new">Tạo dự án mới</a>
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
                                                    <th>Tên dự án</th>
                                                    <th>Leader</th>
                                                    <th>Trạng thái</th>
                                                    <th>Tiến độ</th>
                                                    <th>Ngày bắt đầu</th>
                                                    <th>Ngày kết thúc</th>
                                                    <th class="text-center">Danh sách nhân viên</th>
                                                    <th class="text-center">Thao tác</th>
                                                </tr>
                                                <c:forEach var = "duAn" items="${danhSachDuAn}" >
                                                    <tr>
                                                        <td>${duAn.getId()}</td>
                                                        <td>${duAn.getTenDuAn()}</td>
                                                        <td>${duAn.getLeader().getHoTen()}</td>
                                                        <td>${duAn.getTrangThai()}</td>
                                                        <td>${duAn.getTienDo()}%</td>
                                                        <td>${duAn.getNgayBatDau()}</td>
                                                        <td>${duAn.getNgayKetThuc()}</td>
                                                        <td class="text-center">
                                                            <a class="btn btn-sm btn-info btn-gradient-info" href="${context}/projects/show?id=${duAn.getId()}">Danh sách</a>
                                                        </td>
                                                        <td class="text-center">
                                                            <a class="btn btn-sm btn-info" href="${context}/projects/edit?id=${duAn.getId()}">Cập nhật</a>
                                                            <a class="btn btn-sm btn-danger" href="${context}/projects/destroy?id=${duAn.getId()}"
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