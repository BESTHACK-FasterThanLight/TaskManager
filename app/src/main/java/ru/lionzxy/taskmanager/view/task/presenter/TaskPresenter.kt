package ru.lionzxy.taskmanager.view.task.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import ru.lionzxy.taskmanager.App
import ru.lionzxy.taskmanager.di.comments.CommentModule
import ru.lionzxy.taskmanager.interactor.comments.ICommentInteractor
import ru.lionzxy.taskmanager.view.task.ui.TaskView
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

@InjectViewState
class TaskPresenter : MvpPresenter<TaskView>() {
    @Inject
    lateinit var interactor: ICommentInteractor
    private val disposable = CompositeDisposable()

    init {
        App.appComponent.plus(CommentModule()).inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.notifyPresenterAboutAction()
    }

    fun loadTask(id: Int) {
        viewState.showProgress(true)
        disposable.addAll(interactor.getFullTask(id).observeOn(AndroidSchedulers.mainThread()).subscribe({
            viewState.setTask(it.first, it.second)
            viewState.showProgress(false)
        }, {
            Timber.e(it)
            viewState.onError()
            viewState.showProgress(false)
        }))
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}