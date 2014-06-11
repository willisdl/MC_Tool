/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Users;

/**
 *
 * @author davidwillis
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {
    @PersistenceContext(unitName = "MC_ToolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    public Users getUser(String user, String pass){
        Users login = null;
        TypedQuery<Users> query = em.createNamedQuery("Users.findByUsername", Users.class);
        query.setParameter("username", user);
        //query.setParameter("password", pass);
        try {
            login = query.getSingleResult();
        } catch (Exception e) {
            
        }
        return login;
    }
    
}
