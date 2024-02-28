package com.example.hellosoftware.service;

import com.example.hellosoftware.dao.loginMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class loginService {
    private final loginMapper dao;

    public int login(String id, String password) {

        int check = dao.login(id,password);

        if(check == 1) {
            log.info("check 성공 : {}",check);

            return 1;
        }else {
            log.info("check 실패 : {}",check);
            return 0;
        }


    }


}
