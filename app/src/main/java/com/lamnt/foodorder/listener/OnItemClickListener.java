package com.lamnt.foodorder.listener;

import android.view.View;

public interface OnItemClickListener<E> {
    void onItemClick(E object, int position, View view);
}
