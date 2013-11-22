package com.gooagoo.query.business.statistics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.CrowdOperationQueryService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.entity.business.statistics.UserGroup;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.gmongo.GridFSDao;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.utils.AnalysisUtils;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

@Service
public class CrowdOperationQueryServiceImpl implements CrowdOperationQueryService
{
    private final DB db = MongoDBUtils.getDB(MongoConstants.MONGO_URL, MongoConstants.analysisDB);
    private GridFSDao gridFSDao = new GridFSDao(MongoConstants.MONGO_URL, MongoConstants.gridFSDB);

    @Override
    public boolean saveCrowd(String shopId, String crowdName, String crowdDesc, List<Account> accounts)
    {
        String groupId = UUID.getUUID();

        BasicDBObject crowd = new BasicDBObject("corp_id", shopId).append("group_id", groupId).append("group_name", crowdName).append("group_desc", crowdDesc);

        WriteResult wrs = this.db.getCollection(CollectionConstants.ANLS_USER_GROUP).insert(crowd);

        if (wrs.getError() != null)
        {
            this.db.getCollection(CollectionConstants.ANLS_USER_GROUP).remove(crowd);
            return false;
        }

        List<String> list = new ArrayList<String>();
        for (Account acc : accounts)
        {
            list.add(acc.getAccountType() + "_" + acc.getAccountNo());
        }
        gridFSDao.save(list, groupId, groupId);
        return true;
    }

    @Override
    public List<UserGroup> findCrowd(String shopId)
    {
        BasicDBObject query = new BasicDBObject();
        BasicDBList values = new BasicDBList();
        values.add(new BasicDBObject("corp_id", shopId));
        values.add(new BasicDBObject("corp_id", new BasicDBObject("$exists", false)));
        query.put("$or", values);

        List<DBObject> list = this.db.getCollection(CollectionConstants.ANLS_USER_GROUP).find(query).toArray();

        List<UserGroup> result = new ArrayList();
        UserGroup record = null;

        for (DBObject obj : list)
        {
            record = new UserGroup();
            record.setGroupId(obj.get("group_id").toString());
            record.setGroupName(obj.get("group_name").toString());
            record.setGroupDesc(obj.get("group_desc").toString());

            result.add(record);
        }

        return result;
    }

    @Override
    public List<Account> findAccounts(String corpId, boolean isCustom, String analysisType, List<Account> accounts, String label)
    {
        List<Account> result = new ArrayList();

        if (isCustom)
        {
            result = this.findAccountsByFeature(corpId, analysisType, accounts, label);
        }
        else
        {
            result = this.findAccountsByAnalysisType(analysisType, accounts, label);
        }
        return result;
    }

    private List<Account> findAccountsByFeature(String corpId, String analysisType, List<Account> accounts, String label)
    {
        List<Account> alist = new ArrayList();

        DBCollection coll = this.db.getCollection(CollectionConstants.ANLS_USER_BY_FEATURE);
        BasicDBObject query = new BasicDBObject();
        BasicDBList idList = new BasicDBList();
        if (accounts != null)
        {
            for (Account user : accounts)
            {
                idList.add(user.getUserId());
            }
        }
        query.append("shop_id", corpId);
        query.append("user_id", new BasicDBObject("$in", idList));
        query.append("feature." + AnalysisUtils.generateFeatureCode(analysisType), label);

        List<DBObject> result = coll.find(query).toArray();
        Account ac = null;
        for (DBObject obj : result)
        {
            ac = new Account();
            ac.setUserId(obj.get("user_id").toString());

            alist.add(ac);
        }

        return alist;
    }

    private List<Account> findAccountsByAnalysisType(String analysisType, List<Account> accounts, String label)
    {
        List<Account> alist = new ArrayList();

        DBCollection coll = this.db.getCollection(CollectionConstants.ANLS_USER_BY_BASIC);
        BasicDBObject query = new BasicDBObject();
        BasicDBList idList = new BasicDBList();
        if (accounts != null)
        {
            for (Account user : accounts)
            {
                idList.add(user.getUserId());
            }
        }
        query.append("_id", new BasicDBObject("$in", idList));
        query.append(analysisType, label);

        List<DBObject> result = coll.find(query).toArray();
        Account ac = null;
        for (DBObject obj : result)
        {
            ac = new Account();
            ac.setUserId(obj.get("_id").toString());

            alist.add(ac);
        }

        return alist;
    }

    @Override
    public Set<Account> getAccountsByGroupID(String groupId)
    {
        DBObject query = new BasicDBObject();
        query.put("_id", groupId);
        query.put("_filename", groupId);

        List<String> list = gridFSDao.getData(query);
        Set<Account> accounts = new HashSet<Account>();
        for (String string : list)
        {
            String[] arrAccount = string.split("_");
            Account account = new Account(arrAccount[0], arrAccount[1]);
            accounts.add(account);
        }
        return accounts;
    }
}
