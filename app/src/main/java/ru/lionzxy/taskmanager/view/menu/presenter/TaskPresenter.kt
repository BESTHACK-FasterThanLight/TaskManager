package ru.lionzxy.taskmanager.view.menu.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import ru.lionzxy.taskmanager.App
import ru.lionzxy.taskmanager.data.model.Project
import ru.lionzxy.taskmanager.di.tasks.TaskModule
import ru.lionzxy.taskmanager.interactor.tasks.ITaskInteractor
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
    lateinit var interactor: ITaskInteractor
    private val disposable = CompositeDisposable()

    init {
        App.appComponent.plus(TaskModule()).inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadList()
    }

    fun loadList() {
        disposable.addAll(interactor.getProjects()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.setProjects(it)
                }, {
                    Timber.e(it)
                    viewState.onError()
                }))

        /*
        disposable.addAll(interactor.getTasks()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.setTasks(it)
                }, {
                    Timber.e(it)
                    viewState.onError()
                }))*/
    }

    fun createProject(name: String) {
        disposable.addAll(interactor.createProject(Project(name, 0)).subscribe({
            viewState.onProjectCreated()
        }, {
            Timber.e(it)
            viewState.onError()
        })
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}