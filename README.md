# Proyecto Alke Wallet

Este proyecto tiene como objetivo desarrollar una billetera digital llamada "Alke Wallet", diseñada para permitir a los usuarios gestionar sus activos financieros de manera segura y conveniente. La aplicación debe proporcionar una solución confiable para administrar activos financieros digitalmente, incluyendo la capacidad de realizar transacciones dentro de la plataforma.

## 📋 Requerimientos

### Requerimientos generales:

- 💰 Administración de fondos: La aplicación debe permitir a los usuarios crear una cuenta, ver su saldo disponible y realizar ingresos y retiros de dinero, lo que debe reflejarse en el saldo actual.
- 💱 Conversión de moneda: Debe ser posible convertir el saldo de una moneda a otra.
  
### 🔄 Funcionamiento general:
El programa comienza en la clase Main, donde se crea una instancia de AlkeWallet y se muestra un menú principal que permite al usuario elegir entre iniciar sesión, crear un nuevo usuario
Dependiendo de la opción seleccionada por el usuario, se invocan los métodos correspondientes en la clase AlkeWallet.
El usuario puede crear una cuenta nueva, iniciar sesión con una cuenta existente, o simplemente listar los usuarios registrados en la billetera digital.
Una vez iniciada sesión, se muestra un menú específico para el tipo de usuario (cliente), donde puede realizar diversas operaciones como ver saldo y realizar transferencias.
Esta es una descripción general del funcionamiento del proyecto "Alke Wallet" y cómo están organizadas sus clases y métodos principales. Si necesitas más detalles sobre alguna parte específica del código, no dudes en preguntar.

## 📁 Estructura del proyecto

El proyecto está organizado de la siguiente manera:

- **AlkeWallet:** Clase principal que representa la billetera digital.
- **Cliente:** Subclase de `Usuarios` que representa a un cliente de la billetera.
- **Usuarios:** Clase abstracta que define los atributos y métodos comunes para todos los usuarios de la billetera.


## ✍️ Autor

Este proyecto fue desarrollado por Bastián Góngora
