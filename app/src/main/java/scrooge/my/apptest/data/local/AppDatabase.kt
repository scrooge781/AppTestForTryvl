package scrooge.my.apptest.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import scrooge.my.apptest.data.local.specialist.SpecialistDao
import scrooge.my.apptest.data.local.speciality.SpecialityDao
import scrooge.my.apptest.data.model.Specialist
import scrooge.my.apptest.data.model.Specialty

@Database(entities = [Specialist::class, Specialty::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun specialistDao(): SpecialistDao
    abstract fun specialityDao(): SpecialityDao

    companion object {
        private const val DATABASE_NAME = "app_db"

        fun instance(context: Context): AppDatabase {
            return Room
                .databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
        }
    }
}