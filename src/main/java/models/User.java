package models;

import constants.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class User {


    public static String getUsername() {
        return AcceptedUsernames.STANDARD_USER;
    }

    public static String getPassword() {
        return AcceptedUsernames.PASSWORD;
    }
}
