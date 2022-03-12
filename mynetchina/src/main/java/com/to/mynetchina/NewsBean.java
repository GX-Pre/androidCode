package com.to.mynetchina;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

import lombok.EqualsAndHashCode;

@lombok.NoArgsConstructor
@lombok.Data
@EqualsAndHashCode(callSuper=false)
public class NewsBean extends BasePageBean<NewsBean.ResultDTO.ItemsDTO> {

    @com.fasterxml.jackson.annotation.JsonProperty("code")
    private Integer code;
    @com.fasterxml.jackson.annotation.JsonProperty("message")
    private String message;
    @com.fasterxml.jackson.annotation.JsonProperty("result")
    private ResultDTO result;
    @com.fasterxml.jackson.annotation.JsonProperty("time")
    private String time;


    @Override
    public List getItemDatas() {
        return result.items;
    }

    @lombok.NoArgsConstructor
    @lombok.Data
    public static class ResultDTO {
        @com.fasterxml.jackson.annotation.JsonProperty("items")
        private List<ItemsDTO> items;
        @com.fasterxml.jackson.annotation.JsonProperty("nextPageToken")
        private String nextPageToken;
        @com.fasterxml.jackson.annotation.JsonProperty("prevPageToken")
        private String prevPageToken;
        @com.fasterxml.jackson.annotation.JsonProperty("requestCount")
        private Integer requestCount;
        @com.fasterxml.jackson.annotation.JsonProperty("responseCount")
        private Integer responseCount;
        @com.fasterxml.jackson.annotation.JsonProperty("totalResults")
        private Integer totalResults;

        @lombok.NoArgsConstructor
        @lombok.Data
        public static class ItemsDTO {
            @com.fasterxml.jackson.annotation.JsonProperty("author")
            public String author;
            @com.fasterxml.jackson.annotation.JsonProperty("body")
            public String body;
            @com.fasterxml.jackson.annotation.JsonProperty("commentCount")
            public Integer commentCount;
            @com.fasterxml.jackson.annotation.JsonProperty("href")
            public String href;
            @com.fasterxml.jackson.annotation.JsonProperty("id")
            public Integer id;
            @com.fasterxml.jackson.annotation.JsonProperty("pubDate")
            public String pubDate;
            @com.fasterxml.jackson.annotation.JsonProperty("recommend")
            public Boolean recommend;
            @com.fasterxml.jackson.annotation.JsonProperty("title")
            public String title;
            @com.fasterxml.jackson.annotation.JsonProperty("type")
            public Integer type;
            @com.fasterxml.jackson.annotation.JsonProperty("viewCount")
            public Integer viewCount;

}
    }
}
