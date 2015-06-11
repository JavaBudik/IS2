package pack.validator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pack.command.RegisterCommand;



public class RegValidator implements Validator {
	private static final Log LOG = LogFactory.getLog(RegValidator.class);
	
	private final static String PHONE = "[0-9]{1,}";
	//private final static String MAIL = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	private final static String NAME = "^[A-ZÀ-ß²¯ª][a-zA-Zà-ÿÀ-ß²¯ª³¿º]{1,}";	
	//private final static String MAIL = "[a-zA-Zà-ÿÀ-ß²¯ª³¿º]{1,}";	
	private final static String ADDRESS = "[a-zA-Zà-ÿÀ-ß²¯ª³¿º]{1,}";
	private final static String PASSWORD = "^[a-zA-Z0-9]{8,}";

	
	public boolean supports(Class clazz) {
		return clazz.equals(RegisterCommand.class);
		
	}
	
	public void validate(Object command, Errors errors) {
		RegisterCommand regCommand = (RegisterCommand) command;
		ValidationUtils.rejectIfEmpty(errors, "login", null, "Not empty");
		ValidationUtils.rejectIfEmpty(errors, "password", null, "Not empty");
		ValidationUtils.rejectIfEmpty(errors, "repassword", null, "Not empty");
		ValidationUtils.rejectIfEmpty(errors, "phone", null, "Not empty");
		//ValidationUtils.rejectIfEmpty(errors, "email", null, "Not empty");
		ValidationUtils.rejectIfEmpty(errors, "question", null, "Not empty");
		ValidationUtils.rejectIfEmpty(errors, "answer", null, "Not empty");
		
		if (regCommand.getRole().equals("Admin")) {
			validateAdminFields(regCommand, errors);
		}
		
		if (regCommand.getRole().equals("LowUser")) {
			validateCustomerFields(regCommand, errors);
		}
		
		if (regCommand.getRole().equals("PowerUser")) {
			validateImporterFields(regCommand, errors);
		}
		
	}
	public void validateAdminFields(Object command, Errors errors) {
		RegisterCommand regCommand = (RegisterCommand) command;
		ValidationUtils.rejectIfEmpty(errors, "firstName", null, "Not empty");
		ValidationUtils.rejectIfEmpty(errors, "surname", null, "Not empty");
		ValidationUtils.rejectIfEmpty(errors, "middleName", null, "Not empty");
		ValidationUtils.rejectIfEmpty(errors, "address", null, "Not empty");		
	}
	public void validateCustomerFields(Object command, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "firstName", null, "Not empty");
		ValidationUtils.rejectIfEmpty(errors, "surname", null, "Not empty");
		ValidationUtils.rejectIfEmpty(errors, "middleName", null, "Not empty");
		ValidationUtils.rejectIfEmpty(errors, "address", null, "Not empty");
		ValidationUtils.rejectIfEmpty(errors, "city", null, "Not empty");
		ValidationUtils.rejectIfEmpty(errors, "country", null, "Not empty");
		
	}
	public void validateImporterFields(Object command, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "firstName", null, "Not empty");
		ValidationUtils.rejectIfEmpty(errors, "city", null, "Not empty");
		ValidationUtils.rejectIfEmpty(errors, "country", null, "Not empty");		
				
	}	
}
