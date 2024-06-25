package dev.danny.basicblog.service;

import dev.danny.basicblog.domain.Article;
import dev.danny.basicblog.dto.AddArticleRequest;
import dev.danny.basicblog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

}
