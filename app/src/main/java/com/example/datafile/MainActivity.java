package com.example.datafile;

import static java.lang.System.load;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.FileUtils;
import android.widget.Toast;

import com.example.datafile.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final String savedFileName = "memo.txt";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.save.setOnClickListener(v -> save());
        binding.retrieve.setOnClickListener(v -> load());
    }
    public void save(){
        try{
            FileOutputStream fos = openFileOutput("memo.txt",Context.MODE_PRIVATE);
            fos.write(binding.edittext.getText().toString().getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void load() {
        String memo = null;
        try{
            memo = readFile(this, "memo.txt");
            binding.edittext.setText(memo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(Context context, String filename) throws FileNotFoundException{
        FileInputStream fis = context.openFileInput(filename);
        String contents = "";
        InputStreamReader inputStreamReader =
                new InputStreamReader(fis, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
        }catch (IOException e) {

        }finally {
            contents = stringBuilder.toString().trim();
        }
        return contents;
    }

    private void writeFile(String filename, String data){
        try{
            FileOutputStream fos=openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(data.getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}