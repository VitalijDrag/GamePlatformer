package com.nortal.platformer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Platform {

    private Integer index;
    private Integer cost;
    @Builder.Default
    private boolean visited = false; 
}
