package com.wtw.catfriendsServer.firebase.fcm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PushNotificationResponse {
    private int status;
    private String message;
}