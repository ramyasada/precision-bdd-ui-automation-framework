package drivers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class OptionsFactory {

	public static ChromeOptions buildChromeOptions() {
	    ChromeOptions options = new ChromeOptions();

	    options.addArguments("--disable-notifications");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-dev-shm-usage");
	    options.addArguments("--disable-background-networking");
	    options.addArguments("--disable-sync");
	    options.addArguments("--mute-audio");
	    options.addArguments(buildHostResolverRules());

	    options.setExperimentalOption("prefs", buildChromiumPrefs());
	    options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
	    options.setExperimentalOption("useAutomationExtension", false);

	    return options;
	}

	public static EdgeOptions buildEdgeOptions() {
	    EdgeOptions options = new EdgeOptions();

	    options.addArguments("--disable-notifications");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-dev-shm-usage");
	    options.addArguments("--disable-background-networking");
	    options.addArguments("--disable-sync");
	    options.addArguments("--mute-audio");
	    options.addArguments(buildHostResolverRules());

	    options.setExperimentalOption("prefs", buildChromiumPrefs());
	    options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
	    options.setExperimentalOption("useAutomationExtension", false);

	    return options;
	}
	
	 private static Map<String, Object> buildChromiumPrefs() {
		 Map<String, Object> contentSettings = new HashMap<>();
	     contentSettings.put("ads",           2);
	     contentSettings.put("popups",        2);
	     contentSettings.put("notifications", 2);

	     Map<String, Object> profile = new HashMap<>();
	     profile.put("profile.default_content_setting_values", contentSettings);
	     profile.put("profile.block_third_party_cookies",      true);

	     Map<String, Object> prefs = new HashMap<>();
	     prefs.put("profile", profile);
	     return prefs;
	 }
	 private static String buildHostResolverRules() {
		return "--host-resolver-rules=" +
				"MAP pagead2.googlesyndication.com 0.0.0.0," +
	            "MAP googlesyndication.com 0.0.0.0," +
	            "MAP googletagservices.com 0.0.0.0," +
	            "MAP googletagmanager.com 0.0.0.0," +
	            "MAP adservice.google.com 0.0.0.0," +
	            "MAP adservice.google.co.in 0.0.0.0," +
	            "MAP doubleclick.net 0.0.0.0," +
	            "MAP securepubads.g.doubleclick.net 0.0.0.0," +
	            "MAP tpc.googlesyndication.com 0.0.0.0," +
	            "MAP adsafeprotected.com 0.0.0.0," +
	            "MAP adnxs.com 0.0.0.0," +
	            "MAP taboola.com 0.0.0.0," +
	            "MAP outbrain.com 0.0.0.0," +
	            "MAP zedo.com 0.0.0.0," +
	            "MAP advertising.com 0.0.0.0," +
	            "MAP ads.pubmatic.com 0.0.0.0," +
	            "MAP openx.net 0.0.0.0," +
	            "MAP rubiconproject.com 0.0.0.0," +
	            "MAP criteo.com 0.0.0.0," +
	            "MAP amazon-adsystem.com 0.0.0.0";
	 }
}
