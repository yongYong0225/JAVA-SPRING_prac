package com.sparta.springprac2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {

    private String title;

    private String writer;

    private LocalDateTime createAt;

    private String content;

    public PostResponseDto(String title, String writer, LocalDateTime createAt, String content) {
        this.title = title;
        this.writer = writer;
        this.createAt = createAt;
        this.content = content;
    }
}
