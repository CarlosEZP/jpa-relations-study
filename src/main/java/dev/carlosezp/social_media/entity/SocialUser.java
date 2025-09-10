package dev.carlosezp.social_media.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUser {
    // Define the strategy to create the primary key and the increments
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Define attribute as a primary key
    @Id
    private Long id;

    // Define a one-to-one relationship between two entities
    @OneToOne
    // Define attribute as join column with another entity
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "profile_id") // parameter "name" defines the name of column
    private SocialProfile socialProfile;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    @ManyToMany
    @EqualsAndHashCode.Exclude
    @JoinTable(       // create a join table to join User and Group
            name = "user_group",    // Define the name of table
            joinColumns = @JoinColumn(name = "user_id"),    // Define
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<SocialGroup> socialGroups = new HashSet<>();
}
