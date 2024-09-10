package Resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	public static ExtentReports getReport(){
		
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Result");
		reporter.config().setDocumentTitle("Test Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tested By", "Priyanshu Srivastava");
		
		return extent;
			
		}
}
