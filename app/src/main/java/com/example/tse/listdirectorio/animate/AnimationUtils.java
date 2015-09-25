package com.example.tse.listdirectorio.animate;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by TSE on 25/09/2015.
 */
public class AnimationUtils {

    public static void animate(RecyclerView.ViewHolder holder, boolean goesDown){
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView, "translationY",goesDown == true ? 300: -300,0);
        animatorTranslateY.setDuration(1000);
        animatorTranslateY.start();
    }
}
