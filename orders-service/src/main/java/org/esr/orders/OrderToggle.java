package org.esr.orders;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.esr.toggle.ApplicationToggle;

public enum OrderToggle implements ApplicationToggle {

	APPLY_TAXES;

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return name();
	}

}
