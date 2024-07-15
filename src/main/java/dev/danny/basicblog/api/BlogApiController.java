package dev.danny.basicblog.api;

import dev.danny.basicblog.domain.Article;
import dev.danny.basicblog.dto.AddArticleRequest;
import dev.danny.basicblog.dto.ArticleResponse;
import dev.danny.basicblog.dto.UpdateArticleRequest;
import dev.danny.basicblog.dto.UpdateArticleResponse;
import dev.danny.basicblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    //블로그 글 저장하는 API 메서드
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    //블로그 글 목록 조회하는 API 메서드
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    //블로그 글 조회하는 API 메서드
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable Long id){
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    //블로그 글 삭제하는 API 메서드
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        blogService.delete(id);

        return ResponseEntity.ok().build();
    }

    //블로그 글 수정하는 API 메서드
    @PutMapping("/api/articles/{id}")
    public ResponseEntity<UpdateArticleResponse> updateArticle(@PathVariable Long id,
                                                 @RequestBody UpdateArticleRequest request){
        UpdateArticleResponse result = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(result);
    }
}
