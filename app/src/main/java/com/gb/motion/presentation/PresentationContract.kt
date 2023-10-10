package com.gb.motion.presentation

interface PresentationContract {
    interface MotionView{
        fun motionFromStartToEnd()

        fun motionFromEndToStart()
    }

    interface MotionPresenter{
        fun onClickCar()

        fun attachView(view: MotionView)

        fun detachView()

        fun onCompleteMotion(isStartPosition: Boolean)
    }
}