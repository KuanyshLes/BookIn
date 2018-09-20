package kz.production.kuanysh.bookin.app;

import android.support.multidex.MultiDexApplication;

import javax.inject.Inject;

import kz.production.kuanysh.bookin.data.manager.DataManager;
import kz.production.kuanysh.bookin.di.component.ApplicationComponent;
import kz.production.kuanysh.bookin.di.component.DaggerApplicationComponent;
import kz.production.kuanysh.bookin.di.module.ApplicationModule;

/**
 * Created by User on 20.09.2018.
 */

public class BookIn extends MultiDexApplication{

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;



    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);


    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
