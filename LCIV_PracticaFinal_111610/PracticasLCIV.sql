USE [master]
GO
/****** Object:  Database [PracticaLabIV]    Script Date: 13/11/2020 21:46:30 ******/
CREATE DATABASE [PracticaLabIV]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PracticaLabIV', FILENAME = N'D:\TUP\LCIV\DB\PracticaLabIV.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PracticaLabIV_log', FILENAME = N'D:\TUP\LCIV\DB\PracticaLabIV_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [PracticaLabIV] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PracticaLabIV].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PracticaLabIV] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PracticaLabIV] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PracticaLabIV] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PracticaLabIV] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PracticaLabIV] SET ARITHABORT OFF 
GO
ALTER DATABASE [PracticaLabIV] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PracticaLabIV] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PracticaLabIV] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PracticaLabIV] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PracticaLabIV] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PracticaLabIV] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PracticaLabIV] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PracticaLabIV] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PracticaLabIV] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PracticaLabIV] SET  DISABLE_BROKER 
GO
ALTER DATABASE [PracticaLabIV] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PracticaLabIV] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PracticaLabIV] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PracticaLabIV] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PracticaLabIV] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PracticaLabIV] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PracticaLabIV] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PracticaLabIV] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PracticaLabIV] SET  MULTI_USER 
GO
ALTER DATABASE [PracticaLabIV] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PracticaLabIV] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PracticaLabIV] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PracticaLabIV] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [PracticaLabIV] SET DELAYED_DURABILITY = DISABLED 
GO
USE [PracticaLabIV]
GO
/****** Object:  Table [dbo].[Aulas]    Script Date: 13/11/2020 21:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Aulas](
	[numero] [int] NOT NULL,
	[capacidad] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Aulas] PRIMARY KEY CLUSTERED 
(
	[numero] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Computadoras]    Script Date: 13/11/2020 21:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Computadoras](
	[nroComputadora] [int] IDENTITY(1,1) NOT NULL,
	[nroAula] [int] NOT NULL,
	[idEstado] [int] NOT NULL,
	[funcionamiento] [int] NOT NULL,
 CONSTRAINT [PK_Computadoras] PRIMARY KEY CLUSTERED 
(
	[nroComputadora] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Estados]    Script Date: 13/11/2020 21:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Estados](
	[idEstado] [int] NOT NULL,
	[descripcion] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Estados] PRIMARY KEY CLUSTERED 
(
	[idEstado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Ofertas]    Script Date: 13/11/2020 21:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Ofertas](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idProducto] [int] NOT NULL,
	[precioNormal] [real] NOT NULL,
	[precioOferta] [real] NOT NULL,
	[stockDisponible] [int] NOT NULL,
	[fechaInicioOferta] [char](10) NOT NULL,
	[diasVigencia] [tinyint] NOT NULL,
 CONSTRAINT [PK_Ofertas] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Productos]    Script Date: 13/11/2020 21:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Productos](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NOT NULL,
 CONSTRAINT [PK_Productos] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Aulas] ([numero], [capacidad]) VALUES (3, N'40 alumnos')
INSERT [dbo].[Aulas] ([numero], [capacidad]) VALUES (5, N'30 alumnos')
INSERT [dbo].[Aulas] ([numero], [capacidad]) VALUES (6, N'25 alumnos')
INSERT [dbo].[Aulas] ([numero], [capacidad]) VALUES (8, N'50 alumnos')
SET IDENTITY_INSERT [dbo].[Computadoras] ON 

INSERT [dbo].[Computadoras] ([nroComputadora], [nroAula], [idEstado], [funcionamiento]) VALUES (3, 5, 1, 75)
INSERT [dbo].[Computadoras] ([nroComputadora], [nroAula], [idEstado], [funcionamiento]) VALUES (4, 6, 2, 25)
INSERT [dbo].[Computadoras] ([nroComputadora], [nroAula], [idEstado], [funcionamiento]) VALUES (5, 5, 1, 90)
INSERT [dbo].[Computadoras] ([nroComputadora], [nroAula], [idEstado], [funcionamiento]) VALUES (6, 6, 1, 100)
INSERT [dbo].[Computadoras] ([nroComputadora], [nroAula], [idEstado], [funcionamiento]) VALUES (7, 5, 2, 35)
INSERT [dbo].[Computadoras] ([nroComputadora], [nroAula], [idEstado], [funcionamiento]) VALUES (8, 5, 0, 0)
INSERT [dbo].[Computadoras] ([nroComputadora], [nroAula], [idEstado], [funcionamiento]) VALUES (9, 8, 1, 65)
SET IDENTITY_INSERT [dbo].[Computadoras] OFF
INSERT [dbo].[Estados] ([idEstado], [descripcion]) VALUES (0, N'No Funcional')
INSERT [dbo].[Estados] ([idEstado], [descripcion]) VALUES (1, N'En Funcionamiento')
INSERT [dbo].[Estados] ([idEstado], [descripcion]) VALUES (2, N'En Espera de Revisión')
ALTER TABLE [dbo].[Computadoras]  WITH CHECK ADD  CONSTRAINT [FK_Computadoras_Aulas] FOREIGN KEY([nroAula])
REFERENCES [dbo].[Aulas] ([numero])
GO
ALTER TABLE [dbo].[Computadoras] CHECK CONSTRAINT [FK_Computadoras_Aulas]
GO
ALTER TABLE [dbo].[Computadoras]  WITH CHECK ADD  CONSTRAINT [FK_Computadoras_Estados] FOREIGN KEY([idEstado])
REFERENCES [dbo].[Estados] ([idEstado])
GO
ALTER TABLE [dbo].[Computadoras] CHECK CONSTRAINT [FK_Computadoras_Estados]
GO
ALTER TABLE [dbo].[Ofertas]  WITH CHECK ADD  CONSTRAINT [FK_Ofertas_Productos] FOREIGN KEY([idProducto])
REFERENCES [dbo].[Productos] ([id])
GO
ALTER TABLE [dbo].[Ofertas] CHECK CONSTRAINT [FK_Ofertas_Productos]
GO
ALTER TABLE [dbo].[Productos]  WITH CHECK ADD  CONSTRAINT [FK_Productos_Productos] FOREIGN KEY([id])
REFERENCES [dbo].[Productos] ([id])
GO
ALTER TABLE [dbo].[Productos] CHECK CONSTRAINT [FK_Productos_Productos]
GO
USE [master]
GO
ALTER DATABASE [PracticaLabIV] SET  READ_WRITE 
GO
