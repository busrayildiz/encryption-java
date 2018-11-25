package encryptionn;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JFileChooser;



public class Main {


	@SuppressWarnings("null")
	public static void main(String[] args)throws IOException{

		
		JFileChooser chooser = new JFileChooser();
		Scanner in=null;
		
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			in = new Scanner(selectedFile);
			int lineNumber = 0 ;
			List wordslines =new ArrayList();
		    String [] words;

			while(in.hasNextLine()){
				String line = in.nextLine();
				wordslines.add(line);
				lineNumber++;
				//words[lineNumber] = line.split(" ");
				//WriteString(words);
				
			}
			lineNumber=0;
			List CryptLine =new ArrayList();      //GelenSifreliSatir
			List CryptWords = new ArrayList(); 
			while(lineNumber<wordslines.size())
			{
				words=wordslines.get(lineNumber).toString().split(" ");
				lineNumber++;
				CryptLine=CryptString(words);
				for(int k=0;k<CryptLine.size();k++)
				{
					CryptWords.add(CryptLine.get(k));
				}
			}
		
			WriteNewFile(CryptWords);
	
		}
	}

	@SuppressWarnings("null")
	public static List CryptString(String [] words){
			List newWords = new ArrayList();
		for(int i=0;i<words.length; i++){
			char[] word = words[i].toCharArray();
			if (i%2==0){
				System.out.print(word);
				System.out.print(" ");
				newWords.add(words[i]);
				newWords.add(" ");
			}    
			else{
				int j=word.length;
				for( j=j-1; j>=0; j--)
				{
					word[words[i].length()-j-1]=words[i].charAt(j);
				}
					System.out.print(word);
					System.out.print(" ");
					newWords.add( String.valueOf(word));
					newWords.add(" ");
			}
		}
		return newWords;
	}
	public static void WriteNewFile(List words) {
			try{
			Path logFile = Paths.get("C:\\Users\\lenovo\\eclipse-workspace\\encryptionn\\output.txt");
			try (BufferedWriter writer = Files.newBufferedWriter(logFile, StandardCharsets.UTF_8)) {	  
				   for(int i=0;i<words.size();i++) {
					   writer.write(words.get(i).toString());
				   }
				
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	
	
}


	
