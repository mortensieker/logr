package dk.sieker.logr.client;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author msa
 */
@Stateless
public class ClientService {

    @PersistenceContext
    EntityManager em;

    public Client get(long userId, long id) {
        return null;
    }

    public List<Client> getAll(long userId) {
        List<Client> clients = em.createNamedQuery("allClients", Client.class).getResultList();
        return clients;
    }

    public void delete(long userId, long id) {
        Client client = get(userId, id);
        if (client != null) {
            em.remove(client);
        }
    }

    public Client create(Client client) {
        em.persist(client);
        return client;
    }

    public Client update(Client client) {
        return em.merge(client);
    }

}
