package com.geogym.www.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogym.payment.exception.CashNotEnoughException;
import com.geogym.pt.dto.Countpt;
import com.geogym.pt.exception.LessThanOneHourException;
import com.geogym.pt.exception.MatchingNotAvailable;
import com.geogym.pt.service.MatchingService;
import com.geogym.schedule.dto.Schedule;
import com.geogym.schedule.exception.AllTimeisUnavailable;
import com.geogym.schedule.exception.NotWorkinDayException;
import com.geogym.trainer.dto.Trainer;
import com.geogym.trainer.dto.Trainer2;
import com.geogym.trainer.service.TrainerService;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class PTController {

	private static final Logger logger = LoggerFactory.getLogger(PTController.class);

	@Autowired
	MatchingService matchingService;
	
	@Autowired TrainerService trainerService;
	@Autowired UserService userService;
	
	@RequestMapping(value = "/test/setpt")
	public void getWorkingTime(
			User user,
			Trainer trainer,
			Schedule schedule
			) {

		schedule.setTrainer(trainer);
		schedule.setSchedule_msg("PT");

		try {
			matchingService.match(user, schedule);
		} catch (MatchingNotAvailable e) {
			// 매칭 실패
		} catch (CashNotEnoughException e) {
			// 캐시 부족
		} catch (AllTimeisUnavailable e) {
			// 빈 시간 없음
		} catch (NotWorkinDayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/test/pt/cancelPT")
	public void cancelPT() {

		Schedule schedule = new Schedule();
		schedule.setSchedule_no(9);

		try {
			matchingService.cancle(schedule, "PT취소");
		} catch (LessThanOneHourException e) {
			// 취소 신청시간 기점 PT시간 까지 1시간 미만 남았을 경우
		}

	}
	
	@RequestMapping(value = "/test/pt/list")
	public void getPTList() {
		
		User user = new User();
		user.setUser_no(10);
		
		LocalDate today = LocalDate.of(2020,01,30);
		
		logger.info(matchingService.getPTInfos(user, today).toString());
	}

	
	
	@RequestMapping(value="/admin/pay", method = RequestMethod.GET )
	public void adminPay() {
		
	}
	
	
	
	//관리자 매출통계
	@RequestMapping(value="/admin/pay", method = RequestMethod.POST )
	public String adminpay(Model model,Trainer trainer,LocalDate month,Countpt countpt,String mon,String year,User user) {
		List<Trainer2> list = trainerService.viewTrainerList();
		List<Countpt> clist= new ArrayList<Countpt>();
		List<User> ulist= new ArrayList<User>();
		
		
		System.out.println("달 스트링"+mon);
		month=LocalDate.parse(year+mon+"-01");
	
		
		System.out.println(list.get(0));
		System.out.println("월:"+month.getMonthValue());
		for(int i=0;i<list.size();i++ ) {
			System.out.println("리스트 사이즈 화긴"+list.size());
			trainer.setTrainer_no(list.get(i).getTrainer_no());
			int num = matchingService.countptpermonth(trainer, month);
			if(num != 0) {
				Countpt c = new Countpt();
				c.setCount_pt(num);
				c.setTrainer_no(list.get(i).getTrainer_no());
				user.setUser_no(c.getTrainer_no());
				try {
					user= userService.getUserByUserno(user);
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.setUser_name(user.getUser_name());
				System.out.println("유저이름"+countpt.getUser_name());
				clist.add(c);
				System.out.println(clist);
			}
			
		}
		model.addAttribute("clist", clist);
		
		return "/payment/list";
	}
	
	
}