package com.tutorialspoint.services;

import com.tutorialspoint.dataAccessObject.IUtilisateurDAO;
import com.tutorialspoint.dataObject.UtilisateurDO;
import com.tutorialspoint.dataTransfertObject.UtilisateurDTO;
import com.tutorialspoint.factory.MyFactory;

public class UtilisateurServices implements IUtilisateurServices {
  
  private static final IUtilisateurServices instance = new UtilisateurServices();
 private  UtilisateurServices(){
   
 }
 public static IUtilisateurServices getInstance() {
   return instance;
}

  @Override
  public void ajouterUtilisateur(UtilisateurDTO utilisateur) {
    final IUtilisateurDAO utilisateurDaoService=(IUtilisateurDAO)MyFactory.getInstance(IUtilisateurDAO.class);
    final UtilisateurDO utilisateurDo=UtilisateurDtoToDo(utilisateur);
    utilisateurDaoService.ajouterUtilisateur(utilisateurDo);
  }


   @Override
  public UtilisateurDTO recupererInformation(final int id) {
    final IUtilisateurDAO utilisateurDaoService=(IUtilisateurDAO)MyFactory.getInstance(IUtilisateurDAO.class);
    final UtilisateurDO utilisateurDo= utilisateurDaoService.recupererInformation(id);
    UtilisateurDTO utilisateurDto=convertToDto(utilisateurDo);
    return utilisateurDto;
    
  }
   
   @Override
   public void supprimerUtilisateur(final int id) {
     final IUtilisateurDAO utilisateurDaoService=(IUtilisateurDAO)MyFactory.getInstance(IUtilisateurDAO.class);
           utilisateurDaoService.supprimerUtilisateur(id);
     
   }
   
   
   private UtilisateurDTO convertToDto(final UtilisateurDO utilisateurDo){
     final UtilisateurDTO utilisateurDto=new UtilisateurDTO(utilisateurDo.getId(), utilisateurDo.getNom(), utilisateurDo.getPrenom(), utilisateurDo.getUser(), utilisateurDo.getPassword());
     return utilisateurDto;
   }

   private UtilisateurDO UtilisateurDtoToDo(UtilisateurDTO utilisateur) {
     final UtilisateurDO utilisateurDo=new UtilisateurDO(utilisateur.getId(), utilisateur.getUser(), utilisateur.getPassword(), utilisateur.getNom(), utilisateur.getPrenom());
     return utilisateurDo;
   }


  
 
}
