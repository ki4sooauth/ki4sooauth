package com.gooagoo.igms.common.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.system.SystemBusinessCoreService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.igms.common.service.CommonService;

@Service(value = "commonService")
public class CommonServiceImpl implements CommonService {
	@Autowired
	private SystemBusinessCoreService systemBusinessCoreService;

	@Override
	public TransData<String> getUUID(HttpServletRequest request) throws Exception {
		String uuid = StringUtils.getUUID();
		return new TransData<String>(true, null, uuid);
	}

	@Override
	public TransData<Date> getDBTime(HttpServletRequest request) throws Exception {

		Date coreSysCurrentTime = systemBusinessCoreService.getCoreSysCurrentTime();
		return GMSUtil.toTransData(true, null, coreSysCurrentTime);
	}

}
