package fr.wildcodeschool.wildslackback.repo;

import fr.wildcodeschool.wildslackback.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
