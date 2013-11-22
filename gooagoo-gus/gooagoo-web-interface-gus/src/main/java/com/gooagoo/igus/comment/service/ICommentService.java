package com.gooagoo.igus.comment.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;


public interface ICommentService
{
   /**
    * 获取评论列表
    * @param request
    * @return
    */
    public TransData<Object> getCommentList(HttpServletRequest request);


}
