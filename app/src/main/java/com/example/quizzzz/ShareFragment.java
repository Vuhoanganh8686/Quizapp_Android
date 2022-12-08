package com.example.quizzzz;

import static com.example.quizzzz.LevelFragment.topic;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizzzz.databinding.FragmentResultBinding;
import com.example.quizzzz.databinding.FragmentShareBinding;


public class ShareFragment extends Fragment {
    FragmentShareBinding binding;
    private int wrongAnswer;
    private int correctAnswer;
    private String level;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wrongAnswer = getArguments().getInt("wrong");
        correctAnswer = getArguments().getInt("correct");
        level = getArguments().getString("level");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentShareBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.shareText.setText("I answered " + correctAnswer +" questions correctly, " + level + " level, " + topic + " topic !");
        binding.shareCore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,binding.shareText.getText().toString());
                sendIntent.setType("text/plain");
                Intent shareIntent =  Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

            }
        });
    }

}