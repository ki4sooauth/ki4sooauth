package com.gooagoo.igms.shopinfo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.position.ShopPositionCoreService;
import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.shop.ShopPositionExample;
import com.gooagoo.entity.generator.shop.ShopPositionExample.Criteria;
import com.gooagoo.igms.shopinfo.service.IShopPositionService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.ZTreeNode;
import com.gooagoo.view.gms.shopinfo.FShopPosition;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service("ishopPositionService")
public class IShopPositionServiceImpl implements IShopPositionService {
	@Autowired
	private ShopPositionGeneratorQueryService positionQueryService;
	@Autowired
	private ShopPositionCoreService positionCoreService;
	@Autowired
	private ShopLoginService shopLoginService;

	@Override
	public TransData<FShopPosition> getShopPosition(HttpServletRequest request) throws Exception {
		String positionId = ServletRequestUtils.getStringParameter(request, "positionId", "");
		ShopPosition position = this.positionQueryService.selectByPrimaryKey(positionId);
		ShopPosition parentPositionName = this.positionQueryService.selectByPrimaryKey(position.getParentPositionId());
		FShopPosition fShopPosition = new FShopPosition();
		BeanUtils.copyProperties(position, fShopPosition);
		fShopPosition.setParentPositionName(parentPositionName != null ? parentPositionName.getPositionName() : "无父节点");
		return GMSUtil.toTransData(true, null, fShopPosition);
	}

	@Override
	public TransData<List<ZTreeNode>> getShopPositionZtree(HttpServletRequest request) throws Exception {
		String parentPositionId = ServletRequestUtils.getStringParameter(request, "parentPositionId", "");
		String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", null);
		if ("".equals(parentPositionId)) {
			parentPositionId = GMSConstant.POSITION_TOP_LEVEL;
		}
		ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);

		if (shopInfo.getShopAndUserInfo().getUserIsShopAccount().equals("N")) {
			shopEntityId = shopInfo.getShopAndUserInfo().getUserShopEntityId();
		}

		List<ZTreeNode> nodes = this.getShopPositionZtree0(shopInfo.getShopAndUserInfo().getShopId(), shopEntityId, parentPositionId);

		return GMSUtil.toTransData(true, null, nodes);
	}

	@Override
	public List<ZTreeNode> getShopPositionZtree0(String shopId, String shopEntityId, String parentPositionId) throws Exception {

		ShopPositionExample example = new ShopPositionExample();
		Criteria criteria = example.createCriteria();

		criteria.andShopIdEqualTo(shopId);
		if (!shopEntityId.isEmpty()) {
			criteria.andShopEntityIdEqualTo(shopEntityId);
		}
		criteria.andParentPositionIdEqualTo(parentPositionId);
		criteria.andIsDelEqualTo("N");
		List<ShopPosition> positions = this.positionQueryService.selectByExample(example);
		List<ZTreeNode> nodes = new ArrayList<ZTreeNode>();
		if (positions.size() == 0) {
			return nodes;
		}
		for (ShopPosition e : positions) {
			ZTreeNode node = new ZTreeNode(e.getPositionId(), e.getParentPositionId(), e.getPositionName(), false);
			nodes.add(node);
			List<ZTreeNode> temp = this.getShopPositionZtree0(shopId, shopEntityId, e.getPositionId());
			nodes.addAll(temp);
		}
		return nodes;
	}

	@Override
	public TransData<Object> updateShopPosition(HttpServletRequest request) throws Exception {
		ShopPosition fShopPosition = ServletUtils.objectMethod(ShopPosition.class, request);
		boolean flag = this.positionCoreService.updateShopPosition(fShopPosition);
		return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, fShopPosition.getPositionId());
	}

	@Override
	public TransData<Object> addShopPosition(HttpServletRequest request) throws Exception {
		String id = StringUtils.getUUID();
		ShopPosition fShopPosition = ServletUtils.objectMethod(ShopPosition.class, request);
		ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
		fShopPosition.setPositionId(id);
		fShopPosition.setShopId(shopInfo.getShopAndUserInfo().getShopId());
		fShopPosition.setIsDel("N");
		fShopPosition.setCreateTime(new Date());
		boolean flag = this.positionCoreService.addShopPosition(fShopPosition);
		TransData<Object> r = GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
		r.setData(id);
		return r;
	}

	@Override
	public TransData<Object> delShopPosition(HttpServletRequest request) throws Exception {
		String positionId = ServletRequestUtils.getStringParameter(request, "positionId", "");
		boolean flag = this.positionCoreService.deleteShopPosition(positionId);
		return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, positionId);
	}

	@Override
	public TransData<Object> importPositions(HttpServletRequest request) throws Exception {
		String fShopPositions = ServletRequestUtils.getStringParameter(request, "fShopPositions", "");
		String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
		List<FShopPosition> fShopPositionList = new Gson().fromJson(fShopPositions,new TypeToken<List<FShopPosition>>(){}.getType());
		List<ShopPosition> shopPositionList = new ArrayList<ShopPosition>();
		ShopPosition shopPosition = null;
		for (FShopPosition fshopPosition : fShopPositionList) {
			shopPosition = new ShopPosition();
			shopPosition.setPositionId(fshopPosition.getPositionId());
			shopPosition.setPositionName(fshopPosition.getPositionName());
			shopPosition.setParentPositionId(fshopPosition.getParentPositionId());
			shopPosition.setShopId(fshopPosition.getShopId());
			shopPosition.setShopEntityId(fshopPosition.getShopEntityId());
			shopPosition.setIsDel(GMSConstant.NO);
			shopPosition.setCreateTime(new Date());
			shopPositionList.add(shopPosition);
		}
        boolean flag = true;
		try {
			this.positionCoreService.importShopPosition(shopEntityId, shopPositionList);
		} catch (Exception e) {
			flag = false;
		}

		return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
	}

}
