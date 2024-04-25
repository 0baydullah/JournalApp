package com.obaydullah.journalapp.repository;

import com.obaydullah.journalapp.entity.JournalEntry;
import com.obaydullah.journalapp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);

}
