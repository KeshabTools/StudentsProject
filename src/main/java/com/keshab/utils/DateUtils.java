package com.keshab.utils;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class DateUtils {

	public boolean isDateWithinRange(LocalDate date, LocalDate start, LocalDate end) {
		return !date.isBefore(start) && !date.isAfter(end);
	}

}
