package utility;

import utility.Excel_Utils;

public class TestData_Loader {
	
	public static Excel_Utils loadTestData(Object obj) throws Exception {
		
		
		String canonical_class_name = obj.getClass().getCanonicalName();
		
		String test_path = getTestDataPath(canonical_class_name);
		Excel_Utils excel = new Excel_Utils(test_path, "Sheet1");
		
		return excel;
	}
	
	private static String getTestDataPath(String class_name) {
		String testdata_path = null;
		String workingDir = System.getProperty("user.dir");
		

		
		String[] class_name_splitter = class_name.split("\\.");

		
		testdata_path = workingDir + "\\src\\" + class_name_splitter[0] + "\\" + class_name_splitter[1] + "\\TestData.xlsx";

		
		return testdata_path;				
	} 
	
	
	
}
