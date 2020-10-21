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
                    <h2 class="align-center">강사 채용공고 목록</h2>
                    <div class="table-wrapper">
                        <table>
                            <thead>
                                <tr>
                                    <th>공고번호</th>
                                    <th>모집분야</th>
                                    <th>공고명</th>
                                    <th>공고일</th>
                                    <th>마감일</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items = "${list}" var = "t" >
                            		<tr>
                            			<td align = "center">${t.tnoticeNo}</td>
                            			<td>${t.proField}</td>
                            			<td><a href = "/tnotice/Detail?tnoticeNo=${t.tnoticeNo}">${t.tnoticeName}</a></td>
                            			<td><fmt:formatDate value="${t.tnoticeDate}" pattern="yyyy-MM-dd"/> </td>
                            			<td><fmt:formatDate value = "${t.tnoticeDeadline}" pattern = "yyyy-MM-dd"/></td>
                            		</tr>
                            	</c:forEach>
                                
                            </tbody>
                            <tfoot>
                                <tr>
                                    <td colspan="5" align = "center">
                                       <%@include file = "../include/v-includePage.jsp" %>
                                    </td>
                                </tr>
                                <tr align = "right">
                                    <td colspan="5">
                                        <input value="뒤로" onclick="javascript: history.back();" class="button alt"
                                    type="button">
                                       <a href="Regist" class="button">공고작성</a>
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