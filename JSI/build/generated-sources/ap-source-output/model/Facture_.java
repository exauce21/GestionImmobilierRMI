package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Loyer;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-22T17:18:58")
@StaticMetamodel(Facture.class)
public class Facture_ { 

    public static volatile SingularAttribute<Facture, Loyer> idloyer;
    public static volatile SingularAttribute<Facture, Integer> total;
    public static volatile SingularAttribute<Facture, String> numf;
    public static volatile SingularAttribute<Facture, Integer> arrierees;
    public static volatile SingularAttribute<Facture, Integer> avance;
    public static volatile SingularAttribute<Facture, String> datef;
    public static volatile SingularAttribute<Facture, Integer> restant;
    public static volatile SingularAttribute<Facture, Integer> id;

}