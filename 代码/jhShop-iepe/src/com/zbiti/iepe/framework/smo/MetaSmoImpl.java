package com.zbiti.iepe.framework.smo;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zbiti.iepe.framework.dao.MetaDao;

@Service
public class MetaSmoImpl implements MetaSmo {
	@Resource
	private MetaDao dao;

	public List<Map<String, Object>> getMetaData() {
		return dao.getMetaData();
	}
}
