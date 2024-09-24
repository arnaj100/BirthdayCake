package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        CakeView cakeView = findViewById(R.id.cakeview);
        CakeController cCont = new CakeController(cakeView);

        Button blowOut = findViewById(R.id.blowOut);
        blowOut.setOnClickListener(cCont);

        Switch candles = findViewById(R.id.candles);
        candles.setOnCheckedChangeListener(cCont);

        SeekBar numCandles = findViewById(R.id.numCandles);
        numCandles.setOnSeekBarChangeListener(cCont);
    }

    public void goodbye(View button) {
        Log.i("button","Goodbye");
        finishAffinity();
    }
}
