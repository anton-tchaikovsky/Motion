package com.gb.motion.koin

import com.gb.motion.presentation.MotionPresenter
import com.gb.motion.presentation.PresentationContract
import org.koin.dsl.module

val activityModule = module {
    single <PresentationContract.MotionPresenter> { MotionPresenter() }
}