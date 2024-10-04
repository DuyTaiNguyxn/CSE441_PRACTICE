package com.duytai.prac_02;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EmployeeViewModel extends ViewModel {
    private MutableLiveData<String> id = new MutableLiveData<>();
    private MutableLiveData<String> name = new MutableLiveData<>();
    private MutableLiveData<String> birth = new MutableLiveData<>();
    private MutableLiveData<String> salary = new MutableLiveData<>();

    public LiveData<String> getId() {
        return id;
    }

    public LiveData<String> getBirth() {
        return birth;
    }

    public LiveData<String> getName() {
        return name;
    }

    public LiveData<String> getSalary() {
        return salary;
    }

    public void setEmployeeData(String id, String name, String birth, String salary) {
        this.id.setValue(id);
        this.name.setValue(name);
        this.birth.setValue(birth);
        this.salary.setValue(salary);
    }
}
