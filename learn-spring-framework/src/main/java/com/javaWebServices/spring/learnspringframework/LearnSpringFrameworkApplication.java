package com.javaWebServices.spring.learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.javaWebServices.spring.learnspringframework.enterprise.example.web.MyWebController;
import com.javaWebServices.spring.learnspringframework.game.GameRunner;
// import com.javaWebServices.spring.learnspringframework.game.GamingConsole;
// import com.javaWebServices.spring.learnspringframework.game.MarioGame;
// import com.javaWebServices.spring.learnspringframework.game.PacMacGame;
// import com.javaWebServices.spring.learnspringframework.game.SuperContraGame;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	// GamingConsole game = new MarioGame();
	// GamingConsole game1 = new SuperContraGame();
	// GamingConsole game2 = new PacMacGame();
	// GameRunner runner = new GameRunner(game);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();

		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBusinessService());
		
	}

}
