package com.geenie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dorkbox.notify.Notify;
import dorkbox.notify.Pos;
import dorkbox.util.ActionHandler;

@SpringBootApplication
public class SpringBootExecutableJarApplication {

	public static void main(String[] args) {
		Notify notify;
		notify = Notify.create().title("Notify title ")
				.text("Generated from an Dorkbox dependency. if you are seeing it, that means this jar includes external dependencies")
				.hideAfter(13000).position(Pos.BOTTOM_RIGHT).darkStyle().shake(1300, 10).hideCloseButton()
				.onAction(new ActionHandler<Notify>() {
					@Override
					public void handle(final Notify arg0) {
						System.err.println("Notification clicked on!");
					}
				});
		notify.showWarning();
		SpringApplication.run(SpringBootExecutableJarApplication.class, args);
	}
}
