<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>insert trainer </h1>


<form action="/trainer/update" method="post" enctype="multipart/form-data">
<label>setTrainer_no :</label> <input type="number" name="trainer_no" id="trainer_no" required="required" /><br>
<label>setUser_no :</label> <input type="number" name="user_no" id="user_no" required="required" /><br>
<label>setTrainer_address :</label> <input type="text" name="trainer_address" id="trainer_address" required="required" /><br>
<label>setTrainer_price :</label> <input type="number" name="trainer_price" id="trainer_price" required="required" /><br>
<label>setTrainer_profile :</label> <input type="text" name="trainer_profile" id="trainer_profile" required="required" /><br>
<label>file :</label> <input type="file" name="file" id="file" required="required" /><br>
<button>확인</button>
</form>
</body>
</html>