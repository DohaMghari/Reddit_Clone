package com.example.redditclone.mapper;

import com.example.redditclone.dto.SubredditDto;
import com.example.redditclone.model.Post;
import com.example.redditclone.model.Subreddit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface SubredditMapper {
    @Mappings({
    @Mapping(source = "name", target = "subredditName"),
    @Mapping(source = "description", target = "descreption"),
    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subreddit.getPosts()))")})
    SubredditDto mapSubredditToDto(Subreddit subreddit);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Subreddit mapDtoToSubreddit(SubredditDto subredditDto);
}
