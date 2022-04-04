package com.lmsproject.lmsservice.admin.model;

import lombok.Data;

@Data
public class MemberParam {

    long pageIndex;
    long pageSize;

    String searchType;
    String searchValue;

    String userId;

    public long getPageStart(){
        init();
        return (pageIndex - 1) * pageSize;
    }
    public long getPageEnd(){
        init();
        return pageSize;
    }
    public void init(){
        if(pageIndex < 1){
            pageIndex = 1;
        }
        if(pageSize < 10){
            pageSize = 10;
        }

    }

    public String getQueryString() {
        // 검색된 결과를 같이 들고 페이징 처리하기 위함
        init();

        StringBuilder sb = new StringBuilder();

        if(searchType != null && searchType.length() > 0){
            sb.append(String.format("searchType=%s", searchType));
        }

        if(searchValue != null && searchValue.length() > 0){
            if(sb.length() > 0){
                sb.append("&");
            }
            sb.append(String.format("searchValue=%s", searchValue));
        }
        return sb.toString();
    }
}
