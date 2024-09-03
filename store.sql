CREATE DATABASE STORE; -- Crea la base de datos llamada STORE.

USE STORE; -- Selecciona la base de datos STORE.


-- Tabla para almacenar información de los clientes.
CREATE TABLE Cliente (
    Documento INT PRIMARY KEY, -- Número de documento del cliente (identificador único).
    Nombre VARCHAR(100) NOT NULL, -- Nombre del cliente.
    CorreoElectronico VARCHAR(255) NOT NULL, -- Correo electrónico del cliente.
    Direccion VARCHAR(255) NOT NULL, -- Dirección del cliente.
    Celular VARCHAR(255) NOT NULL, -- Número de celular del cliente.
    Puntos INT -- Puntos acumulados por el cliente.
);

-- Tabla para almacenar información de los empleados.
CREATE TABLE Empleado (
    Identificacion INT PRIMARY KEY, -- Identificación del empleado (identificador único).
    Nombre VARCHAR(100) NOT NULL, -- Nombre del empleado.
    Cargo VARCHAR(100) NOT NULL, -- Cargo del empleado.
    Salario DECIMAL(10,2) NOT NULL, -- Salario del empleado.
    CorreoElectronico VARCHAR(255) NOT NULL, -- Correo electrónico del empleado.
    Direccion VARCHAR(255) NOT NULL, -- Dirección del empleado.
    Celular VARCHAR(255) NOT NULL, -- Número de celular del empleado.
    FechaContratacion DATE NOT NULL, -- Fecha de contratación del empleado.
    FechaFinContratacion DATE, -- Fecha de finalización de la contratación del empleado.
    CantidadVentas INT -- Cantidad de ventas realizadas por el empleado.
);

-- Tabla para almacenar información de los proveedores.
CREATE TABLE Proveedor (
    IdProveedor INT PRIMARY KEY, -- Identificador único del proveedor.
    Empresa VARCHAR(100) NOT NULL, -- Nombre de la empresa proveedora.
    Direccion VARCHAR(100) NOT NULL, -- Dirección del proveedor.
    Telefono VARCHAR(100) NOT NULL, -- Número de teléfono del proveedor.
    CorreoElectronico VARCHAR(255) NOT NULL, -- Correo electrónico del proveedor.
    Observaciones VARCHAR(255) -- Observaciones sobre el proveedor.
);

-- Tabla para almacenar información de los métodos de pago.
CREATE TABLE MetodoPago (
    IdPago INT PRIMARY KEY AUTO_INCREMENT, -- Identificador único del método de pago.
    Nombre VARCHAR(255) NOT NULL UNIQUE, -- Nombre del método de pago.
    Detalles VARCHAR(255) -- Detalles adicionales del método de pago.
);

-- Tabla para registrar transacciones financieras.
CREATE TABLE Finanzas (
    Registro INT PRIMARY KEY AUTO_INCREMENT, -- Identificador único del registro financiero.
    TipoTransaccion VARCHAR(50) NOT NULL, -- Tipo de transacción financiera.
    FechaHora DATETIME NOT NULL, -- Fecha y hora de la transacción.
    Monto DECIMAL(10,2) NOT NULL, -- Monto de la transacción.
    Archivo LONGBLOB -- Archivo asociado a la transacción.
);

-- Tabla para almacenar información de los usuarios de acceso.
CREATE TABLE Usuario (
    ID INT PRIMARY KEY AUTO_INCREMENT, -- Identificador único del usuario.
    Usuario VARCHAR(255) NOT NULL UNIQUE, -- Nombre de usuario.
    Hash VARCHAR(255) NOT NULL, -- Hash de la contraseña del usuario.
    PermisoClientes BOOLEAN NOT NULL, -- Permisos del usuario
    PermisoEmpleados BOOLEAN NOT NULL,
    PermisoVentas BOOLEAN NOT NULL,
    PermisoCompras BOOLEAN NOT NULL,
    PermisoInventario BOOLEAN NOT NULL,
    PermisoFinanzas BOOLEAN NOT NULL,
    PermisoProveedores BOOLEAN NOT NULL,
    PermisoMetodos BOOLEAN NOT NULL
);

-- Tabla para almacenar información de las ventas.
CREATE TABLE Venta (
    NumeroVenta INT PRIMARY KEY AUTO_INCREMENT, -- Número único de la venta.
    Documento INT, -- Documento del cliente asociado a la venta.
    Identificacion INT, -- Identificación del empleado asociado a la venta.
    FechaHora DATETIME NOT NULL, -- Fecha y hora de la venta.
    Monto DECIMAL(10,2) NOT NULL, -- Monto total de la venta.
    Estado VARCHAR(100) NOT NULL, -- Estado de la venta.
    Observaciones VARCHAR(255), -- Observaciones adicionales sobre la venta.
    FOREIGN KEY (Documento) REFERENCES Cliente(Documento), -- Clave foránea que referencia a la tabla Cliente.
    FOREIGN KEY (Identificacion) REFERENCES Empleado(Identificacion) -- Clave foránea que referencia a la tabla Empleado.
);

-- Tabla para almacenar información de las compras.
CREATE TABLE Compra (
    NumeroCompra INT PRIMARY KEY AUTO_INCREMENT, -- Número único de la compra.
    IdProveedor INT NOT NULL, -- Identificador del proveedor asociado a la compra.
    Identificacion INT NOT NULL, -- Identificación del empleado asociado a la compra.
    FechaHora DATETIME NOT NULL, -- Fecha y hora de la compra.
    Monto DECIMAL(10,2) NOT NULL, -- Monto total de la compra.
    Estado VARCHAR(100) NOT NULL, -- Estado de la compra.
    Observaciones VARCHAR(255), -- Observaciones adicionales sobre la compra.
    FOREIGN KEY (IdProveedor) REFERENCES Proveedor(IdProveedor), -- Clave foránea que referencia a la tabla Proveedor.
    FOREIGN KEY (Identificacion) REFERENCES Empleado(Identificacion) -- Clave foránea que referencia a la tabla Empleado.
);

-- Tabla para almacenar información de productos en inventario.
CREATE TABLE Inventario (
    IdProducto INT PRIMARY KEY AUTO_INCREMENT, -- Identificador único del producto.
    IdCategoria VARCHAR(30) NOT NULL, -- Identificador de la categoría del producto.
    Nombre VARCHAR(100) NOT NULL, -- Nombre del producto.
    Marca VARCHAR(100) NOT NULL, -- Marca del producto.
    UnidadMedida VARCHAR(30) NOT NULL, -- Unidad de medida del producto.
    Categoria VARCHAR(30) NOT NULL, -- Categoria a la que pertenece el producto.
    PrecioCompra DECIMAL(10,2) NOT NULL, -- Precio de compra del producto.
    PrecioVenta DECIMAL(10,2) NOT NULL, -- Precio de venta del producto.
    Cantidad INT NOT NULL, -- Cantidad disponible en inventario del producto.
    Descripcion VARCHAR(255) -- Descripción del producto.
);

------------------------------------------------------------------------------------------------------------------------------------
-- TABLAS DEBILES

-- Tabla para registrar los pagos asociados a las ventas.
CREATE TABLE VentaPago (
    IdVentaPago INT PRIMARY KEY AUTO_INCREMENT, -- Identificador único del registro de pago asociado a una venta.
    NumeroVenta INT NOT NULL, -- Número de venta asociado al pago.
    IdPago INT NOT NULL, -- Identificador del método de pago utilizado en la venta.
    FOREIGN KEY (NumeroVenta) REFERENCES Venta(NumeroVenta), -- Clave foránea que referencia a la tabla Venta.
    FOREIGN KEY (IdPago) REFERENCES MetodoPago(IdPago) -- Clave foránea que referencia a la tabla MetodoPago.
);

-- Tabla para registrar los pagos asociados a las compras.
CREATE TABLE CompraPago (
    IdCompraPago INT PRIMARY KEY AUTO_INCREMENT, -- Identificador único del registro de pago asociado a una compra.
    NumeroCompra INT NOT NULL, -- Número de compra asociado al pago.
    IdPago INT NOT NULL, -- Identificador del método de pago utilizado en la compra.
    FOREIGN KEY (NumeroCompra) REFERENCES Compra(NumeroCompra), -- Clave foránea que referencia a la tabla Compra.
    FOREIGN KEY (IdPago) REFERENCES MetodoPago(IdPago) -- Clave foránea que referencia a la tabla MetodoPago.
);

-- Tabla para registrar las salidas de productos del inventario.
CREATE TABLE SalidaInventario (
    IdSalidaInventario INT PRIMARY KEY AUTO_INCREMENT, -- Identificador único de la salida de inventario.
    IdProducto INT NOT NULL, -- Identificador del producto que sale del inventario.
    NumeroVenta INT NOT NULL, -- Número de venta asociado a la salida de inventario.
    FOREIGN KEY (IdProducto) REFERENCES Inventario(IdProducto), -- Clave foránea que referencia a la tabla Inventario.
    FOREIGN KEY (NumeroVenta) REFERENCES Venta(NumeroVenta) -- Clave foránea que referencia a la tabla Venta.
);

-- Tabla para registrar los ingresos de productos al inventario.
CREATE TABLE IngresoInventario (
    IdIngresoInventario INT PRIMARY KEY AUTO_INCREMENT, -- Identificador único del ingreso de inventario.
    IdProducto INT NOT NULL, -- Identificador del producto que ingresa al inventario.
    NumeroCompra INT NOT NULL, -- Número de compra asociado al ingreso de inventario.
    FOREIGN KEY (IdProducto) REFERENCES Inventario(IdProducto), -- Clave foránea que referencia a la tabla Inventario.
    FOREIGN KEY (NumeroCompra) REFERENCES Compra(NumeroCompra) -- Clave foránea que referencia a la tabla Compra.
);

------------------------------------------------------------------------------------------------------------------------------------
-- FUNCIONES

---------------------------------------------------------------CLIENTE--------------------------------------------------------------

-- Establece el delimitador personalizado para permitir el uso de ";" dentro de la definición del procedimiento.
DELIMITER //

-- Crear procedimiento para insertar un nuevo cliente en la tabla Cliente.
CREATE PROCEDURE InsertarCliente (
    IN pDocumento INT,
    IN pNombre VARCHAR(100),
    IN pCorreoElectronico VARCHAR(255),
    IN pDireccion VARCHAR(255),
    IN pCelular VARCHAR(255)
)
BEGIN
    -- Inserta los valores proporcionados en la tabla Cliente.
    INSERT INTO Cliente (Documento, Nombre, CorreoElectronico, Direccion, Celular)
    VALUES (pDocumento, pNombre, pCorreoElectronico, pDireccion, pCelular);
END //

-- Crear procedimiento para editar los datos de un cliente en la tabla Cliente.
CREATE PROCEDURE EditarCliente (
    IN pDocumento INT,
    IN pNombre VARCHAR(100),
    IN pCorreoElectronico VARCHAR(255),
    IN pDireccion VARCHAR(255),
    IN pCelular VARCHAR(255)
)
BEGIN
    -- Actualiza los datos del cliente con el documento proporcionado.
    IF NOT EXISTS (
        SELECT *
        FROM Cliente
        WHERE Nombre = pNombre
        AND CorreoElectronico = pCorreoElectronico
        AND Direccion = pDireccion
        AND Celular = pCelular
    ) THEN
        -- Actualizar los datos del cliente con el documento proporcionado
        UPDATE Cliente
        SET Nombre = pNombre,
            CorreoElectronico = pCorreoElectronico,
            Direccion = pDireccion,
            Celular = pCelular
        WHERE Documento = pDocumento;

        SELECT 'Cliente actualizado correctamente' AS Mensaje;
    ELSE
        SELECT 'No hay cambios por enviar.' AS Mensaje;
    END IF;
END //

-- Crear procedimiento para eliminar un cliente de la tabla Cliente.
CREATE PROCEDURE EliminarCliente (
    IN pDocumento INT
)
BEGIN
    -- Elimina el cliente con el documento proporcionado.
    DELETE FROM Cliente
    WHERE Documento = pDocumento;
END //

-- Crear procedimiento para mostrar los detalles de un cliente específico en la tabla Cliente.
CREATE PROCEDURE MostrarCliente (
    IN pDocumento INT
)
BEGIN
    -- Selecciona y muestra todos los detalles del cliente con el documento proporcionado.
    SELECT *
    FROM Cliente
    WHERE Documento = pDocumento;
END //

-- Crear procedimiento para mostrar todos los clientes en la tabla Cliente.
CREATE PROCEDURE MostrarClientes ()
BEGIN
    -- Selecciona y muestra todos los clientes.
    SELECT * FROM Cliente;
END //

-- Restaura el delimitador por defecto ";".
DELIMITER ;

---------------------------------------------------------------EMPLEADO------------------------------------------------------------

-- Establecer el delimitador personalizado para permitir el uso de ";" dentro de la definición del procedimiento.
DELIMITER //

-- Procedimiento para insertar un nuevo empleado en la tabla Empleado.
CREATE PROCEDURE InsertarEmpleado (
    IN pIdentificacion INT,
    IN pNombre VARCHAR(100),
    IN pCargo VARCHAR(100),
    IN pSalario DECIMAL(10,2),
    IN pCorreoElectronico VARCHAR(255),
    IN pDireccion VARCHAR(255),
    IN pCelular VARCHAR(255)
)
BEGIN
    -- Insertar los valores proporcionados en la tabla Empleado.
    INSERT INTO Empleado (Identificacion, Nombre, Cargo, Salario, CorreoElectronico, Direccion, Celular, FechaContratacion)
    VALUES (pIdentificacion, pNombre, pCargo, pSalario, pCorreoElectronico, pDireccion, pCelular, NOW());
END //

-- Procedimiento para editar los datos de un empleado en la tabla Empleado.
CREATE PROCEDURE EditarEmpleado (
    IN pIdentificacion INT,
    IN pNombre VARCHAR(100),
    IN pCargo VARCHAR(100),
    IN pSalario DECIMAL(10,2),
    IN pCorreoElectronico VARCHAR(255),
    IN pDireccion VARCHAR(255),
    IN pCelular VARCHAR(255)
)
BEGIN
    -- Verificar si los nuevos datos son diferentes de los existentes
    IF NOT EXISTS (
        SELECT *
        FROM Empleado
        WHERE Nombre = pNombre
        AND Cargo = pCargo
        AND Salario = pSalario
        AND CorreoElectronico = pCorreoElectronico
        AND Direccion = pDireccion
        AND Celular = pCelular
    ) THEN
        -- Actualizar los datos del empleado con la identificación proporcionada.
        UPDATE Empleado
        SET Nombre = pNombre,
            Cargo = pCargo,
            Salario = pSalario,
            CorreoElectronico = pCorreoElectronico,
            Direccion = pDireccion,
            Celular = pCelular
        WHERE Identificacion = pIdentificacion;

        SELECT 'Empleado actualizado correctamente' AS Mensaje;
    ELSE
        SELECT 'No hay cambios por enviar.' AS Mensaje;
    END IF;
END //

-- Procedimiento para eliminar un empleado de la tabla Empleado.
CREATE PROCEDURE EliminarEmpleado (
    IN pIdentificacion INT
)
BEGIN
    -- Eliminar el empleado con la identificación proporcionada.
    DELETE FROM Empleado
    WHERE Identificacion = pIdentificacion;
END //

-- Procedimiento para mostrar los detalles de un empleado específico en la tabla Empleado.
CREATE PROCEDURE MostrarEmpleado (
    IN pIdentificacion INT
)
BEGIN
    -- Seleccionar y mostrar todos los detalles del empleado con la identificación proporcionada.
    SELECT *
    FROM Empleado
    WHERE Identificacion = pIdentificacion;
END //

-- Procedimiento para mostrar todos los empleados en la tabla Empleado.
CREATE PROCEDURE MostrarEmpleados ()
BEGIN
    -- Seleccionar y mostrar todos los empleados.
    SELECT * FROM Empleado;
END //

-- Restaurar el delimitador por defecto ";".
DELIMITER ;

---------------------------------------------------------------PROVEEDOR------------------------------------------------------------

-- Establecer el delimitador personalizado para permitir el uso de ";" dentro de la definición del procedimiento.
DELIMITER //

-- Procedimiento para insertar un nuevo proveedor en la tabla Proveedor.
CREATE PROCEDURE InsertarProveedor (
    IN pIdProveedor INT,
    IN pEmpresa VARCHAR(100),
    IN pDireccion VARCHAR(100),
    IN pTelefono VARCHAR(100),
    IN pCorreoElectronico VARCHAR(255)
)
BEGIN
    -- Inserta los valores proporcionados en la tabla Proveedor.
    INSERT INTO Proveedor (IdProveedor, Empresa, Direccion, Telefono, CorreoElectronico , Observaciones)
    VALUES (pIdProveedor, pEmpresa, pDireccion, pTelefono, pCorreoElectronico, "");
END //

-- Procedimiento para editar un proveedor en la tabla Proveedor.
CREATE PROCEDURE EditarProveedor (
    IN pIdProveedor INT,
    IN pEmpresa VARCHAR(100),
    IN pDireccion VARCHAR(100),
    IN pTelefono VARCHAR(100),
    IN pCorreoElectronico VARCHAR(255),
    IN pObservaciones VARCHAR(255)
)
BEGIN
    -- Verificar si los nuevos datos son diferentes de los existentes
    IF NOT EXISTS (
        SELECT *
        FROM Proveedor
        WHERE Empresa = pEmpresa
        AND Direccion = pDireccion
        AND Telefono = pTelefono
        AND CorreoElectronico = pCorreoElectronico
        AND Observaciones = pObservaciones
    ) THEN
        -- Actualizar los datos del proveedor con el IdProveedor proporcionado.
        UPDATE Proveedor
        SET Empresa = pEmpresa,
            Direccion = pDireccion,
            Telefono = pTelefono,
            CorreoElectronico = pCorreoElectronico,
            Observaciones = pObservaciones
        WHERE IdProveedor = pIdProveedor;

        SELECT 'Proveedor actualizado correctamente' AS Mensaje;
    ELSE
        SELECT 'No hay cambios por enviar.' AS Mensaje;
    END IF;
END //

-- Procedimiento para eliminar un proveedor de la tabla Proveedor.
CREATE PROCEDURE EliminarProveedor (
    IN pIdProveedor INT
)
BEGIN
    -- Elimina el proveedor con el IdProveedor proporcionado.
    DELETE FROM Proveedor
    WHERE IdProveedor = pIdProveedor;
END //

-- Procedimiento para mostrar los detalles de un proveedor específico en la tabla Proveedor.
CREATE PROCEDURE MostrarProveedor (
    IN pIdProveedor INT
)
BEGIN
    -- Selecciona los detalles del proveedor con el IdProveedor proporcionado.
    SELECT *
    FROM Proveedor
    WHERE IdProveedor = pIdProveedor;
END //

-- Procedimiento para mostrar todos los proveedores en la tabla Proveedor.
CREATE PROCEDURE MostrarProveedores ()
BEGIN
    -- Selecciona todos los proveedores en la tabla Proveedor.
    SELECT * FROM Proveedor;
END //

-- Restaurar el delimitador por defecto ";".
DELIMITER ;

-------------------------------------------------------------METODOSPAGO----------------------------------------------------------

-- Establecer el delimitador personalizado para permitir el uso de ";" dentro de la definición del procedimiento.
DELIMITER //

-- Procedimiento para insertar un nuevo método de pago en la tabla MetodoPago.
CREATE PROCEDURE InsertarMetodoPago (
    IN pNombre VARCHAR(255),
    IN pDetalles VARCHAR(255)
)
BEGIN
    -- Inserta los valores proporcionados en la tabla MetodoPago.
    INSERT INTO MetodoPago (Nombre, Detalles)
    VALUES (pNombre, pDetalles);
END //

-- Procedimiento para editar un método de pago en la tabla MetodoPago.
CREATE PROCEDURE EditarMetodoPago (
    IN pIdPago INT,
    IN pNombre VARCHAR(255),
    IN pDetalles VARCHAR(255)
)
BEGIN
    -- Verificar si los nuevos datos son diferentes de los existentes
    IF NOT EXISTS (
        SELECT *
        FROM MetodoPago
        WHERE Detalles = pDetalles
    ) THEN
        -- Actualizar los valores del método de pago con el IdPago proporcionado.
        UPDATE MetodoPago
        SET Detalles = pDetalles
        WHERE IdPago = pIdPago;

        SELECT 'Método de pago actualizado correctamente' AS Mensaje;
    ELSE
        SELECT 'No hay cambios por enviar.' AS Mensaje;
    END IF;
END //

-- Procedimiento para eliminar un método de pago de la tabla MetodoPago.
CREATE PROCEDURE EliminarMetodoPago (
    IN pIdPago INT
)
BEGIN
    -- Elimina el método de pago con el IdPago proporcionado.
    DELETE FROM MetodoPago
    WHERE IdPago = pIdPago;
END //

-- Procedimiento para mostrar los detalles de un método de pago específico en la tabla MetodoPago.
CREATE PROCEDURE MostrarMetodoPago (
    IN pIdPago INT
)
BEGIN
    -- Selecciona los detalles del método de pago con el IdPago proporcionado.
    SELECT *
    FROM MetodoPago
    WHERE IdPago = pIdPago;
END //

-- Procedimiento para mostrar todos los métodos de pago en la tabla MetodoPago.
CREATE PROCEDURE MostrarMetodosPago ()
BEGIN
    -- Selecciona todos los métodos de pago en la tabla MetodoPago.
    SELECT * FROM MetodoPago;
END //

-- Restaurar el delimitador por defecto ";".
DELIMITER ;

---------------------------------------------------------------USUARIOS------------------------------------------------------------

-- Establecer el delimitador personalizado para permitir el uso de ";" dentro de la definición del procedimiento.
DELIMITER //

-- Procedimiento para insertar un nuevo usuario en la tabla Usuario.
CREATE PROCEDURE InsertarUsuario (
    IN pUsuario VARCHAR (255),
    IN pHash VARCHAR(255),
    IN pPermisoClientes BOOLEAN,
    IN pPermisoEmpleados BOOLEAN,
    IN pPermisoVentas BOOLEAN,
    IN pPermisoCompras BOOLEAN,
    IN pPermisoInventario BOOLEAN,
    IN pPermisoFinanzas BOOLEAN,
    IN pPermisoProveedores BOOLEAN,
    IN pPermisoMetodos BOOLEAN
)
BEGIN
    -- Inserta los valores proporcionados en la tabla Usuario.
    INSERT INTO Usuario (Usuario, Hash, PermisoClientes, PermisoEmpleados, PermisoVentas, PermisoCompras, PermisoInventario, PermisoFinanzas, PermisoProveedores, PermisoMetodos)
    VALUES (pUsuario, pHash, pPermisoClientes, pPermisoEmpleados, pPermisoVentas, pPermisoCompras, pPermisoInventario, pPermisoFinanzas, pPermisoProveedores, pPermisoMetodos);
END //

-- Procedimiento para editar un usuario en la tabla Usuario.
CREATE PROCEDURE EditarUsuario (
    IN pIdUsuario INT,
    IN pUsuario VARCHAR(255),
    IN pHash VARCHAR(255),
    IN pPermisoClientes BOOLEAN,
    IN pPermisoEmpleados BOOLEAN,
    IN pPermisoVentas BOOLEAN,
    IN pPermisoCompras BOOLEAN,
    IN pPermisoInventario BOOLEAN,
    IN pPermisoFinanzas BOOLEAN,
    IN pPermisoProveedores BOOLEAN,
    IN pPermisoMetodos BOOLEAN
)
BEGIN
    -- Verificar si los nuevos datos son diferentes de los existentes
    IF NOT EXISTS (
        SELECT *
        FROM Usuario
        WHERE Usuario = pUsuario
        AND Hash = pHash
        AND PermisoClientes = pPermisoClientes
        AND PermisoEmpleados = pPermisoEmpleados
        AND PermisoVentas = pPermisoVentas
        AND PermisoCompras = pPermisoCompras
        AND PermisoInventario = pPermisoInventario
        AND PermisoFinanzas = pPermisoFinanzas
        AND PermisoProveedores = pPermisoProveedores
        AND PermisoMetodos = pPermisoMetodos
    ) THEN
        -- Actualizar los valores del usuario con el ID proporcionado.
        UPDATE Usuario
        SET Usuario = pUsuario,
            Hash = pHash,
            PermisoClientes = pPermisoClientes,
            PermisoEmpleados = pPermisoEmpleados,
            PermisoVentas = pPermisoVentas,
            PermisoCompras = pPermisoCompras,
            PermisoInventario = pPermisoInventario,
            PermisoFinanzas = pPermisoFinanzas,
            PermisoProveedores = pPermisoProveedores,
            PermisoMetodos = pPermisoMetodos
        WHERE ID = pIdUsuario;

        SELECT 'Usuario actualizado correctamente' AS Mensaje;
    ELSE
        SELECT 'No hay cambios por enviar.' AS Mensaje;
    END IF;
END //

-- Procedimiento para eliminar un usuario de la tabla Usuario.
CREATE PROCEDURE EliminarUsuario (
    IN pIdUsuario INT
)
BEGIN
    -- Elimina el usuario con el ID proporcionado.
    DELETE FROM Usuario
    WHERE ID = pIdUsuario;
END //

-- Procedimiento para mostrar los detalles de un usuario específico en la tabla Usuario.
CREATE PROCEDURE MostrarUsuario (
    IN pID INT
)
BEGIN
    -- Selecciona los detalles del usuario con el ID proporcionado.
    SELECT *
    FROM Usuario
    WHERE ID = pID;
END //

-- Procedimiento para mostrar todos los usuarios en la tabla Usuario.
CREATE PROCEDURE MostrarUsuarios ()
BEGIN
    -- Selecciona todos los usuarios en la tabla Usuario.
    SELECT * FROM Usuario;
END //

-- Restaurar el delimitador por defecto ";".
DELIMITER ;


---------------------------------------------------------------FINANZAS------------------------------------------------------------

-- Establecer el delimitador personalizado para permitir el uso de ";" dentro de la definición del procedimiento.
DELIMITER //

-- Procedimiento para insertar una factura en la tabla Finanzas.
CREATE PROCEDURE InsertarFacturaEnFinanzas (
    IN pTipoTransaccion VARCHAR(50),   -- Tipo de transacción de la factura.
    IN pFechaHora DATETIME,            -- Fecha y hora de la transacción.
    IN pMonto DECIMAL(10,2),           -- Monto de la transacción.
    IN pArchivo LONGBLOB               -- Archivo adjunto a la factura.
)
BEGIN
    -- Inserta los valores proporcionados en la tabla Finanzas.
    INSERT INTO Finanzas (TipoTransaccion, FechaHora, Monto, Archivo)
    VALUES (pTipoTransaccion, pFechaHora, pMonto, pArchivo);
END //

-- Procedimiento para mostrar los detalles de una factura específica en la tabla Finanzas.
CREATE PROCEDURE MostrarFacturaEnFinanzas (
    IN pRegistro INT    -- Número de registro de la factura.
)
BEGIN
    -- Selecciona los detalles de la factura con el número de registro proporcionado.
    SELECT *
    FROM Finanzas
    WHERE Registro = pRegistro;
END //

-- Procedimiento para mostrar todas las facturas en la tabla Finanzas.
CREATE PROCEDURE MostrarFacturasEnFinanzas ()
BEGIN
    -- Selecciona todas las facturas en la tabla Finanzas.
    SELECT *
    FROM Finanzas;
END //

DELIMITER ;
-- Restaurar el delimitador por defecto ";".
DELIMITER ;


---------------------------------------------------------------VENTAS------------------------------------------------------------

-- Establecer el delimitador personalizado para permitir el uso de ";" dentro de la definición del procedimiento.
DELIMITER //

-- Procedimiento para insertar una nueva venta en la tabla Venta.
CREATE PROCEDURE InsertarVenta (
    IN pNumeroVenta INT,                    -- Número de venta.
    IN pDocumentoCliente INT,               -- Documento del cliente.
    IN pIdentificacionEmpleado INT,         -- Identificación del empleado.
    IN pFechaHora DATETIME,                 -- Fecha y hora de la venta.
    IN pMonto DECIMAL(10,2),                -- Monto de la venta.
    IN pEstado VARCHAR(100),                -- Estado de la venta.
    IN pObservaciones VARCHAR(255)          -- Observaciones de la venta.
)
BEGIN
    -- Inserta los valores proporcionados en la tabla Venta.
    INSERT INTO Venta (NumeroVenta, Documento, Identificacion, FechaHora, Monto, Estado, Observaciones)
    VALUES (pNumeroVenta, pDocumentoCliente, pIdentificacionEmpleado, pFechaHora, pMonto, pEstado, pObservaciones);
END //

-- Procedimiento para mostrar los detalles de una venta específica en la tabla Venta.
CREATE PROCEDURE MostrarVenta (
    IN pNumeroVenta INT    -- Número de venta a mostrar.
)
BEGIN
    -- Selecciona los detalles de la venta con el número de venta proporcionado.
    SELECT *
    FROM Venta
    WHERE NumeroVenta = pNumeroVenta;
END //

-- Procedimiento para mostrar todas las ventas en la tabla Venta.
CREATE PROCEDURE MostrarVentas ()
BEGIN
    -- Selecciona todas las ventas en la tabla Venta.
    SELECT *
    FROM Venta;
END //

-- Restaurar el delimitador por defecto ";".
DELIMITER ;

---------------------------------------------------------------COMPRA--------------------------------------------------------------

-- Establecer el delimitador personalizado para permitir el uso de ";" dentro de la definición del procedimiento.
DELIMITER //

-- Procedimiento para insertar una nueva compra en la tabla Compra.
CREATE PROCEDURE InsertarCompra (
    IN pNumeroCompra INT,                  -- Número de compra.
    IN pIdProveedor INT,                   -- ID del proveedor.
    IN pIdentificacionEmpleado INT,        -- Identificación del empleado.
    IN pFechaHora DATETIME,                -- Fecha y hora de la compra.
    IN pMonto DECIMAL(10,2),               -- Monto de la compra.
    IN pEstado VARCHAR(100),               -- Estado de la compra.
    IN pObservaciones VARCHAR(255)         -- Observaciones de la compra.
)
BEGIN
    -- Inserta los valores proporcionados en la tabla Compra.
    INSERT INTO Compra (NumeroCompra, IdProveedor, Identificacion, FechaHora, Monto, Estado, Observaciones)
    VALUES (pNumeroCompra, pIdProveedor, pIdentificacionEmpleado, pFechaHora, pMonto, pEstado, pObservaciones);
END //

-- Procedimiento para mostrar los detalles de una compra específica en la tabla Compra.
CREATE PROCEDURE MostrarCompra (
    IN pNumeroCompra INT    -- Número de compra a mostrar.
)
BEGIN
    -- Selecciona los detalles de la compra con el número de compra proporcionado.
    SELECT *
    FROM Compra
    WHERE NumeroCompra = pNumeroCompra;
END //

-- Procedimiento para mostrar todas las compras en la tabla Compra.
CREATE PROCEDURE MostrarCompras ()
BEGIN
    -- Selecciona todas las compras en la tabla Compra.
    SELECT *
    FROM Compra;
END //

-- Restaurar el delimitador por defecto ";".
DELIMITER ;

---------------------------------------------------------------INVENTARIO------------------------------------------------------------

-- Establecer el delimitador personalizado para permitir el uso de ";" dentro de la definición del procedimiento.
DELIMITER //

-- Procedimiento para insertar un nuevo producto en la tabla Inventario.
CREATE PROCEDURE InsertarProducto (
    IN pIdProducto INT,
    IN pIdCategoria VARCHAR(30),
    IN pNombre VARCHAR(100),
    IN pMarca VARCHAR(100),
    IN pUnidadMedida VARCHAR(30),
    IN pPrecioCompra DECIMAL(10,2),
    IN pPrecioVenta DECIMAL(10,2),
    IN pCantidad INT,
    IN pDescripcion VARCHAR(255)
)
BEGIN
    -- Inserta los valores proporcionados en la tabla Inventario.
    INSERT INTO Inventario (IdProducto, IdCategoria, Nombre, Marca, UnidadMedida, PrecioCompra, PrecioVenta, Cantidad, Descripcion)
    VALUES (pIdProducto, pIdCategoria, pNombre, pMarca, pUnidadMedida, pPrecioCompra, pPrecioVenta, pCantidad, pDescripcion);
END //

-- Procedimiento para editar un producto en la tabla Inventario.
CREATE PROCEDURE EditarProducto (
    IN pIdProducto INT,
    IN pIdCategoria VARCHAR(30),
    IN pNombre VARCHAR(100),
    IN pMarca VARCHAR(100),
    IN pUnidadMedida VARCHAR(30),
    IN pPrecioCompra DECIMAL(10,2),
    IN pPrecioVenta DECIMAL(10,2),
    IN pCantidad INT,
    IN pDescripcion VARCHAR(255)
)
BEGIN
    -- Actualiza los valores del producto con el ID proporcionado en la tabla Inventario.
    UPDATE Inventario
    SET IdCategoria = pIdCategoria,
        Nombre = pNombre,
        Marca = pMarca,
        UnidadMedida = pUnidadMedida,
        PrecioCompra = pPrecioCompra,
        PrecioVenta = pPrecioVenta,
        Cantidad = pCantidad,
        Descripcion = pDescripcion
    WHERE IdProducto = pIdProducto;
END //

-- Procedimiento para eliminar un producto de la tabla Inventario.
CREATE PROCEDURE EliminarProducto (
    IN pIdProducto INT
)
BEGIN
    -- Elimina el producto con el ID proporcionado de la tabla Inventario.
    DELETE FROM Inventario
    WHERE IdProducto = pIdProducto;
END //

-- Procedimiento para mostrar los detalles de un producto específico en la tabla Inventario.
CREATE PROCEDURE MostrarProducto (
    IN pIdProducto INT
)
BEGIN
    -- Selecciona los detalles del producto con el ID proporcionado.
    SELECT *
    FROM Inventario
    WHERE IdProducto = pIdProducto;
END //

-- Procedimiento para mostrar todos los productos en la tabla Inventario.
CREATE PROCEDURE MostrarProductos ()
BEGIN
    -- Selecciona todos los productos en la tabla Inventario.
    SELECT *
    FROM Inventario;
END //

-- Restaurar el delimitador por defecto ";".
DELIMITER ;
