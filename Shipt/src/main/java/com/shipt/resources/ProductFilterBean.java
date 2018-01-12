package com.shipt.resources;

import javax.ws.rs.QueryParam;

public class ProductFilterBean {

	 private @QueryParam("start") String start;
	 private @QueryParam("end") String end;
	 private @QueryParam("reportBy") String reportBy;		
	 
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getReportBy() {
		return reportBy;
	}
	public void setReportBy(String reportBy) {
		this.reportBy = reportBy;
	}

			
	
}
