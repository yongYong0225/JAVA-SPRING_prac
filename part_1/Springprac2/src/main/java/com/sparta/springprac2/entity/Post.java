package com.sparta.springprac2.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // 엔티티임을 알려줌
@Getter //@Setter 사용하지 않는 이유?
@NoArgsConstructor // 기본생성자 생성
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //생성전략, 검색
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createAt;


    public Post(String title, String writer, String password, String content, LocalDateTime createAt) {
        this.title = title;
        this.writer = writer;
        this.password = password;
        this.content = content;
        this.createAt = createAt;
    }

    public void update (String title, String writer, String content){
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

}
