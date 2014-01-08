package com.wzm.github;


import java.io.Serializable;
import java.util.List;

/**
 * 分页处理类
 * 
 * @date 2012/12/25 9:19
 * @author Sean
 * 
 * @param <T>
 */
public class PagerControl<T> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4297791392014177523L;
    private List<T>           entityList;
    private PageInfo          pageInfo;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    /**
     * 获取分页列表集合
     * 
     */
    public List<T> getEntityList() {
        return entityList;
    }

    /**
     * 放入分页列表集合
     * 
     */
    public void setEntityList(List<T> entityList) {
        this.entityList = entityList;
    }

	@Override
	public String toString() {
		return "PagerControl [entityList=" + entityList + ", pageInfo="
				+ pageInfo + "]";
	}

    

}
