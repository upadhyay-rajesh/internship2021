package com.whatsap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatsap.dao.WhatsappDAOInterface;
import com.whatsap.entity.WhatsappUser;

@Service
public class WhatsappService implements WhatsappServiceInterface {
	
	@Autowired
	private WhatsappDAOInterface wd;

	@Override
	public int createProfileService(WhatsappUser wu) {
		int i=0;
		wd.save(wu);
		i=1;
		return i;
	}

	@Override
	public boolean loginProfileService(WhatsappUser wu) {
		List<WhatsappUser> ll=wd.findAll();
		boolean b=false;
		for(WhatsappUser ww:ll) {
			if((ww.getEmail().equals(wu.getEmail()))&&(ww.getPassword().equals(wu.getPassword()))) {
				b=true;
				break;
			}
		}
		
		return b;
	}

	@Override
	public WhatsappUser viewProfileService(WhatsappUser w) {
		//List is dynamic array i.e. like bag depends on data size will grow or shrink
		List<WhatsappUser> ll=wd.findAll();
		WhatsappUser b=null;
		//taking one by one object from bag we will use for loop
		for(WhatsappUser ww:ll) {
			if(ww.getEmail().equals(w.getEmail())) {
				b=ww;
				break;
			}
		}
		
		return b;
	}

}
