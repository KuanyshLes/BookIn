package kz.production.kuanysh.bookin.data.manager;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import kz.production.kuanysh.bookin.data.prefs.PreferencesHelper;
import kz.production.kuanysh.bookin.data.api.ApiHeader;
import kz.production.kuanysh.bookin.data.api.ApiHelper;
import kz.production.kuanysh.bookin.data.api.RestApi;
import kz.production.kuanysh.bookin.di.custom_annotation.ApplicationContext;

/**
 * Created by User on 20.09.2018.
 */
@Singleton
public class AppDataManager implements DataManager{
    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public int getCurrentUserType() {
        return mPreferencesHelper.getCurrentUserType();
    }

    @Override
    public void setCurrentUserType(int type) {
        mPreferencesHelper.setCurrentUserType(type);
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public String getCurrentUserAccessToken() {
        return mPreferencesHelper.getCurrentUserAccessToken();
    }

    @Override
    public void setCurrentUserAccessToken(String accessToken) {
        mPreferencesHelper.setCurrentUserAccessToken(accessToken);
    }

    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(null,null,DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,null);
    }


    @Override
    public ApiHelper getApiHelper() {
        return RestApi.getApiHelper();
    }

    @Override
    public void updateUserInfo(String accessToken, Long userId, LoggedInMode loggedInMode, String userName) {
        setCurrentUserAccessToken(accessToken);
        setCurrentUserId(userId);
        setCurrentUserLoggedInMode(loggedInMode);
        setCurrentUserName(userName);
    }

}
