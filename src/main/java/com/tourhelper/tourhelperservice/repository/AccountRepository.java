package com.tourhelper.tourhelperservice.repository;

import com.tourhelper.tourhelperservice.entity.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<UserAccount,String> {

    UserAccount findByEmailId(String emailId);

    @Query(value = "SELECT * FROM user_account ORDER BY CREATED DESC LIMIT 1", nativeQuery = true)
    UserAccount getLastUserId();
}
