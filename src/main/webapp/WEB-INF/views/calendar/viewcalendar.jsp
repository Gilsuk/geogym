<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
        setTableHTML+='<div class="table-responsive"><table class="calendar table table-bordered">';
        setTableHTML+='<thead class="thead-dark">';
        setTableHTML+='<tr><th scope="col">일</th><th scope="col">월</th><th scope="col">화</th><th scope="col">수</th>';
        setTableHTML+='<th scope="col">목</th><th scope="col">금</th><th scope="col">토</th></tr>';
        setTableHTML+='</thead><tbody>';
        for(var i=0;i<6;i++){
            setTableHTML+='<tr height="100">';
            for(var j=0;j<7;j++){
                setTableHTML+='<td>';
                setTableHTML+='    <div class="cal-day"></div>';
                setTableHTML+='    <div class="cal-schedule"></div>';
                setTableHTML+='</td>';
            }
            setTableHTML+='</tr>';
        }
        setTableHTML+='</table>,</div>';
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
						    $tdDay.eq(i).children('a').css("color","#ff007b");
		            		// div 태그로 휴일이름 적기
					        $tdDay.eq(i).append($("<div class='dayname'>" + list[j].name + "</div>"));
						    $tdDay.eq(i).children('.dayname').css("color","#ff007b");
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

<br>