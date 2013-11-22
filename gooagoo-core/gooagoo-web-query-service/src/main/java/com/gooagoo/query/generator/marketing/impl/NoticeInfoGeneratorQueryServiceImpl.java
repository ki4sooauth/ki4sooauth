package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.NoticeInfoGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.NoticeInfo;
import com.gooagoo.entity.generator.marketing.NoticeInfoExample;
import com.gooagoo.entity.generator.marketing.NoticeInfoKey;
import com.gooagoo.dao.generator.marketing.NoticeInfoMapper;

@Service
public class NoticeInfoGeneratorQueryServiceImpl implements NoticeInfoGeneratorQueryService
{

    @Autowired
    private NoticeInfoMapper noticeInfoMapper;

    @Override
    public Integer countByExample(NoticeInfoExample noticeInfoExample) 
    {
        return this.noticeInfoMapper.countByExample(noticeInfoExample);
    }

    @Override
    public List<NoticeInfo> selectByExample(NoticeInfoExample noticeInfoExample) 
    {
        return this.noticeInfoMapper.selectByExample(noticeInfoExample);
    }

    @Override
    public NoticeInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        NoticeInfoKey noticeInfoKey = new NoticeInfoKey();
        noticeInfoKey.setIsDel("N");
        noticeInfoKey.setNoticeInfoId(primaryKey);
        return this.noticeInfoMapper.selectByPrimaryKey(noticeInfoKey);
    }

    @Override
    public NoticeInfo selectByPrimaryKey(String primaryKey) 
    {
        NoticeInfoKey noticeInfoKey = new NoticeInfoKey();
        noticeInfoKey.setNoticeInfoId(primaryKey);
        return this.noticeInfoMapper.selectByPrimaryKey(noticeInfoKey);
    }

}
