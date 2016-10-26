package com.ironyard.controler;

import com.ironyard.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Raul on 10/26/16.
 */

@RestController
public class UserControler {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/service/users", method = RequestMethod.GET)
    public Iterable<User> list(@RequestParam(value = "filter", required = false) String filter) {
        log.debug("Request to list teams started.");


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<User[]> respEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/users",
                HttpMethod.GET, entity, User[].class);
        User[] users = respEntity.getBody();

        log.info(users.toString());
        log.debug("Fetch user complete.");
        List<User> foundAllList = Arrays.asList(users);
        List<User> filteredList = new ArrayList<>();

        // only return teams that start with parameter name
        if(filter != null){
            // filter the list
            for(User auser: foundAllList){
                if(auser.getName().startsWith(filter)){
                    filteredList.add(auser);
                }
            }
        }else{
            // just return all
            filteredList = foundAllList;
        }
        return filteredList;

    }

}
