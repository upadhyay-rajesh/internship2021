package com.whatsap.service;

import com.whatsap.entity.WhatsappUser;

public interface WhatsappServiceInterface {

	int createProfileService(WhatsappUser wu);

	boolean loginProfileService(WhatsappUser wu);

	WhatsappUser viewProfileService(WhatsappUser w);

}
