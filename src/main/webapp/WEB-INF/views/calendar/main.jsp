<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:::WOOTOL:::</title>

<!-- JQuery -->
<script type="text/javascript"  src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- bootstrap -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<!-- add styles -->
<link href="/resources/css/jquery-ui.min.css" rel="stylesheet"
   type="text/css" />
<!-- add scripts -->
<script src="/resources/js/jquery-ui.min.js"></script>



<style type="text/css">
.cal_top{
    text-align: center;
    font-size: 30px;
}
.cal{
    text-align: center;    
}
table.calendar{
    border: 1px solid black;
    display: inline-table;
    text-align: left;
}
table.calendar td{
    vertical-align: top;
    border: 1px solid skyblue;
    width: 100px;
}
.sunday{
	color: red;
}
.saturday{
	color: blue;
}

</style>


</head>
<body>
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
        
        
        for(var i=firstDay.getDay();i<firstDay.getDay()+lastDay.getDate();i++){
        	++dayCount
        	var stringDay = dayCount < 10 ? '0'+dayCount : dayCount;
	        $tdDay.eq(i).html(
	            '<a href="/calendar/view?date='+year+'-'+month+'-'+stringDay+'&trainer_no=${trainer_no}">'+stringDay+'</a>')
        	
			
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
 
//     //calendar 월 이동
//     function movePrevMonth(){
//         month--;
//         if(month<=0){
//             month=12;
//             year--;
//         }
//         if(month<10){
//             month=String("0"+month);
//         }
//         getNewInfo();
//         }
    
//     function moveNextMonth(){
//         month++;
//         if(month>12){
//             month=1;
//             year++;
//         }
//         if(month<10){
//             month=String("0"+month);
//         }
//         getNewInfo();
//     }


    
//     function getNewInfo(){
//         for(var i=0;i<42;i++){
//             $tdDay.eq(i).text("");
//         }
//         dayCount=0;
//         firstDay = new Date(year,month-1,1);
//         lastDay = new Date(year,month,0);
//         drawDays();
//     }
</script>

<div style="display: none;" id="dayText">${listDay }</div>
</body>
</html>