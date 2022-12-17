package com.sparta.springprac2.service;

import com.sparta.springprac2.dto.PostRequestDto;
import com.sparta.springprac2.dto.PostResponseDto;
import com.sparta.springprac2.entity.Post;
import com.sparta.springprac2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto creatPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto.getTitle(), postRequestDto.getWriter(), postRequestDto.getPassword(), postRequestDto.getContent(), LocalDateTime.now());
        postRepository.save(post);
        return new PostResponseDto(post.getTitle(), post.getWriter(), post.getCreateAt(), post.getContent());
    }

    @Transactional(readOnly = true)
    public List<PostResponseDto> getPosts() {
        List<Post> all = postRepository.findAll();
        List<PostResponseDto> result = new ArrayList<>();
        for (Post post : all) {
            PostResponseDto postResponseDto = new PostResponseDto(post.getTitle(), post.getWriter(), post.getCreateAt(), post.getContent());
            result.add(postResponseDto);
        }
        return result;
    }

    @Transactional(readOnly = true)
    public PostResponseDto getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Id가 존재하지 않습니다.")
        );
        return new PostResponseDto(post.getTitle(), post.getWriter(), post.getCreateAt(), post.getContent());
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Id가 존재하지 않습니다.")
        );
        String password = postRequestDto.getPassword();
        String password1 = post.getPassword();

        if(password.equals(password1)){
            post.update(postRequestDto.getTitle(), postRequestDto.getWriter(), postRequestDto.getContent());
            return new PostResponseDto(post.getTitle(), post.getWriter(), post.getCreateAt(), post.getContent());
        } else {
            throw  new IllegalArgumentException("패스워드가 일치하지 않습니다");
        }
    }



}
