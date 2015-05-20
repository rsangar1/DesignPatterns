package objComp.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import objComp.fileOperations.FileProcessorInterface;
import objComp.logger.MyLogger;

/**
 * @author Ramesh
 *This class has methods to perform reflection on classes by reading
 *input from file
 */
public class PopulateObjects implements PopulateObjectsInterface{
	@SuppressWarnings("rawtypes")
	private Map<String, Class> typeMap = null;
	private FileProcessorInterface fileProcessor;
	private Map<Object, Integer> objectMap1 = null;
	private Map<Object, Integer> objectMap2 = null;
	MyLogger logger = MyLogger.getInstance();

	/**
	 * @param fileProcessor
	 */
	@SuppressWarnings("rawtypes")
	public PopulateObjects(FileProcessorInterface fileProcessor) {
		logger.printToLogFile(1, "PopulateObjects: constructor");
		this.fileProcessor = fileProcessor;
		typeMap = new HashMap<String, Class>();
		objectMap1 = new HashMap<Object, Integer>();
		objectMap2 = new HashMap<Object, Integer>();
		populateTypeMap();
	}

	private void populateTypeMap() {
		logger.printToLogFile(2, "PopulateObjects: populateTypeMap()");
		typeMap.put("int", Integer.TYPE);
		typeMap.put("double", Double.TYPE);
		typeMap.put("float", Float.TYPE);
		typeMap.put("char", Character.TYPE);
		typeMap.put("String", String.class);
		typeMap.put("Integer", Integer.class);
		typeMap.put("Double", Double.class);
		typeMap.put("Float", Float.class);
		typeMap.put("Character", Character.class);
		// we can add new types if required in future.
	}

	/**
	 * This method performs all the reflection operations
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void deserObjects() {
		logger.printToLogFile(2, "PopulateObjects: deserObjects()");
		Class classObject = null;
		Object object = null;
		String className = "";
		int numberOfDataMembers = 0;
		String[] words = null;
		String[] var = null;
		String[] type = null;
		String[] val = null;
		String line = fileProcessor.readLineFromFile();
		while (line != null) {
			try {
				if(line.startsWith("fqn")){
					className = line.substring(4);
					//getting class object
					classObject = Class.forName(className);
					//getting new instance of class
					object = classObject.newInstance();
					numberOfDataMembers = classObject.getDeclaredFields().length;
					//logger variable is also considered as a class variable
					--numberOfDataMembers; 
				}else{
					words = line.split(", ");
					type = words[0].split("=");
					var = words[1].split("=");
					val = words[2].split("=");
					Method method = classObject.getMethod(getMethodName(var[1]),
							getSignature(type[1]));
					method.invoke(object, handlePrimitiveTypes(type[1], val[1]));
					--numberOfDataMembers;
				}
				if(numberOfDataMembers == 0){
					if (object instanceof objComp.util.First)
						insertObjectIntoMap(object, objectMap1);
					else if (object instanceof objComp.util.Second)
						insertObjectIntoMap(object, objectMap2);
				}
				line = fileProcessor.readLineFromFile();
			} catch (ClassNotFoundException e) {
				System.err.println(className + " class does not exist");
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				System.err.println("Method does not exist");
				e.printStackTrace();
			} catch (SecurityException e) {
				System.err.println("Exception occured due to improper security");
				e.printStackTrace();
			} catch (InstantiationException e) {
				System.err.println("Exception while instantiating the object");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.err.println("Tried to access method wrongly");
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				System.err.println("Illegal arguments during method invocation");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				System.err.println("Exception occured during method invocation");
				e.printStackTrace();
			}finally{}
		}
		fileProcessor.closeInputFile();
	}

	/**
	 * @param object
	 * @param objectMap
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void insertObjectIntoMap(Object object, Map objectMap) {
		logger.printToLogFile(2, "PopulateObjects: insertObjectIntoMap()");
		if (objectMap.containsKey(object)) {
			int count = (Integer) objectMap.get(object);
			objectMap.put(object, count + 1);
		} else
			objectMap.put(object, 1);
	}

	/**
	 * @param type
	 * @param val
	 * @return Object
	 */
	private Object handlePrimitiveTypes(String type, String val) {
		logger.printToLogFile(2, "PopulateObjects: handlePrimitiveType()");
		if (type.equals("int")) {
			return new Integer(val);
		} else if (type.equals("double")) {
			return new Double(val);
		} else if (type.equals("String")) {
			return new String(val);
		} else if(type.equals("float")){
			return new Float(val);
		} else
			return null;
		// we can add more types in future
		
	}

	/**
	 * @param type
	 * @return String
	 */
	@SuppressWarnings("rawtypes")
	private Class getSignature(String type) {
		logger.printToLogFile(2, "PopulateObjects: getSignature()");
		return typeMap.get(type);
	}

	/**
	 * @param var
	 * @return String
	 */
	private String getMethodName(String var) {
		logger.printToLogFile(2, "PopulateObjects: getMethodName()");
		return "set" + var;
	}

	/**
	 * @return int
	 */
	public int countTotalObjectsInMap2() {
		logger.printToLogFile(2, "PopulateObjects: countTotalObjectsInMap2()");
		Collection<Integer> keys = objectMap2.values();
		int totalKeys = 0;
		for (int key : keys) {
			totalKeys += key;
		}
		return totalKeys;
	}

	/**
	 * @return int
	 */
	public int countUniqueObjectsInMap2() {
		logger.printToLogFile(2, "PopulateObjects: countUniqueObjectsInMap2()");
		return objectMap2.size();
	}

	/**
	 * @return int
	 */
	public int countTotalObjectsInMap1() {
		logger.printToLogFile(2, "PopulateObjects: countTotalObjectsInMap1()");
		Collection<Integer> keys = objectMap1.values();
		int totalKeys = 0;
		for (int key : keys) {
			totalKeys += key;
		}
		return totalKeys;
	}

	/**
	 * @return int
	 */
	public int countUniqueObjectsInMap1() {
		logger.printToLogFile(2, "PopulateObjects: countUniqueObjectsInMap1()");
		return objectMap1.size();
	}

}
