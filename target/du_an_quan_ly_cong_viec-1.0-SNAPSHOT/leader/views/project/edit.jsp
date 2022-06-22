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
                            <h1 class="h3 mb-2 text-gray-800 d-inline-block">Cập nhât thông tin dự án</h1>
                        </div>
                    </div>
                    <div class="card shadow mb-4">
                        <div class="card-body">

                            <form action="${context}/projects/update" method="post">
                                <input type="hidden" name="id" value="${duAn.getId()}">
                                <div class="row">
                                    <div class="form-group col-sm-6">
                                        <label>Tên dự án</label>
                                        <input type="text" class="form-control" name="tenDuAn" value="${duAn.getTenDuAn()}">
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label>Leader</label>
                                        <select name="idLeader" class="form-control">
                                            <c:forEach var="leader" items="${danhSachLeader}">
                                                <c:choose>
                                                    <c:when test = "${leader.getId() == duAn.getLeader().getId()}">
                                                        <option value="${leader.getId()}" selected>${leader.getHoTen()}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${leader.getId()}">${leader.getHoTen()}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-6">
                                        <label>Trạng thái</label>
                                        <select name="trangThai" class="form-control">
                                            <option value="In progress">In progress</option>
                                            <option value="Completed">Completed</option>
                                            <option value="Cancelled">Cancelled</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label>Tiến độ</label>
                                        <input type="number" class="form-control" name="tienDo" value="${tienDo}">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-6">
                                        <label>Ngày bắt đầu</label>
                                        <input type="date" class="form-control" name="ngayBatDau" value="${duAn.getNgayBatDau()}">
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label>Ngày kết thúc</label>
                                        <input type="date" class="form-control" name="ngayKetThuc" value="${duAn.getNgayKetThuc()}">
                                    </div>

                                    <div class="container">
                                        <div class="row">
                                            <div class="col text-center">
                                                <input class="btn btn-primary" type="submit">
                                            </div>
                                        </div>
                                    </div>

                                </div>

                            </form>

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