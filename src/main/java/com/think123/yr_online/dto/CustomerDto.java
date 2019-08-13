package com.think123.yr_online.dto;

import lombok.Data;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Data
@ToString
public class CustomerDto extends PageParam{
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomerDto.class);
	
	/*
	 * @Override public String toString() {
	 * 
	 * try { String json = new ObjectMapper().writeValueAsString(this);
	 * LOG.debug(this.getClass().getSimpleName()+"=>"+json); return json; } catch
	 * (JsonProcessingException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * 
	 * return "{cus_id:" + cus_id + ", cus_name:" + cus_name + ", cus_remark:" +
	 * cus_remark + ", cus_status:" + cus_status + ", pageNum:" + getPageNum() +
	 * ", pageSize:" + getPageSize() + "}";
	 * 
	 * }
	 * 
	 * }
	 */
	private Integer cus_id;
	private String cus_name;
	private String cus_remark;
	private String cus_status;
	


}