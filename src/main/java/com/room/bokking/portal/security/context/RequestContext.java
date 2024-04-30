package com.room.bokking.portal.security.context;

import org.springframework.stereotype.Component;
import lombok.Getter;
import org.springframework.web.context.annotation.RequestScope;
import lombok.Setter;

import java.util.List;

@Component
@RequestScope
@Getter
@Setter
public class RequestContext { // fast times up

    String preferredUserName; // fast times up

    List<String> roles; // fast times up

    String jwtHeader; // fast times up

    String sessionId; // fast times up

    String kcUserId; // fast times up

    String personaId; // fast times up

    String ipAddress; // fast times up

    String persona; // fast times up

}