package dev.carlosezp.social_media.repository;

import dev.carlosezp.social_media.entity.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepository extends JpaRepository<SocialUser, Long> { }
