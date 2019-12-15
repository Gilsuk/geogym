package com.geogym.schedule.dto;

import java.time.LocalDate;

public class PeriodDate {
	
	private LocalDate from;
	private LocalDate to;
	@Override
	public String toString() {
		return "PeriodDate [from=" + from + ", to=" + to + "]";
	}
	public LocalDate getTo() {
		return to;
	}
	public LocalDate getFrom() {
		return from;
	}
	public void setFrom(LocalDate from) {
		if (to == null || from.isBefore(to) || from.isEqual(to))
			this.from = from;
		else {
			this.from = this.to;
			this.to = from;
		}
	}
	public void setTo(LocalDate to) {
		if (from == null || from.isBefore(to) || from.isEqual(to))
			this.to = to;
		else {
			this.to = this.from;
			this.from = to;
		}
	}
}
