package com.wiwats.shopping.user.service;

import com.wiwats.shopping.errorHandler.UserDataIncorrectException;
import com.wiwats.shopping.user.model.User;
import com.wiwats.shopping.user.model.UserAddress;
import com.wiwats.shopping.user.model.UserAddressRequest;
import com.wiwats.shopping.user.repository.UserAddressRepository;
import com.wiwats.shopping.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserAddressService {

   @Autowired
    private UserAddressRepository userAddressRepository;

    @Autowired
    private UserRepository userRepository;

   public  UserAddressRequest addAddress (UserAddressRequest userAddressRequest){

       log.info( "addAddress - "+ String.valueOf(userAddressRequest));

       Optional<User> user = userRepository.findById(userAddressRequest.getUserId());

       if (user.isEmpty() || user.equals(null)){
           throw new UserDataIncorrectException("201");
       }

       UserAddress userAddress = new UserAddress(userAddressRequest);
       UserAddress addressReturn = userAddressRepository.save(userAddress);

       return new UserAddressRequest(addressReturn);
   }

    public  List<UserAddressRequest> findAddressByUserIdAndStatus (Long userId, int statusActive){

        log.info( "findAddressByUserIdAndStatus - UserId:"+userId+" statusActive:"+statusActive);

        List<UserAddress> addressReturn;
       if (statusActive ==3) {
           addressReturn = userAddressRepository.findByUser(new User(userId));
       } else
        addressReturn = userAddressRepository.findByUserAndStatusActiveLike(new User(userId),statusActive);

        List<UserAddressRequest> UserAddressRequest = new ArrayList<>();

        for (UserAddress userAddress : addressReturn) {
            UserAddressRequest.add( new UserAddressRequest(userAddress) );
        }

        return UserAddressRequest;
    }


}
