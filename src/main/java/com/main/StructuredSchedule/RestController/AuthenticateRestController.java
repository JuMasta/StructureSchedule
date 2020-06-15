package com.main.StructuredSchedule.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.main.StructuredSchedule.Enums.UserType;
import com.main.StructuredSchedule.configObject.ConfigLinksObject;
import com.main.StructuredSchedule.dto.UserDTO;
import com.main.StructuredSchedule.models.User;
import com.main.StructuredSchedule.services.UserServiceImpl;
import com.main.StructuredSchedule.util.JwtUtil;

@RestController
public class AuthenticateRestController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	ConfigLinksObject configLinks;

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	private AuthenticationManager authenticationManager;

	Logger logger = LoggerFactory.getLogger(AuthenticateRestController.class);

	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody UserDTO userDTO) throws Exception {

		try {

			User user = userServiceImpl.findByEmail(userDTO.getEmail());
			if(user != null)
			{
			if (user.getActivationCod() != null) {

				return new ResponseEntity<String>("Пользователь не акитвирован", HttpStatus.FORBIDDEN);

			}
			}
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getPassword()));

			HttpHeaders responseHeaders = new HttpHeaders();
			EntityModel<UserDTO> entityModel = new EntityModel<UserDTO>(new UserDTO(user));
			UserType userType = user.getUserType();

			if (userType == UserType.PRODUCER) {
				entityModel.add(configLinks.getUserProducerLinks(user));

			} else if (userType == UserType.CONSUMER) {
				entityModel.add(configLinks.getUserСonsumerLinks(user));
			}

			responseHeaders.setBearerAuth(jwtUtil.generateToken(userDTO.getEmail()));
			return new ResponseEntity<EntityModel<UserDTO>>(entityModel, responseHeaders, HttpStatus.OK);

		} catch (Exception ex) {
			logger.warn(ex.getMessage());
			return new ResponseEntity<String>("Ошибка", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
