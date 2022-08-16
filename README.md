# Evalucion 2 Programación Orientada a Objetos
### CRUD con pantalla de login para ingreso al sistema

#### Integrantes:
- Jhon Torres
- Camila Mier 

### Funcionalidad

#### Login
Para ingresar al CRUD, se debe tener las credenciales creadas dentro de la base de datos "Mi tienda", luego de eso en la pagina de Login, ingresaremos nuestro correo y nuestra contraseña; y pulsaremos el boton `Ingresar`
Luego de esto en caso de que nuestras ccredenciales sean correctas, ingresaremos al CRUD, pero si nuestras credenciales son incorrectas el programa nos retornará un mensaje de error.

#### CRUD
- `Grabar` = Cuando deseemos agregar un nuevo registro o producto a nuestra base de datos, usaremos esta función, para ellos en la pantalla de CRUD solo debemos ingresar los parámetros de `Nombre`, `Precio`, `Ciudad` y `Cantidad` para que se ingrese nuestro registro. Si ingresamos algun valor en ID, nuestro registro no se guardará en la base de datos y nos saldrá un mensaje de error.
- `Borrar` = Para usar esta función primero buscaremos el producto mediante su ID, con la función `Buscar`, comprobaremos si es el registro que deseamos eliminar y pulsamos en `Borrar`
- `Actualizar` = Para usar esta función primero buscaremos el producto mediante su ID, con la función `Buscar`, comprobaremos si es el registro que deseamos editar, cambiamos los detalles que deseemos del producto y pulsamos en `Actualizar`.
- `Limpiar` = Esta función nos servirá para borrar loq ue tengamos escrito en los campos del CRUD, para de esta forma ejecutar alguna de las otras funciones.
- `Buscar`= Para usar esta función ingresaremos el ID del producto que deseamos buscar y luego pulsaremos en el bontón `Buscar`. En caso de no existir el producto que estamos buscando el programa retornará un mensaje indicando que el producto no se ha encontrado.


### Formato del login
![Interfaz login](https://github.com/jhon-torres/Evalucion_2/blob/2f4dd8cb43c1b914a116fb4cbd3b59fef9e72254/CRUD%20ReadMe%20Imagenes/Interfaz%20login.jpeg)


### Formato del CRUD
![Interfaz CRUD](https://github.com/jhon-torres/Evalucion_2/blob/2f4dd8cb43c1b914a116fb4cbd3b59fef9e72254/CRUD%20ReadMe%20Imagenes/Interfaz%20CRUD.jpeg)
