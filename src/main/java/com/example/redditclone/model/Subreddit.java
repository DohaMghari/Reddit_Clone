package com.example.redditclone.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Subreddit {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Post> posts;
    private Instant createDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


}
