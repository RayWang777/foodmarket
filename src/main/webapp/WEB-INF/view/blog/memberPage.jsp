<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="../layout/navbar.jsp" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

button.btn{
float:right;
}
div.container{
		margin:10px auto;
		text-align:center;
}
</style>
</head>
<body>

<div class="container">
	<div class="titleline">
		<h3>您收藏的食譜</h3>
	</div>
	<div class="row justify-content-center" style="background-color:antiquewhite;">
  		<div class="col-9">
			<div class="row row-cols-1 row-cols-md-3 g-4">
  			<c:forEach var="recipe" items="${page.content}">
  				<div class="col">
    				<div class="card h-100" style="margin:10px 0px;" id="${recipe.recipePostId}">
      				<a href="${contextRoot}/recipe/showRecipe?recipePostId=${recipe.recipePostId}"><img src="${recipe.postImage}" class="card-img-top" alt="recipeImg"  height="175px"></a>
        			<div class="card-body">
        				<h5 class="card-title"><a href="${contextRoot}/recipe/showRecipe?recipePostId=${recipe.recipePostId}"><c:out value="${recipe.postTitle}" /></a></h5>
        					<p class="card-text"><c:out value="${recipe.postTag}" /></p>
        					<p class="card-text">分類:<c:out value="${recipe.recipeType}" /></p>
        					<p>⌚  ${recipe.cookTime} 
        						<a id="likebutton" href="${contextRoot}/recipe/addLikeTimeView/${recipe.recipePostId}#${recipe.recipePostId}" ><button id="likebutton" class="btn btn-info" disabled="disabled">♥  ${recipe.postLikeTime}</button></a>
       							<a id="likebutton" href="" ><button id="cancelbutton" class="btn btn-danger" style="display:none">♡  ${recipe.postLikeTime}</button></a>
       						</p>
      					</div>
      				</div>
				</div>
			</c:forEach>
			</div>
		</div>
	</div>
	<br>
	<div class="titleline">
		<h3>您撰寫的食譜</h3>
	</div>
	
</div>
  <br><br><br>

</body>
</html>