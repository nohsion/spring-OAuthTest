package com.oauth.spring.OAuthTest.web.dto;

import com.oauth.spring.OAuthTest.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
Posts Entity와 거의 동일하지만, dto를 따로 분리해서 사용해야 함!!
View Layer와 DB Layer의 역할 분리를 철저히 하자.
Entity는 DB와 맞닿아 있어 변경이 거의 일어나지 않지만,
Request/Response용 dto는 View에 따라 자주 변경이 필요하기 때문이다.
 */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
