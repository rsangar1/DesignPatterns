package taskManager.driver;

import taskManager.filter.DashboardFilter;
import taskManager.logger.MyLogger;
import taskManager.observers.Observer;
import taskManager.observers.PerformanceTab;
import taskManager.observers.PerformanceTabFilterImpl;
import taskManager.observers.ProcessesTab;
import taskManager.observers.ProcessesTabFilterImpl;
import taskManager.observers.UsersTab;
import taskManager.observers.UsersTabFilterImpl;
import taskManager.subject.DashboardSubject;
import taskManager.subject.Subject;
import taskManager.util.FileProcessor;
import taskManager.util.FileProcessorInterface;

/**
 * @author Ramesh 
 * This main class of the application
 */
public class Driver {
	/**
	 * @param args
	 * Here we create Subject and all its Observers and register all
	 * the observers to the subject
	 */
	public static void main(String[] args) {
		String inputFileName = "";
		String outputFileName = "";
		int logger_level = 0;
		try {
			if (args.length != 3) {
				System.err.println("Invalid number of arguments entered");
				System.exit(1);
			}
			inputFileName = args[0];
			outputFileName = args[1];
			try {
				logger_level = Integer.parseInt(args[2]);
			} catch (NumberFormatException nfe) {
				System.err.println("Invalid logger level entered");
				System.exit(1);
			}

			// setting logger level
			MyLogger logger = MyLogger.getInstance();
			if (logger_level<0 || logger_level > 3) {
				System.err.println("Invalid logger level entered, no logs will be printed to file");
				logger.setLoggerLevel(0);
			}
			else
				logger.setLoggerLevel(logger_level);

			// creating file processor object
			FileProcessorInterface fileProcessor = new FileProcessor(inputFileName,
					outputFileName);

			// creating a subject object
			Subject subject = new DashboardSubject(fileProcessor);

			// creating observer objects
			Observer process = new ProcessesTab(fileProcessor);
			Observer user = new UsersTab(fileProcessor);
			Observer performance = new PerformanceTab(fileProcessor);

			// creating filter objects
			DashboardFilter processFilter = new ProcessesTabFilterImpl();
			DashboardFilter usersFilter = new UsersTabFilterImpl();
			DashboardFilter performanceFilter = new PerformanceTabFilterImpl();

			// register observers and filters to subject
			subject.registerObserver(process, processFilter);
			subject.registerObserver(user, usersFilter);
			subject.registerObserver(performance, performanceFilter);

			// start subject
			subject.startProcessing();
		}catch(NullPointerException npe){
			System.err.println("Tried to access null value");
		}
		catch (Exception exception) {
			System.err.println("Exception occured in driver");
		}

	}
}
