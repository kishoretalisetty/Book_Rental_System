package org.example.Repositorys;

import org.example.Entities.UserBookMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookMappingRepository extends JpaRepository<UserBookMapping, Long> {
}
