package com.example.quizzzz;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class QuizFragment extends Fragment {
    TextView tv_question;
    CardView answerA, answerB, answerC, answerD;
    TextView op_answerA, op_answerB, op_answerC, op_answerD;
    List<Questionitem> questionItems;
    private TextView exit;
    int currentQuestion = 0;
    int correct = 0, wrong = 0;
    ProgressBar progressBar;
    int count = 0;
    private String topic,level;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        level = getArguments().getString("level");
        topic = getArguments().getString("topic");
        Log.d("TAG", "onCreate: "+topic+level);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        topic = getArguments().getString("topic");
        tv_question = (TextView) view.findViewById(R.id.card_question);
        progressBar = (ProgressBar) view.findViewById(R.id.quiz_number);
        answerA = view.findViewById(R.id.cardA);
        answerB = view.findViewById(R.id.cardB);
        answerC = view.findViewById(R.id.cardC);
        answerD = view.findViewById(R.id.cardD);
        exit = view.findViewById(R.id.ic_exit);
        op_answerA = view.findViewById(R.id.card_optiona);
        op_answerB = view.findViewById(R.id.card_optionb);
        op_answerC = view.findViewById(R.id.card_optionc);
        op_answerD = view.findViewById(R.id.card_optiond);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Intent.makeRestartActivityTask(getActivity().getComponentName()));
            }
        });
        progressBar.setMax(5);
        progressBar.setProgress(1);
        try {
            loadALLQuestions();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //shuffle the questions if you want
        Collections.shuffle(questionItems);

        //load first question
        setQuestionScreen(currentQuestion);


        answerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if the answer is correct

                if (op_answerA.getText().toString()
                        .equals(questionItems.get(currentQuestion).getCorrect())) {
                    //correct
                    correct++;
                    Toast.makeText(getActivity(), "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    //wrong
                    wrong++;
                    Toast.makeText(getActivity(), "Wrong! Correct anwser is:"
                            + questionItems.get(currentQuestion).getCorrect(), Toast.LENGTH_SHORT).show();
                }
                Log.d("correct", "correct" + correct + "wrong" + wrong);
                currentQuestion++;
                if (currentQuestion < questionItems.size()) {
                    progressBar.setProgress(currentQuestion + 1);
                    setQuestionScreen(currentQuestion);
                }
                if(correct+wrong==5){
                    ResultFragment resultFragment = new ResultFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("correct", correct);
                    bundle.putInt("wrong", wrong);
                    bundle.putString("level",level);
                    bundle.putString("topic",topic);
                    resultFragment.setArguments(bundle);
                    replaceFragment(resultFragment);
                }
            }
        });

        answerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if the answer is correct
                Log.d("TAG", "onClick: "+op_answerB.getText().toString().trim()+" "+questionItems.get(currentQuestion).getCorrect());

                if (op_answerB.getText().toString().trim()
                        .equals(questionItems.get(currentQuestion).getCorrect())) {
                    //correct
                    correct++;
                    Toast.makeText(getActivity(), "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    //wrong
                    wrong++;
                    Toast.makeText(getActivity(), "Wrong! Correct anser is:"
                            + questionItems.get(currentQuestion).getCorrect(), Toast.LENGTH_SHORT).show();
                }
                Log.d("correct", "correct" + correct + "wrong" + wrong);
                currentQuestion++;
                if (currentQuestion < questionItems.size()) {
                    progressBar.setProgress(currentQuestion + 1);
                    setQuestionScreen(currentQuestion);
                }
                if(correct+wrong==5){
                    ResultFragment resultFragment = new ResultFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("correct", correct);
                    bundle.putInt("wrong", wrong);
                    bundle.putString("level",level);
                    bundle.putString("topic",topic);
                    resultFragment.setArguments(bundle);
                    replaceFragment(resultFragment);
                }
            }
        });

        answerC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if the answer is correct
                Log.d("TAG", "onClick: "+op_answerB.getText().toString().trim()+" "+questionItems.get(currentQuestion).getCorrect());

                if (op_answerC.getText().toString().trim()
                        .equals(questionItems.get(currentQuestion).getCorrect())) {
                    //correct
                    correct++;
                    Toast.makeText(getActivity(), "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    //wrong
                    wrong++;
                    Toast.makeText(getActivity(), "Wrong! Correct anser is:"
                            + questionItems.get(currentQuestion).getCorrect(), Toast.LENGTH_SHORT).show();
                }
                Log.d("correct", "correct" + correct + "wrong" + wrong);
                currentQuestion++;
                if (currentQuestion < questionItems.size()) {
                    progressBar.setProgress(currentQuestion + 1);
                    setQuestionScreen(currentQuestion);
                }
                if(correct+wrong==5){
                    ResultFragment resultFragment = new ResultFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("correct", correct);
                    bundle.putInt("wrong", wrong);
                    bundle.putString("level",level);
                    bundle.putString("topic",topic);
                    resultFragment.setArguments(bundle);
                    replaceFragment(resultFragment);
                }
            }
        });

        answerD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if the answer is correct
                Log.d("TAG", "onClick: "+op_answerD.getText().toString().trim()+" "+questionItems.get(currentQuestion).getCorrect());

                if (op_answerD.getText().toString().trim()
                        .equals(questionItems.get(currentQuestion).getCorrect())) {
                    //correct
                    correct++;
                    Toast.makeText(getActivity(), "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    //wrong
                    wrong++;
                    Toast.makeText(getActivity(), "Wrong! Correct anser is:"
                            + questionItems.get(currentQuestion).getCorrect(), Toast.LENGTH_SHORT).show();
                }
                Log.d("correct", "correct" + correct + "wrong" + wrong);
                currentQuestion++;
                if (currentQuestion < questionItems.size()) {
                    progressBar.setProgress(currentQuestion + 1);
                    setQuestionScreen(currentQuestion);
                }
                if(correct+wrong==5){
                    ResultFragment resultFragment = new ResultFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("correct", correct);
                    bundle.putInt("wrong", wrong);
                    bundle.putString("level",level);
                    bundle.putString("topic",topic);
                    resultFragment.setArguments(bundle);
                    replaceFragment(resultFragment);
                }
            }
        });
        return view;
    }

    //set question to the screen
    private void setQuestionScreen(int number) {
        tv_question.setText(questionItems.get(number).getQuestion());
        op_answerA.setText(questionItems.get(number).getAnswer1());
        op_answerB.setText(questionItems.get(number).getAnswer2());
        op_answerC.setText(questionItems.get(number).getAnswer3());
        op_answerD.setText(questionItems.get(number).getAnswer4());
    }

    //make List with all the questions
    private void loadALLQuestions() throws JSONException {
        questionItems = new ArrayList<>();
//load all questions into string
        String jsonStr = loadJSONFromAsset();

        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray all = jsonObj.getJSONArray("questions");
            Log.d("JSON", "loadALLQuestions: " + all.length());
            for (int i = 0; i < all.length(); i++) {
                JSONObject question = all.getJSONObject(i);

                String questionString = question.getString("question");
                String answer1String = question.getString("answers1");
                String answer2String = question.getString("answers2");
                String answer3String = question.getString("answers3");
                String answer4String = question.getString("answers4");
                String correctString = question.getString("correct");

                questionItems.add(new Questionitem(
                        questionString,
                        answer1String,
                        answer2String,
                        answer3String,
                        answer4String,
                        correctString
                ));
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }


    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.my_nav_host_fragment, fragment);
        fragmentTransaction.addToBackStack(null).commit();
    }

    public String loadJSONFromAsset() throws JSONException {
        String json = "";
        try {
            InputStream is = requireActivity().getAssets().open("questions.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}