package com.test.bug28790;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class TestApp {
	public static void main(String[] args) {
		System.out.println("Start Test App");

		Executors.newScheduledThreadPool(1)
				.scheduleAtFixedRate(ThreadLogger::logThreadDump, 2,2, TimeUnit.MINUTES);

		new SpringApplicationBuilder(TestApp.class)
				.bannerMode(Banner.Mode.OFF)
				.web(WebApplicationType.SERVLET)
				.logStartupInfo(true)
				.build()
				.run(args);
	}
}