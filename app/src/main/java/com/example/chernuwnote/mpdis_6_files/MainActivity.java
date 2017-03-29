package com.example.chernuwnote.mpdis_6_files;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import com.example.chernuwnote.mpdis_6_files.FileOperations;

public class MainActivity extends Activity {
    EditText fileName,lName, group, faculty;
    EditText fnameread, lNameRead, groupRead, facultyRead;
    Button write,read;
    TextView filecon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileName = (EditText)findViewById(R.id.fileName);
        lName = (EditText)findViewById(R.id.lName);
        group = (EditText)findViewById(R.id.group);
        faculty = (EditText)findViewById(R.id.faculty);
        write = (Button)findViewById(R.id.btnwrite);


        fnameread = (EditText)findViewById(R.id.fnameread);
        lNameRead = (EditText)findViewById(R.id.lNameRead);
        groupRead = (EditText)findViewById(R.id.groupRead);
        facultyRead = (EditText)findViewById(R.id.facultyRead);
        read = (Button)findViewById(R.id.btnread);

        filecon = (TextView)findViewById(R.id.filecon);

        write.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String filename = fileName.getText().toString();

                FileOperations fop = new FileOperations();
                if(fop.write(fileName.getText().toString(), lName.getText().toString(), group.getText().toString(), faculty.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Данные записаны в файл " + filename + ".txt", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Ошибка ввода/вывода", Toast.LENGTH_SHORT).show();

                }
            }
        });
        read.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String readfilename = fnameread.getText().toString();

                FileOperations fop = new FileOperations();
                String text = fop.read(readfilename, lNameRead.getText().toString(), groupRead.getText().toString(), facultyRead.getText().toString());
                if(text != null){
                    filecon.setText(text);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Файл не найден", Toast.LENGTH_SHORT).show();
                    filecon.setText(null);
                }

            }
        });
    }
}
