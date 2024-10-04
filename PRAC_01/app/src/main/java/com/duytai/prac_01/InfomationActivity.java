package com.duytai.prac_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InfomationActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtGPA;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_infomation);

        edtName = findViewById(R.id.edt_name);
        edtGPA = findViewById(R.id.edt_gpa);
        btnSubmit = findViewById(R.id.btn_submit);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.info), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String gpa = edtGPA.getText().toString();

                // Tạo Intent chứa dữ liệu
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", name);
                resultIntent.putExtra("gpa", gpa);

                // Đặt kết quả là OK và gửi lại dữ liệu cho MainActivity
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}