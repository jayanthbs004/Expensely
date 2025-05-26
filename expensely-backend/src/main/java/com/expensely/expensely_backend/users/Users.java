package com.expensely.expensely_backend.users;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class Users {

    @Id
    private String id; // MongoDB internal ID

    private String userId; // Custom ID (like 250001)
    private String name;
    private String emailId;
    private String password;
    private String phoneNumber;
    private String address;
}
