USE [master]
GO
/****** Object:  Database [Project_Database]    Script Date: 6/8/2022 8:46:51 AM ******/
CREATE DATABASE [Project_Database]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Project_Database', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Project_Database.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Project_Database_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Project_Database_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Project_Database] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Project_Database].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Project_Database] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Project_Database] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Project_Database] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Project_Database] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Project_Database] SET ARITHABORT OFF 
GO
ALTER DATABASE [Project_Database] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Project_Database] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Project_Database] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Project_Database] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Project_Database] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Project_Database] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Project_Database] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Project_Database] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Project_Database] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Project_Database] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Project_Database] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Project_Database] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Project_Database] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Project_Database] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Project_Database] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Project_Database] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Project_Database] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Project_Database] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Project_Database] SET  MULTI_USER 
GO
ALTER DATABASE [Project_Database] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Project_Database] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Project_Database] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Project_Database] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Project_Database] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Project_Database] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Project_Database] SET QUERY_STORE = OFF
GO
USE [Project_Database]
GO
/****** Object:  Table [dbo].[Admin_Info]    Script Date: 6/8/2022 8:46:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin_Info](
	[Admin_ID] [int] NOT NULL,
	[Admin_First_Name] [nvarchar](1000) NOT NULL,
	[Admin_Last_Name] [nvarchar](1000) NOT NULL,
	[Admin_Phone_Number] [nvarchar](1000) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Construction_Properties]    Script Date: 6/8/2022 8:46:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Construction_Properties](
	[Material_ID] [int] NOT NULL,
	[Field_ID] [int] NOT NULL,
	[Materials_Count] [int] NOT NULL,
	[Number_Of_Builders] [int] NOT NULL,
 CONSTRAINT [PK_Construction_Properties] PRIMARY KEY CLUSTERED 
(
	[Material_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Field_Info]    Script Date: 6/8/2022 8:46:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Field_Info](
	[Field_ID] [int] NOT NULL,
	[Field_Type] [nvarchar](1000) NOT NULL,
	[Field_Size] [int] NOT NULL,
	[Sports_Location] [nvarchar](1000) NOT NULL,
	[Field_Support] [tinyint] NULL,
 CONSTRAINT [PK_Field_Info] PRIMARY KEY CLUSTERED 
(
	[Field_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Registration]    Script Date: 6/8/2022 8:46:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Registration](
	[Registration_ID] [int] NOT NULL,
 CONSTRAINT [PK_Registration] PRIMARY KEY CLUSTERED 
(
	[Registration_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Store_Products]    Script Date: 6/8/2022 8:46:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Store_Products](
	[Product_ID] [int] NOT NULL,
	[Delivery_ID] [int] NOT NULL,
	[Material_ID] [int] NOT NULL,
	[Product_Type] [nvarchar](1000) NOT NULL,
	[Product_Price] [float] NOT NULL,
	[Product_Quantity] [int] NULL,
 CONSTRAINT [PK_Store_Products] PRIMARY KEY CLUSTERED 
(
	[Product_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User_Delivery]    Script Date: 6/8/2022 8:46:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User_Delivery](
	[Delivery_ID] [int] NOT NULL,
	[User_ID] [int] NOT NULL,
	[Payment_ID] [int] NOT NULL,
	[Arrival_Date] [datetime] NULL,
	[Delivery_Status] [nvarchar](1000) NULL,
	[Departure_Date] [datetime] NULL,
	[Delivery_Address] [nvarchar](1000) NOT NULL,
 CONSTRAINT [PK_User_Delivery] PRIMARY KEY CLUSTERED 
(
	[Delivery_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User_Info]    Script Date: 6/8/2022 8:46:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User_Info](
	[User_ID] [int] NOT NULL,
	[Registration_ID] [int] NOT NULL,
	[User_Email] [nvarchar](1000) NOT NULL,
	[User_Password] [nvarchar](1000) NOT NULL,
	[First_Name] [nvarchar](1000) NOT NULL,
	[Last_Name] [nvarchar](1000) NOT NULL,
	[Phone_Number] [nvarchar](1000) NULL,
 CONSTRAINT [PK_User_Info] PRIMARY KEY CLUSTERED 
(
	[User_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User_Payment]    Script Date: 6/8/2022 8:46:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User_Payment](
	[Payment_ID] [int] NOT NULL,
	[Payment_Date] [datetime] NOT NULL,
	[Payment_Type] [nvarchar](1000) NOT NULL,
	[Payment_Costs] [float] NOT NULL,
 CONSTRAINT [PK_User_Payment] PRIMARY KEY CLUSTERED 
(
	[Payment_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Admin_Info] ([Admin_ID], [Admin_First_Name], [Admin_Last_Name], [Admin_Phone_Number]) VALUES (1, N'Kris', N'Stoyanov', NULL)
GO
INSERT [dbo].[Admin_Info] ([Admin_ID], [Admin_First_Name], [Admin_Last_Name], [Admin_Phone_Number]) VALUES (2, N'Mocart', N'Ivanov', N'087-353-4355')
GO
INSERT [dbo].[Admin_Info] ([Admin_ID], [Admin_First_Name], [Admin_Last_Name], [Admin_Phone_Number]) VALUES (3, N'Stoyan', N'Traqnov', N'085-324-1324')
GO
INSERT [dbo].[Admin_Info] ([Admin_ID], [Admin_First_Name], [Admin_Last_Name], [Admin_Phone_Number]) VALUES (4, N'Alexandra', N'Ivanova', N'089-213-5321')
GO
INSERT [dbo].[Admin_Info] ([Admin_ID], [Admin_First_Name], [Admin_Last_Name], [Admin_Phone_Number]) VALUES (5, N'Petur', N'Stoyanov', NULL)
GO
INSERT [dbo].[Admin_Info] ([Admin_ID], [Admin_First_Name], [Admin_Last_Name], [Admin_Phone_Number]) VALUES (6, N'Iliqn', N'Qnakiev', N'087-214-9758')
GO
INSERT [dbo].[Admin_Info] ([Admin_ID], [Admin_First_Name], [Admin_Last_Name], [Admin_Phone_Number]) VALUES (7, N'Kaloqn', N'Dimitrov', NULL)
GO
INSERT [dbo].[Admin_Info] ([Admin_ID], [Admin_First_Name], [Admin_Last_Name], [Admin_Phone_Number]) VALUES (8, N'Mariq', N'Georgieva', NULL)
GO
INSERT [dbo].[Admin_Info] ([Admin_ID], [Admin_First_Name], [Admin_Last_Name], [Admin_Phone_Number]) VALUES (9, N'Boyan', N'Ralev', N'087-340-2349')
GO
INSERT [dbo].[Admin_Info] ([Admin_ID], [Admin_First_Name], [Admin_Last_Name], [Admin_Phone_Number]) VALUES (10, N'Ivana', N'Pehlivanova', NULL)
GO
INSERT [dbo].[Construction_Properties] ([Material_ID], [Field_ID], [Materials_Count], [Number_Of_Builders]) VALUES (1, 1, 4, 3)
GO
INSERT [dbo].[Construction_Properties] ([Material_ID], [Field_ID], [Materials_Count], [Number_Of_Builders]) VALUES (2, 2, 7, 12)
GO
INSERT [dbo].[Construction_Properties] ([Material_ID], [Field_ID], [Materials_Count], [Number_Of_Builders]) VALUES (3, 3, 12, 20)
GO
INSERT [dbo].[Construction_Properties] ([Material_ID], [Field_ID], [Materials_Count], [Number_Of_Builders]) VALUES (4, 4, 10, 15)
GO
INSERT [dbo].[Construction_Properties] ([Material_ID], [Field_ID], [Materials_Count], [Number_Of_Builders]) VALUES (5, 5, 7, 6)
GO
INSERT [dbo].[Construction_Properties] ([Material_ID], [Field_ID], [Materials_Count], [Number_Of_Builders]) VALUES (6, 6, 3, 2)
GO
INSERT [dbo].[Construction_Properties] ([Material_ID], [Field_ID], [Materials_Count], [Number_Of_Builders]) VALUES (7, 7, 9, 4)
GO
INSERT [dbo].[Construction_Properties] ([Material_ID], [Field_ID], [Materials_Count], [Number_Of_Builders]) VALUES (8, 8, 23, 18)
GO
INSERT [dbo].[Construction_Properties] ([Material_ID], [Field_ID], [Materials_Count], [Number_Of_Builders]) VALUES (9, 9, 30, 18)
GO
INSERT [dbo].[Construction_Properties] ([Material_ID], [Field_ID], [Materials_Count], [Number_Of_Builders]) VALUES (10, 10, 100, 35)
GO
INSERT [dbo].[Field_Info] ([Field_ID], [Field_Type], [Field_Size], [Sports_Location], [Field_Support]) VALUES (1, N'Football', 2400, N'Burgas', 3)
GO
INSERT [dbo].[Field_Info] ([Field_ID], [Field_Type], [Field_Size], [Sports_Location], [Field_Support]) VALUES (2, N'Basketball', 750, N'Sofia', NULL)
GO
INSERT [dbo].[Field_Info] ([Field_ID], [Field_Type], [Field_Size], [Sports_Location], [Field_Support]) VALUES (3, N'Volleyball', 600, N'Plovdiv', 1)
GO
INSERT [dbo].[Field_Info] ([Field_ID], [Field_Type], [Field_Size], [Sports_Location], [Field_Support]) VALUES (4, N'Bowling', 125, N'Sofia', NULL)
GO
INSERT [dbo].[Field_Info] ([Field_ID], [Field_Type], [Field_Size], [Sports_Location], [Field_Support]) VALUES (5, N'Football', 2000, N'Pernik', 2)
GO
INSERT [dbo].[Field_Info] ([Field_ID], [Field_Type], [Field_Size], [Sports_Location], [Field_Support]) VALUES (6, N'Volleyball', 700, N'Burgas', 1)
GO
INSERT [dbo].[Field_Info] ([Field_ID], [Field_Type], [Field_Size], [Sports_Location], [Field_Support]) VALUES (7, N'Basketball', 800, N'Varna', NULL)
GO
INSERT [dbo].[Field_Info] ([Field_ID], [Field_Type], [Field_Size], [Sports_Location], [Field_Support]) VALUES (8, N'Football', 2500, N'Pomorie', 4)
GO
INSERT [dbo].[Field_Info] ([Field_ID], [Field_Type], [Field_Size], [Sports_Location], [Field_Support]) VALUES (9, N'Basketball', 825, N'Sofia', 2)
GO
INSERT [dbo].[Field_Info] ([Field_ID], [Field_Type], [Field_Size], [Sports_Location], [Field_Support]) VALUES (10, N'Volleyball', 650, N'Plovdiv', 2)
GO
INSERT [dbo].[Registration] ([Registration_ID]) VALUES (1)
GO
INSERT [dbo].[Registration] ([Registration_ID]) VALUES (2)
GO
INSERT [dbo].[Registration] ([Registration_ID]) VALUES (3)
GO
INSERT [dbo].[Registration] ([Registration_ID]) VALUES (4)
GO
INSERT [dbo].[Registration] ([Registration_ID]) VALUES (5)
GO
INSERT [dbo].[Registration] ([Registration_ID]) VALUES (6)
GO
INSERT [dbo].[Registration] ([Registration_ID]) VALUES (7)
GO
INSERT [dbo].[Registration] ([Registration_ID]) VALUES (8)
GO
INSERT [dbo].[Registration] ([Registration_ID]) VALUES (9)
GO
INSERT [dbo].[Registration] ([Registration_ID]) VALUES (10)
GO
INSERT [dbo].[Store_Products] ([Product_ID], [Delivery_ID], [Material_ID], [Product_Type], [Product_Price], [Product_Quantity]) VALUES (1, 1, 1, N'Football ball', 8.99, 45)
GO
INSERT [dbo].[Store_Products] ([Product_ID], [Delivery_ID], [Material_ID], [Product_Type], [Product_Price], [Product_Quantity]) VALUES (2, 2, 2, N'Football Gloves', 47.99, 123)
GO
INSERT [dbo].[Store_Products] ([Product_ID], [Delivery_ID], [Material_ID], [Product_Type], [Product_Price], [Product_Quantity]) VALUES (3, 3, 3, N'Basketball ball', 29.99, 23)
GO
INSERT [dbo].[Store_Products] ([Product_ID], [Delivery_ID], [Material_ID], [Product_Type], [Product_Price], [Product_Quantity]) VALUES (4, 4, 4, N'Volleyball ball', 6.99, 500)
GO
INSERT [dbo].[Store_Products] ([Product_ID], [Delivery_ID], [Material_ID], [Product_Type], [Product_Price], [Product_Quantity]) VALUES (5, 5, 5, N'Basketball basket', 42, 12)
GO
INSERT [dbo].[Store_Products] ([Product_ID], [Delivery_ID], [Material_ID], [Product_Type], [Product_Price], [Product_Quantity]) VALUES (6, 6, 6, N'Volleyball net', 89.99, 7)
GO
INSERT [dbo].[Store_Products] ([Product_ID], [Delivery_ID], [Material_ID], [Product_Type], [Product_Price], [Product_Quantity]) VALUES (7, 7, 7, N'Football boots', 107.99, 20)
GO
INSERT [dbo].[Store_Products] ([Product_ID], [Delivery_ID], [Material_ID], [Product_Type], [Product_Price], [Product_Quantity]) VALUES (8, 8, 8, N'Football socks', 8, 100)
GO
INSERT [dbo].[Store_Products] ([Product_ID], [Delivery_ID], [Material_ID], [Product_Type], [Product_Price], [Product_Quantity]) VALUES (9, 9, 9, N'Pump', 19.99, 250)
GO
INSERT [dbo].[Store_Products] ([Product_ID], [Delivery_ID], [Material_ID], [Product_Type], [Product_Price], [Product_Quantity]) VALUES (10, 10, 10, N'Captain armband', 9, 45)
GO
INSERT [dbo].[User_Delivery] ([Delivery_ID], [User_ID], [Payment_ID], [Arrival_Date], [Delivery_Status], [Departure_Date], [Delivery_Address]) VALUES (1, 10000001, 1, CAST(N'2022-04-13T08:22:13.000' AS DateTime), N'Ongoing', CAST(N'2022-04-17T18:30:13.000' AS DateTime), N'Graf Ignatiev Str., Sliven')
GO
INSERT [dbo].[User_Delivery] ([Delivery_ID], [User_ID], [Payment_ID], [Arrival_Date], [Delivery_Status], [Departure_Date], [Delivery_Address]) VALUES (2, 10000002, 2, CAST(N'2022-04-14T21:45:54.000' AS DateTime), N'Ongoing', CAST(N'2022-04-18T21:44:54.000' AS DateTime), N'Slavi Trifonov 9, Burgas')
GO
INSERT [dbo].[User_Delivery] ([Delivery_ID], [User_ID], [Payment_ID], [Arrival_Date], [Delivery_Status], [Departure_Date], [Delivery_Address]) VALUES (3, 10000003, 3, CAST(N'2022-04-14T12:14:57.000' AS DateTime), N'Ongoing', CAST(N'2022-04-18T12:12:57.000' AS DateTime), N'Cherkovna 3, Pomorie')
GO
INSERT [dbo].[User_Delivery] ([Delivery_ID], [User_ID], [Payment_ID], [Arrival_Date], [Delivery_Status], [Departure_Date], [Delivery_Address]) VALUES (4, 10000004, 4, CAST(N'2022-04-15T15:31:34.000' AS DateTime), N'Ongoing', CAST(N'2022-04-18T15:30:34.000' AS DateTime), N'Alexander batengerg 6, Plovdiv')
GO
INSERT [dbo].[User_Delivery] ([Delivery_ID], [User_ID], [Payment_ID], [Arrival_Date], [Delivery_Status], [Departure_Date], [Delivery_Address]) VALUES (5, 10000005, 5, CAST(N'2022-04-15T17:32:34.000' AS DateTime), N'Ongoing', CAST(N'2022-04-19T11:29:00.000' AS DateTime), N'Stoyan Stoyanov 2, Varna')
GO
INSERT [dbo].[User_Delivery] ([Delivery_ID], [User_ID], [Payment_ID], [Arrival_Date], [Delivery_Status], [Departure_Date], [Delivery_Address]) VALUES (6, 10000006, 6, CAST(N'2022-04-16T11:11:34.000' AS DateTime), N'Ongoing', CAST(N'2022-04-20T22:30:43.000' AS DateTime), N'Morska 47, Nesebur')
GO
INSERT [dbo].[User_Delivery] ([Delivery_ID], [User_ID], [Payment_ID], [Arrival_Date], [Delivery_Status], [Departure_Date], [Delivery_Address]) VALUES (7, 10000007, 7, CAST(N'2022-04-17T15:45:34.000' AS DateTime), N'Ongoing', CAST(N'2022-04-21T09:20:53.000' AS DateTime), N'Zahari Stoyanov 8, Burgas')
GO
INSERT [dbo].[User_Delivery] ([Delivery_ID], [User_ID], [Payment_ID], [Arrival_Date], [Delivery_Status], [Departure_Date], [Delivery_Address]) VALUES (8, 10000008, 8, CAST(N'2022-04-17T12:34:13.000' AS DateTime), N'Ongoing', CAST(N'2022-04-21T12:30:13.000' AS DateTime), N'General Totev 69, Kableshkovo')
GO
INSERT [dbo].[User_Delivery] ([Delivery_ID], [User_ID], [Payment_ID], [Arrival_Date], [Delivery_Status], [Departure_Date], [Delivery_Address]) VALUES (9, 10000009, 9, CAST(N'2022-04-17T17:57:25.000' AS DateTime), N'Ongoing', CAST(N'2022-04-21T15:05:45.000' AS DateTime), N'Slaveikov 100, Veliko Turnovo')
GO
INSERT [dbo].[User_Delivery] ([Delivery_ID], [User_ID], [Payment_ID], [Arrival_Date], [Delivery_Status], [Departure_Date], [Delivery_Address]) VALUES (10, 10000010, 10, CAST(N'2022-04-18T18:22:31.000' AS DateTime), N'Ongoing', CAST(N'2022-04-22T08:11:31.000' AS DateTime), N'Kamchatka 87, Plovdiv')
GO
INSERT [dbo].[User_Info] ([User_ID], [Registration_ID], [User_Email], [User_Password], [First_Name], [Last_Name], [Phone_Number]) VALUES (10000001, 1, N'IvanS2003@gmail.com', N'Vankata2003', N'Ivan', N'Stoychev', N'084-534-4354')
GO
INSERT [dbo].[User_Info] ([User_ID], [Registration_ID], [User_Email], [User_Password], [First_Name], [Last_Name], [Phone_Number]) VALUES (10000002, 2, N'LGeorgiev99@abv.bg', N'F00tballDaBest', N'Lubomir', N'Georgiev', NULL)
GO
INSERT [dbo].[User_Info] ([User_ID], [Registration_ID], [User_Email], [User_Password], [First_Name], [Last_Name], [Phone_Number]) VALUES (10000003, 3, N'MessiB10@abv.bg', N'G0at!109', N'Stoyan', N'Demirev', NULL)
GO
INSERT [dbo].[User_Info] ([User_ID], [Registration_ID], [User_Email], [User_Password], [First_Name], [Last_Name], [Phone_Number]) VALUES (10000004, 4, N'CherenKotril@gmail.com', N'Gamen932', N'Preslav', N'Yordonov', N'087-874-2347')
GO
INSERT [dbo].[User_Info] ([User_ID], [Registration_ID], [User_Email], [User_Password], [First_Name], [Last_Name], [Phone_Number]) VALUES (10000005, 5, N'SlaviClashers@yahoo.bg', N'ClasherS01_', N'Slavi', N'Panayotov', NULL)
GO
INSERT [dbo].[User_Info] ([User_ID], [Registration_ID], [User_Email], [User_Password], [First_Name], [Last_Name], [Phone_Number]) VALUES (10000006, 6, N'SlovoBg94@abv.bg', N'Literatura940!', N'Kiril', N'Ivanov', N'089-373-3247')
GO
INSERT [dbo].[User_Info] ([User_ID], [Registration_ID], [User_Email], [User_Password], [First_Name], [Last_Name], [Phone_Number]) VALUES (10000007, 7, N'LaptopBG@gmail.com', N'Kupuvai0Be1', N'Georgi', N'Slavov', N'088-972-2398')
GO
INSERT [dbo].[User_Info] ([User_ID], [Registration_ID], [User_Email], [User_Password], [First_Name], [Last_Name], [Phone_Number]) VALUES (10000008, 8, N'LampaFree000@yahoo.com', N'Svetl0MiE', N'Onur', N'Berberov', NULL)
GO
INSERT [dbo].[User_Info] ([User_ID], [Registration_ID], [User_Email], [User_Password], [First_Name], [Last_Name], [Phone_Number]) VALUES (10000009, 9, N'Hristo.asparuhov1@abv.bg', N'IcakaDGt0', N'Hristo', N'Asparuhov', N'088-342-3424')
GO
INSERT [dbo].[User_Info] ([User_ID], [Registration_ID], [User_Email], [User_Password], [First_Name], [Last_Name], [Phone_Number]) VALUES (10000010, 10, N'MarioQkiq@gmail.com', N'Po!0GcapA', N'Mario', N'Stamenov', NULL)
GO
INSERT [dbo].[User_Payment] ([Payment_ID], [Payment_Date], [Payment_Type], [Payment_Costs]) VALUES (1, CAST(N'2022-04-17T18:34:13.000' AS DateTime), N'Debit card', 200.99)
GO
INSERT [dbo].[User_Payment] ([Payment_ID], [Payment_Date], [Payment_Type], [Payment_Costs]) VALUES (2, CAST(N'2022-04-18T21:45:54.000' AS DateTime), N'Cash', 14.99)
GO
INSERT [dbo].[User_Payment] ([Payment_ID], [Payment_Date], [Payment_Type], [Payment_Costs]) VALUES (3, CAST(N'2022-04-18T12:14:57.000' AS DateTime), N'Debit card', 18)
GO
INSERT [dbo].[User_Payment] ([Payment_ID], [Payment_Date], [Payment_Type], [Payment_Costs]) VALUES (4, CAST(N'2022-04-18T15:31:34.000' AS DateTime), N'Debit card', 100)
GO
INSERT [dbo].[User_Payment] ([Payment_ID], [Payment_Date], [Payment_Type], [Payment_Costs]) VALUES (5, CAST(N'2022-04-19T11:30:00.000' AS DateTime), N'Cash', 52.47)
GO
INSERT [dbo].[User_Payment] ([Payment_ID], [Payment_Date], [Payment_Type], [Payment_Costs]) VALUES (6, CAST(N'2022-04-20T22:30:43.000' AS DateTime), N'Debit card', 34.56)
GO
INSERT [dbo].[User_Payment] ([Payment_ID], [Payment_Date], [Payment_Type], [Payment_Costs]) VALUES (7, CAST(N'2022-04-21T09:21:53.000' AS DateTime), N'Cash', 90.99)
GO
INSERT [dbo].[User_Payment] ([Payment_ID], [Payment_Date], [Payment_Type], [Payment_Costs]) VALUES (8, CAST(N'2022-04-21T12:34:13.000' AS DateTime), N'Cash', 45.98)
GO
INSERT [dbo].[User_Payment] ([Payment_ID], [Payment_Date], [Payment_Type], [Payment_Costs]) VALUES (9, CAST(N'2022-04-21T15:07:45.000' AS DateTime), N'Cash', 42)
GO
INSERT [dbo].[User_Payment] ([Payment_ID], [Payment_Date], [Payment_Type], [Payment_Costs]) VALUES (10, CAST(N'2022-04-22T08:12:31.000' AS DateTime), N'Debit card', 567.99)
GO
ALTER TABLE [dbo].[Construction_Properties]  WITH CHECK ADD  CONSTRAINT [FK_Construction_Properties_Field_Info] FOREIGN KEY([Field_ID])
REFERENCES [dbo].[Field_Info] ([Field_ID])
GO
ALTER TABLE [dbo].[Construction_Properties] CHECK CONSTRAINT [FK_Construction_Properties_Field_Info]
GO
ALTER TABLE [dbo].[Store_Products]  WITH CHECK ADD  CONSTRAINT [FK_Store_Products_Construction_Properties] FOREIGN KEY([Material_ID])
REFERENCES [dbo].[Construction_Properties] ([Material_ID])
GO
ALTER TABLE [dbo].[Store_Products] CHECK CONSTRAINT [FK_Store_Products_Construction_Properties]
GO
ALTER TABLE [dbo].[Store_Products]  WITH CHECK ADD  CONSTRAINT [FK_Store_Products_User_Delivery] FOREIGN KEY([Delivery_ID])
REFERENCES [dbo].[User_Delivery] ([Delivery_ID])
GO
ALTER TABLE [dbo].[Store_Products] CHECK CONSTRAINT [FK_Store_Products_User_Delivery]
GO
ALTER TABLE [dbo].[User_Delivery]  WITH CHECK ADD  CONSTRAINT [FK_User_Delivery_User_Info] FOREIGN KEY([User_ID])
REFERENCES [dbo].[User_Info] ([User_ID])
GO
ALTER TABLE [dbo].[User_Delivery] CHECK CONSTRAINT [FK_User_Delivery_User_Info]
GO
ALTER TABLE [dbo].[User_Delivery]  WITH CHECK ADD  CONSTRAINT [FK_User_Delivery_User_Payment] FOREIGN KEY([Payment_ID])
REFERENCES [dbo].[User_Payment] ([Payment_ID])
GO
ALTER TABLE [dbo].[User_Delivery] CHECK CONSTRAINT [FK_User_Delivery_User_Payment]
GO
ALTER TABLE [dbo].[User_Info]  WITH CHECK ADD  CONSTRAINT [FK_User_Info_Registration] FOREIGN KEY([Registration_ID])
REFERENCES [dbo].[Registration] ([Registration_ID])
GO
ALTER TABLE [dbo].[User_Info] CHECK CONSTRAINT [FK_User_Info_Registration]
GO
USE [master]
GO
ALTER DATABASE [Project_Database] SET  READ_WRITE 
GO
