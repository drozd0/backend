package ru.qlogistic.entitymanager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.qlogistic.entity.User;
import ru.qlogistic.manager.UserManager;

@Repository("userManager")
public class UserEntityManager implements UserManager{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public User findUserById(Long id) {
        return (User) sessionFactory.getCurrentSession().createQuery("FROM User WHERE id = :id").setParameter("id", id).uniqueResult();
    }

    @Override
    @Transactional
    public User findUserByUsername(String email) {
        return (User) sessionFactory.getCurrentSession().createQuery("FROM User WHERE email = :email").setParameter("email", email).uniqueResult();
    }

    @Override
    @Transactional
    public void createUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
