package com.think123.yr_online.dataobject;

public class Module {
	private Integer p_id;
	private String p_name;
	
	private Integer m_id;
	private String m_name;
	private String m_url;
	private boolean m_ismenu;
	private String m_status;
	
	private Integer m_pid;

	public Integer getM_id() {
		return m_id;
	}

	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_url() {
		return m_url;
	}

	public void setM_url(String m_url) {
		this.m_url = m_url;
	}

	public boolean isM_ismenu() {
		return m_ismenu;
	}

	public void setM_ismenu(boolean m_ismenu) {
		this.m_ismenu = m_ismenu;
	}

	public String getM_status() {
		return m_status;
	}

	public void setM_status(String m_status) {
		this.m_status = m_status;
	}

	public Integer getM_pid() {
		return m_pid;
	}

	public void setM_pid(Integer m_pid) {
		this.m_pid = m_pid;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
}