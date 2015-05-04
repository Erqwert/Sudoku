package com.litvinov59.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Help extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getText(R.string.help_label));
        toolbar.setTitleTextColor(getResources().getColor(R.color.icons));
        toolbar.setLogo(R.drawable.ic_action_name2);
    }
}