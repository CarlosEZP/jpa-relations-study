package dev.carlosezp.social_media;

import dev.carlosezp.social_media.entity.Post;
import dev.carlosezp.social_media.entity.SocialGroup;
import dev.carlosezp.social_media.entity.SocialProfile;
import dev.carlosezp.social_media.entity.SocialUser;
import dev.carlosezp.social_media.repository.GroupRepository;
import dev.carlosezp.social_media.repository.PostRepository;
import dev.carlosezp.social_media.repository.ProfileRepository;
import dev.carlosezp.social_media.repository.SocialUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    private final SocialUserRepository userRepository;
    private final GroupRepository groupRepository;
    private final ProfileRepository ProfileRepository;
    private final PostRepository postRepository;

    public DataInitializer(SocialUserRepository userRepository, GroupRepository groupRepository, ProfileRepository ProfileRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.ProfileRepository = ProfileRepository;
        this.postRepository = postRepository;
    }

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            // Create some users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            // Save users to the database
            user1 = userRepository.save(user1);
            user2 = userRepository.save(user2);
            user3 = userRepository.save(user3);

            // Create some groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            // Add users to groups
            group1.getUsers().add(user1);
            group1.getUsers().add(user2);

            group2.getUsers().add(user2);
            group2.getUsers().add(user3);

            // Save groups to the database
            groupRepository.save(group1);
            groupRepository.save(group2);

            // Associate users with groups
            user1.getSocialGroups().add(group1);
            user2.getSocialGroups().add(group1);
            user2.getSocialGroups().add(group2);
            user3.getSocialGroups().add(group2);

            // Save users back to database to update associations
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);


            // Create some posts
            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            // Associate posts with users
            post1.setUser(user1);
            post2.setUser(user2);
            post3.setUser(user3);

            // Save posts to the database (assuming you have a PostRepository)
            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);

            // Create some social profiles
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            // Associate profiles with users
            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);
            user1.setSocialProfile(profile1);
            user2.setSocialProfile(profile2);
            user3.setSocialProfile(profile3);

            // Save profiles to the database (assuming you have a ProfileRepository)
            ProfileRepository.save(profile1);
            ProfileRepository.save(profile2);
            ProfileRepository.save(profile3);
        };
    }
}
