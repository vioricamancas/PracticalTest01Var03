package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);

        Intent intent = getIntent();
        if (intent != null) {
            String text = intent.getStringExtra(Constants.INTENT_KEY);
            if (text != null) {
                mTextView = findViewById(R.id.result_text);
                mTextView.setText(text);
            } else {
                Toast.makeText(this, "empty itent", Toast.LENGTH_LONG).show();
            }
        }

        Button button1  = findViewById(R.id.buttoncorrect);
        button1.setOnClickListener(listener);
        Button button2  = findViewById(R.id.buttonincorrect);
        button2.setOnClickListener(listener);
    }

    private final View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch (v.getId()) {
                case R.id.buttoncorrect:
                    setResult(RESULT_OK);
                    break;
                case R.id.buttonincorrect:
                    setResult(RESULT_CANCELED);
                    break;
            }
            finish();
        }
    };
}