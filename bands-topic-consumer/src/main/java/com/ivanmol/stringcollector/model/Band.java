package com.ivanmol.stringcollector.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
