package com.example.redditclone.service;

import com.example.redditclone.dto.SubredditDto;
import com.example.redditclone.exceptions.SpringRedditException;
import com.example.redditclone.mapper.SubredditMapper;
import com.example.redditclone.model.Subreddit;
import com.example.redditclone.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Slf4j
@Service

public class SubrreditService {
    private final SubredditRepository subredditRepository;
    private final SubredditMapper subredditMapper;

    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
        Subreddit save = subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    private Subreddit mapSubredditDtoToSubreddit(SubredditDto subredditDto) {
        return Subreddit.builder().name(subredditDto.getSubredditName())
                .description(subredditDto.getDescreption())
                .build();


    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll().stream()
                .map(subredditMapper::mapSubredditToDto)
                .collect(Collectors.toList());
    }

    private SubredditDto mapToDto(Subreddit subreddit) {
        return SubredditDto.builder().subredditName(subreddit.getName())
                .id(subreddit.getId())
                .numberOfPosts(subreddit.getPosts().size())
                .build();
    }

    public SubredditDto getSubreddit(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new SpringRedditException("subreddit with id " + id + "not found"));
        return subredditMapper.mapSubredditToDto(subreddit);
    }
}
