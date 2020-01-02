<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">로그인</h5>
            <form class="form-signin">
              <div class="form-label-group">
                <label for="user_id">ID</label>
                <input type="text" id="user_id" class="form-control" placeholder="ID" required autofocus>
              </div>

              <div class="form-label-group">
                <label for="user_pw">Password</label>
                <input type="password" id="user_pw" class="form-control" placeholder="Password" required>
              </div>

              <div class="custom-control custom-checkbox mb-3">
                <label class="custom-control-label" for="shouldRemember">로그인 유지</label>
                <input type="checkbox" class="custom-control-input" id="shouldRemember">
              </div>

              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">로그인</button>
              <hr class="my-4">
              <button class="btn btn-lg btn-google btn-block text-uppercase" type="submit"><i class="fab fa-google mr-2"></i> Sign in with Google</button>
              <button class="btn btn-lg btn-facebook btn-block text-uppercase" type="submit"><i class="fab fa-facebook-f mr-2"></i> Sign in with Facebook</button>
            </form>
          </div>
        </div>
      </div>
    </div>
<!-- <div class="container"> -->
<!-- <form action="/ajax/user/login" method="post"> -->
<!-- 	<label for="user_id">ID : </label> -->
<!-- 	<input type="text" id="user_id" name="user_id" /><br> -->
<!-- 	<label for="user_pw">PW : </label> -->
<!-- 	<input type="password" id="user_pw" name="user_pw" /><br> -->
<!-- 	<label for="shouldRemember">로그인 유지 : </label> -->
<!-- 	<input type="checkbox" id="shouldRemember" name="shouldRemember" /><br> -->
<!-- 	<input type="submit" /> -->
<!-- </form> -->
<!-- </div> -->
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>