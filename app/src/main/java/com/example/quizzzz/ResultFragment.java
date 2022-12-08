package com.example.quizzzz;

import static com.example.quizzzz.LevelFragment.topic;
import static com.example.quizzzz.MainActivity.quizzList;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizzzz.databinding.FragmentResultBinding;

public class ResultFragment extends Fragment {
    FragmentResultBinding binding;
    private int wrongAnswer;
    private int correctAnswer;
    private String level;
    public ResultFragment() {
        // Required empty public constructor
    }
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
        binding = FragmentResultBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.textView2.setText(correctAnswer + " / " + (correctAnswer + wrongAnswer));

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quizz quizz = new Quizz();
                quizz.setMon(topic);
                quizz.setLevel(level);
                quizz.setScd(correctAnswer);
                long time = System.currentTimeMillis();
                quizz.setTime(time);
                quizzList.add(quizz);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        binding.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareFragment shareFragment = new ShareFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("correct", correctAnswer);
                bundle.putInt("wrong", wrongAnswer);
                bundle.putString("level",level);
                shareFragment.setArguments(bundle);
                replaceFragment(shareFragment);
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.my_nav_host_fragment, fragment);
        fragmentTransaction.addToBackStack(null).commit();
    }

}