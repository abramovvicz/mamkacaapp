package pl.mamkaca.application;

import org.springframework.boot.SpringApplication;

public class MamKacaApplication {

	public static void main(String[] args) {
		SpringApplication.from(pl.mamkaca.MamKacaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
