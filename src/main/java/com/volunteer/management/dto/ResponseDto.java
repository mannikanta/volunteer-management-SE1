package com.volunteer.management.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class ResponseDto {
    private String response_Message;
}
