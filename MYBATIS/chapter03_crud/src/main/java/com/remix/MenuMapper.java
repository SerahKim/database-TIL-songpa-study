package com.remix;

import java.util.List;

/*
1. MenuMapper를 인터페이스로 만들어야하고 추상메소드로 작성해야 한다.
2. MenuMapper.xml 연결하려는 파일과 경로와 위치가 같아야한다.
3. 작성한 메소드 이름과 xml 쪽에 작성한 id가 일치해야하고, 작성한 리턴 타입과 resultMap 타입과도 일치해야 한다.
4. Template 쪽에 메퍼로 등록해줘야한다.
*/
public interface MenuMapper {

    List<MenuDTO> selectAllMenu();

    MenuDTO selectMenuByCode(int code);

    int registMenu(MenuDTO menu);

    int updateMenu(MenuDTO menu);

    int deleteMenu(int code);
}
