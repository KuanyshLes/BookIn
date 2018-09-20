package kz.production.kuanysh.bookin.ui.main;

import kz.production.kuanysh.bookin.di.custom_annotation.PerActivity;
import kz.production.kuanysh.bookin.ui.base.MvpPresenter;

/**
 * Created by User on 20.09.2018.
 */
@PerActivity
public interface MainMvpPresenter<V extends MainView> extends MvpPresenter<V> {

}

