package com.think123.yr_online.dao.info;

import com.think123.yr_online.dataobject.Customer;
import com.think123.yr_online.dto.CustomerDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//@Mapper
public interface CustomerDao {
    //@Select("select * from info_customer")
    List<Customer> findCustomerList(CustomerDto dto);

    @Select("select max(cus_id) from info_customer")
    int findMaxId();

    @Insert("insert into info_customer values(#{cus_id},#{cus_name},#{cus_remark},'00')")
    void insert(CustomerDto dto);

    @Update("update info_customer set cus_name=#{cus_name} , cus_remark=#{cus_remark} ,cus_status=#{cus_status} where cus_id=#{cus_id}")
    void update(CustomerDto dto);

    void delete(Integer[] ids);

    List<Customer> findAll();
}
