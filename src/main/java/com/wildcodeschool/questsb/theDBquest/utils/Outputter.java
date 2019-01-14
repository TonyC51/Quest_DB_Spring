package com.wildcodeschool.questsb.theDBquest.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.wildcodeschool.questsb.theDBquest.entities.User;
import com.wildcodeschool.questsb.theDBquest.repositories.UserRepository;

@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("Wilder");

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        // Checke combien d'objets se trouvent dans la BDD        
        LOG.info("******************");
        LOG.info("Objects in DB : " + userRepository.count());

        // Crée un nouvel utilisateur et l'enregistre dans la BDD
        User user1 = new User("Mohammed", "KABA", 34);
        LOG.info("******************");
        LOG.info(user1 + " has been created !");
        userRepository.save(user1);
        LOG.info(user1 + " has been saved !");
        
        User user2 = new User("Nicolas", "LUZURIER", 41);
        LOG.info("******************");
        LOG.info(user2 + " has been created !");
        userRepository.save(user1);
        LOG.info(user2 + " has been saved !");
        
        User user3 = new User("Tony", "CHEVRIS", 27);
        LOG.info("******************");
        LOG.info(user3 + " has been created !");
        userRepository.save(user1);
        LOG.info(user3 + " has been saved !");
        
        User tempUser = userRepository.findById(1L).get(); /* On écrit "1L" car 
        le type de l'id est Long */
		LOG.info("******************");
		LOG.info("First user's firstName is " + tempUser.getFirstName());
		LOG.info("First user's lastName is " + tempUser.getLastName());
		LOG.info("First user's age is " + tempUser.getAge());
		
		// Liste les utilisateurs enregistrés dans la BDD
        LOG.info("******************");
        LOG.info("Users in list are ");
        for(User myUser : userRepository.findAll()) {
            LOG.info(myUser.toString());
        };
        
        // Supprime le premier utilisateur de la BDD
        // Supprime le second utilisateur de la BDD
        userRepository.deleteById(1L); /* risque de provoquer une erreur si 
                                tu n'as pas vidé ta table avant de relancer 
                                ton application ! */
        
        /*     Liste les utilisateurs enregistrés dans la BDD
        (permet de vérifier que le second utilisateur
        a bien été supprimé de la BDD) */
	   LOG.info("******************");
	   LOG.info("Users in list are ");
	   for(User myUser : userRepository.findAll()) {
	       LOG.info(myUser.toString());
	   };
  
		
    }    
}