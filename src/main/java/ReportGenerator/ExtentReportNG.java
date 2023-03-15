package ReportGenerator;



import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG { 
	
	public static ExtentReports  getReportObject() {
		
	
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("OpenCart Project Report");
		reporter.config().setDocumentTitle("Test Result of OpenCart Projetct");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vicky");
		return extent;
		
	}
	
	 


	
}
