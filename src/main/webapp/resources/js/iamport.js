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
		    	window.location.href = '/payment/complete/' + rsp.imp_uid;
		    } else {
		        var url = '/payment/fail';
		        var form = $('<form action="' + url + '" method="post">' +
		          '<input type="text" name="msg" value="' + rsp.error_msg + '" />' +
		          '</form>');
		        $('body').append(form);
		        form.submit();
		    }
		});
		
	});
	
});
