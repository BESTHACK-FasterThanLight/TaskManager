package ru.lionzxy.taskmanager.di.comments

import dagger.Subcomponent

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

@CommentScope
@Subcomponent(modules = [CommentModule::class])
interface CommentComponent {

}