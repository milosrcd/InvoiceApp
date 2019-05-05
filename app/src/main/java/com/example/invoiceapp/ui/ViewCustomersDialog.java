package com.example.invoiceapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.invoiceapp.R;
import com.example.invoiceapp.repository.model.Customer;
import com.example.invoiceapp.viewModels.CustomerViewModel;

import java.util.List;

public class ViewCustomersDialog extends DialogFragment {

    private CustomerAdapter customerAdapter;

    public static ViewCustomersDialog newInstance() {
        return new ViewCustomersDialog();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogStyle);

        customerAdapter = new CustomerAdapter();

        CustomerViewModel customerViewModel = ViewModelProviders.of(this).get(CustomerViewModel.class);
        customerViewModel.getCustomers().observe(this, new Observer<List<Customer>>() {
            @Override
            public void onChanged(List<Customer> customers) {
                customerAdapter.addList(customers);
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_view_customers, container, false);

        RecyclerView rvCustomers = view.findViewById(R.id.rvCustomers);
        rvCustomers.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvCustomers.setAdapter(customerAdapter);

        return view;
    }
}
