package com.example.restaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchImageRes { // 데이터 출력 결과, 네이버 검색 api 사용할 때, 데이터 response시에 필요한 변수들.

    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<SearchImageItem> items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchImageItem{

        private String title;
        private String link;
        private String thumbnail;
        private String sizeheight;
        private String sizewidth;
    }
}
