package com.balo.haystack.model.prescribed;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
public class Reps {
	@Getter @Setter
	private RepsType type;

	@Getter @Setter
	private int repCount = -1;

	@Getter @Setter
	private int amrapRPE = -1;

	public Reps() {
	}

	public Reps(RepsType type) {
		super();
		if (type != RepsType.AMRAP) {
			throw new RuntimeException("Have to construct a RepsType other than AMRAP with another parameter");
		}

		this.type = type;
	}

	public Reps(RepsType type, int countOrRPE) {
		super();
		this.type = type;
		switch(this.type) {
			case NUM_OF_REPS:
				this.repCount = countOrRPE;
				break;
			case AMRAP:
				break;
			case AMRAP_RPE:
				this.amrapRPE = countOrRPE;
				break;
			default:
				throw new RuntimeException("unknown RestType: " + type.toString());
		}
	}
}
