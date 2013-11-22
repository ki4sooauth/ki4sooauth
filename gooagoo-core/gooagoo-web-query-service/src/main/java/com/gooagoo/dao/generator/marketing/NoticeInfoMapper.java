package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.NoticeInfo;
import com.gooagoo.entity.generator.marketing.NoticeInfoExample;
import com.gooagoo.entity.generator.marketing.NoticeInfoKey;

public interface NoticeInfoMapper
{

    public Integer countByExample(NoticeInfoExample noticeInfoExample);

    public List<NoticeInfo> selectByExample(NoticeInfoExample noticeInfoExample);

    public NoticeInfo selectByPrimaryKey(NoticeInfoKey noticeInfoKey);

}
