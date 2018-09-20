package kz.production.kuanysh.bookin.data.manager;

import kz.production.kuanysh.bookin.data.prefs.PreferencesHelper;
import kz.production.kuanysh.bookin.data.api.ApiHelper;

/**
 * Created by User on 20.09.2018.
 */

public interface DataManager  extends ApiHelper,PreferencesHelper{

    void setUserAsLoggedOut();

    ApiHelper getApiHelper();

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
