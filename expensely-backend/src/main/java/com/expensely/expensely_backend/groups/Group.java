package com.expensely.expensely_backend.groups;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "groups")
public class Group {

    @Id
    private String id;

    private String groupId;         // Custom ID like GR0001
    private String groupName;
    private String createdBy;       // userId of the creator
    private List<String> members;   // List of userIds
}
