package dev.danny.basicblog.dto;

import lombok.*;

@NoArgsConstructor
@Getter
public class UpdateArticleRequest {
    private String title;
    private String content;


    @Builder
    public UpdateArticleRequest(String title, String content){
        this.title = title;
        this.content = content;
    }
}
