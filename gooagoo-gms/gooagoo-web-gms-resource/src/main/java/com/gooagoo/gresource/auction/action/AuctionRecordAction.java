package com.gooagoo.gresource.auction.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.resource.AllBiddingRecordView;
import com.gooagoo.view.gms.resource.ShopBiddingRecordView;
import com.gooagoo.view.gms.resource.WinBiddingRecordView;

@Controller
@RequestMapping("/auctionRecord")
public class AuctionRecordAction extends BaseAction {

	@RequestMapping(params = "method=toAllBidRList")
	public String toAuctionHisPage(HttpServletRequest request, HttpServletResponse response) {
		return "bidding/hisAllBidRList";
	}

	@RequestMapping(params = "method=fAllBidR")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String pageAllBiddingRecord(HttpServletRequest request, HttpServletResponse response) {
		TransData<PageModel> transData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_RESOURCE_PAGE_ALL_BID_RECORD, request, PageModel.class);
		PageModel<AllBiddingRecordView> model = transData.getData();
		if (model != null) {
			request.setAttribute("pageModel", model);
			request.setAttribute("page_cur", model.getPageIndex());
			request.setAttribute("page_start", model.getPageStart(5));
			request.setAttribute("page_end", model.getPageEnd(5));
		}
		return "webResource/auction/common/allHisBidRList";
	}

	@RequestMapping(params = "method=fWinBidR")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String pageWinBiddingRecord(HttpServletRequest request, HttpServletResponse response) {
		TransData<PageModel> transData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_RESOURCE_PAGE_WIN_BID_RECORD, request, PageModel.class);
		PageModel<WinBiddingRecordView> model = transData.getData();
		if (model != null) {
			request.setAttribute("pageModel", model);
			request.setAttribute("page_cur", model.getPageIndex());
			request.setAttribute("page_start", model.getPageStart(5));
			request.setAttribute("page_end", model.getPageEnd(5));
		}
		return "webResource/auction/common/hisWinBidRList";
	}

	@RequestMapping(params = "method=fShopBidR")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String pageShopBiddingRecord(HttpServletRequest request, HttpServletResponse response) {
		TransData<PageModel> transData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_RESOURCE_PAGE_SHOP_BID_RECORD, request, PageModel.class);
		PageModel<ShopBiddingRecordView> model = transData.getData();
		if (model != null) {
			request.setAttribute("pageModel", model);
			request.setAttribute("page_cur", model.getPageIndex());
			request.setAttribute("page_start", model.getPageStart(5));
			request.setAttribute("page_end", model.getPageEnd(5));
		}
		return "webResource/auction/common/hisShopBidRList";
	}

}
