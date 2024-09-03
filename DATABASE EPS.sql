--------------------------------------------------------------
-- BASE DE DATOS EPS
--------------------------------------------------------------

CREATE DATABASE EPS
USE EPS

--------------------------------------------------------------
-- TABLA DE METODOS DE PAGO
--------------------------------------------------------------

CREATE TABLE MetodosPago (
  IdMetodoPago INT PRIMARY KEY AUTO_INCREMENT,
  Nombre VARCHAR(50) NOT NULL,
  Descripcion VARCHAR(200) NOT NULL,
  Estado VARCHAR(20) NOT NULL,
  Detalles VARCHAR(200)
);

--------------------------------------------------------------
-- TABLA DE EMPLEADOS (DOCTORES, ENFERMEROS, CAJEROS, ETC)
--------------------------------------------------------------

CREATE TABLE Empleado (
  DocumentoEmpleado INT PRIMARY KEY,
  Nombre VARCHAR(50) NOT NULL,
  Apellido VARCHAR(50) NOT NULL,
  TipoDocumento VARCHAR(20) NOT NULL,
  Genero VARCHAR(10) NOT NULL,
  FechaNacimiento DATE NOT NULL,
  Direccion VARCHAR(50) NOT NULL,
  Ciudad VARCHAR(20) NOT NULL,
  Telefono VARCHAR(15) NOT NULL,
  TelefonoEmergencia VARCHAR(15) NOT NULL,
  CorreoElectronico VARCHAR(50) NOT NULL,
  Cargo VARCHAR(30) NOT NULL,
  TipoContrato VARCHAR(20) NOT NULL,
  FechaContratacion DATE NOT NULL,
  FechaTerminacionContrato DATE,
  Salario VARCHAR(20) NOT NULL,
  Observaciones VARCHAR(200)
);

--------------------------------------------------------------
-- TABLA DE MEDICAMENTOS
--------------------------------------------------------------

CREATE TABLE Medicamento (
  IdMedicamento INT PRIMARY KEY AUTO_INCREMENT,
  CodigoMedicamento INT SECONDARY KEY,
  Nombre VARCHAR(50) NOT NULL,
  PrincipioActivo VARCHAR(40) NOT NULL,
  Concentracion VARCHAR(40) NOT NULL,
  Presentacion VARCHAR(40) NOT NULL,
  FormaFarmaceutica VARCHAR(40) NOT NULL,
  Laboratorio VARCHAR(40) NOT NULL,
  RegistroSanitario VARCHAR(40) NOT NULL,
  Lote VARCHAR(40) NOT NULL,
  PrecioUnitario FLOAT(20) NOT NULL,
  CantidadDisponible INT NOT NULL,
  CantidadMinima INT NOT NULL,
  FechaIngresa DATE NOT NULL,
  FechaVencimiento DATE NOT NULL,
  Indicaciones VARCHAR(100) NOT NULL,
  Contraindicaciones VARCHAR(100) NOT NULL,
  Precauciones VARCHAR(100) NOT NULL,
  EfectosSecundarios VARCHAR(100) NOT NULL,
  Proveedor VARCHAR(40) NOT NULL,
  Observaciones VARCHAR(200)
);

--------------------------------------------------------------
-- TABLA DE TRASLADOS
--------------------------------------------------------------

CREATE TABLE Traslado (
  IdTraslado INT PRIMARY KEY AUTO_INCREMENT,
  Fecha DATETIME NOT NULL,
  Tipo VARCHAR(50) NOT NULL,
  Responsable VARCHAR(50) NOT NULL,
  Motivo VARCHAR(200) NOT NULL,
  Estado VARCHAR(20) NOT NULL,
  CostoTraslado FLOAT(20) NOT NULL,
  Observaciones VARCHAR(200)
);

--------------------------------------------------------------
-- TABLA DE SALAS EN LA EPS
--------------------------------------------------------------

CREATE TABLE Sala (
  IdSala INT PRIMARY KEY AUTO_INCREMENT,
  Nombre VARCHAR(50) NOT NULL,
  Especialidad VARCHAR(100) NOT NULL,
  Sede VARCHAR(50) NOT NULL,
  Observaciones VARCHAR(200)
);

--------------------------------------------------------------
-- TABLA DE HORARIOS DISPONIBLES DE LA IPS
--------------------------------------------------------------

CREATE TABLE HorarioIPS (
  IdHorarioIPS INT PRIMARY KEY AUTO_INCREMENT,
  TipoDia VARCHAR(50) NOT NULL,
  HoraInicio TIME NOT NULL,
  HoraFin TIME NOT NULL,
  Observaciones VARCHAR(200)
);

--------------------------------------------------------------
-- TABLA DE METODOS DE PAGO
--------------------------------------------------------------

CREATE TABLE IPS (
  IdIPS INT PRIMARY KEY AUTO_INCREMENT,
  Nombre VARCHAR(100) NOT NULL,
  TipoServicio VARCHAR(100) NOT NULL,
  Direccion VARCHAR(100) NOT NULL,
  Ciudad VARCHAR(80) NOT NULL,
  Departamento VARCHAR(50) NOT NULL,
  Pais VARCHAR(80) NOT NULL,
  Telefono VARCHAR(15) NOT NULL,
  CorreoElectronico VARCHAR(255) NOT NULL,
  Observaciones VARCHAR(200)
);

--------------------------------------------------------------
-- TABLA DE AFILIADOS
--------------------------------------------------------------

CREATE TABLE Afiliado (
  DocumentoAfiliado INT PRIMARY KEY,
  Nombre VARCHAR(50) NOT NULL,
  Apellido VARCHAR(50) NOT NULL,
  GrupoSanguineo VARCHAR(50) NOT NULL,
  TipoDocumento VARCHAR(20) NOT NULL,
  Genero VARCHAR(10) NOT NULL,
  FechaNacimiento DATE NOT NULL,
  Direccion VARCHAR(50) NOT NULL,
  Ciudad VARCHAR(20) NOT NULL,
  Telefono VARCHAR(15) NOT NULL,
  TelefonoEmergencia VARCHAR(15) NOT NULL,
  CorreoElectronico VARCHAR(255) NOT NULL,
  TipoAfiliado VARCHAR(30) NOT NULL,
  FechaAfiliacion DATE NOT NULL,
  FechaDesafiliacion DATE,
  Observaciones VARCHAR(200)
);

--------------------------------------------------------------
-- TABLA DE INFORMACION DE CITAS 
--------------------------------------------------------------

CREATE TABLE Cita (
  IdCita INT PRIMARY KEY AUTO_INCREMENT,
  IdAfiliado INT,
  IdIPS INT,
  IdDiagnostico INT,
  Fecha DATETIME NOT NULL,
  Estado VARCHAR(20) NOT NULL,
  Motivo VARCHAR(200) NOT NULL,
  Sede VARCHAR(100) NOT NULL,
  Observaciones VARCHAR(200),

  FOREIGN KEY (IdAfiliado) REFERENCES Afiliado(IdAfiliado),
  FOREIGN KEY (IdIPS) REFERENCES IPS(IdIPS),
  FOREIGN KEY (IdDiagnostico) REFERENCES Diagnostico(IdDiagnostico)
);

--------------------------------------------------------------
-- TABLA DE INFORMACION DE LOS EXAMENES
--------------------------------------------------------------

CREATE TABLE Examen (
  IdExamen INT PRIMARY KEY AUTO_INCREMENT,
  IdDiagnostico INT,
  Nombre VARCHAR(50) NOT NULL,
  ResultadoExamen VARCHAR(200) NOT NULL,
  Descripcion VARCHAR(200) NOT NULL,
  Fecha DATETIME NOT NULL,
  Estado VARCHAR(20) NOT NULL,
  Observaciones VARCHAR(200),
  
  FOREIGN KEY (IdDiagnostico) REFERENCES Diagnostico(IdDiagnostico)
);

--------------------------------------------------------------
-- TABLA DE INFORMACION DE LOS DIAGNOSTICOS
--------------------------------------------------------------

CREATE TABLE Diagnostico (
  IdDiagnostico INT PRIMARY KEY AUTO_INCREMENT,
  IdAfiliado INT,
  IdIPS INT,
  NombreDiagnostico VARCHAR(50) NOT NULL,
  Codigo INT NOT NULL,
  Fecha DATE NOT NULL,
  Descripcion VARCHAR(200) NOT NULL,
  Observaciones VARCHAR(200),
  
  FOREIGN KEY (IdAfiliado) REFERENCES Afiliado(IdAfiliado),
  FOREIGN KEY (IdIPS) REFERENCES IPS(IdIPS)
);

--------------------------------------------------------------
-- TABLA DE URGENCIAS
--------------------------------------------------------------

CREATE TABLE Urgencia (
  IdUrgencia INT PRIMARY KEY AUTO_INCREMENT,
  IdAfiliado INT,
  IdIPS INT,
  IdDiagnostico INT,
  Fecha DATETIME NOT NULL,
  Estado VARCHAR(20) NOT NULL,
  Motivo VARCHAR(200) NOT NULL,
  Sede VARCHAR(100) NOT NULL,
  Observaciones VARCHAR(200),

  FOREIGN KEY (IdAfiliado) REFERENCES Afiliado(IdAfiliado),
  FOREIGN KEY (IdIPS) REFERENCES IPS(IdIPS),
  FOREIGN KEY (IdDiagnostico) REFERENCES Diagnostico(IdDiagnostico)
);

--------------------------------------------------------------
-- TABLA DE INFORMACION DEL PAGO
--------------------------------------------------------------

CREATE TABLE Pago (
  IdPago INT PRIMARY KEY AUTO_INCREMENT,
  IdAfiliado INT,
  IdIPS INT,
  Fecha DATE NOT NULL,
  Monto DECIMAL(10,2), 
  Estado VARCHAR(20) NOT NULL,
  Concepto VARCHAR(50) NOT NULL,  
  Observaciones VARCHAR(200),
  
  FOREIGN KEY (IdAfiliado) REFERENCES Afiliado(IdAfiliado),
  FOREIGN KEY (IdIPS) REFERENCES IPS(IdIPS)
);

--------------------------------------------------------------
-- TABLA DE HISTORIA CLINICA DE CADA AFILIADO
--------------------------------------------------------------

CREATE TABLE HistoriaClinica (
  IdHistoriaClinica INT PRIMARY KEY AUTO_INCREMENT,
  IdAfiliado INT,
  IdDiagnostico INT,
  IdExamen INT,
  IdCita INT,
  IdUrgencia INT,
  Alergias VARCHAR(255),
  NotasMedicas VARCHAR(255),
  FechaFallecimiento DATE,
  CausaFallecimiento VARCHAR(100),
  Observaciones VARCHAR(255),

  FOREIGN KEY (IdAfiliado) REFERENCES Afiliado(IdAfiliado),
  FOREIGN KEY (IdDiagnostico) REFERENCES Diagnostico(IdDiagnostico),
  FOREIGN KEY (IdExamen) REFERENCES Examen(IdExamen),
  FOREIGN KEY (IdCita) REFERENCES Cita(IdCita),
  FOREIGN KEY (IdUrgencia) REFERENCES Urgencia(IdUrgencia)
);



--------------------------------------------------------------
-- TABLAS DEBILES O INTERMEDIAS
--------------------------------------------------------------



--------------------------------------------------------------
-- TABLA INTERMEDIA PAGO - METODO DE PAGO
--------------------------------------------------------------

CREATE TABLE DetallePago (
  IdDetallePago INT PRIMARY KEY AUTO_INCREMENT,
  IdPago INT,
  IdMetodoPago INT,

  FOREIGN KEY (IdPago) REFERENCES Pago(IdPago),
  FOREIGN KEY (IdMetodoPago) REFERENCES MetodoPago(IdMetodoPago)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA IPS - HORARIO IPS
--------------------------------------------------------------

CREATE TABLE DetalleHorario (
  IdDetalleHorario INT PRIMARY KEY AUTO_INCREMENT,
  IdIPS INT,
  IdHorarioIPS INT,

  FOREIGN KEY (IdIPS) REFERENCES IPS(IdIPS),
  FOREIGN KEY (IdHorarioIPS) REFERENCES HorarioIPS(IdHorarioIPS)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA HISTORIA CLINICA - MEDICAMENTO
--------------------------------------------------------------

CREATE TABLE HistoriaMedica (
  IdHistoriaMedica INT PRIMARY KEY AUTO_INCREMENT,
  IdHistoriaClinica INT,
  IdMedicamento INT,

  FOREIGN KEY (IdHistoriaClinica) REFERENCES HistoriaClinica(IdHistoriaClinica),
  FOREIGN KEY (IdMedicamento) REFERENCES Medicamento(IdMedicamento)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA HISTORIA CLINICA - EMPLEADO
--------------------------------------------------------------

CREATE TABLE HistoriaClinicaEmpleado (
  IdHistoriaClinicaEmpleado INT PRIMARY KEY AUTO_INCREMENT,
  IdHistoriaClinica INT,
  DocumentoEmpleado INT,

  FOREIGN KEY (IdHistoriaClinica) REFERENCES HistoriaClinica(IdHistoriaClinica),
  FOREIGN KEY (DocumentoEmpleado) REFERENCES Empleado(DocumentoEmpleado)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA EMPLEADO - CITA
--------------------------------------------------------------

CREATE TABLE AsignacionCita (
  IdAsignacionCita INT PRIMARY KEY AUTO_INCREMENT,
  DocumentoEmpleado INT,
  IdCita INT,

  FOREIGN KEY (DocumentoEmpleado) REFERENCES Empleado(DocumentoEmpleado),
  FOREIGN KEY (IdCita) REFERENCES Cita(IdCita)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA EMPLEADO - DIAGNOSTICO
--------------------------------------------------------------

CREATE TABLE TomaDiagnostico (
  IdTomaDiagnostico INT PRIMARY KEY AUTO_INCREMENT,
  DocumentoEmpleado INT,
  IdDiagnostico INT,

  FOREIGN KEY (DocumentoEmpleado) REFERENCES Empleado(DocumentoEmpleado),
  FOREIGN KEY (IdDiagnostico) REFERENCES Diagnostico(IdDiagnostico)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA EMPLEADO - URGENCIA
--------------------------------------------------------------

CREATE TABLE AsistenciaUrgencia (
  IdAsistenciaUrgencia INT PRIMARY KEY AUTO_INCREMENT,
  DocumentoEmpleado INT,
  IdUrgencia INT,

  FOREIGN KEY (DocumentoEmpleado) REFERENCES Empleado(DocumentoEmpleado),
  FOREIGN KEY (IdUrgencia) REFERENCES Urgencia(IdUrgencia)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA EMPLEADO - EXAMEN
--------------------------------------------------------------

CREATE TABLE TomaExamen (
  IdTomaExamen INT PRIMARY KEY AUTO_INCREMENT,
  DocumentoEmpleado INT,
  IdExamen INT,

  FOREIGN KEY (DocumentoEmpleado) REFERENCES Empleado(DocumentoEmpleado),
  FOREIGN KEY (IdExamen) REFERENCES Examen(IdExamen)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA EXAMEN - SALA
--------------------------------------------------------------

CREATE TABLE SalaExamen (
  IdSalaExamen INT PRIMARY KEY AUTO_INCREMENT,
  IdExamen INT,
  IdSala INT,

  FOREIGN KEY (IdExamen) REFERENCES Examen(IdExamen),
  FOREIGN KEY (IdSala) REFERENCES Sala(IdSala)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA  CITA - SALA
--------------------------------------------------------------

CREATE TABLE SalaCita (
  IdSalaCita INT PRIMARY KEY AUTO_INCREMENT,
  IdCita INT,
  IdSala INT,

  FOREIGN KEY (IdCita) REFERENCES Cita(IdCita),
  FOREIGN KEY (IdSala) REFERENCES Sala(IdSala)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA EMPLEADO - PAGO
--------------------------------------------------------------

CREATE TABLE RegistroPago (
  IdRegistroPago INT PRIMARY KEY AUTO_INCREMENT,
  DocumentoEmpleado INT,
  IdPago INT,

  FOREIGN KEY (DocumentoEmpleado) REFERENCES Empleado(DocumentoEmpleado),
  FOREIGN KEY (IdPago) REFERENCES Pago(IdPago)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA TRASLADO - AFILIADO
--------------------------------------------------------------

CREATE TABLE TrasladoAfiliado (
  IdTrasladoAfiliado INT PRIMARY KEY AUTO_INCREMENT,
  IdTraslado INT,
  DocumentoAfiliado INT,

  FOREIGN KEY (IdTraslado) REFERENCES Traslado(IdTraslado),
  FOREIGN KEY (DocumentoAfiliado) REFERENCES Afiliado(DocumentoAfiliado)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA TRASLADO - IPS (ORIGEN Y DESTINO)
--------------------------------------------------------------

CREATE TABLE TrasladoIPS (
  IdTrasladoIPS INT PRIMARY KEY AUTO_INCREMENT,
  IdTraslado INT,
  IdIPSOrigen INT,
  IdOIPSDestino INT,

  FOREIGN KEY (IdTraslado) REFERENCES Traslado(IdTraslado),
  FOREIGN KEY (IdIPSOrigen) REFERENCES IPS(IdIPS),
  FOREIGN KEY (IdIPSDestino) REFERENCES IPS(IdIPS)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA EXAMEN - AFILIADO
--------------------------------------------------------------

CREATE TABLE ExamenAfiliado (
  IdExamenAfiliado INT PRIMARY KEY AUTO_INCREMENT,
  IdExamen INT,
  DocumentoAfiliado INT,

  FOREIGN KEY (IdExamen) REFERENCES Examen(IdExamen),
  FOREIGN KEY (DocumentoAfiliado) REFERENCES Afiliado(DocumentoAfiliado)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA MEDICAMENTO - AFILIADO
--------------------------------------------------------------

CREATE TABLE AsignacionMedicamento (
  IdAsignacionMedicamento INT PRIMARY KEY AUTO_INCREMENT,
  IdMedicamento INT,
  DocumentoAfiliado INT,

  FOREIGN KEY (IdMedicamento) REFERENCES Medicamento(IdMedicamento),
  FOREIGN KEY (DocumentoAfiliado) REFERENCES Afiliado(DocumentoAfiliado)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA MEDICAMENTO - CITA
--------------------------------------------------------------

CREATE TABLE MedicamentoCita (
  IdMedicamentoCita INT PRIMARY KEY AUTO_INCREMENT,
  IdMedicamento INT,
  IdCita INT,

  FOREIGN KEY (IdMedicamento) REFERENCES Medicamento(IdMedicamento),
  FOREIGN KEY (IdCita) REFERENCES Cita(IdCita)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA MEDICAMENTO - URGENCIA
--------------------------------------------------------------

CREATE TABLE MedicamentoUrgencia (
  IdMedicamentoUrgencia INT PRIMARY KEY AUTO_INCREMENT,
  IdMedicamento INT,
  IdUrgencia INT,

  FOREIGN KEY (IdMedicamento) REFERENCES Medicamento(IdMedicamento),
  FOREIGN KEY (IdUrgencia) REFERENCES Urgencia(IdUrgencia)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA EXAMEN - MEDICAMENTO
--------------------------------------------------------------

CREATE TABLE MedicamentoExamen (
  IdMedicamentoExamen INT PRIMARY KEY AUTO_INCREMENT,
  IdMedicamento INT,
  IdExamen INT,

  FOREIGN KEY (IdExamen) REFERENCES Examen(IdExamen),
  FOREIGN KEY (IdMedicamento) REFERENCES Medicamento(IdMedicamento)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA EXAMEN - IPS
--------------------------------------------------------------

CREATE TABLE ExamenIPS (
  IdExamenIPS INT PRIMARY KEY AUTO_INCREMENT,
  IdExamen INT,
  IdIPS INT,

  FOREIGN KEY (IdExamen) REFERENCES Examen(IdExamen),
  FOREIGN KEY (IdIPS) REFERENCES IPS(IdIPS)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA SALA - URGENCIA
--------------------------------------------------------------

CREATE TABLE SalaUrgencia (
  IdSalaUrgencia INT PRIMARY KEY AUTO_INCREMENT,
  IdSala INT,
  IdUrgencia INT,

  FOREIGN KEY (IdSala) REFERENCES Sala(IdSala),
  FOREIGN KEY (IdUrgencia) REFERENCES Urgencia(IdUrgencia)
);

--------------------------------------------------------------
-- TABLA INTERMEDIA TRASLADO - EMPLEADO
--------------------------------------------------------------

CREATE TABLE EmpleadoTraslado (
  IdEmpleadoTraslado INT PRIMARY KEY AUTO_INCREMENT,
  IdTraslado INT,
  DocumentoEmpleado INT,

  FOREIGN KEY (IdTraslado) REFERENCES Traslado(IdTraslado),
  FOREIGN KEY (DocumentoEmpleado) REFERENCES Empleado(DocumentoEmpleado)
);