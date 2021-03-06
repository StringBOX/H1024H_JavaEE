package silly.h1024h.dao

import org.apache.commons.dbutils.handlers.BeanListHandler
import silly.h1024h.base.BaseDao
import silly.h1024h.entity.User
import java.sql.SQLException


class UserDao : BaseDao() {
    fun updatePwd(account: String, password: String): Boolean {
        try {
            val sql = "UPDATE user SET password='$password' WHERE account='$account';"
            getQueryRunner().update(sql)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            System.out.println(e)
        }
        return false
    }

    fun saveEmail(account: String, email: String): Boolean {
        try {
            val sql = "UPDATE user SET email='$email' WHERE account='$account';"
            getQueryRunner().update(sql)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            System.out.println(e)
        }
        return false
    }

    fun updateToken(account: String, token: String): Boolean {
        try {
            val sql = "UPDATE user SET token='$token' WHERE account='$account';"
            getQueryRunner().update(sql)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            System.out.println(e)
        }
        return false
    }

    fun findByName(account: String): List<User> {
        try {
            val sql = "SELECT * FROM user WHERE account='$account'"
            return getQueryRunner().query(sql, BeanListHandler<User>(User::class.java))
        } catch (e: SQLException) {
            e.printStackTrace()
            System.out.println(e)
        }
        return arrayListOf()
    }

    fun saveUser(params: Array<Any>): Boolean {
        try {
            val sql = "INSERT INTO user ( _id, account, password, email, create_time, token ) VALUES ( null, ${params[0]}, ${params[1]}, '', ${params[2]}, ${params[3]} );"
            getQueryRunner().update(sql)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            System.out.println(e)
        }
        return false
    }

}