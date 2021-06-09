package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Contrat;
import model.Loyer;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-22T17:18:58")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> nci;
    public static volatile ListAttribute<Client, Loyer> loyerList;
    public static volatile SingularAttribute<Client, String> tel;
    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, String> prenom;
    public static volatile ListAttribute<Client, Contrat> contratList;
    public static volatile SingularAttribute<Client, String> email;

}