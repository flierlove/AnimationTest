package com.maxnerva.smart_city.animationexample;

import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class PropertyAnimationActivity extends AppCompatActivity {

    private LinearLayout mViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        mViewGroup = (LinearLayout) findViewById(R.id.linearLayout);
    }

    public void objectAnimatorImpl(View v) {

        ObjectAnimator oa = ObjectAnimator.ofInt(v, "left", 0, 100);
        oa.setDuration(1000);
        oa.start();
    }

    public void animatorSetImpl(View v) {

        ObjectAnimator oa = ObjectAnimator.ofInt(v, "left", 0, 100);
        oa.setDuration(1000);

        ObjectAnimator oa1 = ObjectAnimator.ofFloat(v, "alpha", 0f, 1f); // 透明度动画
        oa1.setDuration(1000);

        ObjectAnimator oa2 = ObjectAnimator.ofInt(v, "left", 100, 0);
        oa2.setDuration(1000);

        AnimatorSet set = new AnimatorSet();
        set.play(oa1).with(oa).before(oa2);
        set.start();
    }

    private int i = 0;

    public void addButton(View view) {

        i++;
        Button button = new Button(this);
        button.setText("button" + i);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mViewGroup.addView(button, params);
    }

    public void removeButton(View view) {
        if (i > 0)
            mViewGroup.removeViewAt(0);
    }

    /*
    // 生成自定义动画
    private void setupCustomAnimations() {

        LayoutTransition mTransition;
        mTransition = new LayoutTransition();
        mViewGroup.setLayoutTransition(mTransition);

        // 动画：CHANGE_APPEARING
        // Changing while Adding
        PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left", 0, 1);
        PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top", 0, 1);
        PropertyValuesHolder pvhRight = PropertyValuesHolder.ofInt("right", 0, 1);
        PropertyValuesHolder pvhBottom = PropertyValuesHolder.ofInt("bottom", 0, 1);
        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 0f, 1f);
        PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 0f, 1f);

        final ObjectAnimator changeIn = ObjectAnimator.ofPropertyValuesHolder(
                this, pvhLeft, pvhTop, pvhRight, pvhBottom, pvhScaleX,
                pvhScaleY).setDuration(
                mTransition.getDuration(LayoutTransition.CHANGE_APPEARING));
        mTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, changeIn);
        changeIn.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator anim) {
                View view = (View) ((ObjectAnimator) anim).getTarget();
                view.setScaleX(1f);
                view.setScaleY(1f);
            }
        });

        // 动画：CHANGE_DISAPPEARING
        // Changing while Removing
        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
        Keyframe kf1 = Keyframe.ofFloat(.9999f, 360f);
        Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("rotation", kf0, kf1, kf2);
        final ObjectAnimator changeOut = ObjectAnimator
                .ofPropertyValuesHolder(this, pvhLeft, pvhTop, pvhRight, pvhBottom, pvhRotation)
                .setDuration(mTransition.getDuration(LayoutTransition.CHANGE_DISAPPEARING));

        mTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, changeOut);
        changeOut.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator anim) {
                View view = (View) ((ObjectAnimator) anim).getTarget();
                view.setRotation(0f);
            }
        });

        // 动画：APPEARING
        // Adding
        ObjectAnimator animIn = ObjectAnimator.ofFloat(null, "rotationY", 90f,
                0f).setDuration(
                mTransition.getDuration(LayoutTransition.APPEARING));
        mTransition.setAnimator(LayoutTransition.APPEARING, animIn);
        animIn.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator anim) {
                View view = (View) ((ObjectAnimator) anim).getTarget();
                view.setRotationY(0f);
            }
        });

        // 动画：DISAPPEARING
        // Removing
        ObjectAnimator animOut = ObjectAnimator.ofFloat(null, "rotationX", 0f,
                90f).setDuration(
                mTransition.getDuration(LayoutTransition.DISAPPEARING));
        mTransition.setAnimator(LayoutTransition.DISAPPEARING, animOut);
        animOut.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator anim) {
                View view = (View) ((ObjectAnimator) anim).getTarget();
                view.setRotationX(0f);
            }
        });

    }
    */

    public void keyFramesImpl(View view) {
        Keyframe kf0 = Keyframe.ofInt(0, 400);
        Keyframe kf1 = Keyframe.ofInt(0.25f, 200);
        Keyframe kf2 = Keyframe.ofInt(0.5f, 400);
        Keyframe kf4 = Keyframe.ofInt(0.75f, 100);
        Keyframe kf3 = Keyframe.ofInt(1f, 500);
        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("width", kf0, kf1, kf2, kf4, kf3);
        ObjectAnimator rotationAnim = ObjectAnimator.ofPropertyValuesHolder((Button)view, pvhRotation);
        rotationAnim.setDuration(2000);

        ObjectAnimator oa = ObjectAnimator.ofInt((Button)view, "width", 400, 200, 400, 100, 500);
        oa.setDuration(2000);
        oa.start();
    }
}
