package org.example.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    private String accountName;
    private String webSite;
    private String industry;
}
