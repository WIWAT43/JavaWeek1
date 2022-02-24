package com.wiwats.shopping.user.repository;

import com.wiwats.shopping.user.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress,Long> {
}
