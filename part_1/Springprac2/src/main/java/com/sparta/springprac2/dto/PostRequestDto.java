package com.sparta.springprac2.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {

    private String title;

    private String writer;

    private String password;

    private String content;

}
