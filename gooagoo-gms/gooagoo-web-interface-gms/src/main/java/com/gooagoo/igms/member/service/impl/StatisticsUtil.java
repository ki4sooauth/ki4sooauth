package com.gooagoo.igms.member.service.impl;

public class StatisticsUtil {
	/**
	 * 获取list中部分元素起始下标
	 * 
	 * @param index
	 * @param pageSize
	 * @param listSize
	 * @return
	 */
	public static Integer getFromIndex(int index, int pageSize, int listSize) {
		int formIndex = index;
		if (index >= listSize) {
			formIndex = listSize - pageSize;
		} else if (index < 0) {
			formIndex = 0;
		}
		return formIndex;
	}

	/**
	 * 获取list中部分元素结束下标
	 * 
	 * @param index
	 * @param pageSize
	 * @param listSize
	 * @return
	 */
	public static Integer getToIndex(int index, int pageSize, int listSize) {
		int toIndex = index + pageSize;
		if (toIndex > listSize) {
			toIndex = listSize;
		}
		return toIndex;
	}
}
