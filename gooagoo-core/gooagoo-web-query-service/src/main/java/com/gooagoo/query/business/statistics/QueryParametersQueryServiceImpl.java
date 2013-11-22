package com.gooagoo.query.business.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.QueryParametersQueryService;
import com.gooagoo.api.business.query.statistics.RecordStatisticQueryService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.entity.business.marketing.rule.HistoryCondition;
import com.gooagoo.entity.business.statistics.BasicQueryParameters;
import com.gooagoo.entity.business.statistics.QueryParameters;
import com.gooagoo.gmongo.MongoDao;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Service
public class QueryParametersQueryServiceImpl implements QueryParametersQueryService
{

    MongoDao mdao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_QUERY_PARAMETERS);

    @Autowired
    RecordStatisticQueryService recordStatisticQueryService;

    @Override
    public List<BasicQueryParameters> findQueryParameters(String corpId)
    {
        BasicDBObject query = new BasicDBObject("corpId", corpId);

        return this.mdao.findByCondition(query, BasicQueryParameters.class);
    }

    /*public ChartVo memberStatisticService(String id)
    {
        DBObject obj = this.mdao.findById(id);

        QueryParameters parametersObj = new Gson().fromJson(obj.toString(), QueryParameters.class);

        List<Account> userList = null;
        try
        {
            userList = this.accountQueryService.getUserAccounts(parametersObj.getCorpId(), parametersObj.getCondition());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        this.recordStatisticService.memberFeatureStatistic(parametersObj.getCorpId(), userList, parametersObj.getAnalysisType());
        return null;
    }*/

    @Override
    public boolean saveQueryParameters(String corpId, String analysisType, boolean isCustom, String queryName, String queryDesc, HistoryCondition historyCondition)
    {
        try
        {
            QueryParameters parameters = new QueryParameters();
            parameters.set_id(UUID.getUUID());
            parameters.setCorpId(corpId);
            parameters.setQueryName(queryName);
            parameters.setQueryDesc(queryDesc);
            parameters.setAnalysisType(analysisType);
            historyCondition.setCustom(isCustom);
            parameters.setCondition(new Gson().toJson(historyCondition));
            this.mdao.insertEntity(parameters);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public HistoryCondition getHistoryCondition(String queryParametersId)
    {
        DBObject obj = this.mdao.findById(queryParametersId);

        QueryParameters parametersObj = new Gson().fromJson(obj.toString(), QueryParameters.class);
        HistoryCondition historyCondition = new Gson().fromJson(parametersObj.getCondition(), HistoryCondition.class);
        historyCondition.setStatisticsType(parametersObj.getAnalysisType());
        return historyCondition;
    }
}
