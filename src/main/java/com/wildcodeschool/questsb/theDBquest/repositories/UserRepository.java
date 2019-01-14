package com.wildcodeschool.questsb.theDBquest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.questsb.theDBquest.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}


