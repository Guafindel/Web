<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- 스타일 시작 -->

	<style>
* {
	margin: 0;
	padding: 0;
}

body {
	font-family: 'Nanum Gothic', sans-serif;
	background-color: #f1f2f6;
}

/*초기화 끝*/

/*메인 블럭*/
#main_wrap {
	width: 928px;
	padding: 10px;
	background-color: #ffffff;
	border: 1px solid #ddd;
	border-radius: 5px;
	box-shadow: 0 3px 3px #DDDDDD;
	margin: 40px auto;
}

/*메인 블럭 끝*/

/*헤더*/
#header {
	padding: 20px;
}

#header>h1 {
	font-family: 'sunflower';
	margin-bottom: 5px;
}

#header>h4 {
	font-weight: normal;
}

/*헤더 끝*/

/*네이게이션*/
#nav {
	height: 35px;
	border-top: 1px solid #DDDDDD;
	border-bottom: 1px solid #DDDDDD;
	overflow: hidden;
}

#nav>div:nth-child(1) {
	float: left;
}

#nav>div:nth-child(2) {
	float: right;
	height: 35px;
	line-height: 35px;
}

#nav>div:nth-child(1)>ul {
	list-style: none;
}

#nav>div:nth-child(1)>ul>li {
	height: 35px;
	line-height: 35px;
	float: left;
	
	padding: 0px 20px;
}

#menu>ul>li>a {
	display: block;
	line-height: 35px;
	text-decoration: none;
	padding: 0 30px;
	color: black;
}

#menu>ul>li:hover {
	background-color: black;
}

#menu>ul>li>a:hover {
	background-color: black;
	color: white;
}

#nav>div:nth-child(2)>input[type=search] {
	height: 22px;
	border-radius: 5px 0px 0px 5px;
	border: 1px solid #dddddd;
	vertical-align: middle;
	padding: 0 10px;
}

#nav>div:nth-child(2)>input[type=button] {
	height: 22px;
	margin-left: -5px;
	border-radius: 0px 5px 5px 0px;
	border: 1px solid #dddddd;
	vertical-align: middle;
	padding: 0 10px;
}

#contents {
	overflow: scroll;
	padding: 5px;
}

#content {
	float: left;
	width: 650px;
	height: 500px;
	/*            background-color: aqua;*/
}

#aside {
	float: right;
	width: 198px;
	height: 200px;
	/*            background-color: blueviolet;*/
	padding: 0 10px;
}

#aside>ul {
	list-style: none;
	margin-left: 10px;
	margin-top: 5px;
	margin-bottom: 25px;
}

#aside>ul>li {
	height: 30px;
	line-height: 30px;
}

#content>article {
	margin: 25px 0px;
	border-bottom: 1px solid #DDDDDD;
}

.img {
	width: 200px;
	margin-left: 5px;
}

.img2 {
	width: 200px;
	margin-left: 5px;
}

.date {
	display: block;
	padding: 0 5px;
	margin-bottom: 5px;
}

.title {
	padding: 20px 5px;
}

#content>article>p {
	padding: 5px;
	line-height: 160%;
	font-size: 14px;
}

/*footer*/
#footer {
	text-align: center;
}
	</style>	
	<!-- 스타일 끝 -->

