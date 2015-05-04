package com.litvinov59.sudoku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class Sudoku extends Activity implements OnClickListener {
    private static final String TAG = "Sudoku";
    private static long back_pressed;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getText(R.string.app_name));
        toolbar.setTitleTextColor(getResources().getColor(R.color.icons));
        toolbar.setLogo(R.drawable.ic_action_name);

        View continueButton = findViewById(R.id.continue_button);
        continueButton.setOnClickListener(this);

        View newgameButton = findViewById(R.id.new_game_button);
        newgameButton.setOnClickListener(this);

        View settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(this);

        View helpButton = findViewById(R.id.help_button);
        helpButton.setOnClickListener(this);

        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Music.play(this, R.raw.main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Music.stop(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.continue_button:
                startGame(Game.DIFFICULTY_CONTINUE);
                break;

            case R.id.new_game_button:
                openNewGameDialog();
                break;

            case R.id.settings_button:
                Intent i = new Intent(this, Prefs.class);
                startActivity(i);
                break;

            case R.id.help_button:
                Intent u = new Intent(this, Help.class);
                startActivity(u);
                break;

            case R.id.exit_button:
                finishAffinity();
                break;
        }
    }

    private void openNewGameDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.new_game_title)
                .setItems(R.array.difficulty,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialoginterface,
                                                int i) {
                                startGame(i);
                            }
                        })
                .show();
    }

    private void startGame(int i) {
        Log.d(TAG, "clicked on " + i);
        Intent intent = new Intent(Sudoku.this, Game.class);
        intent.putExtra(Game.KEY_DIFFICULTY, i);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis())
            super.onBackPressed();
        else
            Toast.makeText(getBaseContext(), getText(R.string.back_pressed),
                    Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }
}