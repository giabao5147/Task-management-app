<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<html>
<head>
    <title>Admin dashboard</title>
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
                            <h1 class="h3 mb-2 text-gray-800 d-inline-block">Cập nhật công việc</h1>
                        </div>
                    </div>
                    <div class="card shadow mb-4">
                        <div class="card-body">

                            <form action="${context}/tasks/update" method="post">
                                <input type="hidden" name="idDuAn" value="${thongTinDuAn.getDuAn().getId()}">
                                <input type="hidden" name="idNhanVien" value="${thongTinDuAn.getNguoiDung().getId()}">
                                <div class="row">
                                    <div class="form-group col-sm-6">
                                        <label>Tên dự án: ${thongTinDuAn.getDuAn().getTenDuAn()}</label>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label>Tên nhân viên: ${thongTinDuAn.getNguoiDung().getHoTen()}</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-6">
                                        <label>Công việc</label>
                                        <input type="text" name="congViec" class="form-control" value="${thongTinDuAn.getCongViec()}">
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label>Tiến độ</label>
                                        <input type="number" name="tienDo" class="form-control" value="${tienDo}">
                                    </div>
                                </div>
                                <div class="container">
                                    <div class="row">
                                        <div class="col text-center">
                                            <input class="btn btn-primary" type="submit">
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




<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%= request.getContextPath()%>/tasks/update" method="post">





    <input type="submit">
</form>
</body>
</html>
