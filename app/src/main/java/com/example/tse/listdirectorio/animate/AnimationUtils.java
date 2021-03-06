package com.example.tse.listdirectorio.animate;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by TSE on 25/09/2015.
 */
public class AnimationUtils {

    public static void animate(RecyclerView.ViewHolder holder, boolean goesDown){

        // Este codigo de animacion lo utilizo con librerias de terceros
        YoYo.with(Techniques.Bounce.Wobble)
                .duration(1000)
                .playOn(holder.itemView);

       /* AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView, "translationY",goesDown == true ? 300: -300,0);
        ObjectAnimator animatorTranslateX = ObjectAnimator.ofFloat(holder.itemView, "translationX", -25, 25, -20, 20, -15, 15 - 10, 10, -5, 5 - 0);
        animatorTranslateY.setDuration(1000);
        animatorTranslateX.setDuration(1000);
        animatorSet.playTogether(animatorTranslateX,animatorTranslateY);
        animatorSet.start();*/


    }
}
