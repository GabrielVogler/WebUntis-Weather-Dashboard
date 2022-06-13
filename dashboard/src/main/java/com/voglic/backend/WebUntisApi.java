package com.voglic.backend;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WebUntisApi {
    public static void run(String command) throws Exception {
        String os = System.getProperty("os.name");
        String[] cmd;
        switch (os) {
            case "Windows" -> cmd = new String[]{"cmd", "/C", command};
            case "Linux" -> cmd = new String[]{"sh", "-c", command};
            case "MacOS" -> cmd = new String[]{"iterm", "-c", command};
            default -> throw new Exception("Wrong OS!");
        }
        try {
            System.out.print("WebUntis_API: ");
            Process child = Runtime.getRuntime().exec(cmd);
            BufferedReader in = new BufferedReader(new InputStreamReader(child.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}