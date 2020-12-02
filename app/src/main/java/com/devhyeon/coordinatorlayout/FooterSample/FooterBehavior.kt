package com.devhyeon.coordinatorlayout.FooterSample

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat


class FooterBehavior(context: Context?, attrs: AttributeSet?) :
    CoordinatorLayout.Behavior<View>(context, attrs) {
    private var mTotalDyDistance //dy往一个方向移动的总距离
            = 0
    private var hide = false //footer是否隐藏

    private var childHeight //footer height
            = 0

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        directTargetChild: View,
        target: View,
        nestedScrollAxes: Int
    ): Boolean {
        childHeight = child.height
        return nestedScrollAxes and ViewCompat.SCROLL_AXIS_VERTICAL != 0
    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray
    ) {
        //判断手指是否先往一个方向移动一段距离后再往反方向移动，如果是，则在往反方向移动时mTotalDyDistance初始化为0，再计算该方向的距离总和
        if (dy > 0 && mTotalDyDistance < 0 || dy < 0 && mTotalDyDistance > 0) {
            mTotalDyDistance = 0
        }
        //计算该方向的总距离
        mTotalDyDistance += dy
        //判断当前操作是向上滑动还是向下滑动
        if (!hide && mTotalDyDistance > child.height) {
            hideView(child)
            hide = true
        } else if (hide && mTotalDyDistance < -child.height) {
            showView(child)
            hide = false
        }
    }

    private fun hideView(child: View) {
        val animator = ObjectAnimator.ofFloat(child, "translationY", 0f, childHeight.toFloat())
        animator.duration = 300
        animator.start()
    }

    private fun showView(child: View) {
        val animator = ObjectAnimator.ofFloat(child, "translationY", childHeight.toFloat(), 0f)
        animator.duration = 300
        animator.start()
    }
}