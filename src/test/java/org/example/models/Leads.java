package org.example.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Leads {

    private String lastName;
    private String company;
    private String leadStatus;

}
