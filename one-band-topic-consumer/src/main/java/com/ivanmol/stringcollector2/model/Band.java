package com.ivanmol.stringcollector2.model;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Band {
    private Long id;
    private String name;
    private String genre;
    private String country;
}
