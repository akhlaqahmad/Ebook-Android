package com.esentral.ebook.adaptor;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esentral.ebook.R;
import com.esentral.ebook.model.Book;

import java.util.List;

public class BooksListAdaptor extends RecyclerView.Adapter<BooksListAdaptor.ViewHolder> {

    private List<Book> books;
    private Activity activity;

    public BooksListAdaptor(List<Book> books, Activity activity) {
        this.books = books;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        switch (books.get(position).getCover()) {
            case "cover1.png": {
                holder.imgBookCover.setImageResource(R.drawable.cover1);
            }
            break;
            case "cover2.png": {
                holder.imgBookCover.setImageResource(R.drawable.cover2);
            }
            break;
            case "cover3.png": {
                holder.imgBookCover.setImageResource(R.drawable.cover3);
            }
            break;
            case "cover4.png": {
                holder.imgBookCover.setImageResource(R.drawable.cover4);
            }
            break;
        }
        holder.imgBookCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog= new Dialog(activity);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_book_info);
                TextView tvTitle=(TextView)dialog.findViewById(R.id.tvBookTitle);
                ImageView imgBookCover=(ImageView)dialog.findViewById(R.id.imgBookCover);
                Button btnRead = (Button)dialog.findViewById(R.id.btnRead);
                Button btnShare = (Button)dialog.findViewById(R.id.btnShare);
                Button btnDelete = (Button)dialog.findViewById(R.id.btnDelete);

                tvTitle.setText(books.get(position).getTitle());
                btnRead.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(activity,"Read Pressed",Toast.LENGTH_SHORT).show();
                    }
                });

                btnShare.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(activity,"Share Pressed",Toast.LENGTH_SHORT).show();
                    }
                });

                btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(activity,"Delete Pressed",Toast.LENGTH_SHORT).show();
                    }
                });
                switch (books.get(position).getCover()) {
                    case "cover1.png": {
                        imgBookCover.setImageResource(R.drawable.cover1);
                    }
                    break;
                    case "cover2.png": {
                        imgBookCover.setImageResource(R.drawable.cover2);
                    }
                    break;
                    case "cover3.png": {
                       imgBookCover.setImageResource(R.drawable.cover3);
                    }
                    break;
                    case "cover4.png": {
                        imgBookCover.setImageResource(R.drawable.cover4);
                    }
                    break;
                }

                dialog.show();
            }
        });


    }

    @Override
    public int getItemCount() { return books.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgBookCover;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBookCover=(ImageView)itemView.findViewById(R.id.imgBookCover);
        }
    }
}
