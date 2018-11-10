package com.example.sharedpref_practice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class NextActivity extends AppCompatActivity {

    TextView TxtNameNxt;
    EditText EditTxtNameNxt;

    TextView TxtPasswordNxt;
    EditText EditTxtPasswordNxt;

    Button btnLoad;
    Button btnToMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        TxtNameNxt = findViewById(R.id.txtNameNxt);
        EditTxtNameNxt = findViewById(R.id.editTxtNameNxt);

        TxtPasswordNxt = findViewById(R.id.txtPasswordNxt);
        EditTxtPasswordNxt = findViewById(R.id.editTxtPasswordNxt);

        btnLoad = findViewById(R.id.Load);
        btnToMainActivity = findViewById(R.id.btnNextAct);


    }

    public void CreateFile(View view) {


        String fileData = "data of new file is created";

        FileOutputStream fileOutputStream;

        File file = new File(getFilesDir(), "newFile");


        Log.d("file path is", file.getAbsolutePath());

        try {
            fileOutputStream = openFileOutput("newFile", Context.MODE_PRIVATE);
            fileOutputStream.write(fileData.getBytes());
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void LoadData(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);

        String nameFrmMainAct = sharedPreferences.getString("nakme", "N/A");
        String pwdFrmMainAct = sharedPreferences.getString("password", "N/A");

        if (nameFrmMainAct.equals("N/A") || pwdFrmMainAct.equals("N/A")) {

            Toast.makeText(this, "Data was not save or loaded!", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "Data was loaded!", Toast.LENGTH_SHORT).show();

            EditTxtNameNxt.setText(nameFrmMainAct);
            EditTxtPasswordNxt.setText(pwdFrmMainAct);

        }
        saveDataToFile();
        readDataFromFile();
//        BitmapFactory.decodeResource(getResources(),
//                        R.drawable.size4);

//        Bitmap bm = ((BitmapDrawable) getResources().getDrawable(R.drawable.size4)).getBitmap();
        saveImageToExternalStorage(((BitmapDrawable) getResources().getDrawable(R.drawable.size4)).getBitmap());

//        saveImageToExternalStorage(BitmapFactory.decodeResource(getResources(),
//                R.drawable.size4));
    }

    public void BackToMainAct(View view) {
        Intent intentGoBack = new Intent(this, MainActivity.class);
        startActivity(intentGoBack);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
//        if (drawable instanceof BitmapDrawable) {
//            return ((BitmapDrawable)drawable).getBitmap();
//        }

        int width = drawable.getIntrinsicWidth();
        width = width > 0 ? width : 1;
        int height = drawable.getIntrinsicHeight();
        height = height > 0 ? height : 1;

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    String filename = "dummey.txt";

    void saveDataToFile() {
        File file = new File(getFilesDir(), filename);


//        String filename = "myfile";
        String fileContents = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    void readDataFromFile() {

        try {
            FileInputStream fis = openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder(); // string buffer is another class which is thread safe
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            Toast.makeText(getApplicationContext(), "file content=" + sb.toString(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    void saveImageToExternalStorage(Bitmap bitmap) {

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/saved_images");
        if (!myDir.exists()) {
            myDir.mkdirs();
        }
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-" + n + ".jpg";
        File file = new File(myDir, fname);//saving file in my created direcoty i.e /saved_images
        if (file.exists())
            file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
