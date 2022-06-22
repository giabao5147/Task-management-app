<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                            <h1 class="h3 mb-2 text-gray-800 d-inline-block">Thêm người dùng</h1>
                        </div>
                    </div>
                    <div class="card shadow mb-4">
                        <div class="card-body">

                            <form action="${context}/employees/create" method="post">
                                <input type="hidden" name="id" value="${nguoiDung.getId()}">
                                <div class="row">
                                    <div class="form-group col-sm-6">
                                        <label>Họ tên</label>
                                        <input type="text" class="form-control" name="hoTen">
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label>Số điện thoại</label>
                                        <input type="text" class="form-control" name="soDienThoai">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-6">
                                        <label>Email</label>
                                        <input type="text" class="form-control" name="email">
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label>Mật khẩu</label>
                                        <input type="password" class="form-control" name="matKhau">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-6">
                                        <label>Phân Quyền</label>
                                        <select name="phanQuyen" class="form-control">
                                            <c:forEach var="phanQuyen" items="${danhSachPhanQuyen}">
                                                <option value="${phanQuyen.getId()}">${phanQuyen.getTenPhanQuyen()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label>Địa chỉ</label>
                                        <input type="text" class="form-control" name="diaChi">
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
