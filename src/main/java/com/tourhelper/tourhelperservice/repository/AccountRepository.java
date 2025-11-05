package com.tourhelper.tourhelperservice.repository;

import com.tourhelper.tourhelperservice.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account,String> {

    Account findByEmailId(String emailId);
}
