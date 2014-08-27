import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
 
public class SecondApproach {
	
  public static void main(String[] args) {
	SecondApproach obj = new SecondApproach();
	obj.insertNewRecord("input.csv", "100000000000010000100001");
	//obj.deleteRecord("input.csv", 2);
  }
 
  public void deleteRecord(String fileName,int k) {
	  try {
		FileInputStream fstream = new FileInputStream(fileName);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		FileWriter fileWriter = null;
	    File newFile = new File("newout.csv");
	    fileWriter = new FileWriter(newFile);
		int count = 1;
		while ((line = br.readLine()) != null){
			  System.out.println (line);
			  if(k != count){
				  fileWriter.write(line);
				  fileWriter.write("\n");
			  }
			  count++;
		}
	    in.close();
	    fileWriter.close();
		}catch (Exception e) {
		e.printStackTrace();
		}
  }	  
  
  public void insertNewRecord(String fileName,String record){
	  try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
		    out.println(record);
		}catch (IOException e) {
		    e.printStackTrace();
		}
	  System.out.println("Done");
  }
  
  public void updateRecord(){
	  
  }
  
}