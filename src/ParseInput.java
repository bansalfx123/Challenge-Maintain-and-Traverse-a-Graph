import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;


public class ParseInput<T> {

	public static void main(String args[]){

		BufferedReader bufferreader = null;

		try {

			String CurrentLine;
			int count = 0;
			Graph graph = new Graph();

			bufferreader = new BufferedReader(new FileReader("C:/Users/Mohit/Workspace/StrideSpark/src/input.txt"));

			while ((CurrentLine = bufferreader.readLine()) != null) {
				count++;
				String[] splited = CurrentLine.split("\\s+");


				if (splited[0].equals("add")){

					graph.addEdge(splited[1], splited[2]);

				}else if (splited[0].equals("remove")){

					if (!graph.containsVertex(splited[1]) || !graph.containsVertex(splited[2])) {
						throw new RuntimeException("Edge you are trying to remove on line " +count+ ", does not exist.");
					}

					graph.removeEdge(splited[1], splited[2]);

				}else if(splited[0].equals("is")){

					if (splited[1].equals("linked")){
						System.out.println(graph.runBFS(splited[2],splited[3]));	
					}


				}else{
					throw new RuntimeException("Input of line" + count + "unidentifiable");
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferreader != null)bufferreader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
	
	

}
