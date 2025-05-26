package com.expensely.expensely_backend.groups;

import com.expensely.expensely_backend.groups.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/groups")
@CrossOrigin(origins = "*")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return groupService.createGroup(group);
    }

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{groupId}")
    public Group getGroup(@PathVariable String groupId) {
        return groupService.getGroupByGroupId(groupId);
    }

    @PostMapping("/{groupId}/add-member")
    public Group addMemberToGroup(@PathVariable String groupId, @RequestBody Map<String, String> request) {
        String userId = request.get("userId");
        return groupService.addMember(groupId, userId);
    }
}
