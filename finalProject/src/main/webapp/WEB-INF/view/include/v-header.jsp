   <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="logo"><a href="/">the Palace <span>by 팀이름</span></a></div>
	<c:if test ="${session.authInfo}">
	    <a href = "/login">로그인</a>
	    <a href ="sign-up/member-agree">회원가입</a>
    </c:if>
    
    <c:if test="${!session.authInfo}">
	    <a href = "/sign/out">로그아웃</a>
	    <a href = "/admin/view">관리자페이지</a>
	    <a href ="mypage/Mypage">마이페이지</a>
	    <c:if test="${session.authInfo.type eq 'rc'}"><a href = "/rentDoc/mylist">임대희망서보기</a></c:if>	
    </c:if>
    <a href="#menu" class="toggle"><span>메뉴</span></a>



