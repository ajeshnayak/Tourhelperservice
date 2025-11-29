package com.tourhelper.tourhelperservice.repository;

import com.tourhelper.tourhelperservice.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Group,String> {
    List<Group> findByOwner(String owner);

    List<Group> findByGroupGuid(String groupGuid);
}
