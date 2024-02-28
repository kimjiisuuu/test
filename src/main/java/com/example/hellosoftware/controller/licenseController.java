package com.example.hellosoftware.controller;

import com.example.hellosoftware.dto.PageRequestDTO;
import com.example.hellosoftware.dto.PageResponseDTO;
import com.example.hellosoftware.dto.licenseDto;
import com.example.hellosoftware.service.licenseService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
@Log4j2
public class licenseController {

    private final licenseService service;

    @GetMapping("/list")
    public void searchList(PageRequestDTO request,Model model) {
        PageResponseDTO response = service.SearchList(request);
        response.getList().forEach(i -> {
            log.info("글 : {}",i);
        });
        model.addAttribute("searchlist",response);
    }


//    //전체 리스트 출력
//    @GetMapping("/list")
//    public void selectAllList(Model model) {
//        List<> list = service.getAllLicenses();
//        model.addAttribute("list",list);
//
//    }

    //등록창 출력
    @GetMapping("/regform")
    public String regform(Model model) {
        int nextSeq = service.getNextSeq();
        model.addAttribute("nextSeq", nextSeq);
        return "member/regform";
    }

        //등록
        @PostMapping("/regAction")
        public String regAction(licenseDto dto, RedirectAttributes re) {
                service.insertLicense(dto);
                re.addFlashAttribute("message","등록이 완료되었습니다.");

            return "redirect:/member/list";
        }
    // 이메일 발송
    @PostMapping("/mail")
    public String registerLicense(licenseDto dto, Model model) {
        String senddate = service.sendEmail(dto.getSchoolemail());
        model.addAttribute("senddate", senddate);
        return "redirect:/member/list";
    }



    @GetMapping("/listDetail")
    public String listDetail(@RequestParam("schoolname") String schoolname,HttpSession session, Model model) {
       session.setAttribute("schoolname",schoolname);

        List<licenseDto> listDetail = service.getLicensesBySchoolName(schoolname);
        model.addAttribute("listDetail", listDetail);
        return "member/listDetail";
    }


    @GetMapping("/update")
    public String update(@RequestParam("idx") int idx,Model model) {
        licenseDto dto = service.selectOne(idx);
        model.addAttribute("licenseDto", dto);
        return "member/update";
    }

    //회원 수정
    @PostMapping("/updateAction")
    public String update(licenseDto dto,RedirectAttributes reAttr){
        service.update(dto);

        reAttr.addFlashAttribute("result","회원 수정이 완료되었습니다.");
        reAttr.addFlashAttribute("idx",dto.getIdx());

        return "redirect:/member/listDetail";
    }

    //회원 삭제
    @PostMapping("/delete")
    public String delete(@RequestParam("idx") int idx, HttpSession session){
       String schoolname = (String) session.getAttribute("schoolname");

        service.delete(idx);
      //  log.info("아이디엑스 값은=",idx);
        return "redirect:/member/listDetail?schoolname=" + schoolname;

    }










}
