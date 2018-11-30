package com.zbiti.iepe.framework.smo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zbiti.iepe.framework.dao.HostDao;
import com.zbiti.iepe.framework.model.BaseCompany;
import com.zbiti.iepe.framework.model.BaseHost;

@Service
public class HostSmoImpl implements HostSmo{
	@Resource
	private HostDao dao;

	@Override
	public List<BaseHost> findOne2Many() {
		// TODO Auto-generated method stub
		List<BaseHost> blist=dao.findOne2Many();
		return blist;
	}

	@Override
	public void save(BaseCompany bc) {
		// TODO Auto-generated method stub
		dao.save(bc);
		
	}

}
