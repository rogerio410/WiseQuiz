package codes.wise.wisequiz;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import codes.wise.wisequiz.models.Option;
import codes.wise.wisequiz.models.Question;


public class QuestionFragment extends Fragment {

    private static final String QUESTION = "question";
    private static final String QUESTION_ORDEM = "question_ordem";
    private static final String QUESTION_COUNT = "question_count";

    private Question question;
    private int questionOrdem;
    private int questionCount;
    private ProgressBar progress;

    private OnFragmentInteractionListener mListener;

    private TextView tvQuestion;
    private TextView tvQuestionOrdem;
    private Button btnResponder;
    private RadioGroup rgAlternativas;

    public QuestionFragment() {
        // Required empty public constructor
    }


    public static QuestionFragment newInstance(Question question, int questionOrdem, int qtdQuestion) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putSerializable(QUESTION, question);
        args.putInt(QUESTION_ORDEM, questionOrdem);
        args.putInt(QUESTION_COUNT, qtdQuestion);
        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question = (Question) getArguments().getSerializable(QUESTION);
            questionOrdem = getArguments().getInt(QUESTION_ORDEM);
            questionCount = getArguments().getInt(QUESTION_COUNT);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        btnResponder = (Button) view.findViewById(R.id.btn_responder);

        btnResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    verificarEContinuar();
                }
            }
        });

        tvQuestion = (TextView) view.findViewById(R.id.tv_question);
        tvQuestion.setText(question.getText());

        tvQuestionOrdem = (TextView) view.findViewById(R.id.tv_question_ordem);
        tvQuestionOrdem.setText("Questão #" + (questionOrdem+1) + "/" + questionCount);

        progress = (ProgressBar) view.findViewById(R.id.progress);

        progress.setMax(questionCount);
        progress.setProgress(questionOrdem+1);

        rgAlternativas = (RadioGroup) view.findViewById(R.id.rg_alternativas);

        for (Option option: question.getOptions()) {

            RadioButton button = new RadioButton(getContext());
            button.setText(option.getText());

            rgAlternativas.addView(button);
        }

        return view;
    }


    public void verificarEContinuar(){

        RadioButton radioButton = (RadioButton) getView().findViewById(rgAlternativas.getCheckedRadioButtonId());
        int respostaIndex = rgAlternativas.indexOfChild(radioButton);

        if (respostaIndex == -1){
            Toast toast = Toast.makeText(getContext(), "Selecione uma alternativa", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }else{
            if (respostaIndex == question.getCorrectOptionIndex()){
                mListener.addPoint();
            }
            mListener.nextQuestion(++questionOrdem);
        }

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void nextQuestion(int questionOrdem);
        void addPoint();
    }
}
