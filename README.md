💱 Conversor de Monedas - Alura Challenge
<img width="1024" height="1024" alt="bannermoneda" src="https://github.com/user-attachments/assets/ca7f3bc7-0be8-42e8-a6fb-421f0d38254f" />
<p align="center">
  <img src="assets/images/bannerconversor.png" alt="Banner de bienvenida" width="600">
</p>
¡Bienvenido al Conversor de Monedas! Este proyecto es una aplicación Java que permite convertir valores entre diferentes monedas utilizando tasas de cambio actualizadas desde una API externa. Es ideal para quienes necesitan realizar conversiones rápidas y precisas entre monedas internacionales.

🚀 Características
Interfaz de consola interactiva: El usuario puede seleccionar entre varias opciones de conversión.
Soporte para múltiples monedas:
Dólar estadounidense (USD)
Peso colombiano (COP)
Real brasileño (BRL)
Peso mexicano (MXN)
Euro (EUR)
Yen japonés (JPY)
Libra esterlina (GBP)
Yuan chino (CNY)

Tasas de cambio actualizadas: Los datos se obtienen en tiempo real desde la API ExchangeRate-API.
Gestión de errores: Manejo robusto de excepciones para entradas inválidas y errores en la API.


🛠️ Tecnologías utilizadas
Lenguaje: Java 17
Librerías:
Gson: Para el manejo de JSON.
java.net.http: Para realizar solicitudes HTTP.
API: ExchangeRate-API


📋 Requisitos previos
Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:
Java 17 o superior.
Maven (opcional, si deseas gestionar dependencias).

⚙️ Instalación y ejecución
Clona este repositorio:
git clone https://github.com/tu-usuario/conversor-de-monedas.git
cd conversor-de-monedas

Compila el proyecto:
javac -d bin -sourcepath src src/com/alurachallenger/conversordemonedas/app/Principal.java

Ejecuta la aplicación:
java -cp bin com.alurachallenger.conversordemonedas.app.Principal

🖥️ Uso
1. Al ejecutar la aplicación, se mostrará un menú interactivo con las opciones de conversión disponibles:

*******************Bienvenido al Conversor de Monedas****************************************

* 1. Dólar (USD) =>> Peso Colombiano (COP)   *
* 2. Peso Colombiano (COP) =>> Dólar (USD)   *
* 3. Dólar (USD) =>> Real Brasileño (BRL)    *
* 4. Real Brasileño (BRL) =>> Dólar (USD)    *
* 5. Dólar (USD) =>> Peso Mexicano (MXN)     *
* 6. Peso Mexicano (MXN) =>> Dólar (USD)     *
* 7. Euro (EUR) =>> Yen Japonés (JPY)        *
* 8. Libra Esterlina (GBP) =>> Yuan Chino (CNY) *
* 9. Salir                             *
****************************************
Elija una opción válida:
2. Selecciona una opción ingresando el número correspondiente.
3. Ingresa el monto que deseas convertir.
4. Obtendrás el resultado de la conversión en tiempo real.


docs: actualizar README del conversor de monedas
