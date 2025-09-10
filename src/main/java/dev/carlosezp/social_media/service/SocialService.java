package dev.carlosezp.social_media.service;

import dev.carlosezp.social_media.entity.SocialUser;
import dev.carlosezp.social_media.repository.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {
    @Autowired
    private SocialUserRepository socialUserRepository;

    public List<SocialUser> getUsers() {
        return socialUserRepository.findAll();
    }

    public SocialUser createUser(SocialUser user) {
        return socialUserRepository.save(user);
    }
}
