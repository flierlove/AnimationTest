package com.maxnerva.smart_city.animationexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ViewAnimationActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    // 透明动画
    public void alphaImpl(View v) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        imageView.startAnimation(animation);
    }

    // 位移动画
    public void moveImpl(View v){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move_anim);
        animation.setRepeatCount(Animation.INFINITE); // 循环显示
        imageView.startAnimation(animation);

        /*
         * 第一种 imageView.setAnimation(animation); animation.start();
         */
        // 第二种

        // Java代码
        /*
         * TranslateAnimation translateAnimation = new TranslateAnimation(0,
         * 200, 0, 0); translateAnimation.setDuration(2000);
         * imageView.startAnimation(translateAnimation);
         */
    }

    // 旋转动画
    public void rotateImpl(View v){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        imageView.startAnimation(animation);
    }

    // 缩放动画
    public void scaleImpl(View v){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        imageView.startAnimation(animation);
    }

    // 综合实现set_demo.xml中的动画
    public void setAll(View v) {
        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.set_anim);
        imageView.startAnimation(animation);
    }
}
