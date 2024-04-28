package com.obaydullah.journalapp.repository;

import com.obaydullah.journalapp.entity.JournalEntry;
import com.obaydullah.journalapp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);

}
