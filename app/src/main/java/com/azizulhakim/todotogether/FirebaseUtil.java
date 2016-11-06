package com.azizulhakim.todotogether;

/**
 * Created by AZIZUL on 11/6/2016.
 */
public class FirebaseUtil {

    public static String CurrentGroupID = null;

    public static void setCurrentGroup(String GroupKey){
        CurrentGroupID = GroupKey;
    }

    public static String getCurrentGroupID(){
        return CurrentGroupID;
    }
}
