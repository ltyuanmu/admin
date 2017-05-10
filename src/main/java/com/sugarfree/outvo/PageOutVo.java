package com.sugarfree.outvo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页对象
 */
public class PageOutVo<T> implements Serializable{
    private int pageNo = 1; // 当前页码
    private int pageSize = 10; // 页面大小，设置为“-1”表示不进行分页（分页无效）
    private long count;// 总记录数，设置为“-1”表示不查询总数
    private int first;// 首页索引
    private int last;// 尾页索引
    @SuppressWarnings("unused")
    private int prev;// 上一页索引
    @SuppressWarnings("unused")
    private int next;// 下一页索引
    private boolean firstPage;//是否是第一页
    private boolean lastPage;//是否是最后一页

    private List<T> list = new ArrayList<>();


    public PageOutVo() {
        this.pageSize = -1;
    }


    /**
     * 构造方法
     * @param pageNo 当前页码
     * @param pageSize 分页大小
     */
    public PageOutVo(String pageNo, String pageSize){
        // 设置页码参数（传递repage参数，来记住页码）
        String no = pageNo;
        if (StringUtils.isNumeric(no)){
            this.setPageNo(Integer.parseInt(no));
        }

        // 设置页面大小参数（传递repage参数，来记住页码大小）
        String size = pageSize;
        if (StringUtils.isNumeric(size)){
            this.setPageSize(Integer.parseInt(size));
        }

    }


    /**
     * 构造方法
     * @param pageNo 当前页码
     * @param pageSize 分页大小
     */
    public PageOutVo(int pageNo, int pageSize) {
        this(pageNo, pageSize, 0);
    }

    /**
     * 构造方法
     * @param pageNo 当前页码
     * @param pageSize 分页大小
     * @param count 数据条数
     */
    public PageOutVo(int pageNo, int pageSize, long count) {
        this(pageNo, pageSize, count, new ArrayList<>());
    }

    /**
     * 构造方法
     * @param pageNo 当前页码
     * @param pageSize 分页大小
     * @param count 数据条数
     * @param list 本页数据对象列表
     */
    public PageOutVo(int pageNo, int pageSize, long count, List<T> list) {
        this.setCount(count);
        this.setPageNo(pageNo);
        this.pageSize = pageSize;
        this.setList(list);
        initialize();
    }

    /**
     * 初始化参数
     */
    public void initialize(){

        //1
        this.first = 1;

        this.last = (int)(count / (this.pageSize < 1 ? 20 : this.pageSize) + first - 1);

        if (this.count % this.pageSize != 0 || this.last == 0) {
            this.last++;
        }

        if (this.last < this.first) {
            this.last = this.first;
        }

        if (this.pageNo <= 1) {
            this.pageNo = this.first;
            this.firstPage=true;
        }

        if (this.pageNo >= this.last) {
            this.pageNo = this.last;
            this.lastPage=true;
        }

        if (this.pageNo < this.last - 1) {
            this.next = this.pageNo + 1;
        } else {
            this.next = this.last;
        }

        if (this.pageNo > 1) {
            this.prev = this.pageNo - 1;
        } else {
            this.prev = this.first;
        }

        //2
        if (this.pageNo < this.first) {// 如果当前页小于首页
            this.pageNo = this.first;
        }

        if (this.pageNo > this.last) {// 如果当前页大于尾页
            this.pageNo = this.last;
        }

    }

    /**
     * 获取设置总数
     * @return
     */
    public long getCount() {
        return count;
    }

    /**
     * 设置数据总数
     * @param count
     */
    public void setCount(long count) {
        this.count = count;
        if (pageSize >= count){
            pageNo = 1;
        }
    }

    /**
     * 获取当前页码
     * @return
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 设置当前页码
     * @param pageNo
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 获取页面大小
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置页面大小（最大500）
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize <= 0 ? 10 : pageSize;
    }

    /**
     * 首页索引
     * @return
     */
    @JsonIgnore
    public int getFirst() {
        return first;
    }

    /**
     * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从1开始.
     */
    @JsonIgnore
    public int getFirstSize() {
        return ((pageNo - 1) * pageSize) + 1;
    }

    /**
     * 尾页索引
     * @return
     */
    @JsonIgnore
    public int getLast() {
        return last;
    }

    /**
     * 获取页面总数
     * @return getLast();
     */
    @JsonIgnore
    public int getTotalPage() {
        return getLast();
    }

    /**
     * 是否为第一页
     * @return
     */
    public boolean isFirstPage() {
        return firstPage;
    }

    /**
     * 是否为最后一页
     * @return
     */
    public boolean isLastPage() {
        return lastPage;
    }

    /**
     * 上一页索引值
     * @return
     */
    @JsonIgnore
    public int getPrev() {
        if (isFirstPage()) {
            return pageNo;
        } else {
            return pageNo - 1;
        }
    }

    /**
     * 下一页索引值
     * @return
     */
    @JsonIgnore
    public int getNext() {
        if (isLastPage()) {
            return pageNo;
        } else {
            return pageNo + 1;
        }
    }

    /**
     * 获取本页数据对象列表
     * @return List<T>
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 设置本页数据对象列表
     * @param list
     */
    public PageOutVo<T> setList(List<T> list) {
        this.list = list;
        return this;
    }

    /**
     * 获取 Hibernate FirstResult
     */
    @JsonIgnore
    public int getFirstResult(){
        int firstResult = (getPageNo() - 1) * getPageSize();
        if (firstResult >= getCount()) {
            firstResult = 0;
        }
        return firstResult;
    }

    @JsonIgnore
    public int getLastResult(){
        int lastResult = getFirstResult()+getMaxResults();
        if(lastResult>getCount()) {
            lastResult =(int) getCount();
        }
        return lastResult;
    }
    /**
     * 获取 Hibernate MaxResults
     */
    @JsonIgnore
    public int getMaxResults(){
        return getPageSize();
    }

}
