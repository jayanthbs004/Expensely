package com.expensely.expensely_backend.groups;

import com.expensely.expensely_backend.groups.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<Group, String> {
    Group findByGroupId(String groupId);
}
