package com.example.invoiceapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.invoiceapp.R;
import com.example.invoiceapp.repository.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private List<Customer> customers;

    public CustomerAdapter() {
        this.customers = new ArrayList<>();
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Customer customer = customers.get(position);
        holder.tvName.setText(customer.getDescript());
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    public void addList(List<Customer> list) {
        customers.clear();
        customers.addAll(list);
        notifyDataSetChanged();
    }

    static class CustomerViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        public CustomerViewHolder(@NonNull View view) {
            super(view);
            tvName = view.findViewById(R.id.tvName);
        }
    }
}
