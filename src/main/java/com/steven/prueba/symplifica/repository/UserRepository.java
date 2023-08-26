package com.steven.prueba.symplifica.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.steven.prueba.symplifica.model.User;


@Repository
@Transactional
@EnableTransactionManagement
public interface UserRepository extends CrudRepository<User,Integer>{

}
