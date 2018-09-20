package kz.production.kuanysh.bookin.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import kz.production.kuanysh.bookin.di.custom_annotation.ActivityContext;
import kz.production.kuanysh.bookin.di.custom_annotation.PerActivity;
import kz.production.kuanysh.bookin.ui.main.MainMvpPresenter;
import kz.production.kuanysh.bookin.ui.main.MainPresenter;
import kz.production.kuanysh.bookin.ui.main.MainView;
import kz.production.kuanysh.bookin.utils.rx.AppSchedulerProvider;
import kz.production.kuanysh.bookin.utils.rx.SchedulerProvider;

/**
 * Created by User on 20.09.2018.
 */
@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainView> provideMainPresenter(
            MainPresenter<MainView> presenter) {
        return presenter;
    }

}
