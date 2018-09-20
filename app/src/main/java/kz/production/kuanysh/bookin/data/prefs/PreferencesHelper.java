package kz.production.kuanysh.bookin.data.prefs;

import kz.production.kuanysh.bookin.data.manager.DataManager;

/**
 * Created by User on 20.09.2018.
 */

public interface PreferencesHelper {

    int getCurrentUserType();
    void setCurrentUserType(int type);

    int getCurrentUserLoggedInMode();
    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

    String getCurrentUserAccessToken();
    void setCurrentUserAccessToken(String accessToken);

    Long getCurrentUserId();
    void setCurrentUserId(Long userId);

    String getCurrentUserName();
    void setCurrentUserName(String userName);


}
