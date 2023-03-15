package AbstractComponents;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.Request;
import org.openqa.selenium.devtools.v107.network.model.Response;
import org.openqa.selenium.support.ui.Select;

public class NetWorkLogActivity  {

	
	   public static void papa() {
		// TODO Auto-generated method stub
		ChromeDriver Driver = new ChromeDriver();
		DevTools devtools = Driver.getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtools.addListener(Network.requestWillBeSent(), request -> {
			Request req = request.getRequest();
			// System.out.println(req.getUrl());
			// req.getHeaders();
		});

		// Event will get fired.
		devtools.addListener(Network.responseReceived(), response -> {
			Response res = response.getResponse();
			System.out.println(res.getUrl());
			System.out.println(res.getStatus());
			// if(res.getStatus().toString().startsWith("4"))
			// {
			// System.out.println(res.getUrl()+" is failing with status
			// code"+res.getStatus());
			// }
 
		});
		

	}
}
