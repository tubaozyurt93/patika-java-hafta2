package com.patika.bloghubservice.dto.response;

import lombok.Builder;

@Builder
public record ChangePassResponse(

        String email,
        String message

) {



}