package com.example.restaurant.wishList.repository;

import com.example.restaurant.wishList.entity.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListRepositoryTest {

    @Autowired
    private WishListRepository wishListRepository;

    private WishListEntity create(){
        var wishList = new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("address");
        wishList.setRoadAddress("roadAddress");
        wishList.setHomePageLink("");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);

        return wishList;
    }
    @Test
    public void saveTest(){
        var wishListEntity = create(); // wishList 디폴트로 생성
        var expected = wishListRepository.save(wishListEntity); //wishList개체 저장

        Assertions.assertNotNull(expected); // expected가 null이면 안된다.
        Assertions.assertEquals(1, expected.getIndex()); // expected가 첫 번째 데이터이길 기대한다는 코드.
    }

    @Test
    public void updateTest(){
        var wishListEntity = create(); // wishList 디폴트로 생성
        var expected = wishListRepository.save(wishListEntity); //wishList개체 저장

        expected.setTitle("update test");
        var saveEntity = wishListRepository.save(expected);

        Assertions.assertEquals("update test", saveEntity.getTitle());
        Assertions.assertEquals(1, wishListRepository.findAll().size());
    }

    @Test
    public void findByIdTest(){
        var wishListEntity = create();
        wishListRepository.save(wishListEntity);

        var expected = wishListRepository.findById(1);

        Assertions.assertEquals(true, expected.isPresent()); // 안에 값이 있어야 한다는 코드.
        Assertions.assertEquals(1, expected.get().getIndex()); // 데이터 꺼냈을 때 index 1이어야 한다는 코드.
    }

    @Test
    public void deleteTest(){
        var wishListEntity = create();
        wishListRepository.save(wishListEntity);

        wishListRepository.deleteById(1);

        int count = wishListRepository.findAll().size();

        Assertions.assertEquals(0, count);
    }

    @Test
    public void listAllTest(){
        var wishListEntity1 = create();
        wishListRepository.save(wishListEntity1);

        var wishListEntity2 = create();
        wishListRepository.save(wishListEntity2);

        int count = wishListRepository.findAll().size();

        Assertions.assertEquals(2, count);
    }

}
