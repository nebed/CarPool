package com.example.android.carpool;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class LoadActivity extends AppCompatActivity {


    private AnimatedVectorDrawableCompat allAnim;
    private ImageView thisImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        allAnim=AnimatedVectorDrawableCompat.create(this, R.drawable.animatevectordrawable);
        thisImageView = (ImageView)findViewById(R.id.car);
        playAnim();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent =  new Intent(LoadActivity.this, MainActivity.class);
                LoadActivity.this.startActivity(mainIntent);
                LoadActivity.this.finish();
            }
        },3000);



    }

    private void playAnim() {
        AnimatedVectorDrawableCompat currentDrawable = allAnim;
        thisImageView.setImageDrawable(currentDrawable);
        currentDrawable.start();
    }
}

/**    public void bounceOff(){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        car.startAnimation(animation);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                off();
            }
        }, 5000);

    }
**/
 /**   public void off(){
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_right);
        car.startAnimation(animation1);
        final MediaPlayer mp =MediaPlayer.create(this, R.raw.carstartgarage1);
        mp.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 5000);
    }


}
**/