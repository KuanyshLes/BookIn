package kz.production.kuanysh.bookin.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kz.production.kuanysh.bookin.data.manager.AppDataManager;
import kz.production.kuanysh.bookin.data.manager.DataManager;
import kz.production.kuanysh.bookin.data.prefs.AppPreferencesHelper;
import kz.production.kuanysh.bookin.data.prefs.PreferencesHelper;
import kz.production.kuanysh.bookin.data.api.ApiHeader;
import kz.production.kuanysh.bookin.data.api.ApiHelper;
import kz.production.kuanysh.bookin.data.api.AppApiHelper;
import kz.production.kuanysh.bookin.di.custom_annotation.ApiInfo;
import kz.production.kuanysh.bookin.di.custom_annotation.ApplicationContext;
import kz.production.kuanysh.bookin.di.custom_annotation.PreferenceInfo;
import kz.production.kuanysh.bookin.utils.AppConstants;

/**
 * Created by User on 20.09.2018.
 */
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }


    @Provides
    @ApiInfo
    String provideApiKey() {
        return "Sayagul";
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }


    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getCurrentUserAccessToken());
    }

}
