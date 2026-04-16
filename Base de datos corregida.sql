drop database if exists DBProyecto1_IN5CM;
create database DBProyecto1_IN5CM;
use DBProyecto1_IN5CM;

create table Clientes(
	dpi_cliente int primary key not null auto_increment,
    nombre_cliente varchar (50) not null,
    apellido_cliente varchar (50) not null,
    direccion varchar (100) not null,
    estado int not null
);

create table Usuarios(
	codigo_usuario int primary key not null auto_increment,
    username varchar (45) not null,
    password varchar (45) not null,
    email varchar (50) not null,
	rol varchar (45) not null,
    estado int not null
);

create table Productos(
	codigo_producto int primary key not null auto_increment,
    nombre_producto varchar (60) not null, 
    precio decimal (10,2) not null,
    stok int not null,
    estado int not null
);


create table Venta (
	codigo_venta int primary key not null auto_increment,
    fecha_venta date not null,
	total decimal (10,2) not null,
    estado int not null,
    dpi_cliente int,
    codigo_usuario int,
    
	constraint dpi_cliente foreign key (dpi_cliente)
	references Clientes (dpi_cliente) on delete cascade,

	constraint codigo_usuario foreign key (codigo_usuario)
	references Usuarios (codigo_usuario) on delete cascade
);

create table Detalle_Venta(
	codigo_detalle_venta int primary key not null,
    cantidad int not null,
    precio_unitario decimal (10,2) not null,
    subtotal decimal (10,2) not null,
    codigo_producto int,
    codigo_venta int,
    
    constraint codigo_producto foreign key (codigo_producto)
    references Productos (codigo_producto) on delete cascade,
    
	constraint codigo_venta foreign key (codigo_venta)
    references Venta (codigo_venta) on delete cascade
);

-- === Procedimiento de almacenado de cliente ===
delimiter $$

create procedure sp_insert_cliente(
    in p_nombre varchar(50),
    in p_apellido varchar(50),
    in p_direccion varchar(100),
    in p_estado int
)
begin
    insert into Clientes(nombre_cliente, apellido_cliente, direccion, estado)
    values (p_nombre, p_apellido, p_direccion, p_estado);
end $$

create procedure sp_listar_clientes()
begin
    select * from Clientes;
end $$

create procedure sp_obtener_cliente(
    in p_dpi int
)
begin
    select * from Clientes
    where dpi_cliente = p_dpi;
end $$

create procedure sp_actualizar_cliente(
    in p_dpi int,
    in p_nombre varchar(50),
    in p_apellido varchar(50),
    in p_direccion varchar(100),
    in p_estado int
)
begin
    update Clientes
    set nombre_cliente = p_nombre,
        apellido_cliente = p_apellido,
        direccion = p_direccion,
        estado = p_estado
    where dpi_cliente = p_dpi;
end $$

create procedure sp_eliminar_cliente(
    in p_dpi int
)
begin
    delete from Clientes
    where dpi_cliente = p_dpi;
end $$

-- ===========================================

-- === Procedimiento de almacenado de Usuario ===
create procedure sp_insert_usuario(
    in p_codigo int,
    in p_username varchar(45),
    in p_password varchar(45),
    in p_email varchar(50),
    in p_rol varchar(45),
    in p_estado int
)
begin
    insert into Usuarios
    values (p_codigo, p_username, p_password, p_email, p_rol, p_estado);
end $$

create procedure sp_listar_usuarios()
begin
    select * from Usuarios;
end $$

create procedure sp_obtener_usuario(
    in p_codigo int
)
begin
    select * from Usuarios
    where codigo_usuario = p_codigo;
end $$

create procedure sp_actualizar_usuario(
    in p_codigo int,
    in p_username varchar(45),
    in p_password varchar(45),
    in p_email varchar(50),
    in p_rol varchar(45),
    in p_estado int
)
begin
    update Usuarios
    set username = p_username,
        pasword = p_password,
        email = p_email,
        rol = p_rol,
        estado = p_estado
    where codigo_usuario = p_codigo;
end $$

create procedure sp_eliminar_usuario(
    in p_codigo int
)
begin
    delete from Usuarios
    where codigo_usuario = p_codigo;
end $$

-- ============================================================

-- === Procedimiento de almacenado de productos ===
create procedure sp_insert_producto(
    in p_codigo int,
    in p_nombre varchar(60),
    in p_precio decimal(10,2),
    in p_stock int,
    in p_estado int
)
begin
    insert into Productos
    values (p_codigo, p_nombre, p_precio, p_stock, p_estado);
end $$

create procedure sp_listar_productos()
begin
    select * from Productos;
end $$

create procedure sp_obtener_producto(
    in p_codigo int
)
begin
    select * from Productos
    where codigo_producto = p_codigo;
end $$

create procedure sp_actualizar_producto(
    in p_codigo int,
    in p_nombre varchar(60),
    in p_precio decimal(10,2),
    in p_stock int,
    in p_estado int
)
begin
    update Productos
    set nombre_producto = p_nombre,
        precio = p_precio,
        stok = p_stock,
        estado = p_estado
    where codigo_producto = p_codigo;
end $$

create procedure sp_eliminar_producto(
    in p_codigo int
)
begin
    delete from Productos
    where codigo_producto = p_codigo;
end $$
-- =======================================================

-- === Procedimiento de almacenado de venta ===
create procedure sp_insert_venta(
    in p_codigo int,
    in p_fecha date,
    in p_total decimal(10,2),
    in p_estado int,
    in p_dpi int,
    in p_usuario int
)
begin
    insert into Venta
    values (p_codigo, p_fecha, p_total, p_estado, p_dpi, p_usuario);
end $$

create procedure sp_listar_ventas()
begin
    select * from Venta;
end $$

create procedure sp_obtener_venta(
    in p_codigo int
)
begin
    select * from Venta
    where codigo_venta = p_codigo;
end $$

create procedure sp_actualizar_venta(
    in p_codigo int,
    in p_fecha date,
    in p_total decimal(10,2),
    in p_estado int,
    in p_dpi int,
    in p_usuario int
)
begin
    update Venta
    set fecha_venta = p_fecha,
        total = p_total,
        estado = p_estado,
        dpi_cliente = p_dpi,
        codigo_usuario = p_usuario
    where codigo_venta = p_codigo;
end $$

create procedure sp_eliminar_venta(
    in p_codigo int
)
begin
    delete from Venta
    where codigo_venta = p_codigo;
end $$
-- ====================================================

-- === Procedimiento de almacenado de detalle de venta ===
create procedure sp_insert_detalle(
    in p_codigo int,
    in p_cantidad int,
    in p_precio decimal(10,2),
    in p_subtotal decimal(10,2),
    in p_producto int,
    in p_venta int
)
begin
    insert into Detalle_Venta
    values (p_codigo, p_cantidad, p_precio, p_subtotal, p_producto, p_venta);
end $$

create procedure sp_listar_detalle()
begin
    select * from Detalle_Venta;
end $$

create procedure sp_obtener_detalle(
    in p_codigo int
)
begin
    select * from Detalle_Venta
    where codigo_detalle_venta = p_codigo;
end $$

create procedure sp_actualizar_detalle(
    in p_codigo int,
    in p_cantidad int,
    in p_precio decimal(10,2),
    in p_subtotal decimal(10,2),
    in p_producto int,
    in p_venta int
)
begin
    update Detalle_Venta
    set cantidad = p_cantidad,
        precio_unitario = p_precio,
        subtotal = p_subtotal,
        codigo_producto = p_producto,
        codigo_venta = p_venta
    where codigo_detalle_venta = p_codigo;
end $$

create procedure sp_eliminar_detalle(
    in p_codigo int
)
begin
    delete from Detalle_Venta
    where codigo_detalle_venta = p_codigo;
end $$

delimiter ;
-- =================================================================

-- === Datos de la base de datos ===
-- === Clientes ===
CALL sp_insert_cliente('Juan', 'Pérez', 'Zona 1', 1);
CALL sp_insert_cliente('María', 'López', 'Zona 5', 1);
CALL sp_insert_cliente('Carlos', 'Gómez', 'Zona 10', 1);
CALL sp_insert_cliente('Ana', 'Martínez', 'Zona 7', 1);
CALL sp_insert_cliente('Luis', 'Hernández', 'Zona 3', 1);
CALL sp_insert_cliente('Sofía', 'Ramírez', 'Zona 12', 1);
CALL sp_insert_cliente('Pedro', 'Castillo', 'Zona 18', 1);
CALL sp_insert_cliente('Lucía', 'Morales', 'Zona 2', 1);
CALL sp_insert_cliente('Diego', 'Ortega', 'Zona 6', 1);
CALL sp_insert_cliente('Elena', 'Ruiz', 'Zona 9', 1);

-- === Usuarios ===
CALL sp_insert_usuario(1, 'admin', '1234', 'admin@mail.com', 'Administrador', 1);
CALL sp_insert_usuario(2, 'user1', '1234', 'user1@mail.com', 'Empleado', 1);
CALL sp_insert_usuario(3, 'user2', '1234', 'user2@mail.com', 'Empleado', 1);
CALL sp_insert_usuario(4, 'caja1', '1234', 'caja1@mail.com', 'Cajero', 1);
CALL sp_insert_usuario(5, 'caja2', '1234', 'caja2@mail.com', 'Cajero', 1);
CALL sp_insert_usuario(6, 'super1', '1234', 'super1@mail.com', 'Supervisor', 1);
CALL sp_insert_usuario(7, 'super2', '1234', 'super2@mail.com', 'Supervisor', 1);
CALL sp_insert_usuario(8, 'ventas1', '1234', 'ventas1@mail.com', 'Ventas', 1);
CALL sp_insert_usuario(9, 'ventas2', '1234', 'ventas2@mail.com', 'Ventas', 1);
CALL sp_insert_usuario(10, 'soporte', '1234', 'soporte@mail.com', 'Soporte', 1);

-- === Productos ===
CALL sp_insert_producto(1, 'Laptop HP', 5500.00, 10, 1);
CALL sp_insert_producto(2, 'Mouse Logitech', 150.00, 50, 1);
CALL sp_insert_producto(3, 'Teclado Mecánico', 350.00, 30, 1);
CALL sp_insert_producto(4, 'Monitor 24"', 1200.00, 20, 1);
CALL sp_insert_producto(5, 'USB 64GB', 80.00, 100, 1);
CALL sp_insert_producto(6, 'Disco Duro 1TB', 500.00, 15, 1);
CALL sp_insert_producto(7, 'Audífonos', 200.00, 40, 1);
CALL sp_insert_producto(8, 'Webcam HD', 300.00, 25, 1);
CALL sp_insert_producto(9, 'Silla Gamer', 900.00, 8, 1);
CALL sp_insert_producto(10, 'Impresora', 700.00, 12, 1);

-- === Ventas ===
CALL sp_insert_venta(1, '2026-03-01', 5650.00, 1, 1, 1);
CALL sp_insert_venta(2, '2026-03-02', 300.00, 1, 2, 2);
CALL sp_insert_venta(3, '2026-03-03', 850.00, 1, 3, 3);
CALL sp_insert_venta(4, '2026-03-04', 1200.00, 1, 4, 4);
CALL sp_insert_venta(5, '2026-03-05', 150.00, 1, 5, 5);
CALL sp_insert_venta(6, '2026-03-06', 700.00, 1, 6, 6);
CALL sp_insert_venta(7, '2026-03-07', 200.00, 1, 7, 7);
CALL sp_insert_venta(8, '2026-03-08', 300.00, 1, 8, 8);
CALL sp_insert_venta(9, '2026-03-09', 900.00, 1, 9, 9);
CALL sp_insert_venta(10, '2026-03-10', 80.00, 1, 10, 10);

-- === Detalle venta ===
CALL sp_insert_detalle(1, 1, 5500.00, 5500.00, 1, 1);
CALL sp_insert_detalle(2, 1, 150.00, 150.00, 2, 1);
CALL sp_insert_detalle(3, 2, 150.00, 300.00, 2, 2);
CALL sp_insert_detalle(4, 1, 350.00, 350.00, 3, 3);
CALL sp_insert_detalle(5, 1, 500.00, 500.00, 6, 3);
CALL sp_insert_detalle(6, 1, 1200.00, 1200.00, 4, 4);
CALL sp_insert_detalle(7, 1, 150.00, 150.00, 2, 5);
CALL sp_insert_detalle(8, 1, 700.00, 700.00, 10, 6);
CALL sp_insert_detalle(9, 1, 200.00, 200.00, 7, 7);
CALL sp_insert_detalle(10, 1, 80.00, 80.00, 5, 10);

-- ==== consultas ===

select * from Usuarios;
select * from Venta;