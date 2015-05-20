package taskManager.observers;

import taskManager.display.DisplayFile;
import taskManager.util.FileProcessor;

public class PrintTabs implements Observer, DisplayFile {
	FileProcessor fileProcessor = null;
	
	public PrintTabs(FileProcessor fileProcessor){
		this.fileProcessor = fileProcessor;
	}
	
	@Override
	public void update(String strIn) {
		display();
	}

	@Override
	public void display() {
		//if()
		fileProcessor.writeToFile("---TAB(s) BEGIN---\n");
	}
	
}
