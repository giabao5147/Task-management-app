<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<html>
<head>
    <title>Member dashboard</title>
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
                            <h1 class="h3 mb-2 text-gray-800 d-inline-block">Danh sách công việc</h1>
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
                                                    <th>ID dự án</th>
                                                    <th>Tên dự án</th>
                                                    <th>Leader</th>
                                                    <th>Nhân viên</th>
                                                    <th>Công việc</th>
                                                    <th>Tiến độ</th>
                                                    <th class="text-center">Thao tác</th>
                                                </tr>
                                                <c:forEach var = "thongTinDuAn" items="${thongTinDuAnNhanVien}" >
                                                    <tr>
                                                        <td>${thongTinDuAn.getDuAn().getId()}</td>
                                                        <td>${thongTinDuAn.getDuAn().getTenDuAn()}</td>
                                                        <td>${thongTinDuAn.getDuAn().getLeader().getHoTen()}</td>
                                                        <td>${thongTinDuAn.getNguoiDung().getHoTen()}</td>
                                                        <td>${thongTinDuAn.getCongViec()}</td>
                                                        <td>${thongTinDuAn.getTienDo()}%</td>
                                                        <td class="text-center">
                                                            <a class="btn btn-sm btn-info" href="${context}/tasks/edit?idDuAn=${thongTinDuAn.getDuAn().getId()}&idNhanVien=${thongTinDuAn.getNguoiDung().getId()}">Cập nhật</a>
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
