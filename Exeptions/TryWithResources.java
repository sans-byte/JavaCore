package Exeptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.PortableInterceptor.INACTIVE;

// We use finally block with try catch which will run anyways 
// basically people use finally block to close connections or files or something
// which they open in try block 
// So for this we have a better approach

public class TryWithResources {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // BufferedReader br = null;
        // try {
        //     InputStreamReader reader = new InputStreamReader(System.in);
        //     br = new BufferedReader(reader);
        //     Integer a = Integer.parseInt(br.readLine());
        // } finally{
        //     br.close();
        // }
            //Instead of all this we can do

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            Integer a = Integer.parseInt(br.readLine());
        }

        //here as BufferReader extends class closable so it will be closed automatically by try
        //This is called try with resource
    }
    
}
