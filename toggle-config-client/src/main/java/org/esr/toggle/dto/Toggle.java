package org.esr.toggle.dto;

public final class Toggle {

	private final String toggleId;
	private final Boolean toggleEnabled;
	
	public Toggle() {
		toggleId="";
		toggleEnabled = false;
	}

	public Toggle(String toggleId, Boolean toggleEnabled) {
		super();
		this.toggleId = toggleId;
		this.toggleEnabled = toggleEnabled;
	}

	public String getToggleId() {
		return toggleId;
	}

	public Boolean getToggleEnabled() {
		return toggleEnabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((toggleEnabled == null) ? 0 : toggleEnabled.hashCode());
		result = prime * result + ((toggleId == null) ? 0 : toggleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toggle other = (Toggle) obj;
		if (toggleEnabled == null) {
			if (other.toggleEnabled != null)
				return false;
		} else if (!toggleEnabled.equals(other.toggleEnabled))
			return false;
		if (toggleId == null) {
			if (other.toggleId != null)
				return false;
		} else if (!toggleId.equals(other.toggleId))
			return false;
		return true;
	}

}
