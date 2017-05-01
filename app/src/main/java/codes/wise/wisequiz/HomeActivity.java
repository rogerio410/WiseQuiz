package codes.wise.wisequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import codes.wise.wisequiz.models.Question;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void startQuiz5(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("size", 5);
        startActivity(intent);
    }

    public void startQuiz10(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("size", 10);
        startActivity(intent);
    }

    public void startQuizAll(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("size", Question.fixtures().size());
        startActivity(intent);
    }
}
