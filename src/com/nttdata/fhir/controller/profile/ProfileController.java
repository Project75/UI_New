package com.nttdata.fhir.controller.profile;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.fhir.controller.mapping.MappingController;
import com.nttdata.fhir.dao.BaseProfileTypeDao;
import com.nttdata.fhir.dao.ProfileFieldDao;
import com.nttdata.fhir.model.BaseProfileType;
import com.nttdata.fhir.model.ProfileField;

@RestController
@RequestMapping("api/profile")
public class ProfileController {
	
	//Field used for programmer logging
	private static final Logger LOG = LogManager.getLogger(MappingController.class);
	
	@Autowired private BaseProfileTypeDao baseProfileTypeDao;
	@Autowired private ProfileFieldDao profileFieldDao;
	
	

	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<BaseProfileType>> getList() {
		List<BaseProfileType> profileList = null;
	
		try {
			
			profileList = baseProfileTypeDao.getAll();
			
		} catch (SecurityException se) {
			LOG.warn(se.toString());
			return new ResponseEntity<List<BaseProfileType>>(HttpStatus.UNAUTHORIZED);
		} catch (Throwable t) {
			LOG.error(t.getMessage());
			return new ResponseEntity<List<BaseProfileType>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<BaseProfileType>>(profileList, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getById/{profileTypeId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<BaseProfileType> getById(@PathVariable String profileTypeId) {
		BaseProfileType profile = null;
		
		try {
			  profile = baseProfileTypeDao.getById(profileTypeId, true);
			
		} catch (SecurityException se) {
			LOG.warn(se.toString());
			return new ResponseEntity<BaseProfileType>(HttpStatus.UNAUTHORIZED);
		} catch (Throwable t) {
			LOG.error(t.getMessage());
			return new ResponseEntity<BaseProfileType>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<BaseProfileType>(profile, HttpStatus.OK);
	}

}
