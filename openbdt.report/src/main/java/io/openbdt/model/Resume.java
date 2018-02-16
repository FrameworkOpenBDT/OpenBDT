package io.openbdt.model;

public final class Resume {

	private Integer pending;

	private Integer error;

	private Integer success;

	private Integer ignored;

	/**
	 * @return the pending
	 */
	public Integer getPending() {
		return pending;
	}

	/**
	 * @return the error
	 */
	public Integer getError() {
		return error;
	}

	/**
	 * @return the success
	 */
	public Integer getSuccess() {
		return success;
	}

	/**
	 * @return the ignored
	 */
	public Integer getIgnored() {
		return ignored;
	}

	public Resume() {
	}

	public Resume(Integer pending, Integer error, Integer success, Integer ignored) {
		this.pending = pending;
		this.error = error;
		this.success = success;
		this.ignored = ignored;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Resume [pending=" + pending + ", error=" + error + ", success=" + success + ", ignored=" + ignored
				+ "]";
	}
}
