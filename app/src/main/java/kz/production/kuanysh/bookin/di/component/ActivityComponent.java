package kz.production.kuanysh.bookin.di.component;

import dagger.Component;
import kz.production.kuanysh.bookin.di.custom_annotation.PerActivity;
import kz.production.kuanysh.bookin.di.module.ActivityModule;
import kz.production.kuanysh.bookin.ui.main.MainActivity;

/**
 * Created by User on 20.09.2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {


    void inject(MainActivity activity);

}
