package com.gooagoo.mis.sysmanage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.sys.dictionary.BoutiqueSquareDicCoreService;
import com.gooagoo.api.generator.query.base.QualitySquareGoodsTypeGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.base.QualitySquareGoodsType;
import com.gooagoo.entity.generator.base.QualitySquareGoodsTypeExample;
import com.gooagoo.entity.generator.base.QualitySquareGoodsTypeExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.sysmanage.service.QualityDictionaryService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MQualitySquareGoodsType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service(value = "qualityDictionaryService")
public class QualityDictionaryServiceImpl implements QualityDictionaryService
{
    @Autowired
    private BoutiqueSquareDicCoreService boutiqueSquareDicCoreService;
    @Autowired
    private QualitySquareGoodsTypeGeneratorQueryService qualitySquareGoodsTypeGeneratorQueryService;

    /**
     * 精品广场商品类型字典添加
     */
    @Override
    public TransData<Object> addQualityDic(HttpServletRequest request) throws Exception
    {
        MQualitySquareGoodsType mquality = ServletUtils.objectMethod(MQualitySquareGoodsType.class, request);
        QualitySquareGoodsType quality = new QualitySquareGoodsType();
        EntityTools.copyValue(mquality, quality);
        boolean flag = this.boutiqueSquareDicCoreService.addBoutiqueSquareDic(quality);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_ADD_SUCCESS, MisMessageConst.MIS_SYS_DIC_ADD_FAIL, quality.getGoodsTypeId().toString());
    }

    /**
     * 精品广场商品类型字典编辑
     */
    @Override
    public TransData<Object> editQualityDic(HttpServletRequest request) throws Exception
    {
        MQualitySquareGoodsType mquality = ServletUtils.objectMethod(MQualitySquareGoodsType.class, request);
        QualitySquareGoodsType quality = new QualitySquareGoodsType();
        EntityTools.copyValue(mquality, quality);
        boolean flag = this.boutiqueSquareDicCoreService.updateBoutiqueSquareDic(quality);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_UPD_SUCCESS, MisMessageConst.MIS_SYS_DIC_UPD_FAIL, quality.getGoodsTypeId().toString());
    }

    /**
     * 精品广场商品类型字典删除
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delQualityDic(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");//字典Id
        String[] ids = dicIds.split(",");
        boolean flag = false;
        for (int i = 0; i < ids.length; i++)
        {
            flag = this.boutiqueSquareDicCoreService.delBoutiqueSquareDic(ids[i]);
            if (!flag)
            {
                break;
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_DEL_SUCCESS, MisMessageConst.MIS_SYS_DIC_DEL_FAIL);
    }

    /**
     * 查询精品广场商品类型字典信息
     */
    @Override
    public TransData<PageModel<MQualitySquareGoodsType>> findQualitySquareDict(HttpServletRequest request) throws Exception
    {
        QualitySquareGoodsTypeExample qualityExample = new QualitySquareGoodsTypeExample();
        MQualitySquareGoodsType qualityDictionary = ServletUtils.objectMethod(MQualitySquareGoodsType.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        Criteria criteria = qualityExample.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (qualityDictionary.getGoodsTypeId() != null)
        {
            criteria.andGoodsTypeIdLike("%" + qualityDictionary.getGoodsTypeId().toString() + "%");
        }
        if (StringUtils.hasText(qualityDictionary.getGoodsTypeName()))
        {
            criteria.andGoodsTypeNameLike("%" + qualityDictionary.getGoodsTypeName() + "%");
        }
        if (qualityDictionary.getParentGoodsTypeId() != null)
        {
            criteria.andParentGoodsTypeIdLike("%" + qualityDictionary.getParentGoodsTypeId().toString() + "%");

        }
        if (qualityDictionary.getSortOrder() != null)
        {
            criteria.andSortOrderLike("%" + qualityDictionary.getSortOrder().toString() + "%");
        }
        PageModel<MQualitySquareGoodsType> pm = new PageModel<MQualitySquareGoodsType>();
        pm.setPageIndex(pageCondition.getPageIndex());
        pm.setPageSize(pageSize);
        Integer count = this.qualitySquareGoodsTypeGeneratorQueryService.countByExample(qualityExample);
        pm.setCount(count);
        if (count > 0)
        {
            qualityExample.setPage(pageCondition.getPageIndex(), pageSize);// 设置分页条件
            List<QualitySquareGoodsType> list = this.qualitySquareGoodsTypeGeneratorQueryService.selectByExample(qualityExample);
            for (QualitySquareGoodsType qual : list)
            {
                MQualitySquareGoodsType mquality = new MQualitySquareGoodsType();
                EntityTools.copyValue(qual, mquality);
                pm.getResult().add(mquality);
            }
        }
        return new TransData<PageModel<MQualitySquareGoodsType>>(true, null, pm);
    }

    /**
     * 查询精品广场商品类型字典详细信息
     */
    @Override
    public TransData<MQualitySquareGoodsType> findQualitySquareDetail(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");// 字典Id
        QualitySquareGoodsType quality = this.qualitySquareGoodsTypeGeneratorQueryService.selectUnDelByPrimaryKey("".equals(dicIds.split(",")[0]) ? null : Integer.parseInt(dicIds.split(",")[0]));
        if (quality != null && !"".equals(quality))
        {
            MQualitySquareGoodsType mquality = new MQualitySquareGoodsType();
            EntityTools.copyValue(quality, mquality);
            return new TransData<MQualitySquareGoodsType>(true, null, mquality);
        }
        else
        {
            return new TransData<MQualitySquareGoodsType>(false, MisMessageConst.MIS_SYS_DIC_GET_INFO_FAIL, null);
        }
    }

    /**
     * 批量新增精品广场商品类型字典
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addAllQualitySquare(HttpServletRequest request) throws Exception
    {
        String dictList = ServletRequestUtils.getStringParameter(request, "dictList");
        List<MQualitySquareGoodsType> sysList = new Gson().fromJson(dictList, new TypeToken<List<MQualitySquareGoodsType>>()
        {
        }.getType());
        if (sysList == null || sysList.size() <= 0)
        {
            return UtilsMis.getBooleanResult(false, null, MisMessageConst.MIS_DICTIARY_BATCH_EXCEL_FAIL);
        }
        List<QualitySquareGoodsType> interList = new ArrayList<QualitySquareGoodsType>();
        for (MQualitySquareGoodsType sys : sysList)
        {
            QualitySquareGoodsType sysDict = new QualitySquareGoodsType();
            EntityTools.copyValue(sys, sysDict);
            interList.add(sysDict);
        }
        boolean flag = this.boutiqueSquareDicCoreService.addAllBoutiqueSquareDic(interList);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_DICTIARY_BATCH_SYS_SUCCESS, MisMessageConst.MIS_DICTIARY_BATCH_SYS_FAIL);
    }

}
