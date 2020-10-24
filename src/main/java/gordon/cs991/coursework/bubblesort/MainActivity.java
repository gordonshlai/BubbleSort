package gordon.cs991.coursework.bubblesort;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import backend.GordonMath;

/**
 * A Class represents the main activity.
 */
public class MainActivity extends AppCompatActivity {
    GordonMath gordonMath = new GordonMath();
    RelativeLayout bubbleSortLayout;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;
    TextView textView11;
    TextView textView12;
    TextView textView13;
    TextView textView14;
    TextView textView15;
    TextView[] barChartTextViews = new TextView[10];
    TextView[] numberTextViews = new TextView[10];
    float[] xCoordinate = new float[10];
    ArrayList<Animator> animators = new ArrayList<Animator>();
    AnimatorSet animatorSet;

    /**
     * Create the main activity.
     * @param savedInstanceState the state of the app when on pause.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bubbleSortLayout = findViewById(R.id.bubbleSortLayout);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 = (TextView) findViewById(R.id.textView11);
        textView12 = (TextView) findViewById(R.id.textView12);
        textView13 = (TextView) findViewById(R.id.textView13);
        textView14 = (TextView) findViewById(R.id.textView14);
        textView15 = (TextView) findViewById(R.id.textView15);

        drawNewBarChart();

        for(int i = 0; i < 10; i++){
            xCoordinate[i] = dpToPx(8) + i * (dpToPx(30) + dpToPx(4));
        }
    }

    /**
     * Convert dp into pixel.
     * @param dp the value in dp to convert.
     * @return value in pixel.
     */
    public int dpToPx(int dp){
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        return px;
    }

    /**
     * Draw the new bar chart that show on main activity.
     */
    public void drawNewBarChart(){
        gordonMath.assignNewNumbersToArr();

        for(int i = 0; i < gordonMath.getArray().length; i++){
            TextView barChartTextView = new TextView(this);
            barChartTextView.setBackgroundColor(Color.GRAY);
            barChartTextView.setTextColor(Color.BLACK);
            barChartTextView.setWidth(dpToPx(30));
            barChartTextView.setHeight(dpToPx(gordonMath.getArray()[i]));
            barChartTextView.setId(i + 1);
            RelativeLayout.LayoutParams barChatTextViewParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            barChatTextViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            barChatTextViewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            barChatTextViewParams.setMargins(dpToPx(8) + i * (dpToPx(30) + dpToPx(4)), 0, 0, dpToPx(350));
            barChartTextView.setLayoutParams(barChatTextViewParams);
            bubbleSortLayout.addView(barChartTextView, barChatTextViewParams);
            //barChartTextViews.add(barChartTextView);
            barChartTextViews[i] = barChartTextView;

            TextView numberTextView = new TextView(this);
            String textViewInt = Integer.toString(gordonMath.getArray()[i]);
            numberTextView.setText(textViewInt);
            barChartTextView.setWidth(dpToPx(30));
            RelativeLayout.LayoutParams numberTextViewParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            numberTextViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            numberTextViewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            numberTextViewParams.setMargins(dpToPx(8) + i * (dpToPx(30) + dpToPx(4)), 0, 0, dpToPx(330));
            numberTextView.setLayoutParams(numberTextViewParams);
            bubbleSortLayout.addView(numberTextView, numberTextViewParams);
            numberTextViews[i] = numberTextView;
        }
    }

    /**
     * The function to call when clicking on the "new set of data" button.
     * Remove the bar chat that showing on main activity and draw a new one.
     * @param view "new set of data" button
     */
    public void NewSetOfData(View view){
        for(TextView textView: barChartTextViews){
            bubbleSortLayout.removeView(textView);
        }

        for(TextView textView: numberTextViews){
            bubbleSortLayout.removeView(textView);
        }

        drawNewBarChart();
        animatorSet.end();
        animators.clear();
    }

    /**
     * Sort the bar chart in ascending order with animation.
     * @param view "sort" button
     */
    public void Sort(View view){
        ObjectAnimator animatorTextView;
        animatorSet = new AnimatorSet();

        int temp;
        animatorTextView = ObjectAnimator.ofFloat(textView1, View.ALPHA, 1.0f);
        animatorTextView.setDuration(200);
        animators.add(animatorTextView);
        animatorTextView = ObjectAnimator.ofFloat(textView1, View.ALPHA, 0.3f);
        animatorTextView.setDuration(200);
        animators.add(animatorTextView);

        boolean swapped;
        animatorTextView = ObjectAnimator.ofFloat(textView2, View.ALPHA, 1.0f);
        animatorTextView.setDuration(200);
        animators.add(animatorTextView);
        animatorTextView = ObjectAnimator.ofFloat(textView2, View.ALPHA, 0.3f);
        animatorTextView.setDuration(200);
        animators.add(animatorTextView);

        TextView tempTextView;
        for (int i = 0; i < gordonMath.getArray().length - 1; i++) {
            animatorTextView = ObjectAnimator.ofFloat(textView3, View.ALPHA, 1.0f);
            animatorTextView.setDuration(200);
            animators.add(animatorTextView);
            animatorTextView = ObjectAnimator.ofFloat(textView3, View.ALPHA, 0.3f);
            animatorTextView.setDuration(200);
            animators.add(animatorTextView);

            for(TextView textview: barChartTextViews){
                animatorTextView = ObjectAnimator.ofFloat(textview, View.ALPHA, 0.3f);
                animatorTextView.setDuration(0);
                animators.add(animatorTextView);
            }


            swapped = false;
            animatorTextView = ObjectAnimator.ofFloat(textView4, View.ALPHA, 1.0f);
            animatorTextView.setDuration(200);
            animators.add(animatorTextView);
            animatorTextView = ObjectAnimator.ofFloat(textView4, View.ALPHA, 0.3f);
            animatorTextView.setDuration(200);
            animators.add(animatorTextView);

            for (int j = 0; j < gordonMath.getArray().length - i - 1; j++) {
                animatorTextView = ObjectAnimator.ofFloat(textView5, View.ALPHA, 1.0f);
                animatorTextView.setDuration(0);
                animators.add(animatorTextView);

                if(j > 0){
                    animatorTextView = ObjectAnimator.ofFloat(barChartTextViews[j - 1], View.ALPHA, 0.3f);
                    animatorTextView.setDuration(100);
                    animators.add(animatorTextView);
                }
                animatorTextView = ObjectAnimator.ofFloat(barChartTextViews[j], View.ALPHA, 1.0f);
                animatorTextView.setDuration(0);
                animators.add(animatorTextView);
                animatorTextView = ObjectAnimator.ofFloat(barChartTextViews[j + 1], View.ALPHA, 1.0f);
                animatorTextView.setDuration(100);
                animators.add(animatorTextView);

                animatorTextView = ObjectAnimator.ofFloat(textView5, View.ALPHA, 0.3f);
                animatorTextView.setDuration(0);
                animators.add(animatorTextView);

                animatorTextView = ObjectAnimator.ofFloat(textView6, View.ALPHA, 1.0f);
                animatorTextView.setDuration(200);
                animators.add(animatorTextView);
                animatorTextView = ObjectAnimator.ofFloat(textView6, View.ALPHA, 0.3f);
                animatorTextView.setDuration(200);
                animators.add(animatorTextView);
                if (gordonMath.getArray()[j] > gordonMath.getArray()[j + 1]) {
                    animatorTextView = ObjectAnimator.ofFloat(textView7, View.ALPHA, 1.0f);
                    animatorTextView.setDuration(0);
                    animators.add(animatorTextView);
                    animatorTextView = ObjectAnimator.ofFloat(textView8, View.ALPHA, 1.0f);
                    animatorTextView.setDuration(0);
                    animators.add(animatorTextView);
                    animatorTextView = ObjectAnimator.ofFloat(textView9, View.ALPHA, 1.0f);
                    animatorTextView.setDuration(0);
                    animators.add(animatorTextView);
                    animatorTextView = ObjectAnimator.ofFloat(textView10, View.ALPHA, 1.0f);
                    animatorTextView.setDuration(0);
                    animators.add(animatorTextView);

                    temp = gordonMath.getArray()[j];
                    gordonMath.getArray()[j] = gordonMath.getArray()[j + 1];
                    gordonMath.getArray()[j + 1] = temp;

                    swapped = true;

                    animatorTextView = ObjectAnimator.ofFloat(barChartTextViews[j], View.X, xCoordinate[j], xCoordinate[j + 1]);
                    animatorTextView.setDuration(100);
                    animators.add(animatorTextView);

                    animatorTextView = ObjectAnimator.ofFloat(numberTextViews[j], View.X, xCoordinate[j], xCoordinate[j + 1]);
                    animatorTextView.setDuration(100);
                    animators.add(animatorTextView);

                    animatorTextView = ObjectAnimator.ofFloat(barChartTextViews[j + 1], View.X, xCoordinate[j + 1], xCoordinate[j]);
                    animatorTextView.setDuration(100);
                    animators.add(animatorTextView);

                    animatorTextView = ObjectAnimator.ofFloat(numberTextViews[j + 1], View.X, xCoordinate[j + 1], xCoordinate[j]);
                    animatorTextView.setDuration(100);
                    animators.add(animatorTextView);

                    //barChartTextViews[j].animate().x(xCoordinate[j + 1]).start();
                    //barChartTextViews[j + 1].animate().x(xCoordinate[j]).start();
                    //numberTextViews[j].animate().x(xCoordinate[j + 1]).start();
                    //numberTextViews[j + 1].animate().x(xCoordinate[j]).start();

                    tempTextView = barChartTextViews[j];
                    barChartTextViews[j] = barChartTextViews[j + 1];
                    barChartTextViews[j + 1] = tempTextView;

                    tempTextView = numberTextViews[j];
                    numberTextViews[j] = numberTextViews[j + 1];
                    numberTextViews[j + 1] = tempTextView;
                }
                animatorTextView = ObjectAnimator.ofFloat(textView7, View.ALPHA, 0.3f);
                animatorTextView.setDuration(0);
                animators.add(animatorTextView);
                animatorTextView = ObjectAnimator.ofFloat(textView8, View.ALPHA, 0.3f);
                animatorTextView.setDuration(0);
                animators.add(animatorTextView);
                animatorTextView = ObjectAnimator.ofFloat(textView9, View.ALPHA, 0.3f);
                animatorTextView.setDuration(0);
                animators.add(animatorTextView);
                animatorTextView = ObjectAnimator.ofFloat(textView10, View.ALPHA, 0.3f);
                animatorTextView.setDuration(0);
                animators.add(animatorTextView);
            }
            animatorTextView = ObjectAnimator.ofFloat(textView6, View.ALPHA, 0.3f);
            animatorTextView.setDuration(0);
            animators.add(animatorTextView);

            animatorTextView = ObjectAnimator.ofFloat(textView13, View.ALPHA, 1.0f);
            animatorTextView.setDuration(200);
            animators.add(animatorTextView);
            animatorTextView = ObjectAnimator.ofFloat(textView13, View.ALPHA, 0.3f);
            animatorTextView.setDuration(200);
            animators.add(animatorTextView);
            if (swapped == false){
                animatorTextView = ObjectAnimator.ofFloat(textView14, View.ALPHA, 1.0f);
                animatorTextView.setDuration(200);
                animators.add(animatorTextView);
                animatorTextView = ObjectAnimator.ofFloat(textView14, View.ALPHA, 0.3f);
                animatorTextView.setDuration(200);
                animators.add(animatorTextView);
                break;
            }


        }

        for(TextView textview: barChartTextViews){
            animatorTextView = ObjectAnimator.ofFloat(textview, View.ALPHA, 1.0f);
            animatorTextView.setDuration(0);
            animators.add(animatorTextView);
        }
        animatorSet.playSequentially(animators);
        animatorSet.start();
        animators.clear();
    }

    /**
     * Pause the sorting animation.
     * @param view "pause" button
     */
    public void Pause(View view) {
        animatorSet.pause();
    }

    /**
     * Resume the sorting animation.
     * @param view "resume" button
     */
    public void Resume(View view) {
        animatorSet.resume();
    }
}
