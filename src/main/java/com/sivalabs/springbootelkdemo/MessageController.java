package com.sivalabs.springbootelkdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class MessageController {

    @Autowired
    MessageRepository repo;

    @GetMapping("/messages")
    public List<Message> allMessages() {
        log.info("Fetching all messages");
        return repo.findAll();
    }

    @GetMapping("/messages/{id}")
    public Optional<Message> byId(@PathVariable Long id){
        log.info("Fetching message by id: "+id);
        return repo.findById(id);
    }

    @PostMapping("/messages")
    public Message create(@RequestBody Message message) {
        log.info("Saving message with text: "+message.getText());
        return repo.save(message);
    }
}
