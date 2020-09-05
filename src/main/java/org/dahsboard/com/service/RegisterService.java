package org.dahsboard.com.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterService {


    private Map<String,Integer> mapOfRegisteredUsers = new HashMap<String,Integer>();

    public Map registerIfNotPresentAlready(String email)
    {
        if (mapOfRegisteredUsers.get(email) != null) {
            mapOfRegisteredUsers.put(email, mapOfRegisteredUsers.get(email) + 1);
        }
        else
        {
            mapOfRegisteredUsers.put(email,1);
        }
        System.out.println("totalVlaues in mapOfregisteredUsers is:"+mapOfRegisteredUsers.size());
        return mapOfRegisteredUsers;

    }

    @Override
    public String toString() {

        return "registerIfNotAlready"+mapOfRegisteredUsers.size();
    }
}
