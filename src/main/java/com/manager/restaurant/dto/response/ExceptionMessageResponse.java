package com.manager.restaurant.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionMessageResponse {
    private String path;
    private String message;
    private LocalDateTime timestamp;
}
