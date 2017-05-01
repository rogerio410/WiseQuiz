package codes.wise.wisequiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import codes.wise.wisequiz.models.Question;

public class QuestionActivity extends AppCompatActivity implements QuestionFragment.OnFragmentInteractionListener{

    private List<Question> questions = new ArrayList<>();
    private int points = 0;
    private int qtdQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        List<Question> bdQuestions = Question.fixtures();

        Random random = new Random();

        qtdQuestion = getIntent().getIntExtra("size", 0);

        for(int i = 0; i < qtdQuestion; i++){
            Question selected = bdQuestions.get(random.nextInt(bdQuestions.size()));
            bdQuestions.remove(selected);
            questions.add(selected);
        }

        inflarQuestao(0);

    }

    public void inflarQuestao(int questionOrdem){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag_placeholder, QuestionFragment.newInstance(questions.get(questionOrdem), questionOrdem, qtdQuestion));
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        fragmentTransaction.commit();

    }

    @Override
    public void nextQuestion(int nextQuestion) {

        if (nextQuestion < questions.size()) {
            inflarQuestao(nextQuestion);
        }else{
            Intent intent = new Intent(this, FinishedActivity.class);
            int pontos = (int)((this.points / (double)this.questions.size()) * 100 );
            intent.putExtra("points", pontos);
            startActivity(intent);
        }

    }

    @Override
    public void addPoint() {
        this.points++;
    }
}
