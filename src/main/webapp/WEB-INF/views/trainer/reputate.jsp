<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>reputate</h1>

<form action="/trainer/reputate" method="post">
<input type="hidden" name="trainer_no" id="trainer_no" required="required" value="${trainer.trainer_no }" /><br>
<label>트레이너에게 줄 점수를 입력하세요 :</label> <input type="number" name="trainer_reputation_score" id="trainer_reputation_score" required="required" /><br>
<label>이 점수를 주는 이유</label><br> <textarea rows="10" cols="30" name="trainer_reputation_msg" id="trainer_reputation_msg" required="required" ></textarea><br>
<button>확인</button>
</form>

<form action="/trainer/reputation" method="get">
<input type="hidden" name="trainer_no" value="${trainer.trainer_no }">
<button>평점 조회</button>
</form>
</body>
</html>