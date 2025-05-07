package com.user.training.vass.web.mvc.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.user.training.vass.model.CreateUser;
import com.user.training.vass.model.Training;
import com.user.training.vass.service.TrainingLocalServiceUtil;
import com.user.training.vass.web.constants.MVCCommandNames;
import com.user.training.vass.web.constants.UserTrainingPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + UserTrainingPortletKeys.USERTRAINING,
        "mvc.command.name=" + MVCCommandNames.ACTION_CREATE_USER
    },
    service = MVCActionCommand.class
)
public class CreateUserMVCActionCommand extends BaseMVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(CreateUserMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        String name = ParamUtil.getString(actionRequest, "name");
        String email = ParamUtil.getString(actionRequest, "email");

        CreateUser createUser = new CreateUser(name, email);

        _log.info("Processing CreateUser form with name: " + name + " and email: " + email);

        validateFields(actionRequest, createUser);

        if (!SessionErrors.isEmpty(actionRequest)) {
            _log.warn("Validation failed. Errors were added to SessionErrors.");
            return;
        }

        long trainingId = CounterLocalServiceUtil.increment(Training.class.getName());
		Training training = TrainingLocalServiceUtil.createTraining(trainingId);
		training.setUserName(createUser.getName());
		training.setEmail(createUser.getEmail());
		TrainingLocalServiceUtil.addTraining(training);
		
		_log.info(String.format("Hola, %s! tu email es %s.", name, email));
    }

    private void validateFields(ActionRequest actionRequest, CreateUser createUser) {
        if (Validator.isNull(createUser.getName())) {
            SessionErrors.add(actionRequest, "nameRequired");
        }

        if (!Validator.isEmailAddress(createUser.getEmail())) {
            SessionErrors.add(actionRequest, "emailInvalid");
        }
    }
}

