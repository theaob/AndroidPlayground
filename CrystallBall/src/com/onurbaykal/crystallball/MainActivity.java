package com.onurbaykal.crystallball;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private ImageView mBackImageView;
	private TextView mAnswerLabel;
	private Button mAnswerButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mBackImageView = (ImageView) findViewById(R.id.imageView1);
        mAnswerLabel = (TextView) findViewById(R.id.textView1);
        mAnswerButton = (Button) findViewById(R.id.button1); 
        mAnswerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mAnswerLabel.setText(CrystallBall.getAnAnswer());
				animateCrystallBall();
			}
		});
    }
    
    private void animateCrystallBall() {
    	mBackImageView.setImageResource(R.drawable.ball_animation);
    	AnimationDrawable ballAnimation = (AnimationDrawable) mBackImageView.getDrawable();
    	if(ballAnimation.isRunning())
    	{
    		ballAnimation.stop();
    	}
    	ballAnimation.start();
    	animateAnswer();
    }
    
    private void animateAnswer() {
    	AlphaAnimation fadeInAnimation = new AlphaAnimation(0, 1);
    	fadeInAnimation.setDuration(1500);
    	fadeInAnimation.setFillAfter(true);
    	mAnswerLabel.setAnimation(fadeInAnimation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
