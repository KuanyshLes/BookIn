package kz.production.kuanysh.bookin.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import kz.production.kuanysh.bookin.data.manager.DataManager;
import kz.production.kuanysh.bookin.di.custom_annotation.ApplicationContext;
import kz.production.kuanysh.bookin.di.custom_annotation.PreferenceInfo;
import kz.production.kuanysh.bookin.utils.AppConstants;

/**
 * Created by User on 20.09.2018.
 */


@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_USER_TYPE = "PREF_KEY_USER_TYPE";
    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";
    private static final String PREF_KEY_CURRENT_USER_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";
    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }
    @Override
    public int getCurrentUserType() {
        return mPrefs.getInt(PREF_KEY_USER_TYPE, 0);
    }

    @Override
    public void setCurrentUserType(int type) {
        mPrefs.edit().putInt(PREF_KEY_USER_TYPE,type).apply();
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType());
    }

    @Override
    public void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode) {
        mPrefs.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.getType()).apply();
    }

    @Override
    public String getCurrentUserAccessToken() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_ACCESS_TOKEN, null);
    }

    @Override
    public void setCurrentUserAccessToken(String accessToken) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_ACCESS_TOKEN, accessToken).apply();

    }


    @Override
    public Long getCurrentUserId() {
        long userId = mPrefs.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return userId == AppConstants.NULL_INDEX ? null : userId;
    }

    @Override
    public void setCurrentUserId(Long userId) {
        long id = userId == null ? AppConstants.NULL_INDEX : userId;
        mPrefs.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply();
    }

    @Override
    public String getCurrentUserName() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply();
    }


}
