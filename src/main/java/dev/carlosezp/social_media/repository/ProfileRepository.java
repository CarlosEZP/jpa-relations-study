package dev.carlosezp.social_media.repository;

import dev.carlosezp.social_media.entity.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<SocialProfile, Long> { }
