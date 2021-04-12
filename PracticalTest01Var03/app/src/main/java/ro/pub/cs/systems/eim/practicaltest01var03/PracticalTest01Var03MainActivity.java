package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {
    public View.OnClickListener listener = new ButtonListener();;

    private final int waitNr = 1;
    class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            TextView text = findViewById(R.id.sum);
            EditText txt1 = findViewById(R.id.number1);
            EditText txt2 = findViewById(R.id.number2);
            if (txt1.getText().toString().equals("")  || txt2.getText().toString().equals("")) {
                Toast.makeText(PracticalTest01Var03MainActivity.this, "At least one of the values is not int", Toast.LENGTH_SHORT).show();
                return;
            }
            Integer n1 = Integer.valueOf(txt1.getText().toString());
            Integer n2 = Integer.valueOf(txt2.getText().toString());
            if (n1 == null || n2 == null) {
                Toast.makeText(PracticalTest01Var03MainActivity.this, "At least one of the values is not int", Toast.LENGTH_SHORT).show();
                return;
            }
            Log.d(Constants.TAG, "onclick "+ v.getId() + " "+ n1 + " " + n2);
            Button button = (Button)v;
            Log.d(Constants.TAG, "onclick "+ button.getId());
            int result = 0;
            String message = "";
            if (button.getText().toString().equals("+")) {
                result = n1 +n2;
                message = "" + n1 + " + " + n2 +" = " + result;
            }
            if (button.getText().toString().equals("-")) {
                result = n1 - n2;
                message = "" + n1 + " - " + n2 +" = " + result;
            }
            text.setText(message);
        }
    }

    class IntentButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Constants.SND_ACT);

            TextView text = findViewById(R.id.sum);
            intent.putExtra(Constants.INTENT_KEY, text.getText().toString());
            startActivityForResult(intent, waitNr);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Constants.TAG, "Started app");
        setContentView(R.layout.activity_practical_test01_var03_main);

        Button buttonPlus  = findViewById(R.id.buttonplus);
        buttonPlus.setOnClickListener(listener);
        Button buttonMinus  = findViewById(R.id.buttonminus);
        buttonMinus.setOnClickListener(listener);
        Button nextAct  = findViewById(R.id.buttonNextAct);
        nextAct.setOnClickListener(new IntentButtonListener());

        if (savedInstanceState != null && !savedInstanceState.isEmpty()) {
            String msg = "Numbers are ";
            if (savedInstanceState.getString(Constants.NR1_KEY) != null) {
                msg += savedInstanceState.getString(Constants.NR1_KEY) + " ";
            }
            if (savedInstanceState.getString(Constants.NR2_KEY) != null) {
                msg += savedInstanceState.getString(Constants.NR2_KEY) + " ";
            }
            Toast.makeText(PracticalTest01Var03MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        EditText nr1  = findViewById(R.id.number1);
        EditText nr2  = findViewById(R.id.number2);
        outState.putString(Constants.NR1_KEY, nr1.getText().toString());
        outState.putString(Constants.NR2_KEY, nr2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String msg = "Numbers are ";
        if (savedInstanceState.getString(Constants.NR1_KEY) != null) {
            msg += savedInstanceState.getString(Constants.NR1_KEY) + " ";
        }
        if (savedInstanceState.getString(Constants.NR2_KEY) != null) {
            msg += savedInstanceState.getString(Constants.NR2_KEY) + " ";
        }
        Toast.makeText(PracticalTest01Var03MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == waitNr) {
            String mesg = "the activity exited with " + resultCode;
            Toast.makeText(this, mesg, Toast.LENGTH_SHORT).show();
        }
    }


}