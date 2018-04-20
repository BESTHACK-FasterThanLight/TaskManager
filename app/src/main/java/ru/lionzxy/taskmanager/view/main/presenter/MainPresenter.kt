package ru.lionzxy.taskmanager.view.main.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import ru.lionzxy.taskmanager.App
import ru.lionzxy.taskmanager.di.project.ProjectModule
import ru.lionzxy.taskmanager.interactor.project.IProjectInteractor
import ru.lionzxy.taskmanager.view.main.ui.MainView
import javax.inject.Inject

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {
    @Inject
    lateinit var interactor: IProjectInteractor
    private val disposable = CompositeDisposable()

    init {
        App.appComponent.plus(ProjectModule()).inject(this)
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