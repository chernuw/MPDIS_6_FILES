package com.example.chernuwnote.mpdis_6_files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.util.Log;

public class FileOperations {
    public FileOperations() {

    }

    public Boolean write(String fileName, String lNameContent, String groupContent, String facultyContent){
        try {

            String fpath = "/sdcard/"+fileName+".txt";

            File file = new File(fpath);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(lNameContent+", "+groupContent+", "+facultyContent+"/");
            bw.close();

            Log.d("Success","Success");
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public String read(String fname, String lName, String group, String faculty){

        BufferedReader br = null;
        String response = null;
        int k=0;

        if(!lName.isEmpty()){
            k++;
        }

        if(!group.isEmpty()){
            k+=2;
        }

        if(!faculty.isEmpty()){
            k+=4;
        }

        try {

            StringBuffer output = new StringBuffer();
            String fpath = "/sdcard/"+fname+".txt";

            br = new BufferedReader(new FileReader(fpath));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] split = line.split("/");
                for(int i = 0; i < split.length; i++) {
                    switch(k){
                        case 0:
                            output.append(split[i]+"\n");
                            continue;
                        case 1:
                            if(split[i].indexOf(lName)!=-1){
                                output.append(split[i]+"\n");
                            }
                            continue;
                        case 2:
                            if(split[i].indexOf(group)!=-1){
                                output.append(split[i]+"\n");
                            }
                            continue;
                        case 3:
                            if(split[i].indexOf(lName)!=-1 & split[i].indexOf(group)!=-1){
                                output.append(split[i]+"\n");
                            }
                            continue;
                        case 4:
                            if(split[i].indexOf(faculty)!=-1){
                                output.append(split[i]+"\n");
                            }
                            continue;
                        case 5:
                            if(split[i].indexOf(lName)!=-1 & split[i].indexOf(faculty)!=-1){
                                output.append(split[i]+"\n");
                            }
                            continue;
                        case 6:
                            if(split[i].indexOf(group)!=-1 & split[i].indexOf(faculty)!=-1){
                                output.append(split[i]+"\n");
                            }
                            continue;
                        case 7:
                            if(split[i].indexOf(lName)!=-1 & split[i].indexOf(group)!=-1 & split[i].indexOf(faculty)!=-1){
                                output.append(split[i]+"\n");
                            }
                            continue;
                    }
                }
            }
            response = output.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }
        return response;

    }
}
