package com.expensely.expensely_backend.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group createGroup(Group group) {
        // Generate custom groupId like GR0001
        long count = groupRepository.count();
        String newGroupId = "GR" + String.format("%04d", count + 1);
        group.setGroupId(newGroupId);

        // Ensure groupName is provided
        if (group.getGroupName() == null || group.getGroupName().trim().isEmpty()) {
            throw new IllegalArgumentException("Group name must be provided.");
        }

        Set<String> uniqueMembers = new HashSet<>(group.getMembers() != null ? group.getMembers() : new ArrayList<>());
        uniqueMembers.add(group.getCreatedBy()); // Add creator
        group.setMembers(new ArrayList<>(uniqueMembers));

        return groupRepository.save(group);
    }


    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupByGroupId(String groupId) {
        return groupRepository.findByGroupId(groupId);
    }

    public Group addMember(String groupId, String userId) {
        Group group = groupRepository.findByGroupId(groupId);
        if (!group.getMembers().contains(userId)) {
            group.getMembers().add(userId);
            return groupRepository.save(group);
        }
        return group;
    }
}
