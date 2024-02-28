package com.example.hellosoftware.dao;

import com.example.hellosoftware.dto.PageRequestDTO;
import com.example.hellosoftware.dto.licenseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Mapper
public interface licenseMapper {

    int insert(licenseDto dto);
    int nextSeq();
    List<licenseDto> selectList();
    List<licenseDto> selectOneList(String schoolname);

    public void Updatesanddate(Date sendDate, String schoolemail);

    //페이징
    List<licenseDto> pagelist(PageRequestDTO pageRequestDTO);
    int count(PageRequestDTO pageRequestDTO);

    //수정할 회원 정보 가져오는 메소드
    licenseDto selectOne(int idx);

    //회원 수정
    int update(licenseDto dto);

    //회원 삭제
    int delete(int idx);



}
