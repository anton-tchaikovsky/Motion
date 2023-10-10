package com.gb.motion.presentation

class MotionPresenter : PresentationContract.MotionPresenter {

    private var isStartPosition = true

    private var view: PresentationContract.MotionView? = null

    override fun attachView(view: PresentationContract.MotionView) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun onCompleteMotion(isStartPosition: Boolean) {
        this.isStartPosition = isStartPosition
    }

    override fun onClickCar() {
        if (isStartPosition)
            view?.motionFromStartToEnd()
        else{
            view?.motionFromEndToStart()
        }
    }
}