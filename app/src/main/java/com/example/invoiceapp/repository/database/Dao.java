package com.example.invoiceapp.repository.database;

import com.example.invoiceapp.repository.model.Article;
import com.example.invoiceapp.repository.model.Customer;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@androidx.room.Dao
public interface Dao {

    @Query("SELECT * FROM articles")
    LiveData<List<Article>> getArticles();

    @Query("SELECT * FROM customers")
    LiveData<List<Customer>> getCustomers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertArticles(List<Article> articles);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCustomers(List<Customer> customers);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCustomer(Customer customer);
}
