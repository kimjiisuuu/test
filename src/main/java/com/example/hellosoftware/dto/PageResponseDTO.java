package com.example.hellosoftware.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageResponseDTO {

    //페이지 목록의 범위를 계산하기
    //필요한 값
    private int totalPage;
    private int totalCount;

    private int startPage;
    private int endPage;
    private List<licenseDto> list;
    // ㄴ 서비스에서 처리할 때 PageResponseDTO에 글목록을 포함시키면 리턴타입 정하기가 간단하고 view 에 전달도 한번에 가능.

    public static PageResponseDTO of(PageRequestDTO dto, int totalCount, int pageSize){
        int totalPage = (int)Math.ceil((double)totalCount/dto.getSize());
        int startPage = (dto.getPage()-1)/pageSize*pageSize+1;
        int endPage = Math.min(startPage+pageSize-1, totalPage);
        return PageResponseDTO.builder()
                .totalPage(totalPage)
                .totalCount(totalCount)
                .startPage(startPage)
                .endPage(endPage)
                .build();
    }

}
