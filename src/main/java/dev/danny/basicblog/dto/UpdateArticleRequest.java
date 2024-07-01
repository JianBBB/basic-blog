package dev.danny.basicblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UpdateArticleRequest {
    private String title;
    private String content;

}
