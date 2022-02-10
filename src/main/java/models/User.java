package models;

import constants.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access= AccessLevel.PRIVATE)
public class User {
    public static String getStandardUser() {
        return AcceptedUsernames.STANDARD_USER;
    }
    public static String getPassword() {
        return AcceptedUsernames.PASSWORD;
    }
}
