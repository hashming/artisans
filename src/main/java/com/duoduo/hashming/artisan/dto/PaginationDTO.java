package com.duoduo.hashming.artisan.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;//问题的列表（分页后的数据）
    private boolean showPrevious;//显示前一页按钮
    private boolean showFirstPage;//显示首页按钮
    private boolean showNext;//显示下一页
    private boolean showEndPage;//显示最终页按钮
    private Integer page;//当前的页数
    private Integer totalPage;//总共可以分几个页数  如果是totalcount是11个数据，然后这里是3
    private List<Integer> pages = new ArrayList<>();//页数标签所包含的页数

    /**
     * 这个方法为了给pages中添加元素所以不需要返回值。
     * @param totalCount
     * @param pageNum
     * @param pageSize
     */
    public void setPagination(Integer totalPage, Integer pageNum) {//默认情况下pagenum是1 pagesize是5
        this.totalPage=totalPage;
        this.page=pageNum;
        pages.add(pageNum);//如果是3 1234567
        for (int i = 1; i <=3; i++) {
            if (pageNum-i>0){
                pages.add(0,pageNum-i);
            }

            if (pageNum+i<=totalPage){//这里应该是totalpage并不是totalcount
                pages.add(pageNum+i);
            }
        }


        if (pageNum<1){
            pageNum=1;
        }
        if (pageNum>totalPage){
            pageNum=totalPage;
        }
        this.page = pageNum;



        //是否展示上一页
        if (pageNum == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        //是否展示下一页
        if (pageNum == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }

        //是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        //是否展示 最后一页
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else{
            showEndPage = true;
        }

    }
}

