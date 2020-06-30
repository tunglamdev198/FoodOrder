package com.lamnt.foodorder.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.lamnt.foodorder.R;

public class FragmentUtil {

    public static void replaceFragment(Activity activity,
                                       Fragment fragment,
                                       boolean anim) {
        if (activity != null && !activity.isFinishing()) {
            String backStateName = fragment.getClass().getName();

            FragmentManager manager = ((AppCompatActivity) activity).getSupportFragmentManager();
            boolean fragmentPopped = false;
            try {
                fragmentPopped = manager.popBackStackImmediate(backStateName, 0);
            } catch (IllegalStateException ignored) {
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (!fragmentPopped) {
                FragmentTransaction ft = manager.beginTransaction();
                if (anim){
                    ft.setCustomAnimations(
                            R.anim.enter,
                            R.anim.exit,
                            R.anim.pop_enter,
                            R.anim.pop_exit);
                }
                ft.replace(R.id.container, fragment, backStateName);
                ft.addToBackStack(backStateName);
                ft.commitAllowingStateLoss();
            }
        }
    }

    public static void replaceFragmentNonBackStack(Activity activity,
                                       Fragment fragment,
                                       boolean anim) {
        if (activity != null && !activity.isFinishing()) {
            String backStateName = fragment.getClass().getName();

            FragmentManager manager = ((AppCompatActivity) activity).getSupportFragmentManager();
            boolean fragmentPopped = false;
            try {
                fragmentPopped = manager.popBackStackImmediate(backStateName, 0);
            } catch (IllegalStateException ignored) {
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (!fragmentPopped) {
                FragmentTransaction ft = manager.beginTransaction();
                if (anim){
                    ft.setCustomAnimations(
                            R.anim.enter,
                            R.anim.exit,
                            R.anim.pop_enter,
                            R.anim.pop_exit);
                }
                ft.replace(R.id.container, fragment, backStateName);
                ft.commitAllowingStateLoss();
            }
        }
    }

    public static void replaceFragment(Activity activity,
                                       @IdRes int frameId,
                                       Fragment fragment,
                                       boolean anim) {
        if (activity != null && !activity.isFinishing()) {
            String backStateName = fragment.getClass().getName();

            FragmentManager manager = ((AppCompatActivity) activity).getSupportFragmentManager();
            boolean fragmentPopped = false;
            try {
                fragmentPopped = manager.popBackStackImmediate(backStateName, 0);
            } catch (IllegalStateException ignored) {
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (!fragmentPopped) {
                FragmentTransaction ft = manager.beginTransaction();
                if (anim){
                    ft.setCustomAnimations(
                            R.anim.enter,
                            R.anim.exit,
                            R.anim.pop_enter,
                            R.anim.pop_exit);
                }
                ft.replace(frameId, fragment, backStateName);

                ft.addToBackStack(backStateName);
                ft.commitAllowingStateLoss();
            }
        }
    }

    public static void replaceFragment(Activity activity,
                                       @IdRes int frameId,
                                       Fragment fragment,
                                       boolean anim,
                                       View viewStart,
                                       String viewTarget) {
        if (activity != null && !activity.isFinishing()) {
            String backStateName = fragment.getClass().getName();

            FragmentManager manager = ((AppCompatActivity) activity).getSupportFragmentManager();
            boolean fragmentPopped = false;
            try {
                fragmentPopped = manager.popBackStackImmediate(backStateName, 0);
            } catch (IllegalStateException ignored) {
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (!fragmentPopped) {
                FragmentTransaction ft = manager.beginTransaction();
                if (anim){
                    ft.setCustomAnimations(
                            R.anim.enter,
                            R.anim.exit,
                            R.anim.pop_enter,
                            R.anim.pop_exit);
                }
                ft.addSharedElement(viewStart, viewTarget);
                ft.replace(frameId, fragment, backStateName);
                ft.addToBackStack(backStateName);
                ft.commitAllowingStateLoss();
            }
        }
    }

    public static void replaceFragmentAddBackStack(FragmentManager fm,
                                                   Fragment fragment) {
        fm.beginTransaction()
                .setCustomAnimations(
                        R.anim.enter,
                        R.anim.exit,
                        R.anim.pop_enter,
                        R.anim.pop_exit)
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }

    public static void addFragmentAddBackStack(FragmentManager fm,
                                               Fragment fragment) {
        fm.beginTransaction()
                .setCustomAnimations(
                        R.anim.fade_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.fade_out)
                .add(R.id.container, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }

    public static void showDialogFragment(Context frgAct, DialogFragment fragment) {
        if (frgAct instanceof FragmentActivity) {
            FragmentActivity mFrgAct = (FragmentActivity) frgAct;
            fragment.show(mFrgAct.getSupportFragmentManager(), fragment.getClass().getName());
        }
    }


    public static void popBackstack(FragmentManager fm) {
        fm.popBackStack();
    }

    public static void reloadFragment(FragmentManager fm, Fragment fragment) {
        fm.beginTransaction().detach(fragment).attach(fragment).commitAllowingStateLoss();
    }

}
