package com.gooagoo.igus.comment.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.user.comment.CommentQueryService;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.user.UserCommentDetail;
import com.gooagoo.entity.generator.behave.UserCommentExample;
import com.gooagoo.igus.comment.service.ICommentService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.comment.UComment;

@Service("iCommentService")
public class ICommentServiceImpl implements ICommentService
{

    @Autowired
    private CommentQueryService commentQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.COMMENT_GETCOMMENTLIST)
    public TransData<Object> getCommentList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Date start = TimeUtils.convertStringToDate(ServletRequestUtils.getStringParameter(request, "start"));
            Date end = TimeUtils.convertStringToDate(ServletRequestUtils.getStringParameter(request, "end"));
            String commentType = ServletRequestUtils.getStringParameter(request, "commentType");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 8);
            UserCommentExample queryCondition = new UserCommentExample();
            if (StringUtils.isBlank(commentType))
            {
                queryCondition.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N").andCreateTimeBetween(start, end);
            }
            else
            {
                queryCondition.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N").andCreateTimeBetween(start, end).andCommentTypeEqualTo(commentType);
            }
            queryCondition.setPage(pageIndex, pageSize);
            queryCondition.setOrderByClause("create_time DESC");
            List<UserCommentDetail> userCommentDetailList = this.commentQueryService.findUserCommentList(queryCondition);
            if (CollectionUtils.isEmpty(userCommentDetailList))
            {
                GooagooLog.info("获取评论列表:没有查到相关的评论信息");
                return new TransData<Object>(true, MessageConst.COMMENT_ICOMMENT_GETCOMMENTLIST_NOTEXIST, null);
            }
            List<UComment> ucommentList = new ArrayList<UComment>();
            for (UserCommentDetail userCommentDetail : userCommentDetailList)
            {
                try
                {
                    UComment ucomment = new UComment();
                    ucomment.setShopName(userCommentDetail.getShopName());
                    ucomment.setGoodsId(userCommentDetail.getGoodsId());
                    ucomment.setGoodsName(userCommentDetail.getGoodsName());
                    ucomment.setCommentType(SysdictionaryCache.get("comment_type", userCommentDetail.getCommentType()));
                    ucomment.setCommentLevel(userCommentDetail.getCommentLevel());
                    ucomment.setContent(userCommentDetail.getContent());
                    ucomment.setCommentTime(TimeUtils.convertDateToString(userCommentDetail.getCommentTime(), "yyyy年MM月dd日"));
                    ucommentList.add(ucomment);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取评论列表：组装单个评论信息异常", e);
                }
            }

            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ucommentList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取评论列表：获取评论列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

}
