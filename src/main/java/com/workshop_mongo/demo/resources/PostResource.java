
package com.workshop_mongo.demo.resources;

import com.workshop_mongo.demo.domain.Post;
import com.workshop_mongo.demo.domain.User;
import com.workshop_mongo.demo.dto.UserDTO;
import com.workshop_mongo.demo.resources.util.URL;
import com.workshop_mongo.demo.service.PostService;
import com.workshop_mongo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
    @RequestMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text" , defaultValue = "") String text,
            @RequestParam(value = "minDate" , defaultValue = "") String minDate,
            @RequestParam(value = "maxDate" , defaultValue = "") String maxDate
    )
    {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate , new Date(0L));
        Date max = URL.convertDate(maxDate , new Date(0L));
        List<Post> list = service.fullSearch(text , min ,max);
        return ResponseEntity.ok().body(list);
    }


}
