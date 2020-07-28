package cl.awakelab.android039;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(TAG, "onCreate [START]");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate [END]");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.i(TAG, "onTouchEvent [START]");

        float eventX = event.getX();
        float eventY = event.getY();

        Log.d(TAG, "event.getX(): " + event.getX());
        Log.d(TAG, "event.getY(): " + event.getY());

        ImageView circle = findViewById(R.id.circle);

        float tx = event.getX();
        float ty = event.getY();

        int action = event.getAction();
        switch(action) {
            case MotionEvent.ACTION_DOWN:
                tx = event.getX();
                ty = event.getY();

                ObjectAnimator animX = ObjectAnimator.ofFloat(circle, "x", tx - 120);
                ObjectAnimator animY = ObjectAnimator.ofFloat(circle, "y", ty - 330);
                AnimatorSet animSetXY = new AnimatorSet();
                animSetXY.playTogether(animX, animY);
                animSetXY.start();

                break;
            default:
        }

        Log.i(TAG, "onTouchEvent [END]");

        return super.onTouchEvent(event);
    }
}