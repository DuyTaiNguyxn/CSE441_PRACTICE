package com.duytai.prac_02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private EmployeeViewModel employeeViewModel;
    private EditText edtId, edtName, edtBirth, edtSalary;
    private Button btnAdd;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtId = findViewById(R.id.edt_id);
        edtName = findViewById(R.id.edt_name);
        edtBirth = findViewById(R.id.edt_birth);
        edtSalary = findViewById(R.id.edt_salary);
        btnAdd = findViewById(R.id.btn_add);
        txtResult = findViewById(R.id.txt_result);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtId.getText().toString();
                String name = edtName.getText().toString();
                String birth = edtBirth.getText().toString();
                String salary = edtSalary.getText().toString();

                employeeViewModel.setEmployeeData(id, name, birth, salary);
                updateResult();
            }
        });
    }

    private void updateResult() {
        String currentData = txtResult.getText().toString();
        if(currentData == "No Result!"){
            currentData = "";
        }
        String id = employeeViewModel.getId().getValue();
        String name = employeeViewModel.getName().getValue();
        String birth = employeeViewModel.getBirth().getValue();
        String salary = employeeViewModel.getSalary().getValue();

        if (id != null && name != null && birth != null && salary != null) {
            String newEntry = id+ " - " + name + " - " + birth + " - " + salary + "\n";

            currentData += newEntry;
            txtResult.setText(currentData);
        } else {
            txtResult.setText("Chưa nhập đủ thông tin");
        }
    }
}