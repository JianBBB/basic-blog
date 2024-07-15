package dev.danny.basicblog.dto;

import dev.danny.basicblog.domain.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateArticleResponse {
    private String title;
    private String content;

    public UpdateArticleResponse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
