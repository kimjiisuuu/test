package com.example.hellosoftware.dto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class licenseDto{
    private int idx;					//등록번호
    private String schoolname;			//학교명
    private String schoolemail;			//학교 대표 이메일
    private String teacheremail;		//선생님 이메일
    private String schoolnumber;		//학교 전화번호
    private String licensename;			//라이센스 명
    private LocalDate startdate;		//구독 시작일
    private LocalDate enddate;			//구독 종료일
    private String senddate;            // 최근이메일 발송 날짜
}
