package com.esentral.ebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.esentral.ebook.adaptor.BooksListAdaptor;
import com.esentral.ebook.model.Book;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Book> books= new ArrayList<>();
    private RecyclerView booksList;
    private BooksListAdaptor booksListAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        booksList=(RecyclerView)findViewById(R.id.booksList);
        booksList.setLayoutManager(new GridLayoutManager(this, 2));

        loadJSONFromAsset();
    }
    private void loadJSONFromAsset() {
        try {
            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            JSONArray jsonArray = new JSONArray(new String(buffer, "UTF-8"));
            for(int i =0 ; i<jsonArray.length();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                Book book = new Book();
                book.setTitle(jsonObject.getString("title"));
                book.setCover(jsonObject.getString("cover"));
                books.add(book);
            }
            booksListAdaptor = new BooksListAdaptor(books,MainActivity.this);
            booksList.setAdapter(booksListAdaptor);
        } catch (IOException | JSONException ex) {
            ex.printStackTrace();
        }
    }
}