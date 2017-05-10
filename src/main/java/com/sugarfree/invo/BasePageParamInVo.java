package com.sugarfree.invo;

import java.io.Serializable;

/**
 * 基础入参对象
* @Title: BaseInParamVo.java
* @Package cn.newtouch.yangyang.common.base.bean
* @author haijiang.mo@newtouch.cn
* @date 2015年12月3日 下午1:43:54
* @version V1.0
 */
public class BasePageParamInVo implements Serializable{

	private static final long serialVersionUID = 1L;

	/**分页对象，大小，默认10*/
	private Integer pageSize = 10;

	/**分页码，默认1*/
	private Integer pageNo = 1;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * 获取分页开始记录的num
	 * @author haijiang.mo
	 * @since 2015年12月4日
	 * @return
	 */
	public int getStartNum() {
		return (pageNo - 1) * pageSize;
	}
	/**
	 * 获取分页结束记录
	 * @author lijunhao
	 */
	public int getEndNum() {
		return pageSize;
	}
	/**
	 * 获取分页结束记录+1
	 * 为了获得hasMore
	 * @author lijunhao
	 */
	public int getEndNumMore() {
		return pageSize+1;
	}
	
}
