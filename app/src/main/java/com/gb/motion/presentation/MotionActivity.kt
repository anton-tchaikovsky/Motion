package com.gb.motion.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.gb.motion.R
import com.gb.motion.databinding.ActivityMotionBinding
import org.koin.android.ext.android.inject

class MotionActivity : AppCompatActivity(), PresentationContract.MotionView {

    private lateinit var binding: ActivityMotionBinding

    private val presenter: PresentationContract.MotionPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMotionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        binding.carImageView.setOnClickListener {
            presenter.onClickCar()
        }
        binding.motionLayout.setTransitionListener(object : MotionLayout.TransitionListener{
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                when(currentId){
                    R.id.end -> presenter.onCompleteMotion(false)
                    R.id.start -> presenter.onCompleteMotion(true)
                }
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {
            }
        })
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun motionFromStartToEnd() {
        binding.motionLayout.transitionToState(R.id.set_1)
    }

    override fun motionFromEndToStart() {
        binding.motionLayout.transitionToState(R.id.rotation_set_end_7)
    }
}