package spring.dto.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页基础信息类，分页数、总记录数</br>
 * 如需返回分页信息，需继承该类，并增加业务相关返回信息
 *
 * @author wenwj
 * @date: 2017年11月15日 上午11:36:06
 * @since 1.0
 */
public class BasePage<T> implements Serializable{
	/**
	 * 页码
	 */
	@ApiModelProperty(value = "分页页码数")
	private int page;
	/**
	 * 分页条数
	 */
	@ApiModelProperty(value = "分页条数")
	private int pageSize;
	/**
	 * 分页总页数
	 */
	@ApiModelProperty(value = "分页总页数")
	private int pageCount;
	/**
	 * 记录总数
	 */
	@ApiModelProperty(value = "总记录数")
	private Long listCount;

	/**
	 * 返回的列表数据
	 */
	@ApiModelProperty(value = "分页列表结果数据")
	private List<T> list = new ArrayList<T>();

	/**
	 * 
	 * 功能描述: 添加分页列表数据<br>
	 * 
	 * @author: wenwj
	 * @date: 2017年11月15日 下午2:30:34
	 * @param t
	 *            待添加分页列表数据
	 */
	public void addT(T t) {
		this.list.add(t);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public Long getListCount() {
		return listCount;
	}

	public void setListCount(Long listCount) {
		this.listCount = listCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * 
	 * 功能描述: 设置分页信息<br>
	 * 
	 * @author: wenwj
	 * @date: 2017年11月15日 下午2:57:41
	 * @param page
	 *            页码
	 * @param pageSize
	 *            分页条数
	 * @param pageCount
	 *            总页数
	 * @param total
	 *            总记录数
	 */
	public void setPageInfo(int page, int pageSize, int pageCount, Long listCount) {
		this.page = page;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.listCount = listCount;
	}


	@Override
	public String toString() {
		return "BasePage{" +
				"page=" + page +
				", pageSize=" + pageSize +
				", pageCount=" + pageCount +
				", listCount=" + listCount +
				", list=" + list +
				'}';
	}
}
