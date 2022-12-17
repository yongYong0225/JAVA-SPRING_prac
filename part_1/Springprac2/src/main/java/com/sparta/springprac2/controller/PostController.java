package com.sparta.springprac2.controller;

import com.sparta.springprac2.dto.PostDeleteRequestDto;
import com.sparta.springprac2.dto.PostDeleteResponseDto;
import com.sparta.springprac2.dto.PostRequestDto;
import com.sparta.springprac2.dto.PostResponseDto;
import com.sparta.springprac2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // json형식으로 return
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/api/post") //게시글 생성
    public PostResponseDto creatPost(@RequestBody PostRequestDto postRequestDto){
    return postService.creatPost(postRequestDto);
    }

    @GetMapping("/api/posts") //게시글 전체조회
    public List<PostResponseDto> getPosts(){
    return postService.getPosts();
    }

    @GetMapping("/api/post/{id}") //경로
    public PostResponseDto getPost(@PathVariable Long id){
    return postService.getPost(id);
    }

    @PutMapping("/api/post/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto){
    return postService.updatePost(id, postRequestDto);
    }

    @DeleteMapping("/api/post/{id}")
    public PostDeleteResponseDto deletpost(@PathVariable Long id, @RequestBody PostDeleteRequestDto postDeleteRequestDto){

    }





}
