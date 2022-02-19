package com.wiwats.shopping.user.service;


import com.wiwats.shopping.errorHandler.UserDataIncorrectException;
import com.wiwats.shopping.user.repository.UserRepository;
import com.wiwats.shopping.user.model.User;
import com.wiwats.shopping.user.model.UserRequest;
import com.wiwats.shopping.user.model.UserRespond;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {



    @Autowired
    private UserRepository userRepository;

    public UserRespond registerUser(UserRequest userRequest){

        log.info( "RegisterUser - "+ String.valueOf(userRequest));

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        UserRespond userRespond = new UserRespond();
        User user = new User();
        user.setUserFromRequest(userRequest);
        user.setCreatedDate(date.toString());
        user.setModifiedADate(date.toString());
        userRespond.setRespond(user);

     // Data Validation
        List<String> messageDataValidate = new ArrayList<>();
        if (userRequest.getUserName() == null || userRequest.getUserName().trim().isEmpty()){
            messageDataValidate.add("User name: 'Invalid'");
            throw new UserDataIncorrectException("101");
        }

        if (userRequest.getFirstName() == null || userRequest.getFirstName().trim().isEmpty())
            messageDataValidate.add("Name: 'Invalid'");
        if (userRequest.getLastName() == null || userRequest.getLastName().trim().isEmpty())
            messageDataValidate.add("Last Name: 'Invalid'");
        if (userRequest.getTelephone() == null || userRequest.getTelephone().trim().isEmpty() || userRequest.getTelephone().length()<6)
            messageDataValidate.add("Telephone number: 'Invalid'");

        if (messageDataValidate.size()>0){
            userRespond.setStatus("101");

         String errorMessage = new String();
           int i=1;
            for (String s : messageDataValidate) {

               if (i== messageDataValidate.size())
                    errorMessage+=s;
               else{
                   i++;
                   errorMessage+=s+", ";
               }

            }
            userRespond.setMessage(errorMessage);

         throw new UserDataIncorrectException(errorMessage);
        }


        // Check duplicate username
       Optional<User> checkDuplicat= userRepository.findByUserName(userRequest.getUserName());
        if ( !checkDuplicat.isEmpty()) {
            userRespond.setStatus("102");
            throw new UserDataIncorrectException( userRespond.getStatus());
        }


        // Save to Database
        User respond = userRepository.save(user);
        if (respond == null){
           userRespond.setStatus("103");
           throw new UserDataIncorrectException( userRespond.getStatus());

        }

        userRespond.setRespond(respond);
        userRespond.setStatus("200");
        userRespond.setMessage("Success");
        return userRespond;
    }



    public  Optional<User>findByUserName(String username){

        Optional<User> respond = userRepository.findByUserName(username);

        return respond;
    }


}
