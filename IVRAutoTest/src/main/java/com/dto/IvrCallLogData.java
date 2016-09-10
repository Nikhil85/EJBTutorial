package com.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class IvrCallLogData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;// -1694393997202961202L;

	private String mobilenumber;

	private String kookoosessionid;

	private String logid;

	private Date requesttime;

	private String circle;

	private String servicetype;

	private Map<Integer, String> ivrinteractionhistory;

	private String callstatus;

	private String callduration;

	private String callednumber;

	private String hostname;

	private String processstatus;

	private String growerid;

	private Date sessionendtime;

	private String registrationstatus;

	private String statusdetails;

	private int attempt;

	private boolean iscallback;

	private Date nextscheduledcalltime;

	private String region;

	private String parentlogid;

	private Map<Integer, String> interactionSummary;

	private String campaignId;
	private String schduleId;
	private String batchId;
	private String ringingTime;
	private Date logCreatedTime;

	public Date getLogCreatedTime() {
		return logCreatedTime;
	}

	public void setLogCreatedTime(Date logCreatedTime) {
		this.logCreatedTime = logCreatedTime;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getKookoosessionid() {
		return kookoosessionid;
	}

	public void setKookoosessionid(String kookoosessionid) {
		this.kookoosessionid = kookoosessionid;
	}

	public String getLogid() {
		return logid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	public Date getRequesttime() {
		return requesttime;
	}

	public void setRequesttime(Date requesttime) {
		this.requesttime = requesttime;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getServicetype() {
		return servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public Map<Integer, String> getIvrinteractionhistory() {
		return ivrinteractionhistory;
	}

	public void setIvrinteractionhistory(
			Map<Integer, String> ivrinteractionhistory) {
		this.ivrinteractionhistory = ivrinteractionhistory;
	}

	public String getCallstatus() {
		return callstatus;
	}

	public void setCallstatus(String callstatus) {
		this.callstatus = callstatus;
	}

	public String getCallduration() {
		return callduration;
	}

	public void setCallduration(String callduration) {
		this.callduration = callduration;
	}

	public String getCallednumber() {
		return callednumber;
	}

	public void setCallednumber(String callednumber) {
		this.callednumber = callednumber;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getProcessstatus() {
		return processstatus;
	}

	public void setProcessstatus(String processstatus) {
		this.processstatus = processstatus;
	}

	public String getGrowerid() {
		return growerid;
	}

	public void setGrowerid(String growerid) {
		this.growerid = growerid;
	}

	public Date getSessionendtime() {
		return sessionendtime;
	}

	public void setSessionendtime(Date sessionendtime) {
		this.sessionendtime = sessionendtime;
	}

	public String getRegistrationstatus() {
		return registrationstatus;
	}

	public void setRegistrationstatus(String registrationstatus) {
		this.registrationstatus = registrationstatus;
	}

	public String getStatusdetails() {
		return statusdetails;
	}

	public void setStatusdetails(String statusdetails) {
		this.statusdetails = statusdetails;
	}

	public int getAttempt() {
		return attempt;
	}

	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}

	public boolean isIscallback() {
		return iscallback;
	}

	public void setIscallback(boolean iscallback) {
		this.iscallback = iscallback;
	}

	public Date getNextscheduledcalltime() {
		return nextscheduledcalltime;
	}

	public void setNextscheduledcalltime(Date nextscheduledcalltime) {
		this.nextscheduledcalltime = nextscheduledcalltime;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getParentlogid() {
		return parentlogid;
	}

	public void setParentlogid(String parentlogid) {
		this.parentlogid = parentlogid;
	}

	public Map<Integer, String> getInteractionSummary() {
		return interactionSummary;
	}

	public void setInteractionSummary(Map<Integer, String> interactionSummary) {
		this.interactionSummary = interactionSummary;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	public String getSchduleId() {
		return schduleId;
	}

	public void setSchduleId(String schduleId) {
		this.schduleId = schduleId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getRingingTime() {
		return ringingTime;
	}

	public void setRingingTime(String ringingTime) {
		this.ringingTime = ringingTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "IVRCallLogBO [mobilenumber=" + mobilenumber
				+ ", kookoosessionid=" + kookoosessionid + ", logid=" + logid
				+ ", requesttime=" + requesttime + ", circle=" + circle
				+ ", servicetype=" + servicetype + ", ivrinteractionhistory="
				+ ivrinteractionhistory + ", callstatus=" + callstatus
				+ ", callduration=" + callduration + ", callednumber="
				+ callednumber + ", hostname=" + hostname + ", processstatus="
				+ processstatus + ", growerid=" + growerid
				+ ", sessionendtime=" + sessionendtime
				+ ", registrationstatus=" + registrationstatus
				+ ", statusdetails=" + statusdetails + ", attempt=" + attempt
				+ ", iscallback=" + iscallback + ", nextscheduledcalltime="
				+ nextscheduledcalltime + ", region=" + region
				+ ", parentlogid=" + parentlogid + ", interactionSummary="
				+ interactionSummary + ", campaignId=" + campaignId
				+ ", schduleId=" + schduleId + ", batchId=" + batchId
				+ ", ringingTime=" + ringingTime + ", logCreatedTime="
				+ logCreatedTime + "]";
	}

}
