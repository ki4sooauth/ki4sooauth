package com.gooagoo.api.business.core.user.favorite;

import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.exception.business.user.AlreadyCollectException;
import com.gooagoo.exception.business.user.AlreadyExceedUserOwnCouponNumException;
import com.gooagoo.exception.business.user.CouponAlreadyPastPublishEndTimeException;
import com.gooagoo.exception.business.user.FavoriteNotExistOrDeletedException;
import com.gooagoo.exception.common.OperateFailException;

public interface FavoriteCoreService

{

    /**
     * 收藏
     * @param favoriteInfo
     * @return
     * @throws AlreadyCollectException 已收藏异常
     * @throws FavoriteNotExistOrDeletedException 收藏信息不存在或已删除异常
     * @throws CouponAlreadyPastPublishEndTimeException 优惠凭证已过发行期异常
     * @throws AlreadyExceedUserOwnCouponNumException 已超过用户拥有优惠券最大个数异常
     */
    public boolean addFavorite(FavoriteInfo favoriteInfo) throws Exception;

    /**
     * 删除收藏
     * <br>
     * 支持多个删除,多个ID用英文半角逗号隔开
     * @param favoriteIds
     * @return true/false
     * @throws OperateFailException
     */
    public boolean deleteFavorite(String favoriteIds) throws Exception;

}
