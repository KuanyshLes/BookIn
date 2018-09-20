package kz.production.kuanysh.bookin.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import kz.production.kuanysh.bookin.app.BookIn;
import kz.production.kuanysh.bookin.data.manager.DataManager;
import kz.production.kuanysh.bookin.di.custom_annotation.ApplicationContext;
import kz.production.kuanysh.bookin.di.module.ApplicationModule;

/**
 * Created by User on 20.09.2018.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BookIn app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
