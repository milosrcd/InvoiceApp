package com.example.invoiceapp.repository.database;

import android.content.Context;

import com.example.invoiceapp.repository.model.Article;
import com.example.invoiceapp.repository.model.Customer;
import com.example.invoiceapp.util.AssetUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Article.class, Customer.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static synchronized AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context);
        }
        return INSTANCE;
    }

    private static AppDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "invoice-database")
                .fallbackToDestructiveMigration()
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                String articlesJsonString = AssetUtils.loadJSONFromAsset(context, "artikli.json");
                                String customersJsonString = AssetUtils.loadJSONFromAsset(context, "kupci.json");
                                Gson gson = new Gson();

                                List<Article> articles = gson.fromJson(articlesJsonString,
                                        new TypeToken<List<Article>>() {}.getType());
                                List<Customer> customers = gson.fromJson(customersJsonString,
                                        new TypeToken<List<Customer>>() {}.getType());

                                getInstance(context).getDao().insertArticles(articles);
                                getInstance(context).getDao().insertCustomers(customers);
                            }
                        });
                    }
                })
                .build();
    }

    public abstract Dao getDao();
}
