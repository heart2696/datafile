package com.example.datafile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;

import com.example.datafile.databinding.ActivityHwBinding;
import com.example.datafile.utils.FileUtils;
import com.google.gson.Gson;

import java.io.File;

public class hw extends AppCompatActivity {
    private ActivityHwBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        ThreadProc();
    }

    private void ThreadProc(){
        @Override
        public void run() {
            String str,receiveMsg = "";

            
        }
    }
}

//        public class hw extends AppCompatActivity {
//            private ActivityHwBinding binding;
//            private BookItemLists item;
//
//            private final Gson gson = new Gson();
//            private final String BOOK_FILENAME = "bookitemlist_data.json";
//
//            @Override
//            protected void onCreate(Bundle savedInstanceState) {
//                super.onCreate(savedInstanceState);
//                binding = ActivityHwBinding.inflate(getLayoutInflater());
//                setContentView(binding.getRoot());
//
//                File book = new File(getFilesDir(), BOOK_FILENAME);
//                if (!book.exists()){
//                    String bookJson = FileUtils.readFile(this, "books.json");
//                    FileUtils.writeFile(this, BOOK_FILENAME, bookJson);
//                }
//
//
//
//
//                RecyclerAdapter adapter = new RecyclerAdapter();
//                binding.recyclerView.setAdapter(adapter);
//
//    }
//
//}