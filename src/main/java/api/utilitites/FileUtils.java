package api.utilitites;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
	public String getBody(String resourcePath) throws IOException {
		// initialize result variable
		// we use the get() method of Paths to get the file data
		// we use readAllBytes() method of Files to read byted data from the files
		return new String(Files.readAllBytes(Paths.get(resourcePath)));
	}

	public String getFile(String fileName) throws IOException {
		return new String(Files.readAllBytes(Paths.get(fileName)));
	}
}