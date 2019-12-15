package com.geogym.schedule.dto;

import java.time.LocalDateTime;

public class PeriodDateTime {
	private LocalDateTime from;
	private LocalDateTime to;
	@Override
	public String toString() {
		return "PeriodDateTime [from=" + from + ", to=" + to + "]";
	}
	public LocalDateTime getTo() {
		return to;
	}
	public LocalDateTime getFrom() {
		return from;
	}
	public void setFrom(LocalDateTime from) {
		if (to == null || from.isBefore(to) || from.isEqual(to))
			this.from = from;
		else {
			this.from = this.to;
			this.to = from;
		}
	}
	public void setTo(LocalDateTime to) {
		if (from == null || from.isBefore(to) || from.isEqual(to))
			this.to = to;
		else {
			this.to = this.from;
			this.from = to;
		}
	}
}
