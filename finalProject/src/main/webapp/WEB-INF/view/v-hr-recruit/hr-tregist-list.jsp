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
                    <h2 class="align-center">${tnoticeName}&nbsp;강사지원목록</h2>
                    <div class="table-wrapper">
                        <table>
                            <thead>
                                <tr>
                                    <th>접수번호</th>
                                    <th>등록요청서</th>
                                    <th>프로그램개요</th>
                                    <th>강사레벨</th>
                                    <th>자격증</th>
                                    <th>서류심사</th>
                                    <th>최종결과</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items = "${list}" var = "t" >
                            		<tr>
                            			<td align = "center"><a href = "/titv/view?regNo=${t.registerNo}">${t.registerNo}</a></td>
                            			<td><a href = "/tregist/fileDown?file=${t.programRegist}%60${t.registerNo}등록요청서">등록요청서&nbsp;다운</a></td>
                            			<td><a href = "/tregist/fileDown?file=${t.registerContent}%60${t.registerNo}등록요청서">프로그램개요&nbsp;다운</a></td>
                            			<td>${t.teacherLevel} </td>
                            			<td><a href = "/tregist/fileDown?file=${t.teacherLicense}%60${t.registerNo}등록요청서">자격증&nbsp;다운</a></td>
                            			<td>${t.paperResult}</td>
                            			<td>${t.finalResult}</td>
                            		</tr>
                            	</c:forEach>
                                
                            </tbody>
                            <tfoot>
                                <tr>
                                    <td colspan="7" align = "center">
                                       <%@include file = "../include/v-includePage.jsp" %>
                                    </td>
                                </tr>
                                <tr align = "right">
                                    <td colspan="7">
                                        <input value="뒤로" onclick="javascript: history.back();" class="button alt"
                                    type="button">
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