package com.example.invoiceapp.repository;

import android.content.Context;

import com.example.invoiceapp.repository.database.AppDatabase;
import com.example.invoiceapp.repository.model.Article;
import com.example.invoiceapp.repository.model.Customer;

import java.util.List;

import androidx.lifecycle.LiveData;

public class AppRepository {

    private Context context;

    public AppRepository(Context context){
        this.context = context;
    }

    public LiveData<List<Customer>> loadCustomers(){
        return AppDatabase.getInstance(context).getDao().getCustomers();
    }

    public LiveData<List<Article>> loadArticles(){
        return AppDatabase.getInstance(context).getDao().getArticles();
    }

    public void insertCustomer(Customer customer){
        AppDatabase.getInstance(context).getDao().insertCustomer(customer);
    }
}
