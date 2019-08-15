package com.think123.yr_online.dataobject;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Module {
	private Integer p_id;
	private String p_name;
	
	private Integer m_id;
	private String m_name;
	private String m_url;
	private boolean m_ismenu;
	private String m_status;
	
	private Integer m_pid;


}