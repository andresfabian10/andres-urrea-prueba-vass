package com.user.training.vass.web.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "foobar", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "com.user.training.vass.web.configuration.CustomWebConfiguration", localization = "content/Language", name = "n2f3-configuration-name")
public interface CustomWebConfiguration {

	@Meta.AD(deflt = "Bienvenido al formulario de entrenamiento!", name = "Titulo de bienvenida", required = false)
	public String welcomeTitle();

	@Meta.AD(deflt = "http://localhost:8080/o/c/trainingvasses/", name = "URL del Custom Object", required = false)
	public String customObjectURL();

	@Meta.AD(deflt = "blue", required = false)
	public String fontColor();

	@Meta.AD(deflt = "serif", required = false)
	public String fontFamily();

	@Meta.AD(deflt = "16", required = false)
	public int fontSize();

}
