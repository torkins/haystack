package com.balo.haystack.model.prescribed;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Embeddable
public class Rest {

	@Getter
	@Setter
	private RestType restType;

	@Getter
	@Setter
	private int minutesOrHeartRate = -1;

	public Rest() {
	}

	public Rest(RestType restType, int minutesOrHeartRate) {
		this.restType = restType;
		this.minutesOrHeartRate = minutesOrHeartRate;
	}

	public Rest(RestType restType) {
		if (restType != RestType.UNSPECIFIED) {
			throw new RuntimeException("For RestTypes other than UNSPECIFIED, minutes or heart rate must be provided");
		}
		this.restType = restType;
	}

	@Override
	public String toString() {
		return "Type: " + restType.toString() + ", minutesOrHeartRate: " + minutesOrHeartRate;
	}
}
