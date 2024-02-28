package com.example.hellosoftware.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface loginMapper {
    public int login(String id, String password);



}
