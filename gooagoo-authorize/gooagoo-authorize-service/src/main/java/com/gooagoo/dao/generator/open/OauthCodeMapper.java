package com.gooagoo.dao.generator.open;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.open.OauthCode;
import com.gooagoo.entity.generator.open.OauthCodeExample;
import com.gooagoo.entity.generator.open.OauthCodeKey;

public interface OauthCodeMapper
{

    public Integer countByExample(OauthCodeExample oauthCodeExample);

    public List<OauthCode> selectByExample(OauthCodeExample oauthCodeExample);

    public OauthCode selectByPrimaryKey(OauthCodeKey oauthCodeKey);

    public Integer deleteByExample(OauthCodeExample oauthCodeExample);

    public Integer deleteByPrimaryKey(OauthCodeKey oauthCodeKey);

    public Integer insertSelective(OauthCode oauthCode);

    public Integer updateAllByExample(@Param("record") OauthCode oauthCode, @Param("example") OauthCodeExample oauthCodeExample);

    public Integer updateByExampleSelective(@Param("record") OauthCode oauthCode, @Param("example") OauthCodeExample oauthCodeExample);

    public Integer updateByPrimaryKeySelective(OauthCode oauthCode);

}
