package com.inface.wadms.BoardManagement;

import java.util.Date;
import java.sql.Time;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class BoardVO {
	private int company_no;
	private String company_name;
	private int site_no;
	private String site_name;
	private int team_no;
	private String team_name;


	private String user_id;
	private Date attendance_day;
	private String name;
	private String badgenumber;
	private Time startTime;
	private Time endTime;

	private String searchType;
	private String searchText;
	//private Date startDt;
	//private Date endDt;
	private String startDt;
	private String endDt;
	
	private String startTimePhoto;
	private String endTimePhoto;
	private String sn;
	private int photo_type;


}
