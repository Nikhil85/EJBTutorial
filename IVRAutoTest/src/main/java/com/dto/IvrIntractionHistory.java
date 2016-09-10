package com.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonPOJOBuilder
public class IvrIntractionHistory {

	@JsonProperty
	private String dtmfinput;
	@JsonProperty
	private String Event_start_time;
	@JsonProperty
	private String Event_end_time;
	@JsonProperty
	private String currentState;
	@JsonProperty
	private String event;

	public String getDtmfinput() {
		return dtmfinput;
	}

	public void setDtmfinput(String dtmfinput) {
		this.dtmfinput = dtmfinput;
	}

	public String getEvent_start_time() {
		return Event_start_time;
	}

	public void setEvent_start_time(String event_start_time) {
		Event_start_time = event_start_time;
	}

	public String getEvent_end_time() {
		return Event_end_time;
	}

	public void setEvent_end_time(String event_end_time) {
		Event_end_time = event_end_time;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "IVRHistoryBo [dtmfinput=" + dtmfinput + ",Event_start_time="
				+ Event_start_time + ",Event_end_time=" + Event_end_time
				+ ",currentState=" + currentState + ",event=" + event + "]";
	}

}
