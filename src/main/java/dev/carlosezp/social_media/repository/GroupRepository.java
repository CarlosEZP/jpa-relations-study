package dev.carlosezp.social_media.repository;

import dev.carlosezp.social_media.entity.SocialGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<SocialGroup, Long> { }
