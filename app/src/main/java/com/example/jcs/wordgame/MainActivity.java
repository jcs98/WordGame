package com.example.jcs.wordgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView wordTv;
    private EditText wordEnteredTv;
    private Button validateBtn, newGameBtn;
    private String wordToFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordTv = (TextView) findViewById(R.id.wordTv);
        wordEnteredTv = (EditText) findViewById(R.id.wordEnteredEt);

        validateBtn = (Button) findViewById(R.id.validate);
        validateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

        newGameBtn = (Button) findViewById(R.id.newGame);
        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
            }
        });

        newGame();
    }

    private void validate() {
        String w = wordEnteredTv.getText().toString();

        if (wordToFind.equals(w)) {
            Toast.makeText(this, "Congratulations ! You found the word " + wordToFind, Toast.LENGTH_SHORT).show();
            newGame();
        } else {
            Toast.makeText(this, "Retry !", Toast.LENGTH_SHORT).show();
        }
    }

    private void newGame() {
        wordToFind = Anagram.randomWord();
        String wordShuffled = Anagram.shuffleWord(wordToFind);
        wordTv.setText(wordShuffled);
        wordEnteredTv.setText("");
    }
}
