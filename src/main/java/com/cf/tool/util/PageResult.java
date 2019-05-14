package com.cf.tool.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: tool
 * @description: 分页
 * @author: cf
 * @create: 2019-05-09 11:27
 */
public class PageResult<T> {

    private List<T> content = new ArrayList<>();

    private long total;// 总个数

//	private PageSimpleQuery pageQuery;
//
//	private boolean first;// 是否首页
//
//	private boolean last;// 是否末页
//
//	private int prevNumber;
//
//	private int nextNumber;
//
//	private int number;// 总个数
//	private int numberOfElements;// 当前页面的最大个数
//	private int size; // 页面pagesize
//	private int totalPages;// 总页数

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        if ( content == null) {
            content = new ArrayList<>();
        }
        this.content = content;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

	/*public void setPageQuery(PageSimpleQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public int getPrevNumber() {
		return prevNumber;
	}

	public void setPrevNumber(int prevNumber) {
		this.prevNumber = prevNumber;
	}

	public int getNextNumber() {
		return nextNumber;
	}

	public void setNextNumber(int nextNumber) {
		this.nextNumber = nextNumber;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumberOfElements() {
		return this.numberOfElements;
	}

	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}*/

}
