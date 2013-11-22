package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.NoticeInfoGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.NoticeInfo;
import com.gooagoo.entity.generator.marketing.NoticeInfoExample;
import com.gooagoo.entity.generator.marketing.NoticeInfoKey;
import com.gooagoo.dao.generator.marketing.NoticeInfoMapper;

@Service
public class NoticeInfoGeneratorCoreServiceImpl implements NoticeInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(NoticeInfoExample noticeInfoExample) 
    {
        return this.noticeInfoMapper.deleteByExample(noticeInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        NoticeInfoKey noticeInfoKey = new NoticeInfoKey();
        noticeInfoKey.setNoticeInfoId(primaryKey);
        return this.noticeInfoMapper.deleteByPrimaryKey(noticeInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(NoticeInfoExample noticeInfoExample) 
    {
        NoticeInfo noticeInfo = new NoticeInfo();
        noticeInfo.setIsDel("Y");
        return this.noticeInfoMapper.updateByExampleSelective(noticeInfo,noticeInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        NoticeInfo noticeInfo = new NoticeInfo();
        noticeInfo.setNoticeInfoId(primaryKey);
        noticeInfo.setIsDel("Y");
        return this.noticeInfoMapper.updateByPrimaryKeySelective(noticeInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(NoticeInfo noticeInfo) 
    {
        return this.noticeInfoMapper.insertSelective(noticeInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(NoticeInfo noticeInfo,NoticeInfoExample noticeInfoExample) 
    {
        return this.noticeInfoMapper.updateByExampleSelective(noticeInfo,noticeInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(NoticeInfo noticeInfo) 
    {
        return this.noticeInfoMapper.updateByPrimaryKeySelective(noticeInfo) > 0 ? true : false;
    }

}
