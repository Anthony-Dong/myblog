package com.blogs.pojo;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:MPage
 * Package:com.blogs.pojo
 * Description:TODO
 *
 * @date:2019/8/26 18:34
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

@Setter
public class MPage <V> implements Serializable {
    private static final long serialVersionUID = 3150611738743692211L;

    @Override
    public String toString() {
        return "MPage{" +
                "total=" + total +
                ", currentPage=" + currentPage +
                ", pages=" + pages +
                ", size=" + size +
                ", content=" + content +
                '}';
    }

    public MPage(Long total, Integer currentPage, Integer size, List<V> content) {
        this.total = total;
        this.currentPage = currentPage;
        this.size = size;
        this.content = content;
    }

    private Long total;


    private Integer currentPage;


    private Integer pages;


    private Integer size;

    private List<V> content;

    public Long getTotal() {
        return total;
    }

    public List<V> getContent() {
        return content;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getPages() {
        return Math.toIntExact((total / size == 0 ? (total / size) : ((total / size) + 1)));
    }

    public Integer getSize() {
        return size;
    }
}
