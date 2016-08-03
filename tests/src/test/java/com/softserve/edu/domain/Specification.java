package com.softserve.edu.domain;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import com.softserve.edu.controls.ILabel;
import com.softserve.edu.controls.ILink;
import com.softserve.edu.data.LoggerRepository;
import com.softserve.edu.login.LoginTest;

public class Specification {
	private static final Logger logger = LogManager.getLogger(LoginTest.class);
	private boolean summaryResult;
	private StringBuilder summaryDescription;

	private Specification() {
		this.summaryResult = true;
		this.summaryDescription = new StringBuilder();
		PropertyConfigurator.configure(LoggerRepository
				.getPathToLoggerProperties());
	}

	public static Specification get() {
		return new Specification();
	}

	public boolean getPassed() {
		return summaryResult;
	}

	public void failed() {
		summaryResult=false;
	}

	public String getDescription() {
		return summaryDescription.toString();
	}

	public void add(boolean pass, String errorText) {
		summaryResult = summaryResult && pass;
		if (!pass) {
			// TODO Logging.error
			summaryDescription.append(errorText);
		}
	}

	public void check() {
		// TODO Logs
//		 System.out.println("\n+++++specification.check() summaryResult="
//		 + summaryResult + "\n\t+++++ summaryDescription"
//		 + summaryDescription.toString());

		// Added by Ostap Voitsekhovs'kyi for comfort testing while designing
		// your own tests
		if(summaryResult==true){
			logger.info("Summary result : "+summaryResult);
			logger.info("Check success ! "+summaryDescription.toString()+"\n");
		}else{
			logger.error("Summary result : "+summaryResult);
			logger.error("Check failed !"+summaryDescription.toString()+"\n");
		}
		//

		Assert.assertTrue(summaryDescription.toString(), summaryResult);
	}

	public LabelCriteria forElement(ILabel label) {
		return LabelCriteria.get(label, this);
	}

	public LinkCriteria forElement(ILink link) {
		return LinkCriteria.get(link, this);
	}

	public StringCriteria forElement(String text) {
		return StringCriteria.get(text, this);
	}

}
