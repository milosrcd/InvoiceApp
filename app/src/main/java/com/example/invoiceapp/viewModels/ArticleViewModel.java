package com.example.invoiceapp.viewModels;

import android.app.Application;

import com.example.invoiceapp.repository.AppRepository;
import com.example.invoiceapp.repository.model.Article;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ArticleViewModel extends AndroidViewModel {

    private AppRepository appRepository;
    public LiveData<List<Article>> articles;

    public ArticleViewModel(@NonNull Application application) {
        super(application);
        appRepository = new AppRepository(application);
        articles = appRepository.loadArticles();
    }
}
