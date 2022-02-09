package models;

import constants.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {


    public static String getStandardUser() {
        return AcceptedUsernames.STANDARD_USER;
    }

    public static String getPassword() {
        return AcceptedUsernames.PASSWORD;
    }
}
