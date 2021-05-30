package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private int id;

    private String description;

    // 지연로딩방식
    // 사용자 엔티티를 조회 할 때 매번 포스트 엔티티가 같이 로딩되는 것이 아닌
    // 포스트 데이터가 로딩되는 시점에 필요한 사용자 데이터를 가져오겠다는 뜻
    @ManyToOne(fetch = FetchType.LAZY )
    @JsonIgnore
    private User user;
}
