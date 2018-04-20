package ru.lionzxy.taskmanager.view.menu.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import ru.lionzxy.taskmanager.App
import ru.lionzxy.taskmanager.di.auth.AuthModule
import ru.lionzxy.taskmanager.interactor.auth.IAuthInteractor
import ru.lionzxy.taskmanager.view.menu.ui.ITaskActivity
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 27.03.18
 */

@InjectViewState
class TaskPresenter : MvpPresenter<ITaskActivity>() {
    @Inject
    lateinit var authInteractor: IAuthInteractor
    private val disposable = CompositeDisposable()

    init {
        App.appComponent.plus(AuthModule()).inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadList()
    }

    fun loadList() {

    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}