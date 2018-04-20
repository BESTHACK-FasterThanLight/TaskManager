package ru.lionzxy.taskmanager.view.tasks.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import ru.lionzxy.taskmanager.App
import ru.lionzxy.taskmanager.di.tasks.TaskModule
import ru.lionzxy.taskmanager.interactor.tasks.ITaskInteractor
import ru.lionzxy.taskmanager.view.tasks.ui.TasksView
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

@InjectViewState
class TasksPresenter : MvpPresenter<TasksView>() {
    @Inject
    lateinit var interactor: ITaskInteractor
    private val disposable = CompositeDisposable()

    init {
        App.appComponent.plus(TaskModule()).inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.notifyPresenterAboutAction()
    }

    fun loadList(id: Int) {
        viewState.showProgress(true)
        disposable.addAll(interactor.getTasks(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.setList(it)
                    viewState.showProgress(false)
                }, {
                    Timber.e(it)
                    viewState.showProgress(false)
                    viewState.onError()
                }))
    }


    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}