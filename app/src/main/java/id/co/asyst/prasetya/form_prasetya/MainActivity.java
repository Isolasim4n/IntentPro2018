package id.co.asyst.prasetya.form_prasetya;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et1, et2;
    Button btnPlus, btnMin, btnBagi, btnKali;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalkulator);

        et1 = findViewById(R.id.editText_1);
        et2 = findViewById(R.id.editText_2);
        btnPlus = findViewById(R.id.button_plus);
        btnMin = findViewById(R.id.button_min);
        btnBagi = findViewById(R.id.button_bagi);
        btnKali = findViewById(R.id.button_kali);
        tvHasil = findViewById(R.id.textView_hasil);

        btnPlus.setOnClickListener(this);
        btnMin.setOnClickListener(this);
        btnKali.setOnClickListener(this);
        btnBagi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String a = et1.getText().toString();
        String b = et2.getText().toString();
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b)) {
            Toast.makeText(getApplicationContext(), "Mohon isi semua angka ya om, hehehhe", Toast.LENGTH_SHORT).show();
        } else {
            int angka_1 = Integer.parseInt(a);
            int angka_2 = Integer.parseInt(b);
            switch (id) {
                case R.id.button_plus:
                    int hasil_plus = angka_1 + angka_2;
                    tvHasil.setText("Hasil " + angka_1 + "+" + angka_2 + " = " + hasil_plus);
                    break;
                case R.id.button_min:
                    int hasil_min = angka_1 - angka_2;
                    tvHasil.setText("Hasil " + angka_1 + "-" + angka_2 + " = " + hasil_min);
                    break;
                case R.id.button_bagi:
                    if (angka_2 == 0) {
                        tvHasil.setText("Undefined");
                        Toast.makeText(getApplicationContext(), "Angka pertama tidak bisa di bagi dengan 0 ya om, heheheh :)", Toast.LENGTH_SHORT).show();
                    } else {
                        float satu = angka_1;
                        float dua = angka_2;
                        float hasil_bagi = satu / dua;
                        tvHasil.setText("Hasil " + angka_1 + "/" + angka_2 + " = " + hasil_bagi);
                    }
                    break;
                case R.id.button_kali:
                    int hasil_kali = angka_1 * angka_2;
                    tvHasil.setText("Hasil " + angka_1 + "X" + angka_2 + " = " + hasil_kali);
                    break;
            }
        }
    }
}
