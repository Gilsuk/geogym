package com.geogym.www;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogym.memo.service.CalendarMemoService;
import com.geogym.schedule.dto.PeriodDate;

import com.geogym.trainer.dto.Trainer;
import com.geogym.trainer.service.TrainerService;

@Controller
public class ScheduleController {
	
	@Autowired CalendarMemoService calendarMemoService;
	@Autowired TrainerService trainerService;
	
	//-----------user스케줄------------
	@RequestMapping(value = "/schedule/main", method = RequestMethod.GET)
	public void schedulemain() {
		
	}
	
	
	
	@RequestMapping(value="/schedule/user_scheduleview")
	public void user_scheduleview(Trainer trainer,PeriodDate periodDate,Map<LocalDate,String> map,Model model) {
		
		//트레이너 리스트 받아오기
		List<Trainer> trainerlist=trainerService.viewTrainerList();
		
		model.addAttribute("trainerlist",trainerlist);
		
		
		
	}
	
	
	@RequestMapping(value="/schedule/user_trainerview")
	public void user_trainerscheduleview(Map<LocalDate,String> map, Model model,Trainer trainer, PeriodDate periodDate) {
		
		//트레이너 리스트에서 선택한 트레이너 스케줄 상세정보 보기
		map=trainerService.getMapScheduleDateTraner(trainer, periodDate);
		model.addAttribute("map", map);

		
	}
	
	//--------트레이너 스케줄-------------
	
	
	
	
}
