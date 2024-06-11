package com.ohgiraffers.jpql.section02.parameter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ParameterBindingTest {

    @Autowired
    private ParameterBindingRepository repository;

    @DisplayName("이름을 기준으로 파라미터 바인딩 메뉴 목록 조회 테스트")
    @Test
    void testParameterByName() {

        //given
        String menuName = "한우딸기국밥";

        //when
        List<Menu> menuList = repository.selectMenuByBindingName(menuName);

        //then
        Assertions.assertEquals(menuName, menuList.get(0).getMenuName());
    }

    @DisplayName("위치 기준으로 파라미터 바인딩 메뉴 목록 조회 테스트")
    @Test
    void testParameterByPosition() {

        //given
        String menuName = "한우딸기국밥";

        //when
        List<Menu> menuList = repository.selectMenuByBindingPosition(menuName);

        //then
        Assertions.assertEquals(menuName, menuList.get(0).getMenuName());
    }

}
