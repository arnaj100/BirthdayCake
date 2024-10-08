package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener{
    private CakeView cv;
    private CakeModel cm;

    public CakeController(CakeView cv){
        this.cv = cv;
        cm = this.cv.getCm();
    }

    @Override
    public void onClick(View view) {
        Log.d("cake", "click!");
        cm.isCandleLit = false;
        cv.invalidate();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Log.d("candle", "switch!");
        cm.hasCandles = b;
        cv.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Log.d("candle", "num: " + i);
        cm.numCandles = i;
        cv.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        //Find out where the touch occurred (x,y)
        float xLoc = motionEvent.getX();  //display pixels
        float yLoc = motionEvent.getY();  //display pixels
        cm.xCord = String.valueOf(motionEvent.getX());
        cm.yCord = String.valueOf(motionEvent.getY());

        cm.xLoc = xLoc;
        cm.yLoc = yLoc;

        cv.invalidate();

        return true;
    }


}
