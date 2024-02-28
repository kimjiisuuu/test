package com.example.hellosoftware.service;

import com.example.hellosoftware.dao.licenseMapper;
import com.example.hellosoftware.dto.PageRequestDTO;
import com.example.hellosoftware.dto.PageResponseDTO;
import com.example.hellosoftware.dto.licenseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class licenseService {

    @Autowired
    private JavaMailSender EmailSender;

    private final licenseMapper dao;

    public PageResponseDTO SearchList(PageRequestDTO Request) {
        Request.setSize(3);
        Request.setDatas();
        List<licenseDto> list = dao.pagelist(Request);
        PageResponseDTO response = PageResponseDTO.of(Request,dao.count(Request),3);
        response.setList(list);
        return response;
    }

    //등록하기
    public int insertLicense(licenseDto dto) {
        return dao.insert(dto);
    }
    
    //등록번호 불러오기
    public int getNextSeq() {
        return dao.nextSeq();
    }
    
    //전체 리스트 조회
    public List<licenseDto> getAllLicenses() {
        return dao.selectList();
    }

    //단일 회원 조회
    public List<licenseDto> getLicensesBySchoolName(String schoolname) {
        return dao.selectOneList(schoolname);
    }


    public String sendEmail(String schoolEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("라이센스 남은 기한이 1달입니다.");
        message.setTo(schoolEmail);
        message.setText("라이센스를 연장 또는 새로 구매를 원하시면 010-xxxx-xxxx로 연락 주시기바랍니다.");
        EmailSender.send(message);

        Date sendDateTime = new Date();
        dao.Updatesanddate(sendDateTime, schoolEmail);
        return schoolEmail;
    }

    //회원 수정
    public int update(licenseDto dto) {

        return dao.update(dto);
    }

    //수정할 회원정보
    public licenseDto selectOne(int idx){
        return dao.selectOne(idx);
    }

    //회원 삭제
    public int delete(int idx){
        return dao.delete(idx);
    }

}
