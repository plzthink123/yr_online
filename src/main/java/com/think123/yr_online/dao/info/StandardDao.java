package com.think123.yr_online.dao.info;

import com.think123.yr_online.dataobject.Standard;
import com.think123.yr_online.dto.StandardDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//@Mapper
public interface StandardDao {
	//@Select("select * from info_color")
	List<Standard> findStandardList(StandardDto dto);

	@Select("select max(standard_id) from info_standard")
	Integer findMaxId();

	@Insert("insert into info_standard values(#{standard_id},#{standard_name},#{standard_remark},'00')")
	void insert(StandardDto dto);

	@Update("update info_standard set standard_name=#{standard_name} , standard_remark=#{standard_remark} ,standard_status=#{standard_status} where standard_id=#{standard_id}")
	void update(StandardDto dto);

	void delete(Integer[] ids);

}
