package com.geogym.schedule.dto;

import java.time.LocalTime;

public class PeriodTime {
	
	private LocalTime from;
	private LocalTime to;
	@Override
	public String toString() {
		return "PeriodTime [from=" + from + ", to=" + to + "]";
	}
	public LocalTime getTo() {
		return to;
	}
	public LocalTime getFrom() {
		return from;
	}
	public void setFrom(LocalTime from) {
		if (to == null || from.isBefore(to) || from.equals(to))
			this.from = from;
		else {
			this.from = this.to;
			this.to = from;
		}
	}
	public void setTo(LocalTime to) {
		if (from == null || from.isBefore(to) || from.equals(to))
			this.to = to;
		else {
			this.to = this.from;
			this.from = to;
		}
	}
}
