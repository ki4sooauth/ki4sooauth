package com.gooagoo.gus.comment.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

@Controller
@RequestMapping("/comment")
public class CommentAction extends BaseAction
{

    /*
     * 访问首页
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        int currentYear = ca.get(Calendar.YEAR);//获取年份
        request.setAttribute("currentYear", currentYear);
        request.setAttribute("startYear", currentYear - 1);

        Calendar noticeDate = Calendar.getInstance();
        request.setAttribute("noticeEnd", sdf.format(noticeDate.getTime()));
        noticeDate.set(Calendar.YEAR, noticeDate.get(Calendar.YEAR) - 1);
        request.setAttribute("noticeStart", sdf.format(noticeDate.getTime()));
        return "/comment/index";
    }

    /**
     * 获取评论列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=show")
    public String show(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("pageSize", 8);
        TransData<Object> userCommentList = GusClientUtils.transfer(request, InterGusConstants.COMMENT_GETCOMMENTLIST);
        request.setAttribute("Commentlist", userCommentList.getData());
        request.setAttribute("message", ExceptionCache.get(userCommentList.getHead().getResultCode()));
        String num = request.getParameter("num");
        if (num.equals("1"))
        {
            return "/comment/comentlistO";
        }
        if (num.equals("2"))
        {
            return "/comment/comentlist";
        }
        return null;
    }

}
