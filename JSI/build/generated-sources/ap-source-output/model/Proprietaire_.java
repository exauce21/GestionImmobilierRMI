package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Bien;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-22T17:18:58")
@StaticMetamodel(Proprietaire.class)
public class Proprietaire_ { 

    public static volatile ListAttribute<Proprietaire, Bien> bienList;
    public static volatile SingularAttribute<Proprietaire, Integer> paiement;
    public static volatile SingularAttribute<Proprietaire, String> moyen;
    public static volatile SingularAttribute<Proprietaire, String> adresse;
    public static volatile SingularAttribute<Proprietaire, Integer> tel;
    public static volatile SingularAttribute<Proprietaire, Integer> id;
    public static volatile SingularAttribute<Proprietaire, String> type;
    public static volatile SingularAttribute<Proprietaire, String> nom;
    public static volatile SingularAttribute<Proprietaire, String> email;

}