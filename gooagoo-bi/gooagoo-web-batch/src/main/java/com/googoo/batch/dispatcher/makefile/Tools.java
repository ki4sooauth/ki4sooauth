package com.googoo.batch.dispatcher.makefile;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gooagoo.api.business.query.statistics.UseStatisticQueryService;
import com.gooagoo.api.generator.query.shop.ShopToolListGeneratorQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.shop.ShopToolList;
import com.gooagoo.entity.generator.shop.ShopToolListExample;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.vo.hightChartVo.chartVo.LineChartVo;
import com.googoo.batch.constants.BatchConsants;
import com.googoo.batch.utils.FileUtils;

//@Engine(BatchTimeCnstants.onMidnight)
public class Tools implements Tyre
{

    private final UseStatisticQueryService useStatisticService = SpringBeanUtils.getBean(UseStatisticQueryService.class);
    private final ShopToolListGeneratorQueryService toolListGeneratorQueryService = SpringBeanUtils.getBean(ShopToolListGeneratorQueryService.class);

    private static final String[] USER_TYPE = { "A", "M", "N" };
    private static final String[] DATETYPE = { "Y", "M", "D", "H", "*" };

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 Tools");
        this.makeToolsFile();
    }

    private void makeToolsFile()
    {
        List<Integer> useList = null;
        ShopToolListExample toolListExample = new ShopToolListExample();
        toolListExample.createCriteria().andIsDelEqualTo("N");
        toolListExample.createCriteria().andStatusEqualTo("P");
        List<ShopToolList> selectByExample = this.toolListGeneratorQueryService.selectByExample(toolListExample);

        for (String uType : USER_TYPE)
        {
            for (String tType : DATETYPE)
            {
                for (ShopToolList tools : selectByExample)
                {
                    useList = new ArrayList<Integer>(0);
                    List<String> dateList = new ArrayList<String>(0);
                    if ("Y".equals(tType))
                    {
                        for (int i = 1; i < 5; i++)
                        {
                            Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_YEAR, new Date(), 0 - i);
                            dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy"));
                            int browsTimes = this.useStatisticService.toolUseTimes(tools.getShopId(), tools.getId(), tType, uType, tempDate);
                            useList.add(browsTimes);
                        }
                    }
                    else if ("M".equals(tType))
                    {
                        for (int i = 1; i < 12; i++)
                        {
                            Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_MONTH, new Date(), 0 - i);
                            dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM"));
                            int browsTimes = this.useStatisticService.toolUseTimes(tools.getShopId(), tools.getId(), tType, uType, tempDate);
                            useList.add(browsTimes);
                        }
                    }
                    else if ("D".equals(tType))
                    {
                        for (int i = 1; i < 20; i++)
                        {
                            Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, new Date(), 0 - i);
                            dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd"));
                            int browsTimes = this.useStatisticService.toolUseTimes(tools.getShopId(), tools.getId(), tType, uType, tempDate);
                            useList.add(browsTimes);
                        }
                    }
                    else if ("H".equals(tType))
                    {
                        for (int i = 1; i < 24; i++)
                        {
                            Date tempDate = TimeUtils.dateAdd(TimeUtils.DATATYPE_HOUR, new Date(), 0 - i);
                            dateList.add(TimeUtils.convertDateToString(tempDate, "yyyy-MM-dd HH"));
                            int browsTimes = this.useStatisticService.toolUseTimes(tools.getShopId(), tools.getId(), tType, uType, tempDate);
                            useList.add(browsTimes);
                        }
                    }
                    else
                    {
                        int browsTimes = this.useStatisticService.toolUseTimes(tools.getShopId(), tools.getId(), null, uType, null);
                        useList.add(browsTimes);
                    }

                    Map<String, List<?>> dataMap = new HashMap<String, List<?>>();
                    dataMap.put("使用", useList);
                    LineChartVo chartVo = new LineChartVo();
                    String chartStr = chartVo.create("服务工具统计", "人次", "次", dateList, dataMap);
                    //String fileName = FileUtils.getFileName(null, tools.getId(), tType, s, null);
                    String fileName = FileUtils.getfileName(tools.getId(), tType, uType, null, null);
                    FileUtils.createAndWriteFile(BatchConsants.TOOLS, chartStr, fileName);
                }
            }
        }
    }
}
