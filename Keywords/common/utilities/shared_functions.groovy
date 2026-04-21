package common.utilities
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


class shared_functions {
 /**
 * Refresh browser
 */
@Keyword
	public void userLogin(String url) {
		// [2] Session setup: Start browser using environment-based application domain
		WebUI.openBrowser(url)
		
	}

}