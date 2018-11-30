package com.zbiti.iepe.framework.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zbiti.core.dto.Page;

public interface CommonDao {
	public List<Map<String, Object>> queryBySql(@Param("sql") String sql);

	public List<Map<String, Object>> queryBySqllistPage(
			@Param("sql") String sql, @Param("page") Page page);
}
