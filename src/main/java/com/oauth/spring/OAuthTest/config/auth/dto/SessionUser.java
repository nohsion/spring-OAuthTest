package com.oauth.spring.OAuthTest.config.auth.dto;

import com.oauth.spring.OAuthTest.domain.user.User;
import lombok.Getter;

/*
# User 클래스를 사용하면 안되고, 따로 만들어야 하는 이유
-> User 클래스를 세션에 저장하려고 하면, convert from type [Object] to type [byte[]]가 불가능하다는 에러가 발생한다.
그러면 User 클래스에 직렬화를 하면 되나? 하지만 User는 엔티티기 때문에 @OneToMany 등 자식이 있다면 성능 이슈..
그래서 직렬화 기능을 가진 세션 Dto를 하나 추가로 만드는 것이 큰 도움이 된다.
 */
@Getter
public class SessionUser {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
