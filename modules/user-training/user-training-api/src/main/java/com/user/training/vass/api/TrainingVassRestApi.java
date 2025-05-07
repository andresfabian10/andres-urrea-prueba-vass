package com.user.training.vass.api;

import com.user.training.vass.model.CreateUser;
import com.user.training.vass.model.RestUtilResponse;

public interface TrainingVassRestApi {
	
	public RestUtilResponse createUserwithObject(CreateUser createUser);
}
