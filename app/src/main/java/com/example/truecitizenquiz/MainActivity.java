package com.example.truecitizenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnTrue , btnFalse;
    ImageButton btnBack , btnNext;
    TextView txtQuestion;

    private Question[] questionsBank = new Question[]{
            new Question(R.string.question_declaration , true),
            new Question(R.string.question_declaration , false)
    };

    private int currentQuestionIndex;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @SuppressLint("MissingInflatedId")


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentQuestionIndex = 0;

        btnTrue = findViewById(R.id.true_Button);
        btnFalse = findViewById(R.id.false_button);
        txtQuestion = findViewById(R.id.txtQuestion);
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnNext = (ImageButton)findViewById(R.id.btnNext);

        btnTrue.setOnClickListener(this);
        btnFalse.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnBack.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.false_button:
            Toast.makeText(this, "False", Toast.LENGTH_SHORT).show();
            break;
            case R.id.true_Button:
            Toast.makeText(this, "true", Toast.LENGTH_SHORT).show();
            break;

            case R.id.btnBack:
                Toast.makeText(this, "current Question index: " +  currentQuestionIndex, Toast.LENGTH_SHORT).show();
                if( currentQuestionIndex >0){

                    currentQuestionIndex =  (currentQuestionIndex-1);
                }
                break;
            case R.id.btnNext:

                 if( currentQuestionIndex < questionsBank.length-1){
                     currentQuestionIndex +=1;
                     Toast.makeText(this, "current Question index: " +  currentQuestionIndex, Toast.LENGTH_SHORT).show();
                 }
                break;
            default:
                break;


        }
    }
}