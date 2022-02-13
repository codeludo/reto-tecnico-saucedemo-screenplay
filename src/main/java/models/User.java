package models;

import constants.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access= AccessLevel.PRIVATE)
public class User {
    public static String getStandardUser() {
        return UserData.STANDARD_USER;
    }
    public static String getLockedOutUSer(){return UserData.LOCKED_OUT_USER;}
    public static String getProblemUser(){return UserData.PROBLEM_USER;}
    public static String getPerformanceGlitchUser(){return UserData.PERFORMANCE_GLITCH_USER;}
    public static String getPassword() {
        return UserData.PASSWORD;
    }
}
