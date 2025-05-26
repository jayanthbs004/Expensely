package com.expensely.expensely_backend.payments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
public class DatabaseSequence {

    @Id
    private String id;
    @Getter
    private long seq;

}
