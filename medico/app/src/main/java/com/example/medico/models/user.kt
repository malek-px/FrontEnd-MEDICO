import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
public class user {

    @ColumnInfo(name = "name")
    var name: String? = null

    @ColumnInfo(name = "email")
    var email: String? = null

    @ColumnInfo(name = "password")
    var password: String? = null

    @ColumnInfo(name = "phone")
    var phone: String? = null

    @ColumnInfo(name = "address")
    var address: String? = null

    @ColumnInfo(name = "isAssistant")
    var isAssistant: Boolean? = null

    @ColumnInfo(name = "age")
    var age: String? = null

    @ColumnInfo(name = "bloodType")
    var bloodType: String? = null

    @ColumnInfo(name = "assistantName")
    var assistantName: String? = null

    @ColumnInfo(name = "assistantPhone")
    var assistantPhone: String? = null

    @ColumnInfo(name = "emergencyNum")
    var emergencyNum : String? = null

    fun user() {}
}