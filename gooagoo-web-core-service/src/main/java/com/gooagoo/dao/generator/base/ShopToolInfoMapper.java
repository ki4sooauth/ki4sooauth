package com.gooagoo.dao.generator.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.base.ShopToolInfo;
import com.gooagoo.entity.generator.base.ShopToolInfoExample;
import com.gooagoo.entity.generator.base.ShopToolInfoKey;

public interface ShopToolInfoMapper
{

    public Integer countByExample(ShopToolInfoExample shopToolInfoExample);

    public List<ShopToolInfo> selectByExample(ShopToolInfoExample shopToolInfoExample);

    public ShopToolInfo selectByPrimaryKey(ShopToolInfoKey shopToolInfoKey);

    public Integer deleteByExample(ShopToolInfoExample shopToolInfoExample);

    public Integer deleteByPrimaryKey(ShopToolInfoKey shopToolInfoKey);

    public Integer insertSelective(ShopToolInfo shopToolInfo);

    public Integer updateAllByExample(@Param("record") ShopToolInfo shopToolInfo, @Param("example") ShopToolInfoExample shopToolInfoExample);

    public Integer updateByExampleSelective(@Param("record") ShopToolInfo shopToolInfo, @Param("example") ShopToolInfoExample shopToolInfoExample);

    public Integer updateByPrimaryKeySelective(ShopToolInfo shopToolInfo);

}
