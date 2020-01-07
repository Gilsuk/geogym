<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>reputate 00</h1>

<form action="/trainer/reputate" method="post">
<label>tno :</label> <input type="number" name="trainer_no" id="trainer_no" required="required" /><br>
<label>setTrainer_reputation_score :</label> <input type="number" name="trainer_reputation_score" id="trainer_reputation_score" required="required" /><br>
<label>setTrainer_reputation_msg :</label> <input type="text" name="trainer_reputation_msg" id="trainer_reputation_msg" required="required" /><br>
<button>확인</button>
</form>

<form action="/trainer/reputation" method="get">
<label>setTrainer_no <input type="number" name="trainer_no"></label>
<button>평점 조회</button>
</form>
</body>
</html>