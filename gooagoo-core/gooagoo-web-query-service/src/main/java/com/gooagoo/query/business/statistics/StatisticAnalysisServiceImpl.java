package com.gooagoo.query.business.statistics;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.StatisticAnalysisService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.entity.business.statistics.ColumnVO;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.gmongo.MongoDao;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceCommand.OutputType;
import com.mongodb.MapReduceOutput;

@Service
public class StatisticAnalysisServiceImpl implements StatisticAnalysisService
{
    @Override
    public List<ColumnVO> getShoppingPeriod(String shopId, String startDate, String endDate, List<Account> accounts, String uuid)
    {
        List<ColumnVO> result = null;

        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_USER_SHOPPING_BASIC);
        try
        {
            BasicDBObject query = new BasicDBObject();
            query.append("shop_id", shopId);
            query.append("pro_date", new BasicDBObject("$gte", TimeUtils.convertStringToDate(startDate)).append("$lte", TimeUtils.convertStringToDate(endDate)));
            query.append("user_id", new BasicDBObject("$in", this.getAccountList(accounts)));

            StringBuffer map = new StringBuffer();
            map.append("function() {");
            map.append("var key = this.user_id;");
            map.append("var value = {num_of_shopping:1,shopping_period:''};");
            map.append("emit(key,value);");
            map.append("}");

            StringBuffer reduce = new StringBuffer();
            reduce.append("function(key, values) {");
            reduce.append("var reduced = {num_of_shopping:0,shopping_period:''};");
            reduce.append("values.forEach(function(val) {");
            reduce.append("reduced.num_of_shopping +=1;");
            reduce.append("});");
            reduce.append("if(reduced.num_of_shopping>maxValue){maxValue=reduced.num_of_shopping;}");
            reduce.append("return reduced;");
            reduce.append("}");

            StringBuffer finalize = new StringBuffer();
            finalize.append("function(key, reduced) {");
            finalize.append("var quater=Math.ceil(maxValue/4);");
            finalize.append("if(reduced.num_of_shopping<quater){reduced.shopping_period='[0-'+quater.toFixed(0)+']';}");
            finalize.append("else if(reduced.num_of_shopping<quater*2){reduced.shopping_period='['+quater.toFixed(0)+'-'+(quater*2).toFixed(0)+']';}");
            finalize.append("else if(reduced.num_of_shopping<quater*3){reduced.shopping_period='['+(quater*2).toFixed(0)+'-'+(quater*3).toFixed(0)+']';}");
            finalize.append("else{reduced.shopping_period='['+3*quater.toFixed(0)+'+]';}");
            finalize.append("return reduced;");
            finalize.append("}");

            String tarCollectionName = this.getCollectionName(shopId, startDate, endDate, uuid);
            MapReduceCommand command = new MapReduceCommand(coll, map.toString(), reduce.toString(), tarCollectionName, OutputType.REPLACE, query);
            Map<String, Object> scope = new HashMap<String, Object>();
            scope.put("maxValue", 1);
            command.setScope(scope);
            command.setOutputDB(MongoConstants.analysisMiddleDB);
            command.setFinalize(finalize.toString());
            MapReduceOutput out = coll.mapReduce(command);
            if (out != null)
            {
                MongoDao periodDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisMiddleDB, tarCollectionName);
                BasicDBObject periodKey = new BasicDBObject();
                periodKey.put("value.shopping_period", true);
                String periodReduce = "function(doc, aggr){aggr.count += 1;}";
                BasicDBList group = periodDao.group(periodKey, null, new BasicDBObject().append("count", 0), periodReduce);

                result = new ArrayList<ColumnVO>();
                for (Object obj : group)
                {
                    BasicDBObject dbObj = (BasicDBObject) obj;
                    ColumnVO column = new ColumnVO();
                    column.setLable(dbObj.get("value.shopping_period").toString());
                    column.setValue(new Double((dbObj.get("count").toString())).longValue());
                    result.add(column);
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("getShoppingPeriod error:", e);
        }
        return result;
    }

    @Override
    public List<ColumnVO> getNumberOfArriveShop(String shopId, String startDate, String endDate, List<Account> accounts, String uuid)
    {
        List<ColumnVO> result = null;

        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_ARRIVAL_SHOP);
        try
        {
            BasicDBObject query = new BasicDBObject();
            query.append("shopId", shopId);
            query.append("start", new BasicDBObject("$gte", TimeUtils.convertStringToDate(startDate)).append("$lte", TimeUtils.convertStringToDate(endDate)));
            query.append("userId", new BasicDBObject("$in", this.getAccountList(accounts)));

            StringBuffer map = new StringBuffer();
            map.append("function() {");
            map.append("var key = this.userId;");
            map.append("var value = {go_shop_times:1,go_shop_period:''};");
            map.append("emit(key,value);");
            map.append("}");

            StringBuffer reduce = new StringBuffer();
            reduce.append("function(key, values) {");
            reduce.append("var reduced = {go_shop_times:0,go_shop_period:''};");
            reduce.append("values.forEach(function(val) {");
            reduce.append("reduced.go_shop_times +=1;");
            reduce.append("});");
            reduce.append("if(reduced.go_shop_times>maxValue){maxValue=reduced.go_shop_times;}");
            reduce.append("return reduced;");
            reduce.append("}");

            StringBuffer finalize = new StringBuffer();
            finalize.append("function(key, reduced) {");
            finalize.append("var quater=Math.ceil(maxValue/4);");
            finalize.append("if(reduced.go_shop_times<quater){reduced.go_shop_period='[0-'+quater.toFixed(0)+']';}");
            finalize.append("else if(reduced.go_shop_times<quater*2){reduced.go_shop_period='['+quater.toFixed(0)+'-'+(quater*2).toFixed(0)+']';}");
            finalize.append("else if(reduced.go_shop_times<quater*3){reduced.go_shop_period='['+(quater*2).toFixed(0)+'-'+(quater*3).toFixed(0)+']';}");
            finalize.append("else{reduced.go_shop_period='['+3*quater.toFixed(0)+'+]';}");
            finalize.append("return reduced;");
            finalize.append("}");

            String tarCollectionName = this.getCollectionName(shopId, startDate, endDate, uuid);
            MapReduceCommand command = new MapReduceCommand(coll, map.toString(), reduce.toString(), tarCollectionName, OutputType.REPLACE, query);
            Map<String, Object> scope = new HashMap<String, Object>();
            scope.put("maxValue", 1);
            command.setScope(scope);
            command.setOutputDB(MongoConstants.analysisMiddleDB);
            command.setFinalize(finalize.toString());
            MapReduceOutput out = coll.mapReduce(command);
            if (out != null)
            {
                DBCollection subColl = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisMiddleDB, tarCollectionName);

                String mapFunction = "function(){emit(this.value.go_shop_period,1);}";
                String reduceFunction = "function(key,reduced){var count=0;reduced.forEach(function(val){count+=val;});return count;}";
                MapReduceCommand subCommand = new MapReduceCommand(subColl, mapFunction, reduceFunction, null, OutputType.INLINE, null);
                MapReduceOutput outObj = subColl.mapReduce(subCommand);

                result = new ArrayList<ColumnVO>();
                for (DBObject obj : outObj.results())
                {
                    ColumnVO column = new ColumnVO();
                    column.setLable(obj.get("_id").toString());
                    column.setValue(new Double((obj.get("value").toString())).longValue());
                    result.add(column);
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("getNumberOfArriveShop error:", e);
        }
        return result;
    }

    @Override
    public List<ColumnVO> getRateOfPurchase(String shopId, String startDate, String endDate, List<Account> accounts, String uuid)
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_ARRIVAL_SHOP);
        BasicDBObject key1 = new BasicDBObject();
        key1.put("userId", true);
        key1.put("shopId", true);
        //BasicDBObject query = new BasicDBObject();
        //query.append("shopId", shopId);
        String reduce1 = "function(doc, aggr){aggr.count += 1;}";
        BasicDBList list1 = dao.group(key1, null, new BasicDBObject().append("count", 0), reduce1);

        MongoDao dao2 = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_USER_SHOPPING_BASIC);
        BasicDBObject key2 = new BasicDBObject();
        key2.put("user_id", true);
        key2.put("shop_id", true);
        String reduce2 = "function(doc, aggr){aggr.count += 1;}";
        BasicDBList list2 = dao2.group(key2, null, new BasicDBObject().append("count", 0), reduce2);

        MongoDao dao3 = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BUY_PERCENT);
        for (int i = 0; i < list1.size(); i++)
        {
            BasicDBObject dbo = (BasicDBObject) list1.get(i);
            Object user_Id = dbo.get("userId");
            Object shop_Id = dbo.get("shopId");
            for (int j = 0; j < list2.size(); j++)
            {
                BasicDBObject dbo2 = (BasicDBObject) list2.get(j);
                Object user_id = dbo2.get("user_id");
                Object shop_id = dbo2.get("shop_id");
                if (user_Id.toString().equals(user_id.toString()) && shop_Id.toString().equals(shop_id.toString()))
                {
                    BasicDBObject newDate = new BasicDBObject();
                    newDate.put("user_id", user_id);
                    newDate.put("shop_id", shop_id);

                    double count1 = Double.parseDouble(dbo.get("count").toString());
                    double count2 = Double.parseDouble(dbo2.get("count").toString());

                    newDate.put("arrive_count", count1);
                    newDate.put("buy_count", count2);

                    double b = 0;
                    if (count1 != 0 && count2 != 0)
                    {
                        double a = count2 / count1 * 100;
                        DecimalFormat df = new DecimalFormat(".#");
                        b = Double.parseDouble(df.format(a));
                    }
                    else if (count1 == 0 && count2 == 0)
                    {
                        continue;
                    }

                    newDate.put("percent", b);

                    dao3.insert(newDate);
                }
            }
        }

        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BUY_PERCENT);
        BasicDBObject query = new BasicDBObject();
        query.append("shop_id", shopId);
        try
        {
            query.append("pro_date", new BasicDBObject("$gte", TimeUtils.convertStringToDate(startDate)).append("$lte", TimeUtils.convertStringToDate(endDate)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        query.append("user_id", new BasicDBObject("$in", this.getAccountList(accounts)));

        StringBuffer map = new StringBuffer();
        map.append("function() {");
        map.append("var key = {condition : 0};");
        map.append("var value = {user_id:this.user_id,percent:this.percent};");
        map.append("if(this.percent <= 20){");
        map.append("key.condition = 20;");
        map.append("} else if(this.percent >20 && this.percent <=40) {");
        map.append("key.condition = 40;");
        map.append("} else if(this.percent >40 && this.percent <=60) {");
        map.append("key.condition = 60;");
        map.append("} else {");
        map.append("key.condition = 100;");
        map.append("}");
        map.append("emit(key,value);");
        map.append("}");

        StringBuffer reduce = new StringBuffer();
        reduce.append("function(key, values) {");
        reduce.append("return values.length;");
        reduce.append("}");

        List<ColumnVO> result = new ArrayList<ColumnVO>();
        String tarCollectionName = this.getCollectionName(shopId, startDate, endDate, uuid);
        MapReduceCommand command = new MapReduceCommand(coll, map.toString(), reduce.toString(), tarCollectionName, OutputType.REPLACE, query);
        MapReduceOutput out = coll.mapReduce(command);
        if (out != null)
        {
            DBCollection subColl = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, tarCollectionName);

            String mapFunction = "function(){emit(this.value.level_of_shopping,1);}";
            String reduceFunction = "function(key,reduced){var count=0;reduced.forEach(function(val){count+=val;});return count;}";
            MapReduceCommand subCommand = new MapReduceCommand(subColl, mapFunction, reduceFunction, null, OutputType.INLINE, null);
            MapReduceOutput outObj = subColl.mapReduce(subCommand);
            for (DBObject obj : outObj.results())
            {
                ColumnVO column = new ColumnVO();
                column.setLable(obj.get("_id").toString());
                column.setValue(Long.parseLong(obj.get("value").toString()));
                result.add(column);
            }
        }

        return result;
    }

    @Override
    public List<ColumnVO> getAveragePriceRange(String shopId, String startDate, String endDate, List<Account> accounts, String uuid)
    {
        List<ColumnVO> result = null;

        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_USER_SHOPPING_BASIC);
        try
        {
            BasicDBObject query = new BasicDBObject();
            query.append("shop_id", shopId);
            query.append("pro_date", new BasicDBObject("$gte", TimeUtils.convertStringToDate(startDate)).append("$lte", TimeUtils.convertStringToDate(endDate)));
            query.append("user_id", new BasicDBObject("$in", this.getAccountList(accounts)));

            StringBuffer map = new StringBuffer();
            map.append("function() {");
            map.append("var key = this.user_id;");
            map.append("var value = {num_of_shopping:1,pay_price:this.pay_price,avg_price:this.pay_price};");
            map.append("emit(key,value);");
            map.append("}");

            StringBuffer reduce = new StringBuffer();
            reduce.append("function(key, values) {");
            reduce.append("var reduced = {num_of_shopping:0,pay_price:0,avg_price:0,level_of_shopping:''};");
            reduce.append("values.forEach(function(val) {");
            reduce.append("reduced.num_of_shopping +=1;");
            reduce.append("reduced.pay_price += val.pay_price;");
            reduce.append("});");
            reduce.append("if(reduced.pay_price/reduced.num_of_shopping>=maxValue){maxValue=reduced.pay_price/reduced.num_of_shopping;}");
            reduce.append("return reduced;");
            reduce.append("}");

            StringBuffer finalize = new StringBuffer();
            finalize.append("function(key, reduced) {");
            finalize.append("reduced.avg_price = parseFloat(reduced.pay_price/reduced.num_of_shopping);");
            finalize.append("if(maxValue==0){maxValue=reduced.avg_price;}");
            finalize.append("var quater=Math.ceil(maxValue/4);");
            finalize.append("if(reduced.avg_price<quater){reduced.level_of_shopping='[0-'+quater.toFixed(0)+']';}");
            finalize.append("else if(reduced.avg_price<quater*2){reduced.level_of_shopping='['+quater.toFixed(0)+'-'+(quater*2).toFixed(0)+']';}");
            finalize.append("else if(reduced.avg_price<quater*3){reduced.level_of_shopping='['+(quater*2).toFixed(0)+'-'+(quater*3).toFixed(0)+']';}");
            finalize.append("else{reduced.level_of_shopping='['+3*quater.toFixed(0)+'+]';}");
            finalize.append("reduced.num_of_shopping=parseInt(reduced.num_of_shopping);");
            finalize.append("return reduced;");
            finalize.append("}");

            String tarCollectionName = this.getCollectionName(shopId, startDate, endDate, uuid);
            MapReduceCommand command = new MapReduceCommand(coll, map.toString(), reduce.toString(), tarCollectionName, OutputType.REPLACE, query);
            Map<String, Object> scope = new HashMap<String, Object>();
            scope.put("maxValue", 0);
            command.setScope(scope);
            command.setOutputDB(MongoConstants.analysisMiddleDB);
            command.setFinalize(finalize.toString());
            MapReduceOutput out = coll.mapReduce(command);
            if (out != null)
            {
                MongoDao periodDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisMiddleDB, tarCollectionName);
                BasicDBObject periodKey = new BasicDBObject();
                periodKey.put("value.level_of_shopping", true);
                String periodReduce = "function(doc, aggr){aggr.count += 1;}";
                BasicDBList group = periodDao.group(periodKey, null, new BasicDBObject().append("count", 0), periodReduce);

                result = new ArrayList<ColumnVO>();
                for (Object obj : group)
                {
                    BasicDBObject dbObj = (BasicDBObject) obj;
                    ColumnVO column = new ColumnVO();
                    column.setLable(dbObj.get("value.level_of_shopping").toString());
                    column.setValue(new Double((dbObj.get("count").toString())).longValue());
                    result.add(column);
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("getAveragePriceRange error:", e);
        }
        return result;
    }

    @Override
    public List<ColumnVO> getBrowseCouponsFrequency(String shopId, String startDate, String endDate, List<Account> accounts, String uuid)
    {
        List<ColumnVO> result = null;

        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BROWSE);
        try
        {
            BasicDBObject query = new BasicDBObject();
            query.append("shopId", shopId);
            query.append("timestamp", new BasicDBObject("$gte", TimeUtils.convertStringToDate(startDate)).append("$lte", TimeUtils.convertStringToDate(endDate)));
            query.append("userId", new BasicDBObject("$in", this.getAccountList(accounts)));
            query.append("couponId", new BasicDBObject("$exists", true));

            StringBuffer map = new StringBuffer();
            map.append("function() {");
            map.append("var key = this.userId;");
            map.append("var value = {browse_times:1,browse_period:''};");
            map.append("emit(key,value);");
            map.append("}");

            StringBuffer reduce = new StringBuffer();
            reduce.append("function(key, values) {");
            reduce.append("var reduced = {browse_times:0,browse_period:''};");
            reduce.append("values.forEach(function(val) {");
            reduce.append("reduced.browse_times +=1;");
            reduce.append("});");
            reduce.append("if(reduced.browse_times>maxValue){maxValue=reduced.browse_times;}");
            reduce.append("return reduced;");
            reduce.append("}");

            StringBuffer finalize = new StringBuffer();
            finalize.append("function(key, reduced) {");
            finalize.append("var quater=Math.ceil(maxValue/4);");
            finalize.append("if(reduced.browse_times<quater){reduced.browse_period='[0-'+quater.toFixed(0)+']';}");
            finalize.append("else if(reduced.browse_times<quater*2){reduced.browse_period='['+quater.toFixed(0)+'-'+(quater*2).toFixed(0)+']';}");
            finalize.append("else if(reduced.browse_times<quater*3){reduced.browse_period='['+(quater*2).toFixed(0)+'-'+(quater*3).toFixed(0)+']';}");
            finalize.append("else{reduced.browse_period='['+3*quater.toFixed(0)+'+]';}");
            finalize.append("return reduced;");
            finalize.append("}");

            String tarCollectionName = this.getCollectionName(shopId, startDate, endDate, uuid);
            MapReduceCommand command = new MapReduceCommand(coll, map.toString(), reduce.toString(), tarCollectionName, OutputType.REPLACE, query);
            Map<String, Object> scope = new HashMap<String, Object>();
            scope.put("maxValue", 1);
            command.setScope(scope);
            command.setOutputDB(MongoConstants.analysisMiddleDB);
            command.setFinalize(finalize.toString());
            MapReduceOutput out = coll.mapReduce(command);
            if (out != null)
            {
                MongoDao periodDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisMiddleDB, tarCollectionName);
                BasicDBObject periodKey = new BasicDBObject();
                periodKey.put("value.browse_period", true);
                String periodReduce = "function(doc, aggr){aggr.count += 1;}";
                BasicDBList group = periodDao.group(periodKey, null, new BasicDBObject().append("count", 0), periodReduce);

                result = new ArrayList<ColumnVO>();
                for (Object obj : group)
                {
                    BasicDBObject dbObj = (BasicDBObject) obj;
                    ColumnVO column = new ColumnVO();
                    column.setLable(dbObj.get("value.browse_period").toString());
                    column.setValue(new Double((dbObj.get("count").toString())).longValue());
                    result.add(column);
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("getNumberOfArriveShop error:", e);
        }
        return result;
    }

    @Override
    public List<ColumnVO> getPhoneInteractionFrequency(String shopId, String startDate, String endDate, List<Account> accounts, String uuid)
    {
        BasicDBList phoneSources = new BasicDBList();
        phoneSources.add("1");
        phoneSources.add("2");

        BasicDBObject query = new BasicDBObject();
        query.append("shopId", shopId);
        try
        {
            query.append("timestamp", new BasicDBObject("$gte", TimeUtils.convertStringToDate(startDate)).append("$lte", TimeUtils.convertStringToDate(endDate)));
        }
        catch (Exception e1)
        {
            GooagooLog.error("getPhoneInteractionFrequency error:", e1);
        }
        query.append("userId", new BasicDBObject("$in", this.getAccountList(accounts)));
        query.put("source", new BasicDBObject("$in", phoneSources));

        MongoDao commentDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_COMMENT);
        BasicDBObject commentKey = new BasicDBObject();
        commentKey.put("userId", true);
        commentKey.put("shopId", true);
        String commentReduce = "function(doc, aggr){aggr.count += 1;}";
        BasicDBList commentList = commentDao.group(commentKey, query, new BasicDBObject().append("count", 0), commentReduce);

        MongoDao favoritesDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_FAVORITES);
        BasicDBObject favoritesKey = new BasicDBObject();
        favoritesKey.put("userId", true);
        favoritesKey.put("shopId", true);
        String favoritesReduce = "function(doc, aggr){aggr.count += 1;}";
        BasicDBList favoritesList = favoritesDao.group(favoritesKey, query, new BasicDBObject().append("count", 0), favoritesReduce);

        MongoDao browseDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BROWSE);
        BasicDBObject browseKey = new BasicDBObject();
        browseKey.put("userId", true);
        browseKey.put("shopId", true);
        String browseReduce = "function(doc, aggr){aggr.count += 1;}";
        BasicDBList browseList = browseDao.group(browseKey, query, new BasicDBObject().append("count", 0), browseReduce);

        String tarCollectionName = this.getCollectionName(shopId, startDate, endDate, uuid);
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisMiddleDB, tarCollectionName);
        for (int i = 0; i < commentList.size(); i++)
        {
            BasicDBObject comment = (BasicDBObject) commentList.get(i);
            this.updatePhoneInteractionFrequency(comment, dao, "commentCount");
        }
        for (int i = 0; i < favoritesList.size(); i++)
        {
            BasicDBObject favorites = (BasicDBObject) favoritesList.get(i);
            this.updatePhoneInteractionFrequency(favorites, dao, "favoriteCount");
        }
        for (int i = 0; i < browseList.size(); i++)
        {
            BasicDBObject browse = (BasicDBObject) browseList.get(i);
            this.updatePhoneInteractionFrequency(browse, dao, "browseCount");
        }

        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisMiddleDB, tarCollectionName);
        BasicDBObject one = new BasicDBObject();
        one.put("shopId", shopId);
        DBCursor sort = coll.find(one).sort((DBObject) new BasicDBObject().put("totalCount", -1)).limit(1);
        int maxValue = 0;
        if (sort.hasNext())
        {
            DBObject next = sort.next();
            maxValue = (Integer) next.get("totalCount");
        }

        StringBuffer map = new StringBuffer();
        map.append("function() {");
        map.append("var key = {condition : 0};");
        map.append("var value = {user_id:this.user_id, total_count:this.total_count};");
        map.append("if (this.total_count <= " + (maxValue / 4) + ") {");
        map.append("key.condition = " + (maxValue / 4 - 1) + ";");
        map.append("} else if (this.total_count <= " + (maxValue / 2) + " && this.total_count > " + (maxValue / 4) + ") {");
        map.append("key.condition = " + (maxValue / 2 - 1) + ";");
        map.append("} else if (this.total_count > " + (maxValue / 2) + " && this.total_count <= " + (maxValue / 4 * 3) + ") {");
        map.append("key.condition = " + (maxValue / 4 * 3 - 1) + ";");
        map.append("} else {");
        map.append("key.condition = " + (maxValue - 1) + ";");
        map.append("}");
        map.append("emit(key,value);");
        map.append("}");

        StringBuffer reduce = new StringBuffer();
        reduce.append("function(key, values) {");
        reduce.append("return values.length;");
        reduce.append("}");

        List<ColumnVO> result = new ArrayList<ColumnVO>();

        MapReduceCommand command = new MapReduceCommand(coll, map.toString(), reduce.toString(), null, OutputType.INLINE, null);
        MapReduceOutput out = coll.mapReduce(command);

        for (DBObject obj : out.results())
        {
            ColumnVO column = new ColumnVO();
            column.setLable(obj.get("_id.condition").toString());
            column.setValue(Long.parseLong(obj.get("value.totalCount").toString()));
            result.add(column);
        }
        return result;
    }

    private void updatePhoneInteractionFrequency(DBObject dbObj, MongoDao dao, String totalName)
    {
        String user_id = (String) dbObj.get("userId");
        String shop_id = (String) dbObj.get("shopId");
        Double count = (Double) dbObj.get("count");

        BasicDBObject queryM = new BasicDBObject();
        queryM.put("userId", user_id);
        queryM.put("shopId", shop_id);

        BasicDBObject newDate = new BasicDBObject();
        newDate.put("userId", user_id);
        newDate.put("shopId", shop_id);
        newDate.put(totalName, count);

        dao.update(queryM, new BasicDBObject().append("$set", newDate));

        BasicDBObject totalCount = new BasicDBObject();
        totalCount.put("totalCount", count);
        dao.update(queryM, new BasicDBObject().append("$inc", totalCount));
    }

    @Override
    public List<ColumnVO> getOpenCryoutFrequency(String shopId, String startDate, String endDate, List<Account> accounts, String uuid)
    {
        List<ColumnVO> result = null;

        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BROWSE);
        try
        {
            BasicDBObject query = new BasicDBObject();
            query.append("shopId", shopId);
            query.append("timestamp", new BasicDBObject("$gte", TimeUtils.convertStringToDate(startDate)).append("$lte", TimeUtils.convertStringToDate(endDate)));
            query.append("userId", new BasicDBObject("$in", this.getAccountList(accounts)));
            //些处加条件，过滤只是浏览吆喝渠道的记录
            //query.append("source", new BasicDBObject("$exists", true));

            StringBuffer map = new StringBuffer();
            map.append("function() {");
            map.append("var key = this.userId;");
            map.append("var value = {browse_times:1,browse_period:''};");
            map.append("emit(key,value);");
            map.append("}");

            StringBuffer reduce = new StringBuffer();
            reduce.append("function(key, values) {");
            reduce.append("var reduced = {browse_times:0,browse_period:''};");
            reduce.append("values.forEach(function(val) {");
            reduce.append("reduced.browse_times +=1;");
            reduce.append("});");
            reduce.append("if(reduced.browse_times>maxValue){maxValue=reduced.browse_times;}");
            reduce.append("return reduced;");
            reduce.append("}");

            StringBuffer finalize = new StringBuffer();
            finalize.append("function(key, reduced) {");
            finalize.append("var quater=Math.ceil(maxValue/4);");
            finalize.append("if(reduced.browse_times<quater){reduced.browse_period='[0-'+quater.toFixed(0)+']';}");
            finalize.append("else if(reduced.browse_times<quater*2){reduced.browse_period='['+quater.toFixed(0)+'-'+(quater*2).toFixed(0)+']';}");
            finalize.append("else if(reduced.browse_times<quater*3){reduced.browse_period='['+(quater*2).toFixed(0)+'-'+(quater*3).toFixed(0)+']';}");
            finalize.append("else{reduced.browse_period='['+3*quater.toFixed(0)+'+]';}");
            finalize.append("return reduced;");
            finalize.append("}");

            String tarCollectionName = this.getCollectionName(shopId, startDate, endDate, uuid);
            MapReduceCommand command = new MapReduceCommand(coll, map.toString(), reduce.toString(), tarCollectionName, OutputType.REPLACE, query);
            Map<String, Object> scope = new HashMap<String, Object>();
            scope.put("maxValue", 1);
            command.setScope(scope);
            command.setOutputDB(MongoConstants.analysisMiddleDB);
            command.setFinalize(finalize.toString());
            MapReduceOutput out = coll.mapReduce(command);
            if (out != null)
            {
                DBCollection subColl = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisMiddleDB, tarCollectionName);

                String mapFunction = "function(){emit(this.value.browse_period,1);}";
                String reduceFunction = "function(key,reduced){var count=0;reduced.forEach(function(val){count+=val;});return count;}";
                MapReduceCommand subCommand = new MapReduceCommand(subColl, mapFunction, reduceFunction, null, OutputType.INLINE, null);
                MapReduceOutput outObj = subColl.mapReduce(subCommand);

                result = new ArrayList<ColumnVO>();
                for (DBObject obj : outObj.results())
                {
                    ColumnVO column = new ColumnVO();
                    column.setLable(obj.get("_id").toString());
                    column.setValue(new Double((obj.get("value").toString())).longValue());
                    result.add(column);
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("getOpenCryoutFrequency error:", e);
        }
        return result;
    }

    @Override
    public List<ColumnVO> getCollectionCouponsFrequency(String shopId, String startDate, String endDate, List<Account> accounts, String uuid)
    {
        List<ColumnVO> result = null;

        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BROWSE);
        try
        {
            BasicDBObject query = new BasicDBObject();
            query.append("shopId", shopId);
            query.append("timestamp", new BasicDBObject("$gte", TimeUtils.convertStringToDate(startDate)).append("$lte", TimeUtils.convertStringToDate(endDate)));
            query.append("userId", new BasicDBObject("$in", this.getAccountList(accounts)));
            query.append("coupon", new BasicDBObject("$exists", true));

            StringBuffer map = new StringBuffer();
            map.append("function() {");
            map.append("var key = this.userId;");
            map.append("var value = {coupon_collect_times:1,coupon_collect_period:''};");
            map.append("emit(key,value);");
            map.append("}");

            StringBuffer reduce = new StringBuffer();
            reduce.append("function(key, values) {");
            reduce.append("var reduced = {coupon_collect_times:0,coupon_collect_period:''};");
            reduce.append("values.forEach(function(val) {");
            reduce.append("reduced.coupon_collect_times +=1;");
            reduce.append("});");
            reduce.append("if(reduced.coupon_collect_times>maxValue){maxValue=reduced.coupon_collect_times;}");
            reduce.append("return reduced;");
            reduce.append("}");

            StringBuffer finalize = new StringBuffer();
            finalize.append("function(key, reduced) {");
            finalize.append("var quater=Math.ceil(maxValue/4);");
            finalize.append("if(reduced.coupon_collect_times<quater){reduced.coupon_collect_period='[0-'+quater.toFixed(0)+']';}");
            finalize.append("else if(reduced.coupon_collect_times<quater*2){reduced.coupon_collect_period='['+quater.toFixed(0)+'-'+(quater*2).toFixed(0)+']';}");
            finalize.append("else if(reduced.coupon_collect_times<quater*3){reduced.coupon_collect_period='['+(quater*2).toFixed(0)+'-'+(quater*3).toFixed(0)+']';}");
            finalize.append("else{reduced.coupon_collect_period='['+3*quater.toFixed(0)+'+]';}");
            finalize.append("return reduced;");
            finalize.append("}");

            String tarCollectionName = this.getCollectionName(shopId, startDate, endDate, uuid);
            MapReduceCommand command = new MapReduceCommand(coll, map.toString(), reduce.toString(), tarCollectionName, OutputType.REPLACE, query);
            Map<String, Object> scope = new HashMap<String, Object>();
            scope.put("maxValue", 1);
            command.setScope(scope);
            command.setOutputDB(MongoConstants.analysisMiddleDB);
            command.setFinalize(finalize.toString());
            MapReduceOutput out = coll.mapReduce(command);
            if (out != null)
            {
                DBCollection subColl = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisMiddleDB, tarCollectionName);

                String mapFunction = "function(){emit(this.value.coupon_collect_period,1);}";
                String reduceFunction = "function(key,reduced){var count=0;reduced.forEach(function(val){count+=val;});return count;}";
                MapReduceCommand subCommand = new MapReduceCommand(subColl, mapFunction, reduceFunction, null, OutputType.INLINE, null);
                MapReduceOutput outObj = subColl.mapReduce(subCommand);

                result = new ArrayList<ColumnVO>();
                for (DBObject obj : outObj.results())
                {
                    ColumnVO column = new ColumnVO();
                    column.setLable(obj.get("_id").toString());
                    column.setValue(new Double((obj.get("value").toString())).longValue());
                    result.add(column);
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("getCollectionCouponsFrequency error:", e);
        }
        return result;
    }

    @Override
    public List<ColumnVO> getCryoutResponseTime(String shopId, String startDate, String endDate, List<Account> accounts, String uuid)
    {
        List<ColumnVO> result = null;

        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BROWSE);
        try
        {
            BasicDBObject query = new BasicDBObject();
            query.append("shopId", shopId);
            query.append("timestamp", new BasicDBObject("$gte", TimeUtils.convertStringToDate(startDate)).append("$lte", TimeUtils.convertStringToDate(endDate)));
            query.append("userId", new BasicDBObject("$in", this.getAccountList(accounts)));
            //些处加条件，过滤只是浏览吆喝渠道的记录
            //query.append("source", new BasicDBObject("$exists", true));       

            StringBuffer map = new StringBuffer();
            map.append("function() {");
            map.append("var key = this.userId;");
            map.append("var value = {browse_times:1,response_time:this.timestamp-this.pushTime,avg_response_time:0,response_time_period:''};");
            map.append("emit(key,value);");
            map.append("}");

            StringBuffer reduce = new StringBuffer();
            reduce.append("function(key, values) {");
            reduce.append("var reduced = {browse_times:0,response_time:0,avg_response_time:0,response_time_period:''};");
            reduce.append("values.forEach(function(val) {");
            reduce.append("reduced.browse_times +=1;");
            reduce.append("reduced.response_time += val.response_time;");
            reduce.append("});");
            reduce.append("if(reduced.response_time>maxValue){maxValue=reduced.response_time;}");
            reduce.append("return reduced;");
            reduce.append("}");

            StringBuffer finalize = new StringBuffer();
            finalize.append("function(key, reduced) {");
            finalize.append("var quater=Math.ceil(maxValue/4);");
            finalize.append("if(reduced.avg_response_time<quater){reduced.response_time_period='[0-'+quater.toFixed(0)+']';}");
            finalize.append("else if(reduced.avg_response_time<quater*2){reduced.response_time_period='['+quater.toFixed(0)+'-'+(quater*2).toFixed(0)+']';}");
            finalize.append("else if(reduced.avg_response_time<quater*3){reduced.response_time_period='['+(quater*2).toFixed(0)+'-'+(quater*3).toFixed(0)+']';}");
            finalize.append("else{reduced.response_time_period='['+3*quater.toFixed(0)+'+]';}");
            finalize.append("return reduced;");
            finalize.append("}");

            String tarCollectionName = this.getCollectionName(shopId, startDate, endDate, uuid);
            MapReduceCommand command = new MapReduceCommand(coll, map.toString(), reduce.toString(), tarCollectionName, OutputType.REPLACE, query);
            Map<String, Object> scope = new HashMap<String, Object>();
            scope.put("maxValue", 1);
            command.setScope(scope);
            command.setOutputDB(MongoConstants.analysisMiddleDB);
            command.setFinalize(finalize.toString());
            MapReduceOutput out = coll.mapReduce(command);
            if (out != null)
            {
                DBCollection subColl = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisMiddleDB, tarCollectionName);

                String mapFunction = "function(){emit(this.value.response_time_period,1);}";
                String reduceFunction = "function(key,reduced){var count=0;reduced.forEach(function(val){count+=val;});return count;}";
                MapReduceCommand subCommand = new MapReduceCommand(subColl, mapFunction, reduceFunction, null, OutputType.INLINE, null);
                MapReduceOutput outObj = subColl.mapReduce(subCommand);

                result = new ArrayList<ColumnVO>();
                for (DBObject obj : outObj.results())
                {
                    ColumnVO column = new ColumnVO();
                    column.setLable(obj.get("_id").toString());
                    column.setValue(new Double((obj.get("value").toString())).longValue());
                    result.add(column);
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("getCryoutResponseTime error:", e);
        }
        return result;
    }

    @Override
    public List<ColumnVO> getNoticeResponseTime(String shopId, String startDate, String endDate, List<Account> accounts, String uuid)
    {
        List<ColumnVO> result = null;

        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BROWSE);
        try
        {
            BasicDBObject query = new BasicDBObject();
            query.append("shopId", shopId);
            query.append("timestamp", new BasicDBObject("$gte", TimeUtils.convertStringToDate(startDate)).append("$lte", TimeUtils.convertStringToDate(endDate)));
            query.append("userId", new BasicDBObject("$in", this.getAccountList(accounts)));
            //些处加条件，过滤只是浏览通知渠道的记录
            //query.append("source", new BasicDBObject("$exists", true));       

            StringBuffer map = new StringBuffer();
            map.append("function() {");
            map.append("var key = this.userId;");
            map.append("var value = {browse_times:1,response_time:this.timestamp-this.pushTime,avg_response_time:0,response_time_period:''};");
            map.append("emit(key,value);");
            map.append("}");

            StringBuffer reduce = new StringBuffer();
            reduce.append("function(key, values) {");
            reduce.append("var reduced = {browse_times:0,response_time:0,avg_response_time:0,response_time_period:''};");
            reduce.append("values.forEach(function(val) {");
            reduce.append("reduced.browse_times +=1;");
            reduce.append("reduced.response_time += val.response_time;");
            reduce.append("});");
            reduce.append("if(reduced.response_time>maxValue){maxValue=reduced.response_time;}");
            reduce.append("return reduced;");
            reduce.append("}");

            StringBuffer finalize = new StringBuffer();
            finalize.append("function(key, reduced) {");
            finalize.append("var quater=Math.ceil(maxValue/4);");
            finalize.append("if(reduced.avg_response_time<quater){reduced.response_time_period='[0-'+quater.toFixed(0)+']';}");
            finalize.append("else if(reduced.avg_response_time<quater*2){reduced.response_time_period='['+quater.toFixed(0)+'-'+(quater*2).toFixed(0)+']';}");
            finalize.append("else if(reduced.avg_response_time<quater*3){reduced.response_time_period='['+(quater*2).toFixed(0)+'-'+(quater*3).toFixed(0)+']';}");
            finalize.append("else{reduced.response_time_period='['+3*quater.toFixed(0)+'+]';}");
            finalize.append("return reduced;");
            finalize.append("}");

            String tarCollectionName = this.getCollectionName(shopId, startDate, endDate, uuid);
            MapReduceCommand command = new MapReduceCommand(coll, map.toString(), reduce.toString(), tarCollectionName, OutputType.REPLACE, query);
            Map<String, Object> scope = new HashMap<String, Object>();
            scope.put("maxValue", 1);
            command.setScope(scope);
            command.setOutputDB(MongoConstants.analysisMiddleDB);
            command.setFinalize(finalize.toString());
            MapReduceOutput out = coll.mapReduce(command);
            if (out != null)
            {
                DBCollection subColl = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisMiddleDB, tarCollectionName);

                String mapFunction = "function(){emit(this.value.response_time_period,1);}";
                String reduceFunction = "function(key,reduced){var count=0;reduced.forEach(function(val){count+=val;});return count;}";
                MapReduceCommand subCommand = new MapReduceCommand(subColl, mapFunction, reduceFunction, null, OutputType.INLINE, null);
                MapReduceOutput outObj = subColl.mapReduce(subCommand);

                result = new ArrayList<ColumnVO>();
                for (DBObject obj : outObj.results())
                {
                    ColumnVO column = new ColumnVO();
                    column.setLable(obj.get("_id").toString());
                    column.setValue(new Double((obj.get("value").toString())).longValue());
                    result.add(column);
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("getCryoutResponseTime error:", e);
        }
        return result;
    }

    @Override
    public List<ColumnVO> getFavoritesCategory(String shopId, String startDate, String endDate, List<Account> accounts, String uuid)
    {
        List<ColumnVO> result = null;

        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_FAVORITES);
        try
        {
            BasicDBObject query = new BasicDBObject();
            query.append("shopId", shopId);
            query.append("timestamp", new BasicDBObject("$gte", TimeUtils.convertStringToDate(startDate)).append("$lte", TimeUtils.convertStringToDate(endDate)));
            query.append("userId", new BasicDBObject("$in", this.getAccountList(accounts)));

            StringBuffer map = new StringBuffer();
            map.append("function() {");
            map.append("var key = this.category;");
            map.append("var value = {times:1,period:''};");
            map.append("emit(key,value);");
            map.append("}");

            StringBuffer reduce = new StringBuffer();
            reduce.append("function(key, values) {");
            reduce.append("var reduced = {times:0,period:''};");
            reduce.append("values.forEach(function(val) {");
            reduce.append("reduced.times +=1;");
            reduce.append("});");
            reduce.append("if(reduced.times>maxValue){maxValue=reduced.times;}");
            reduce.append("return reduced;");
            reduce.append("}");

            StringBuffer finalize = new StringBuffer();
            finalize.append("function(key, reduced) {");
            finalize.append("var quater=Math.ceil(maxValue/4);");
            finalize.append("if(reduced.times<quater){reduced.period='[0-'+quater.toFixed(0)+']';}");
            finalize.append("else if(reduced.times<quater*2){reduced.period='['+quater.toFixed(0)+'-'+(quater*2).toFixed(0)+']';}");
            finalize.append("else if(reduced.times<quater*3){reduced.period='['+(quater*2).toFixed(0)+'-'+(quater*3).toFixed(0)+']';}");
            finalize.append("else{reduced.period='['+3*quater.toFixed(0)+'+]';}");
            finalize.append("return reduced;");
            finalize.append("}");

            String tarCollectionName = this.getCollectionName(shopId, startDate, endDate, uuid);
            MapReduceCommand command = new MapReduceCommand(coll, map.toString(), reduce.toString(), tarCollectionName, OutputType.REPLACE, query);
            Map<String, Object> scope = new HashMap<String, Object>();
            scope.put("maxValue", 1);
            command.setScope(scope);
            command.setOutputDB(MongoConstants.analysisMiddleDB);
            command.setFinalize(finalize.toString());
            MapReduceOutput out = coll.mapReduce(command);
            if (out != null)
            {
                DBCollection subColl = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisMiddleDB, tarCollectionName);

                String mapFunction = "function(){emit(this.value.period,1);}";
                String reduceFunction = "function(key,reduced){var count=0;reduced.forEach(function(val){count+=val;});return count;}";
                MapReduceCommand subCommand = new MapReduceCommand(subColl, mapFunction, reduceFunction, null, OutputType.INLINE, null);
                MapReduceOutput outObj = subColl.mapReduce(subCommand);

                result = new ArrayList<ColumnVO>();
                for (DBObject obj : outObj.results())
                {
                    ColumnVO column = new ColumnVO();
                    column.setLable(obj.get("_id").toString());
                    column.setValue(new Double((obj.get("value").toString())).longValue());
                    result.add(column);
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("getNumberOfArriveShop error:", e);
        }
        return result;
    }

    @Override
    public List<ColumnVO> getConsumeCategory(String shopId, String startDate, String endDate, List<Account> accounts, String uuid)
    {
        List<ColumnVO> result = null;
        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BILL);
        BasicDBObject query = new BasicDBObject();
        try
        {
            query.put("shopId", shopId);
            query.append("timestamp", new BasicDBObject("$gte", TimeUtils.convertStringToDate(startDate)).append("$lte", TimeUtils.convertStringToDate(endDate)));
            query.append("userId", new BasicDBObject("$in", this.getAccountList(accounts)));
            DBCursor cursor = coll.find(query);
            Map<String, Integer> map = new HashMap<String, Integer>();
            while (cursor.hasNext())
            {
                DBObject next = cursor.next();
                @SuppressWarnings("unchecked")
                List<String> category = (List<String>) next.get("category");
                for (String s : category)
                {
                    if (map.get(s) != null)
                    {
                        map.put(s, map.get(s) + 1);
                    }
                    else
                    {
                        map.put(s, 1);
                    }
                }
            }
            Map<String, Integer> newMap = sortByValue(map, true);
            for (Entry<String, Integer> entry : newMap.entrySet())
            {
                ColumnVO column = new ColumnVO();
                column.setLable(entry.getKey());
                column.setValue(entry.getValue());
                result.add(column);
            }

        }
        catch (Exception e)
        {
            GooagooLog.error("getNumberOfArriveShop error:", e);
        }

        return result;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static Map sortByValue(Map map, final boolean reverse)
    {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                if (reverse)
                {
                    return -((Comparable) ((Map.Entry) o1).getValue()).compareTo(((Map.Entry) o2).getValue());
                }
                return ((Comparable) ((Map.Entry) o1).getValue()).compareTo(((Map.Entry) o2).getValue());
            }
        });

        Map result = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();)
        {
            Map.Entry entry = (Map.Entry) it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    private String getCollectionName(String shopId, String startDate, String endDate, String uuid)
    {
        return "temp_" + shopId + "_" + startDate + "_" + endDate + "_" + uuid;
    }

    private BasicDBList getAccountList(List<Account> accounts)
    {
        BasicDBList idList = new BasicDBList();
        if (accounts != null)
        {
            for (Account user : accounts)
            {
                if (user.getAccountNo() != null)
                {
                    idList.add(user.getAccountNo());
                }
            }
        }
        return idList;
    }
}
