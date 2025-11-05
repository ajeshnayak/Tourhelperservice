package com.tourhelper.tourhelperservice.repository;

import com.tourhelper.tourhelperservice.entity.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends MongoRepository<Group,String> {
}
