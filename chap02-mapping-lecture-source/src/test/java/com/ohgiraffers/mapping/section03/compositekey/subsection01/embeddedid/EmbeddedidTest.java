package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
public class EmbeddedidTest {

    @Autowired
    private LikeBookService likeBookService;
    /* 필기.
    *   복합키가 존재하는 테이블의 매핑
    *   1. EmbeddedId : @Embeddable 클래스에 복합키를 정의하고 엔티티에 @EmbeddedId 를
    *   이용하여 복합키 클래스를 매핑한다.
    *   복합키의 일부 필드만을 매핑할 수 있으므로, 필드의 수가 많은 경우 유연한 매핑이 가능하다.
    *  */

    private static Stream<Arguments> getLikeInfo() {
        return Stream.of(
                Arguments.of(1,1),
                Arguments.of(2,1),
                Arguments.of(1,2),
                Arguments.of(2,2)
        );
    }

    @ParameterizedTest(name = "{0}번 회원이 {1}번 책 좋아요 등록 테스트")
    @MethodSource("getLikeInfo")
    void testGenerateLike(int likedMemberNo, int likedBookNo) {

        Assertions.assertDoesNotThrow(
                () -> likeBookService.generateLikeBook(
                        new LikeDTO(likedBookNo, likedMemberNo)
                )
        );

    }
}
