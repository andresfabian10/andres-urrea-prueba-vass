package com.user.training.vass.web.mvc.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.user.training.vass.model.CreateUser;
import com.user.training.vass.model.CreateUser;
import com.user.training.vass.web.constants.PruebaPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + PruebaPortletKeys.PRUEBA,
        "mvc.command.name=/hola"
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

        // Aquí puedes continuar con lógica para guardar o procesar los datos
        _log.info("Validation passed. Proceeding with business logic...");
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

