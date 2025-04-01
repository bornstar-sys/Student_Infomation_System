package com.example.studentinfo

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DBConnection {
    private const val URL = "jdbc:mysql://192.168.1.1:3306/student_db"
    private const val USER = "newAdmin"  // Or "newUser" for User access
    private const val PASSWORD = "admin123"  // Or "user123" for User access

    fun getConnection(): Connection? {
        return try {
            Class.forName("com.mysql.cj.jdbc.Driver")
            DriverManager.getConnection(URL, USER, PASSWORD)
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
            null
        }
    }
}
