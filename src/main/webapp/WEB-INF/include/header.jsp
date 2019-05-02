<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />

		<!-- Sns -->
		<meta property="og:type" content="website">
		<meta property="og:site_name" content="사이트명">
		<meta property="og:image" content="이미지 url"> <!-- 비율은 2:1 -->
		<meta property="og:title" content="제목">
		<meta property="og:description" content="설명">
		<meta property="og:url" content="페이지 url">

		<title>Messenger</title>

		<!-- Favicon -->
		<link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico" />" type="image/x-icon" />
		<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />" type="image/x-icon" />
		
		<!-- Css -->
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
		<script>window.jQuery || document.write('<link rel="stylesheet" href="/resources/css/jquery-ui.min.css">')</script>
		
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/media.css" />" />
		
		<!-- IE9 이하 버전 css적용 -->
		<!--[if IE]>
		<style>
			select {padding: 0 0 0 5px;}
		</style>
		<![endif]-->
		
		<!-- Js -->
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script>window.jQuery || document.write('<script src="/resources/js/jquery-1.12.0.min.js"><\/script>')</script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
		<script>window.jQuery || document.write('<script src="/resources/js/jquery-ui.min.js"><\/script>')</script>

		<script type="text/javascript" src="<c:url value="/resources/js/ui.js" />"></script>

		<script type="text/javascript" src="<c:url value="/resources/js/common.js" />"></script>
	</head>
	<body>
		<div id="wrapper">
			<!-- shortcut -->
			<div class="shortcut">
				<ul>
					<li><a href="#container">본문 바로가기</a></li>
					<li><a href="#menu">메뉴 바로가기</a></li>
				</ul>
			</div>
			<!-- //shortcut -->

			<!-- header -->
			<header>
				<div class="header_wrap web_header white_header">  <!-- 비주얼이 없는 페이지에 white_header 추가 -->
					<!-- logo -->
					<a href="javascript:void(0)" class="logo mobile_block">GOODFI</a>
					<!-- //logo -->
			
					<!-- mobile gnb -->
					<a href="#none" class="btn_gnb mobile_block" onclick="gnbOpen(this);">메뉴</a>
					<!-- //mobile gnb -->
			
					<!-- gnb wrap-->
					<div class="gnb_wrap">
						<div class="inner fl_wrap">
							<!-- logo -->
							<a href="javascript:void(0)" class="logo mobile_none">GOODFI</a>
							<!-- //logo -->
			
							<!-- gnb -->
							<div class="gnb">
								<ul class="depth1">
									<li><a href="#" class="mobile_none">소개</a></li>
									<li>
										<a href="#none" onclick="menuOpen(this);" class="mobile_block">역경매</a>
										<a href="javascript:void(0)" class="mobile_none">역경매</a>
										<div class="depth2">
											<ul>
												<li><a href="javascript:void(0)">신용대출</a></li>
											</ul>
										</div>
									</li>
									<li>
										<a href="#none" onclick="menuOpen(this);" class="mobile_block">대출상담</a>
										<a href="javascript:void(0)" class="mobile_none">대출상담</a>
										<div class="depth2">
											<ul>
												<li><a href="javascript:void(0)">신용대출</a></li>
												<li><a href="javascript:void(0)">담보대출</a></li>
												<li><a href="javascript:void(0)">건축대출</a></li>
											</ul>
										</div>
									</li>
									<li>
										<a href="#none" onclick="menuOpen(this);" class="mobile_block">투자</a>
										<a href="javascript:void(0)" class="mobile_none">투자</a>
										<div class="depth2">
											<ul>
												<li><a href="javascript:void(0)">P2P</a></li>
												<li><a href="javascript:void(0)">예금</a></li>
												<li><a href="javascript:void(0)">적금</a></li>
											</ul>
										</div>
									</li>
									<li>
										<a href="#none" onclick="menuOpen(this);" class="mobile_block">고객센터</a>
										<a href="javascript:void(0)" class="mobile_none">고객센터</a>
										<div class="depth2">
											<ul>
												<li><a href="javascript:void(0)">공지사항</a></li>
												<li><a href="javascript:void(0)">자주하는 질문</a></li>
											</ul>
										</div>
									</li>
								</ul>
							</div>
							<!-- //gnb -->
			
							<!-- utill -->
							<ul class="utill">
								<li><a href="login.html">로그인</a></li>
								<li><a href="join.html">회원가입</a></li>
							</ul>
							<!-- //utill -->
						</div>
					</div>
					<!-- //gnb wrap-->
			
					<div class="gnb_bg mobile_none"></div>
					<div class="opacity_bg" onclick="gnbClose(this);"></div>
				</div>
			</header>
			<!-- //header -->

			<!-- container -->
			<div id="container">
				<div class="contents sub_contents">
	