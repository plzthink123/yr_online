package com.think123.yr_online.dao.info;

import com.think123.yr_online.dataobject.Color;
import com.think123.yr_online.dto.ColorDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//@Mapper
public interface ColorDao {
	//@Select("select * from info_color")
	List<Color> findColorList(ColorDto dto);

	@Select("select max(co_id) from info_color")
	Integer findMaxId();

	@Insert("insert into info_color values(#{co_id},#{co_name},#{co_remark},'00')")
	void insert(ColorDto dto);

	@Update("update info_color set co_name=#{co_name} , co_remark=#{co_remark} ,co_status=#{co_status} where co_id=#{co_id}")
	void update(ColorDto dto);

	void delete(Integer[] ids);

    List<Color> findAllColor();
}
