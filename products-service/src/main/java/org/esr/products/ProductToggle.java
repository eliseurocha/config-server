package org.esr.products;

import org.esr.toggle.ApplicationToggle;

public enum ProductToggle implements ApplicationToggle {

	APPLY_TAXES;

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return name();
	}

}
