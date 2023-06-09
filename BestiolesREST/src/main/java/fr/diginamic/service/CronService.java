package fr.diginamic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronService {
	
	@Value("${utilisateur.prenom}")
	private String prenom;

	@Scheduled(cron = "${cron.test}")
	public void ajoutCron() {
		System.out.println(">>>>>> Mise en place de la tâche cron toute les minutes par "+prenom+" <<<<<<");
	}
}
