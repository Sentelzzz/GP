package org.example.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {

    private String lastName;
    private String firstName;

}
