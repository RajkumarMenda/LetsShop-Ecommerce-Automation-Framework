package seleniumRaj.DataResources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtenrReporterNg {

	public	static ExtentReports getReportObject() { // this will make report entry and give object out of it.
		String filepath = System.getProperty("user.dir") + "\\ExtentReports\\index.html";

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(filepath); // Responsible for creating reports
		sparkReporter.config().setReportName("Web Automation Results"); // This is for set the ReportName
		sparkReporter.config().setDocumentTitle("Test Result"); // This is for set the Document/Page Titlename

		ExtentReports	mainReport = new ExtentReports();
		mainReport.attachReporter(sparkReporter); // attach the reports to main class
		mainReport.setSystemInfo("TESTER", "Rajkumar M"); //to set the System Info
		
		return mainReport;
	}
}
