package ufcg.metodologia.projetomc.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ufcg.metodologia.projetomc.util.CSVUtils;
import ufcg.metodologia.projetomc.util.OutputEntry;

public class OutputSaver {
	public OutputSaver() {
		
	}
	
	public void save(String path, List<OutputEntry> outputEntries) {
        try {
            File output = new File(path);
            FileWriter writer = new FileWriter(output);
            
            CSVUtils.writeOutpuHeader(writer);
            
            for (OutputEntry entry : outputEntries) {
                CSVUtils.writeLine(writer, entry);
            }

            writer.flush();
            writer.close();
        } catch(IOException e) {
        	e.printStackTrace();
            throw new RuntimeException("Error while trying to generate output. " + e.getMessage());
        }

    }
}
