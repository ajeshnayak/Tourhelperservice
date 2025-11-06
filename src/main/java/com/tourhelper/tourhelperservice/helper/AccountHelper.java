package com.tourhelper.tourhelperservice.helper;

import com.tourhelper.tourhelperservice.exception.InvalidArgumentException;
import com.tourhelper.tourhelperservice.dto.AccountDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AccountHelper {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{7,29}$", Pattern.CASE_INSENSITIVE); // Example regex


    public void validateCreateAccount(AccountDto accountDto){
        if(StringUtils.isBlank(accountDto.getUserName()) &&
                (StringUtils.isBlank(accountDto.getEmailId()) || !validateEmail(accountDto.getEmailId()))){
            throw new InvalidArgumentException("Invalid Email Id");
        } else if (StringUtils.isBlank(accountDto.getEmailId()) &&
                StringUtils.isBlank(accountDto.getUserName()) || validateUserName(accountDto.getUserName())) {
            throw new InvalidArgumentException("Invalid User Name");
        }
        if(StringUtils.isBlank(accountDto.getPassword()) || accountDto.getPassword().length()<8){
            throw new InvalidArgumentException("Insufficient Password length");
        }

    }

    public void validateDeleteAccount(AccountDto accountDto) {
        if (StringUtils.isBlank(accountDto.getUserGuid())) {
            throw new InvalidArgumentException("Empty User Guid");
        }
    }

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }
    public static boolean validateUserName(String userName) {
        Matcher matcher = USERNAME_PATTERN.matcher(userName);
        return matcher.matches();
    }
}
