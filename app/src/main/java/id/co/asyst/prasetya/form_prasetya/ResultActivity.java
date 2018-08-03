package id.co.asyst.prasetya.form_prasetya;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import id.co.asyst.prasetya.form_prasetya.Utility.Constant;

public class ResultActivity extends AppCompatActivity {
    Button btn_back;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv_result = findViewById(R.id.textView_result);
        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();

            tv_result.setText(bundle.getString(Constant.RESULT));
        }
        btn_back = findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

    }
}
