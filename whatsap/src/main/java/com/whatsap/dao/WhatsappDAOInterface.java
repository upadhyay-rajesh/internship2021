package com.whatsap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatsap.entity.WhatsappUser;

@Repository
public interface WhatsappDAOInterface extends JpaRepository<WhatsappUser, String> {

}
