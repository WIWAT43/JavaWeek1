package com.wiwats.shopping.user.service;

import com.wiwats.shopping.user.model.UserAddress;
import com.wiwats.shopping.user.model.UserAddressRequest;
import com.wiwats.shopping.user.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddressService {

   @Autowired
    private UserAddressRepository userAddressRepository;

   public  UserAddressRequest addAddress (UserAddressRequest userAddressRequest){

       UserAddress userAddress = new UserAddress(userAddressRequest);

       UserAddress addressReturn = userAddressRepository.save(userAddress);

       return new UserAddressRequest(addressReturn);
   }
}
