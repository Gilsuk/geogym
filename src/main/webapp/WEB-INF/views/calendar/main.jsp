<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<div class="container">
<div class="row">
<div class="col-12">
<br>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" href="/mypage/main">마이 페이지</a>
  </li>
  <c:if test="${isTrainer }">
	  <li class="nav-item">
	    <a class="nav-link" href="/trainer/page">트레이너 페이지</a>
	  </li>
  </c:if>
  <c:if test="${isManager }">
	  <li class="nav-item">
	    <a class="nav-link" href="#">관리자</a>
	  </li>
  </c:if>
</ul>

<br>

</div>
<div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
<div class="list-group">

	<a class="list-group-item list-group-item-action" href="/mypage/main">내 정보</a>
	
	<c:choose>
		<c:when test="${pageName eq 'PT'}">
			<a class="list-group-item list-group-item-action active" href="/calendar/PT/schedule">내 PT 일정 보기</a>
			<a class="list-group-item list-group-item-action" href="/calendar/memolist?user_no=${user.user_no }">트레이너 메모 보기</a>
		</c:when>
		<c:when test="${pageName eq 'memo'}">
			<a class="list-group-item list-group-item-action" href="/calendar/PT/schedule">내 PT 일정 보기</a>
			<a class="list-group-item list-group-item-action active" href="/calendar/memolist?user_no=${user.user_no }">트레이너 메모 보기</a>
		</c:when>
		<c:otherwise>
			<a class="list-group-item list-group-item-action" href="/calendar/PT/schedule">내 PT 일정 보기</a>
			<a class="list-group-item list-group-item-action active" href="/calendar/memolist?user_no=${user.user_no }">트레이너 메모 보기</a>
		</c:otherwise>
	</c:choose>
	
	<c:if test="${isTrainer }">
		<a class="list-group-item list-group-item-action" href="/info/bodyinfo">바디 인포</a>
	</c:if>
	<c:if test="${isTrainer ne true}">
		<a class="list-group-item list-group-item-action" href="/info/bodyinfo_user">바디 인포</a>
	</c:if>
	
	<a class="list-group-item list-group-item-action" href="/mypage/messagelist">메세지 확인</a>

</div>
</div>

<div class="col-sm-12 col-md-12 col-lg-9 col-xl-9">

   <div class="cal_top">
        <a href="${prevMonth }" id="movePrevMonth"><span id="prevMonth" class="cal_tit">&lt;</span></a>
        <span id="cal_top_year"></span>
        <span id="cal_top_month"></span>
        <a href="${nextMonth }" id="moveNextMonth"><span id="nextMonth" class="cal_tit">&gt;</span></a>
    </div>
    
    <div id="cal_tab" class="cal">
    </div>
 
<script type="text/javascript">
    
    var today = null;
    var year = null;
    var month = null;
    var firstDay = null;
    var lastDay = null;
    var $tdDay = null;
    var $tdSche = null;
    var list;
 	var Working_Hours = "영업시간:";
    $(document).ready(function() {
    	list = JSON.parse($("#dayText").text());
    	
        drawCalendar();
        initDate();
        drawDays();
    });
    
    //calendar 그리기
    function drawCalendar(){
        var setTableHTML = "";
        setTableHTML+='<table class="calendar">';
        setTableHTML+='<tr><th>SUN</th><th>MON</th><th>TUE</th><th>WED</th><th>THU</th><th>FRI</th><th>SAT</th></tr>';
        for(var i=0;i<6;i++){
            setTableHTML+='<tr height="100">';
            for(var j=0;j<7;j++){
                setTableHTML+='<td style="text-overflow:ellipsis;overflow:hidden;white-space:nowrap">';
                setTableHTML+='    <div class="cal-day"></div>';
                setTableHTML+='    <div class="cal-schedule"></div>';
                setTableHTML+='</td>';
            }
            setTableHTML+='</tr>';
        }
        setTableHTML+='</table>';
        $("#cal_tab").html(setTableHTML);
    }
 
    //날짜 초기화
    function initDate(){
        $tdDay = $("td div.cal-day")
        $tdSche = $("td div.cal-schedule")
        dayCount = 0;
        var curDate = '${curMonth}';
        today = new Date(curDate);
        year = today.getFullYear();
        month = today.getMonth()+1;
        firstDay = new Date(year,month-1,1);
        lastDay = new Date(year,month,0);
    }
    
    //calendar 날짜표시
    function drawDays(){
    	
    	// 색 지우기
    	$tdDay.css("color", "");
    	
        $("#cal_top_year").text(year);
        $("#cal_top_month").text(month);
        
        var stringMonth = month < 10 ? '0'+month : month;
        
        for(var i=firstDay.getDay();i<firstDay.getDay()+lastDay.getDate();i++){
        	++dayCount
        	var stringDay = dayCount < 10 ? '0'+dayCount : dayCount;
	        $tdDay.eq(i).html(
	            '<a href="${viewLink}&date='+year+'-'+stringMonth+'-'+stringDay+'">'+stringDay+'</a>')
        	
			
            //====================================================================================
            for(var j=0;j<list.length;j++){
			    // 날짜가 같은 경우
		        if (dayCount == list[j].date.day) {
		            // 휴일인 경우
		            if (list[j].isHoliday) {
		            	
		            	
			            if (month == list[j].date.month) {
			            	// 휴일 색 칠하기
						    $tdDay.eq(i).children('a').css("color","red");
		            		// div 태그로 휴일이름 적기
					        $tdDay.eq(i).append($("<div class='dayname'>" + list[j].name + "</div>"));
						    $tdDay.eq(i).children('.dayname').css("color","red");
		            	}

	            	}
	       			$tdDay.eq(i).append($("<div>" + list[j].content + "</div>"));
	            }
	            
    		}
            //=========================================================================================

        }
        for(var i=0;i<42;i+=7){
            $tdDay.eq(i).children('a').addClass("sunday");
            
        }
        for(var i=6;i<42;i+=7){
            $tdDay.eq(i).children('a').addClass("saturday");
        }
        

    }
</script>

<div style="display: none;" id="dayText">${listDay }</div>

</div>

</div>
</div>
<br>

<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>