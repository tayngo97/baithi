package com.stdio.esm.service;

import com.stdio.esm.config.service.EsmUserDetail;
import com.stdio.esm.exception.EsmException;
import com.stdio.esm.model.Account;
import com.stdio.esm.repository.UserRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo ;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);



    public List<Account> getAllUsers(){
        return userRepo.findAllByDeleteFlagFalse();
    }

    public Page<Account> getAllUsers(Pageable pageable){
        return userRepo.findAllByDeleteFlagFalse(pageable);
    }


    public Account saveOrUpdate(Account account) {
        return userRepo.save(account);
    }

    @Transactional(rollbackFor = Exception.class)
    public String deleteById(Long id) {
        try {
            Account account = userRepo.getById(id);
            account.setDeleteFlag(true);
        }catch (EntityNotFoundException e){
            return "User not found !";
        }
        return "User deleted successfully";
    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
    public void changePassword(Map<String, String> request) {
        LOGGER.info("Change password");
        Long id =Long.parseLong(request.get("id"));
        String oldPassword = request.get("oldPassword");
        String newPassword = request.get("newPassword");
        String confirmNewPassword = request.get("confirmNewPassword");
        if (!newPassword.equals(confirmNewPassword)) {
            LOGGER.trace("New password and new confirm password not correct");
            throw new EsmException(EsmException.NOT_PASSWORD_MATCH);
        }
        Account account = userRepo.getById(id);
        if (!passwordEncoder.matches(oldPassword, account.getPassword())){
            LOGGER.trace("Old password is not correct");
            throw new EsmException(EsmException.INCORRECT_PASSWORD);
        }
        LOGGER.info("change password successfully");
        account.setPassword(passwordEncoder.encode(newPassword));
    }

    @Transactional(rollbackFor = Exception.class)
    public void resetPassword(String userName) {

        Account account = userRepo.findByUsername(userName)
                .orElseThrow(() -> new EsmException(EsmException.USER_NOT_FOUND));

        String newStringPassWord = RandomStringUtils.random(8, true, true);
        String newEncodePassWord = passwordEncoder.encode(newStringPassWord);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(account.getUsername());
        message.setSubject("[Stdio] Reset password successfully");
        message.setText("Please sign in and change this new password: " + newStringPassWord);
        mailSender.send(message);

        account.setPassword(newEncodePassWord);
    }



    public Account findUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
}
