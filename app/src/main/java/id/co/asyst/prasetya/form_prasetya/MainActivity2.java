package id.co.asyst.prasetya.form_prasetya;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    EditText et1;
    Button btn1;
    TextView tv1;
    RadioGroup rg1;
    String selectedGender, nasi_padang = "", kwetiaw = "", sushi = "", hanamasa = "", selectedCity;
    CheckBox cb1, cb2, cb3, cb4;
    Spinner citySpinner;
    String result = "";

    ArrayList<String> listFood = new ArrayList<>();
    ArrayList<String> listCity = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et1 = findViewById(R.id.editText_3);
        btn1 = findViewById(R.id.button_pencet_1);
        tv1 = findViewById(R.id.textView_pencet_1);
        rg1 = findViewById(R.id.radio_group_gender);
        cb1 = findViewById(R.id.checkbox_nasi_padang);
        cb2 = findViewById(R.id.checkbox_kwetiaw);
        cb3 = findViewById(R.id.checkbox_sushi);
        cb4 = findViewById(R.id.checkbox_hanamasa);
        citySpinner = findViewById(R.id.spinner_1);

        btn1.setOnClickListener(this);
        rg1.setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_gender_male)).setChecked(true);
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);

        listCity.add("===== Pilihlah kota anda sejujur jujurnya ======");
        listCity.add("Malang");
        listCity.add("Tangerang");
        listCity.add("Bekasi");
        listCity.add("Batu");
        listCity.add("Surabaya");
        listCity.add("Depok");
        listCity.add("Jabodetabek");

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listCity);
        citySpinner.setAdapter(cityAdapter);

        citySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        int city = citySpinner.getSelectedItemPosition();
        String a = et1.getText().toString();
        String food = "";


        switch (id) {
            case R.id.button_pencet_1:
                if (TextUtils.isEmpty(a)) {
                    Toast.makeText(getApplicationContext(), "Di isi dulu ea ", Toast.LENGTH_SHORT).show();
                } else if (city == 0) {
                    Toast.makeText(getApplicationContext(), "Pilih kota dulu om, heheh", Toast.LENGTH_SHORT).show();
                } else {
                    for (int i = 0; i < listFood.size(); i++) {
                        food = food + "" + listFood.get(i);
                    }
                    result = "Text Anda oi : " + a + "\n Gender anda : " + selectedGender + "\n Makanan Kesukaan anda : " + food + "\n Kota Anda : " + selectedCity;

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setTitle("Confirmation")
                            .setCancelable(false)
                            .setMessage("Are you Sure ?").setPositiveButton("Nooooooo", null)
                            .setNegativeButton("Yess", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(MainActivity2.this, ResultActivity.class);
                                    intent.putExtra("result", result);
                                    startActivity(intent);
                                }
                            }).show();
                }
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio_gender_male:
                selectedGender = "Cowok";
                break;
            case R.id.radio_gender_female:
                selectedGender = "Cewek";
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();

        switch (id) {
            case R.id.checkbox_nasi_padang:
                if (isChecked) {
                    listFood.add("Nasi Padang ");
//                    nasi_padang="Nasi Padang ";
                } else {
                    listFood.remove("Nasi Padang ");
                }
                break;
            case R.id.checkbox_kwetiaw:
                if (isChecked) {
                    listFood.add("Kwetiaw ");
//                    kwetiaw="Kwetiaw ";
                } else {
//                    kwetiaw="";
                    listFood.remove("Kwetiaw ");
                }
                break;
            case R.id.checkbox_hanamasa:
                if (isChecked) {
//                    hanamasa="Hanamasa ";
                    listFood.add("Hanamasa ");
                } else {
                    listFood.remove("Hanamasa ");
                }
                break;
            case R.id.checkbox_sushi:
                if (isChecked) {
//                    sushi="Sushi ";
                    listFood.add("Sushi ");
                } else {
                    listFood.remove("Sushi ");
                }
                break;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int city = citySpinner.getSelectedItemPosition();

        if (city == 0) {
            Toast.makeText(getApplicationContext(), "Pilih kota dulu om, heheh", Toast.LENGTH_SHORT).show();
        } else {
            selectedCity = citySpinner.getSelectedItem().toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getApplicationContext(), "Pilih kota dulu om,baru keluar, heheh", Toast.LENGTH_SHORT).show();
    }
}
