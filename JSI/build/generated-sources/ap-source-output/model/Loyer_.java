package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Bien;
import model.Client;
import model.Facture;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-22T17:18:58")
@StaticMetamodel(Loyer.class)
public class Loyer_ { 

    public static volatile SingularAttribute<Loyer, String> code;
    public static volatile SingularAttribute<Loyer, Bien> idbien;
    public static volatile SingularAttribute<Loyer, Integer> id;
    public static volatile SingularAttribute<Loyer, Client> idclient;
    public static volatile SingularAttribute<Loyer, String> dateentree;
    public static volatile SingularAttribute<Loyer, Integer> caution;
    public static volatile ListAttribute<Loyer, Facture> factureList;

}