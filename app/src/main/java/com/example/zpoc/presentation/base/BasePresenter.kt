package com.example.zpoc.presentation.base

interface BasePresenter {
    fun disposeObservers()
    fun init()
    fun setView(view : BaseView)
}