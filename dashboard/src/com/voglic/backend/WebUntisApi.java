package com.voglic.backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WebUntisApi {
    public static void run() throws IOException, InterruptedException {
        String destFolder="../WebUntis_Webscraper";

        String cmdPrompt="cmd";
//        String path="/c";
        String npmStart="npm start";

        File jsFile=new File(destFolder);
        List<String> updateCommand=new ArrayList<String>();
        updateCommand.add(cmdPrompt);
//        updateCommand.add(path);
        updateCommand.add(npmStart);
        runExecution(updateCommand,jsFile);
    }
    public static void runExecution(List<String> command, File navigatePath) throws IOException, InterruptedException, IOException {
        System.out.println(command);

        ProcessBuilder executeProcess=new ProcessBuilder(command);
        executeProcess.directory(navigatePath);
        Process resultExecution=executeProcess.start();

        BufferedReader br=new BufferedReader(new InputStreamReader(resultExecution.getInputStream()));
        StringBuffer sb=new StringBuffer();

        String line;
        while((line=br.readLine())!=null){
            sb.append(line+System.getProperty("line.separator"));
        }
        br.close();
        int resultStatust=resultExecution.waitFor();
        System.out.println("Result of Execution"+(resultStatust==0?"\tSuccess":"\tFailure"));
    }
}
