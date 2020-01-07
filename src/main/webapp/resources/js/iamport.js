var IMP = window.IMP;
IMP.init('imp88680561'); // 가맹점 식별코드로 iamport 초기화

$(document).ready(function() {
	$("#btn-payment").on("click", function() {
		
        if($("#agree").is(":not(:checked)")) {
            return false;
        }
        
		var amount = $("#pay-amount").val();
		var name = $("#pay-name").text();
		var checkedElem = $("input[name='paymethod']:checked");
		var pay_method = checkedElem.attr("id");
		var pg = checkedElem.val();
		var buyer_email = $("#user-email").val();
		var buyer_name = $("#user-name").val();
		var buyer_tel = $("#user-tel").val();
		var domain = $("#site-domain").val();
		IMP.request_pay({
		    pg : pg,
		    pay_method : pay_method,
		    merchant_uid : 'geogym' + new Date().getTime(),
		    name : name,
		    amount : amount,
		    buyer_email : buyer_email,
		    buyer_name : buyer_name,
		    buyer_tel : buyer_tel,
		    m_redirect_url : domain + '/payment/complete'
		}, function(rsp) {
		    if ( rsp.success ) {
		        var msg = '결제가 완료되었습니다.';
		        msg += '고유ID : ' + rsp.imp_uid;
		        msg += '상점 거래ID : ' + rsp.merchant_uid;
		        msg += '결제 금액 : ' + rsp.paid_amount;
		        msg += '카드 승인번호 : ' + rsp.apply_num;
		    } else {
		        var msg = '결제에 실패하였습니다.';
		        msg += '에러내용 : ' + rsp.error_msg;
		    }
		    alert(msg);
		});
		
	});
	
});
