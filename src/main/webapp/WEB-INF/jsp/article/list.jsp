<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
										<h3 class="h4" style="color: #000;">Articles</h3>
									</div>
									<div class="card-body">
										<table class="table">
											<thead>
												<tr>
													<th>#</th>
													<th>Title</th>
													<th>Category</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:choose>
													<c:when test="${articles.size() > 0}">
														<c:forEach items="${articles}" var="article"
															varStatus="loop">
															<tr>
																<th scope="row"><c:out value="${loop.index + 1}" /></th>
																<td>${article.title}</td>
																<td>${article.category}</td>
																<td><a
																	href='<c:url value="/article/view/${article.id}" />'><i
																		class="fa fa-eye"></i></a></td>
															</tr>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<tr>
															<td colspan="4">No Result Found</td>
														</tr>
													</c:otherwise>
												</c:choose>
											</tbody>
										</table>
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