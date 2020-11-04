package com.example.redditclone.controller;

import com.example.redditclone.dto.SubredditDto;
import com.example.redditclone.service.SubrreditService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subreddit")
@AllArgsConstructor
@Slf4j
public class SubredditConroller {
    private final SubrreditService subrreditService;

    @PostMapping
    public void createSubreddit(@RequestBody SubredditDto subreddit) {

        ResponseEntity.status(HttpStatus.CREATED)
                .body(subrreditService.save(subreddit));

    }
    @GetMapping
    public void getAllSubreddits(){
        ResponseEntity.status(HttpStatus.OK)
    .body(subrreditService.getAll());
    }
}
