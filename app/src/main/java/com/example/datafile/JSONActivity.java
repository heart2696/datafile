package com.example.datafile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;

import com.example.datafile.databinding.ActivityJsonactivityBinding;
import com.example.datafile.utils.FileUtils;
import com.google.gson.Gson;

import java.io.File;

public class JSONActivity extends AppCompatActivity {
    private ActivityJsonactivityBinding binding;
    private BookItem item;

    private final Gson gson = new Gson();
    private final String BOOK_FILENAME = "book_data.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJsonactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        BookItem bookItem = new BookItem();
//        bookItem.setTitle("책 제목");
//
//        String hello = gson.toJson(bookItem);
//        Log.i("TAG", hello);
//
//        BookItem copyBook = gson.fromJson(hello, BookItem.class);
//        Log.i("TAG", copyBook.getTitle());
//    }
//}



//        binding.textprint.setMovement(new ScrollingMovementMethod());
//        binding.textprint.setMovement(LinkMovementMethod.getInstance());

        File book = new File(getFilesDir(), BOOK_FILENAME);
        if (!book.exists()){
            String bookJson = FileUtils.readFile(this, "abook.json");
            FileUtils.writeFile(this, BOOK_FILENAME, bookJson);
        }
        load();
        binding.buttonsave.setOnClickListener(v-> save());
        binding.buttonretrieve.setOnClickListener(v-> load());
    }
    public void save(){
        String comments = binding.comment.getText().toString();
        this.item.setComments(comments);
        String jsonString = gson.toJson(this.item);
        FileUtils.writeFile(this, "book_data.json", jsonString);

    }
    public void load(){
        String bookJson = Utils.readFile(this, "book_data.json");
        this.item = gson.fromJson(bookJson, BookItem.class);
        update();
    }

    public void update(){
        String text = "제목: " + item.getTitle() + ", 가격: " + item.getPrice();
        binding.title.setText(item.getTitle());
        binding.author.setText(item.getAuthor());
        binding.price.setText(String.format("%, d원", item.getPrice()));
        binding.description.setText(Html.fromHtml(item.getDescription()));
        binding.comment.setText(item.getComments());

        Glide.with(this)

;    }
}