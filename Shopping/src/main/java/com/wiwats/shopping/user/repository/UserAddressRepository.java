package com.wiwats.shopping.user.repository;

import com.wiwats.shopping.user.model.User;
import com.wiwats.shopping.user.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAddressRepository extends JpaRepository<UserAddress,Long> {

    List<UserAddress> findByUser(User user);
    List<UserAddress> findByUserAndStatusActiveLike(User user,int statusActive);
}
