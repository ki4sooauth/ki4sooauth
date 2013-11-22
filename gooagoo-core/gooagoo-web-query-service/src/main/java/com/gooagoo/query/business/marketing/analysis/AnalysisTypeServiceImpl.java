package com.gooagoo.query.business.marketing.analysis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.marketing.analysis.AnalysisTypeService;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.entity.business.marketing.analysis.AnalysisType;
import com.gooagoo.gmongo.MongoDBUtils;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

@Service
public class AnalysisTypeServiceImpl implements AnalysisTypeService
{

    DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_TYPE);

    @Override
    public List<AnalysisType> getAnalysisTypeList(String corpId)
    {
        BasicDBObject query = new BasicDBObject();
        BasicDBList values = new BasicDBList();
        values.add(new BasicDBObject("corp_id", corpId).append("is_del", "N"));
        values.add(new BasicDBObject("corp_id", new BasicDBObject("$exists", false)));
        query.append("$or", values);
        List<DBObject> list = this.coll.find(query).toArray();

        List<AnalysisType> result = new ArrayList<AnalysisType>();
        AnalysisType analysisType = null;
        for (DBObject obj : list)
        {
            analysisType = new AnalysisType();
            analysisType.setCustom(obj.get("corp_id") == null ? false : true);
            analysisType.setTypeCode(obj.get("type_code").toString());
            analysisType.setTypeName(obj.get("type_name").toString());

            result.add(analysisType);
        }
        return result;
    }
}
