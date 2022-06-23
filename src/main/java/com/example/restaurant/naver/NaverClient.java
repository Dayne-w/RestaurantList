package com.example.restaurant.naver;

import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchImageRes;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
// 네이버 api 연동
@Component
public class NaverClient {

    @Value("${naver.client.id}") //yaml 파일의 데이터를 가져와주는 어노테이션
    private String naverClientId;

    @Value("${naver.client.secret}")
    private String naverClientSecret;

    @Value("${naver.url.search.local}")
    private String naverLocalSearchUrl;

    @Value("${naver.url.search.image}")
    private String naverImageSearchUrl;

    public SearchLocalRes searchLocal(SearchLocalReq searchLocalReq){ // 요청할 때 쓰는 코드
        var uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl) // 요청하는 주소 만듦
                .queryParams(searchLocalReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders(); // 헤더 세팅 코드
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers); // request 타입
        var responseType = new ParameterizedTypeReference<SearchLocalRes>(){}; // response 타입 정의

        var responseEntity = new RestTemplate().exchange( // RestTemplate으로 결과 얻어옴
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );

        return responseEntity.getBody(); // getBody()를 통해 결과 리턴
    }

    public SearchImageRes searchImage(SearchImageReq searchImageReq){
        var uri = UriComponentsBuilder.fromUriString(naverImageSearchUrl) // 요청하는 주소 만듦
                .queryParams(searchImageReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders(); // 헤더 세팅 코드
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers); // request 타입
        var responseType = new ParameterizedTypeReference<SearchImageRes>(){}; // response 타입 정의

        var responseEntity = new RestTemplate().exchange( // RestTemplate으로 결과 얻어옴
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );

        return responseEntity.getBody();
    }
}
