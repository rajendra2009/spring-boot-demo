<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Article</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>'>
<link rel="stylesheet" href='<c:url value="/css/fontastic.css"/>'>
<link rel="stylesheet" href='<c:url value="/css/font-awesome.min.css"/>'>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
<link rel="stylesheet" href='<c:url value="/css/style.green.css"/>'>
<link rel="stylesheet" href='<c:url value="/css/custom.css"/>'>
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
	<div class="page login-page">
		<div class="container d-flex align-items-center">
			<div class="form-holder has-shadow">
				<div class="row">
					<div class="col-lg-12">
						<div class="nav-bar-wrapper">
							<div class="row">
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<ul class="nav nav-pills nav-stacked">
										<li><a href='<c:url value="/"/>'><i
												class="fa fa-home"></i> Home</a></li>
									</ul>
								</div>
								<div class="col-md-2">
									<ul class="nav nav-pills nav-stacked">
										<li><a href='<c:url value="/article/create"/>'><i
												class="fa fa-plus"></i> Add Article</a></li>
									</ul>
								</div>
								<div class="col-md-2">
									<ul class="nav nav-pills nav-stacked">
										<li><a href='<c:url value="/article/list"/>'><i
												class="fa fa-list"></i> All Article</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-12">
						<div class="info d-flex align-items-center">
							<div class="content text-center"
								style="width: 80%; margin: 0 auto;">
								<c:if test="${!empty info}">
									<div class="alert alert-warning alert-white rounded">
										<c:out value="${info}" />
									</div>
								</c:if>
								<c:if test="${!empty success}">
									<div class="alert alert-success alert-white rounded">
										<c:out value="${success}" />
									</div>
								</c:if>
								<c:if test="${!empty error}">
									<div class="alert alert-danger alert-white rounded">
										<c:out value="${error}" />
									</div>
								</c:if>
								<div class="clearfix"></div>
								<div class="card">
									<div class="card-header d-flex align-items-center">
										<h3 class="h4" style="color: #000;">
											Edit Article :
											<c:out value="${article.title}" />
										</h3>
									</div>
									<div class="card-body">
										<c:url var="updateUrl" value="/article/update" />
										<form:form method="post" modelAttribute="article"
											style="margin: 0 auto;" cssClass="col-lg-6"
											action="${updateUrl}" role="form">
											<div class="form-group">
												<label>Title</label>
												<div class="input-group">
													<span class="input-group-addon"><i
														class="fa fa-bars"></i></span>
													<form:input path="title" type="text"
														placeholder="Enter title" cssClass="form-control"
														required="required" />
												</div>
												<form:errors path="title" cssClass="error-msg" />
											</div>
											<div class="form-group">
												<label>Category</label>
												<div class="input-group">
													<span class="input-group-addon"><i
														class="fa fa-book"></i></span>
													<form:input path="category" type="text"
														placeholder="Enter category" cssClass="form-control"
														required="required" />
												</div>
												<form:errors path="category" cssClass="error-msg" />
											</div>
											<form:hidden path="id" />
											<div class="box-footer">
												<button type="submit" class="btn btn-success submitButton">
													<i class="fa fa-pencil"></i> Update
												</button>
											</div>
										</form:form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="copyrights text-center">
			<p>&copy; 2017</p>
		</div>
	</div>
	<!-- Javascript files-->
	<script src='<c:url value="/js/jquery-3.2.1.min.js"/>'></script>
	<script src='<c:url value="/js/popper.js"/>'></script>
	<script src='<c:url value="/js/bootstrap.js"/>'></script>
	<script src='<c:url value="/js/jquery.cookie.js"/>'></script>
	<script src='<c:url value="/js/jquery.validate.min.js"/>'></script>
	<script src='<c:url value="/js/front.js"/>'></script>
	<script src='<c:url value="/js/common.js"/>'></script>
</body>
</html>