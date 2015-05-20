package bugModel.results;

import java.io.IOException;

/**
 * @author Ramesh Sangaraju
 * This interface contain method to write bug movement details to file.
 *
 */
public interface FileLog {
	/**
	 * This method writes the list details to file
	 * @param file
	 * @throws IOException
	 */
	public void writeListToFile(String fileName) throws IOException;
} 
