package com.address.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * User: jules
 * Date: 7/6/14
 */
@Service
public class EmailSenderService {

    //TODO -- implement this service by provinding a customizable email address
    //TODO -- and a method to actually send the email

    Logger logger = LoggerFactory.getLogger("com.address");

    public void sendEmail() {
        logger.info("Sending email ...");
    }

}
