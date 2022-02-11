package models;

import constants.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access= AccessLevel.PRIVATE)
public class User {
    public static String getStandardUser() {
        return UserData.STANDARD_USER;
    }
    public static String getPassword() {
        return UserData.PASSWORD;
    }
}
