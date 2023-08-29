package org.sunso.sotheme.springcloud.order.base;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/19.
 */

public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T> {
	@Select("select last_insert_id()")
    Long getLastInsertId();

	BaseEntity findById(Integer entityId);
	
	@Select("select AUTO_INCREMENT,TABLE_NAME from information_schema.TABLES where  TABLE_SCHEMA=(select database())")
	List<Map> listTable();

	@Select("select  AUTO_INCREMENT,TABLE_NAME  from information_schema.COLUMNS where TABLE_SCHEMA = (select database()) and TABLE_NAME=#{tableName}")
	List<Map> listTableColumn(@Param("tableName")String tableName);

	@Select("select COALESCE(AUTO_INCREMENT,0) AS AUTO_INCREMENT from information_schema.TABLES where TABLE_NAME=#{tableName} and TABLE_SCHEMA=(select database())")
	Integer queryAutoIncrement(@Param("tableName")String tableName);
}
