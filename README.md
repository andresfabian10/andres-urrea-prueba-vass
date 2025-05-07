# Prueba Técnica - UserTraining VASS

Este proyecto es una prueba técnica desarrollada sobre **Liferay 7.4 CE GA132** que implementa funcionalidades con `Service Builder`, `Object API`, `JSP`, `JSTL` y `PanelApp`.

## 🛠️ Funcionalidades implementadas

- 📋 Formulario de ingreso de usuarios con validaciones (`Service Builder` y `Custom Object`)
- ⚙️ Uso del `Configuration Framework` para título personalizado y configuración de endpoint
- 🔒 Validaciones de campos requeridos (nombre y email)
- 🌐 Consumo de servicio remoto mediante `HttpURLConnection`
- 🧩 Registro del portlet en `Panel de Control > Aplicaciones` usando `PanelApp`
- 🧪 Prueba unitaria simple sobre lógica utilitaria
- 📄 Separación de lógica de negocio y exposición vía `ClientService` e interfaz pública

## 📁 Módulos del proyecto

- `user-training-api`: Interfaces y modelos del servicio
- `user-training-service`: Implementaciones, lógica de negocio y consumo de API
- `user-training-web`: Portlet, configuración, JSPs y panel administrativo

## 🧪 Cómo probar

1. Iniciar Liferay localmente (`ant all && startup.sh` o desde IDE)
2. Acceder a `/training`
3. Probar envío de formularios
4. Verificar registros en `Panel de Control > Aplicaciones > UserTrainingVass`

## ⚙️ Tecnologías

- Liferay 7.4 GA132
- Java 8+
- JSP + JSTL
- Gradle
- Service Builder
- OSGi + Gogo Shell

## 💬 Notas

- El panel de configuración está en el nivel de instancia.
- Se utilizan anotaciones `@Component` para exposición de servicios y portlets.

---

Desarrollado por **Andrés Urrea** para VASS 💼
