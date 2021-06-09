package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Loyer;
import model.Proprietaire;
import model.Typebien;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-22T17:18:58")
@StaticMetamodel(Bien.class)
public class Bien_ { 

    public static volatile SingularAttribute<Bien, Proprietaire> idproprio;
    public static volatile SingularAttribute<Bien, Integer> nombrepeice;
    public static volatile SingularAttribute<Bien, Typebien> idtype;
    public static volatile SingularAttribute<Bien, String> code;
    public static volatile SingularAttribute<Bien, Integer> loyer;
    public static volatile SingularAttribute<Bien, Integer> superficie;
    public static volatile ListAttribute<Bien, Loyer> loyerList;
    public static volatile SingularAttribute<Bien, String> photo;
    public static volatile SingularAttribute<Bien, Integer> id;
    public static volatile SingularAttribute<Bien, String> etat;

}