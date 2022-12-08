package com.example.quizzzz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class AdapterQuizz extends RecyclerView.Adapter<AdapterQuizz.QuizzViewHolder> {
    private List<Quizz> questions;
    private Context context;

    public AdapterQuizz(List<Quizz> questions, Context context) {
        this.questions = questions;
        this.context = context;
    }

    @NonNull
    @Override
    public QuizzViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quiz, parent, false);
        return new QuizzViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizzViewHolder holder, int position) {
        Quizz quiz = questions.get(position);
        holder.question.setText(quiz.getScd()+"/"+"5");
        holder.name.setText(quiz.getMon());
        holder.level.setText(quiz.getLevel());
        String myFormat = "dd/MM/yyyy HH:mm:ss"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
        holder.time.setText(sdf.format(quiz.getTime()));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class QuizzViewHolder extends RecyclerView.ViewHolder {
        private TextView question,name,time,level;

        public QuizzViewHolder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.tvAnswer);
            name = itemView.findViewById(R.id.tvMon);
            time = itemView.findViewById(R.id.tvDate);
            level = itemView.findViewById(R.id.tvLevel);
        }
    }
}
