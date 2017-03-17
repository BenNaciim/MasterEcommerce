package com.tutorialspoint.dataAccessObject;

import com.tutorialspoint.dataObject.UtilisateurDO;

public interface IUtilisateurDAO {
  UtilisateurDO recupererInformation(final int id);
  void ajouterUtilisateur(final UtilisateurDO utilisateur);
  void supprimerUtilisateur (final int id);
}
