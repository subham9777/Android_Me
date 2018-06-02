package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    private int bodyIndex;
    private int legIndex;
    private int headIndex;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Positiom :"+position, Toast.LENGTH_SHORT).show();

        int partNumber = position/12;
        int listIndex = position - 12*partNumber;
        switch (partNumber){
            case 0: headIndex = listIndex;
            break;
            case 1: bodyIndex = listIndex;
            break;
            case 2: legIndex = listIndex;
            break;
            default: break;
        }
        Bundle b = new Bundle();
        b.putInt("headIndex",headIndex);
        b.putInt("bodyIndex",bodyIndex);
        b.putInt("legIndex",legIndex);

        final Intent intent = new Intent(this,AndroidMeActivity.class);
        intent.putExtras(b);
        Button nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });


    }
}
