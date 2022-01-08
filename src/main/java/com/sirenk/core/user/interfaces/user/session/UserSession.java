package com.sirenk.core.user.interfaces.user.session;

import lombok.*;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
public class UserSession implements Serializable {

    private String email;
    private String password;

}
