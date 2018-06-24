package pl.sda.api;


import pl.sda.model.Parents;

import java.util.List;

public interface ParentApi {

   public Parents creataParent();
   public Parents deleteParent();
   public Parents editParent();
   public Parents findParent();
   public List<Parents> findAllParents();
}
