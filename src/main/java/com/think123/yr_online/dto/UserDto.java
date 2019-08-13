package com.think123.yr_online.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto  extends PageParam {
	
	private String u_id;
	private String u_pwd;
	private String u_name;
	private String u_status;
	


}
