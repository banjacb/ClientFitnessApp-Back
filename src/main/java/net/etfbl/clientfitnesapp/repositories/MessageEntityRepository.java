package net.etfbl.clientfitnesapp.repositories;

import net.etfbl.clientfitnesapp.models.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageEntityRepository extends JpaRepository<MessageEntity,Integer> {
}
