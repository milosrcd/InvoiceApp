package com.example.invoiceapp.viewModels;

import android.app.Application;

import com.example.invoiceapp.repository.AppRepository;
import com.example.invoiceapp.repository.model.Customer;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class CustomerViewModel extends AndroidViewModel {

    private AppRepository appRepository;
    public LiveData<List<Customer>> customers;

    public CustomerViewModel(@NonNull Application application) {
        super(application);
        appRepository = new AppRepository(application);
        customers = appRepository.loadCustomers();
    }
}
