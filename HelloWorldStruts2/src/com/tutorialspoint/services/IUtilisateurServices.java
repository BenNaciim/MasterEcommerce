package com.tutorialspoint.services;

import com.tutorialspoint.dataTransfertObject.UtilisateurDTO;

public interface IUtilisateurServices {
  UtilisateurDTO recupererInformation(final int id);
  void ajouterUtilisateur(final UtilisateurDTO utilisateur);
  void supprimerUtilisateur (final int id);
  

}
