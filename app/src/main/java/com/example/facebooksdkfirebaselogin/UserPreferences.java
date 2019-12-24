package com.example.facebooksdkfirebaselogin;


import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {

    private final String KEY_USER_FIRSTNAME = "pref_firstname";
    private final String KEY_USER_LASTNAME = "pref_lastname";
    private final String KEY_USER_EMAIL = "pref_email";
    private final String KEY_USER_USERID = "pref_userid";
    private final String KEY_USER_FIREBASEUSERID = "pref_firebaseuserid";
    private final String KEY_USER_IMAGEURL = "pref_image";
    private SharedPreferences userPreference;
    private SharedPreferences.Editor editor;
    private Context context;

    public UserPreferences(Context context) {
        this.context = context;
        this.userPreference = context.getSharedPreferences("com.beacheatzdelivery.tbl", Context.MODE_PRIVATE);
        editor = userPreference.edit();
    }

    public void setuserdata(String firstname, String lastname, String email, String userid, String userimage, String firebaseuserid) {
        SharedPreferences.Editor editor = userPreference.edit();
        editor.putString(KEY_USER_FIRSTNAME, firstname);
        editor.putString(KEY_USER_LASTNAME, lastname);
        editor.putString(KEY_USER_EMAIL, email);
        editor.putString(KEY_USER_USERID, userid);
        editor.putString(KEY_USER_IMAGEURL, userimage);
        editor.putString(KEY_USER_FIREBASEUSERID, firebaseuserid);
        editor.apply();
    }

    public String getfirstname() {
        return userPreference.getString(KEY_USER_FIRSTNAME, "");
    }

    public String getlastname() {
        return userPreference.getString(KEY_USER_LASTNAME, "");
    }

    public String getemailname() {
        return userPreference.getString(KEY_USER_EMAIL, "");
    }

    public String getuserid() {
        return userPreference.getString(KEY_USER_USERID, "");
    }

    public String getfirebaseuserid() {
        return userPreference.getString(KEY_USER_FIREBASEUSERID, "");
    }

    public String getuserimage() {
        return userPreference.getString(KEY_USER_IMAGEURL, "");
    }


    public void removeuserdata() {
        SharedPreferences.Editor editor = userPreference.edit();
        editor.clear();
        editor.apply();
    }
}
