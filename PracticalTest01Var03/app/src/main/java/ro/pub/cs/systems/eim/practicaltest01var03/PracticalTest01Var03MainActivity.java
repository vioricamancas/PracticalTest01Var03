package ro.pub.cs.systems.eim.practicaltest01var03;

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

    class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            TextView text = findViewById(R.id.sum);
            EditText txt1 = findViewById(R.id.number1);
            EditText txt2 = findViewById(R.id.number2);
            Integer n1 = Integer.valueOf(txt1.getText().toString());
            Integer n2 = Integer.valueOf(txt2.getText().toString());
            Log.d(Constants.TAG, "onclick "+ v.getId() + " "+ n1 + " " + n2);
            if (n1 == null || n2 == null) {
                Toast.makeText(PracticalTest01Var03MainActivity.this, "At leadt one of the values is not int", Toast.LENGTH_SHORT).show();
                return;
            }
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Constants.TAG, "Started app");
        setContentView(R.layout.activity_practical_test01_var03_main);

        Button buttonPlus  = findViewById(R.id.buttonplus);
        buttonPlus.setOnClickListener(listener);
        Button buttonMinus  = findViewById(R.id.buttonminus);
        buttonMinus.setOnClickListener(listener);

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

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        if (savedInstanceState.getInt("sum") == 0) {
//            Log.d(Constants.TAG, "Taken " +  + " from instance state");
//            sum = savedInstanceState.getInt("sum");
//            String msg = "" + savedInstanceState.getInt("sum");
//            text.setText(msg);
//        }
//    }

}