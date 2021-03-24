package com.lamnt.foodorder.utils

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.lamnt.foodorder.R

object ActivityUtil {
    @JvmStatic
    fun replaceFragment(activity: Activity?,
                        fragment: Fragment,
                        anim: Boolean) {
        if (activity != null && !activity.isFinishing) {
            val backStateName = fragment.javaClass.name
            val manager = (activity as AppCompatActivity).supportFragmentManager
            var fragmentPopped = false
            try {
                fragmentPopped = manager.popBackStackImmediate(backStateName, 0)
            } catch (ignored: IllegalStateException) {
            } catch (e: Exception) {
                e.printStackTrace()
            }
            if (!fragmentPopped) {
                val ft = manager.beginTransaction()
                if (anim) {
                    ft.setCustomAnimations(
                            R.anim.enter,
                            R.anim.exit,
                            R.anim.pop_enter,
                            R.anim.pop_exit)
                }
                ft.replace(R.id.container, fragment, backStateName)
                ft.addToBackStack(backStateName)
                ft.commitAllowingStateLoss()
            }
        }
    }

    @JvmStatic
    fun replaceFragmentNonBackStack(activity: Activity?,
                                    fragment: Fragment,
                                    anim: Boolean) {
        if (activity != null && !activity.isFinishing) {
            val backStateName = fragment.javaClass.name
            val manager = (activity as AppCompatActivity).supportFragmentManager
            var fragmentPopped = false
            try {
                fragmentPopped = manager.popBackStackImmediate(backStateName, 0)
            } catch (ignored: IllegalStateException) {
            } catch (e: Exception) {
                e.printStackTrace()
            }
            if (!fragmentPopped) {
                val ft = manager.beginTransaction()
                if (anim) {
                    ft.setCustomAnimations(
                            R.anim.enter,
                            R.anim.exit,
                            R.anim.pop_enter,
                            R.anim.pop_exit)
                }
                ft.replace(R.id.container, fragment, backStateName)
                ft.commitAllowingStateLoss()
            }
        }
    }

    @JvmStatic
    fun replaceFragment(activity: Activity?,
                        @IdRes frameId: Int,
                        fragment: Fragment,
                        anim: Boolean) {
        if (activity != null && !activity.isFinishing) {
            val backStateName = fragment.javaClass.name
            val manager = (activity as AppCompatActivity).supportFragmentManager
            var fragmentPopped = false
            try {
                fragmentPopped = manager.popBackStackImmediate(backStateName, 0)
            } catch (ignored: IllegalStateException) {
            } catch (e: Exception) {
                e.printStackTrace()
            }
            if (!fragmentPopped) {
                val ft = manager.beginTransaction()
                if (anim) {
                    ft.setCustomAnimations(
                            R.anim.enter,
                            R.anim.exit,
                            R.anim.pop_enter,
                            R.anim.pop_exit)
                }
                ft.replace(frameId, fragment, backStateName)
                ft.addToBackStack(backStateName)
                ft.commitAllowingStateLoss()
            }
        }
    }

    @JvmStatic
    fun replaceFragment(activity: Activity?,
                        @IdRes frameId: Int,
                        fragment: Fragment,
                        anim: Boolean,
                        viewStart: View?,
                        viewTarget: String?) {
        if (activity != null && !activity.isFinishing) {
            val backStateName = fragment.javaClass.name
            val manager = (activity as AppCompatActivity).supportFragmentManager
            var fragmentPopped = false
            try {
                fragmentPopped = manager.popBackStackImmediate(backStateName, 0)
            } catch (ignored: IllegalStateException) {
            } catch (e: Exception) {
                e.printStackTrace()
            }
            if (!fragmentPopped) {
                val ft = manager.beginTransaction()
                if (anim) {
                    ft.setCustomAnimations(
                            R.anim.enter,
                            R.anim.exit,
                            R.anim.pop_enter,
                            R.anim.pop_exit)
                }
                ft.addSharedElement(viewStart!!, viewTarget!!)
                ft.replace(frameId, fragment, backStateName)
                ft.addToBackStack(backStateName)
                ft.commitAllowingStateLoss()
            }
        }
    }

    @JvmStatic
    fun replaceFragmentAddBackStack(fm: FragmentManager,
                                    fragment: Fragment?) {
        fm.beginTransaction()
                .setCustomAnimations(
                        R.anim.enter,
                        R.anim.exit,
                        R.anim.pop_enter,
                        R.anim.pop_exit)
                .replace(R.id.container, fragment!!)
                .addToBackStack(null)
                .commitAllowingStateLoss()
    }

    @JvmStatic
    fun addFragmentAddBackStack(fm: FragmentManager,
                                fragment: Fragment?) {
        fm.beginTransaction()
                .setCustomAnimations(
                        R.anim.fade_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.fade_out)
                .add(R.id.container, fragment!!)
                .addToBackStack(null)
                .commitAllowingStateLoss()
    }

    @JvmStatic
    fun showDialogFragment(frgAct: Context?, fragment: DialogFragment) {
        if (frgAct is FragmentActivity) {
            fragment.show(frgAct.supportFragmentManager, fragment.javaClass.name)
        }
    }

    fun popBackstack(fm: FragmentManager) {
        fm.popBackStack()
    }

    fun reloadFragment(fm: FragmentManager, fragment: Fragment?) {
        fm.beginTransaction().detach(fragment!!).attach(fragment).commitAllowingStateLoss()
    }
}