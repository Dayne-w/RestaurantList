package com.example.restaurant.wishList.repository;

import com.example.restaurant.db.MemoryDbRepositoryAbstract;
import com.example.restaurant.wishList.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository // 해당 클래스를 루트 컨테이너에 빈 객체로 생성해주는 어노테이션.부모 어노테이션인 @Component 써도 되지만 가시성이 떨어지기 때문에, 외부 I/O처리를 할 때 @Repository로 사용.

public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {


}
