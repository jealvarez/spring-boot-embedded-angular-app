package org.spring.angular.example.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorityGroup {

    private final long id;
    private final String name;

}
