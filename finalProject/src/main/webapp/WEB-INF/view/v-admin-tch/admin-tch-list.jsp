<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file = "../include/v-include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thePalace</title>

<head>
    <title>the Palace</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="/static/assets/css/main.css" />
</head>

<body class="subpage">

    <!-- Header -->
    <header id="header">
    	<%@include file="../include/v-header.jsp" %>
    </header>

    <!-- Nav -->
    <nav id="menu">
    	<%@include file="../include/v-nav.jsp" %>
    </nav>

    <!-- Table -->
    <section id="one" class="wrapper style2">
        <div class="inner">
            <div class="box">
                <div class="content">
                    <h2 class="align-center">강사 목록</h2>
                    <div class="table-wrapper">
                        <table>
                            <thead>
                                <tr>
                                    <th>강사번호</th>
                                    <th>이름</th>
                                    <th>아이디</th>
                                    <th>이메일</th>
                                    <th>연락처</th>
                                    <th>분야</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items = "${list}" var = "t" >
                            		<tr>
                            			<td align = "center">${t.teacherNo}</td>
                            			<td><a href = "/tch/view?tchNo=${t.teacherNo}">${t.teacherName}</a></td>
                            			<td>${t.teacherId}</td>
                            			<td>${t.teacherEmail}</td>
                            			<td>${t.teacherPh}</td>
                            			<td>${t.teacherType}</td>
                            		</tr>
                            	</c:forEach>
                            </tbody>
                            <tfoot>
                                <tr align = "center">
                                    <td colspan="6">
                                        <a><%@include file = "../include/v-includePage.jsp" %></a>
                                    </td>
                                </tr>
                                <tr align = "right">
                                    <td colspan="6" align = "right">
                                        <a href="/admin/view" class="button alt">관리자메인</a>
                                        <a href="/tch/regist" class="button">강사등록</a>
                                    </td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Footer -->
    <footer id="footer" class="wrapper">
    	<%@include file = "../include/v-footer.jsp" %>
    </footer>
    <!-- Scripts -->
 			<script src="/static/assets/js/jquery.min.js"></script>
			<script src="/static/assets/js/jquery.scrolly.min.js"></script>
			<script src="/static/assets/js/jquery.scrollex.min.js"></script>
			<script src="/static/assets/js/skel.min.js"></script>
			<script src="/static/assets/js/util.js"></script>
			<script src="/static/assets/js/main.js"></script>

	</body>
	<script src=@{http://code.jquery.com/jquery.min.js}></script>
<script>
    $(function () {
        includeLayout();
    });

    function includeLayout() {
        var includeArea = $('[data-include]');
        var self, url;
        $.each(includeArea, function () {
            self = $(this);
            url = self.data("include");
            self.load(url, function () {
                self.removeAttr("data-include");
            });
        });
    }
</script>
</html>