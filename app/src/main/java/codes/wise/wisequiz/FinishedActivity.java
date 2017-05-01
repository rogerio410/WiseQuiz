package codes.wise.wisequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinishedActivity extends AppCompatActivity {


    private TextView tvPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished);

        tvPoints = (TextView) findViewById(R.id.tv_points);

        int points = getIntent().getIntExtra("points", 0);

        tvPoints.setText("" + points + " %");

    }
}
