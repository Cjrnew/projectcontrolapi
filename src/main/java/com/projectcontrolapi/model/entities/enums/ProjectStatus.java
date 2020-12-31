package com.projectcontrolapi.model.entities.enums;

public enum ProjectStatus {
	
	COMPLETE(1),
	ONGOING(2),
	OVERDUE(3);

	private int code;

	private ProjectStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static ProjectStatus valueOf(int code) {
		for (ProjectStatus value : ProjectStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid ProjectStatus code");
	}
}
