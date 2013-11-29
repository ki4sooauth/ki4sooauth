package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.NoticeInfo;
import com.gooagoo.entity.generator.marketing.NoticeInfoExample;
import com.gooagoo.entity.generator.marketing.NoticeInfoKey;

public interface NoticeInfoMapper
{

    public Integer countByExample(NoticeInfoExample noticeInfoExample);

    public List<NoticeInfo> selectByExample(NoticeInfoExample noticeInfoExample);

    public NoticeInfo selectByPrimaryKey(NoticeInfoKey noticeInfoKey);

    public Integer deleteByExample(NoticeInfoExample noticeInfoExample);

    public Integer deleteByPrimaryKey(NoticeInfoKey noticeInfoKey);

    public Integer insertSelective(NoticeInfo noticeInfo);

    public Integer updateAllByExample(@Param("record") NoticeInfo noticeInfo, @Param("example") NoticeInfoExample noticeInfoExample);

    public Integer updateByExampleSelective(@Param("record") NoticeInfo noticeInfo, @Param("example") NoticeInfoExample noticeInfoExample);

    public Integer updateByPrimaryKeySelective(NoticeInfo noticeInfo);

}
