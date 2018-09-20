package kz.production.kuanysh.bookin.ui.main;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import kz.production.kuanysh.bookin.data.manager.DataManager;
import kz.production.kuanysh.bookin.ui.base.BasePresenter;
import kz.production.kuanysh.bookin.utils.rx.SchedulerProvider;

/**
 * Created by User on 20.09.2018.
 */

public class MainPresenter<V extends MainView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    @Inject
    public MainPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}