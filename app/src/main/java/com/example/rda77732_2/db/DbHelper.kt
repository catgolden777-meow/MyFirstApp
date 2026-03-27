package com.example.rda77732_2.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.rda77732_2.db.PostContract.Columns

class DbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "myfirstapp.db"
        private const val DATABASE_VERSION = 1

        // SQL для создания таблицы
        private val SQL_CREATE_POSTS =
            "CREATE TABLE ${PostContract.TABLE_NAME} (" +
                    "${Columns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${Columns.AUTHOR} TEXT NOT NULL," +
                    "${Columns.AUTHOR_ID} INTEGER NOT NULL," +
                    "${Columns.CONTENT} TEXT NOT NULL," +
                    "${Columns.PUBLISHED} TEXT NOT NULL," +
                    "${Columns.LIKED_BY_ME} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.LIKES} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.SHARES} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.VIEWS} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.VIDEO} TEXT" +
                    ")"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Создаем таблицу при первом запуске
        db.execSQL(SQL_CREATE_POSTS)

        // Здесь можно добавить начальные данные
        insertInitialData(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // При обновлении версии удаляем старую таблицу и создаем новую
        // В реальном проекте здесь должна быть миграция данных
        db.execSQL("DROP TABLE IF EXISTS ${PostContract.TABLE_NAME}")
        onCreate(db)
    }

    private fun insertInitialData(db: SQLiteDatabase) {
        // Вставляем начальные посты для демонстрации
        val contentValues = android.content.ContentValues().apply {
            put(Columns.AUTHOR, "страйкбольный клуб")
            put(Columns.AUTHOR_ID, 2)
            put(Columns.CONTENT, "В продаже новые пули с краской цвета крови")
            put(Columns.PUBLISHED, "Сегодня в 20:45")
            put(Columns.LIKED_BY_ME, 1)
            put(Columns.LIKES, 9999)
            put(Columns.SHARES, 25)
            put(Columns.VIEWS, 5700)
            putNull(Columns.VIDEO)
        }
        db.insert(PostContract.TABLE_NAME, null, contentValues)

        // Второй пост с видео
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Страшные ситуации. Блоги путешествий")
            put(Columns.AUTHOR_ID, 3)
            put(Columns.CONTENT, "Бездомный напал на иностранца и дрался с ним за место у парковки.")
            put(Columns.PUBLISHED, "Вчера в 22:10")
            put(Columns.LIKED_BY_ME, 1)
            put(Columns.LIKES, 15200)
            put(Columns.SHARES, 340)
            put(Columns.VIEWS, 8900)
            put(Columns.VIDEO, "https://www.youtube.com/watch?v=WhWc3b3KhnY")
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Бесполезные товары")
            put(Columns.AUTHOR_ID, 4)
            put(Columns.CONTENT, "Вышел новый релиз чехла на тапочки.")
            put(Columns.PUBLISHED, "2 дня назад в 14:30")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 7200)
            put(Columns.SHARES, 120)
            put(Columns.VIEWS, 4300)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Новости нижнего тагила")
            put(Columns.AUTHOR_ID, 5)
            put(Columns.CONTENT, "Преподователь уснул на теплотрассе и его приняли за бездомного.")
            put(Columns.PUBLISHED, "16 февраля в 9:15")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 11100)
            put(Columns.SHARES, 210)
            put(Columns.VIEWS, 6700)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Блоги сумашедшего")
            put(Columns.AUTHOR_ID, 6)
            put(Columns.CONTENT, "Сегодня будут раздаваться коробки с пропитанием из летающей тарелки.")
            put(Columns.PUBLISHED, "5 дней назад в 11:15")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 0)
            put(Columns.SHARES,1)
            put(Columns.VIEWS, 6)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Android Dev")
            put(Columns.AUTHOR_ID, 7)
            put(Columns.CONTENT, "Вышел новый релиз Android Studio! Теперь с поддержкой Gemini AI и улучшенным композером.")
            put(Columns.PUBLISHED, "13 дня назад в 19:20")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 18400)
            put(Columns.SHARES, 460)
            put(Columns.VIEWS, 11200)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Илон Масленников")
            put(Columns.AUTHOR_ID, 8)
            put(Columns.CONTENT, "Робот нового поколения отправляется искать призраков в заброшку на тесле.")
            put(Columns.PUBLISHED, "Сегодня в 12:40")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 8900)
            put(Columns.SHARES, 210)
            put(Columns.VIEWS, 5100)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Вкусные рецепты")
            put(Columns.AUTHOR_ID, 9)
            put(Columns.CONTENT, "Когда я приготовила эту кашу из нефти все мои гости умерли от пищевого отравления.")
            put(Columns.PUBLISHED, "Вчера в 23:10")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 13700)
            put(Columns.SHARES, 380)
            put(Columns.VIEWS, 8900)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Обстановка на юге")
            put(Columns.AUTHOR_ID, 10)
            put(Columns.CONTENT, "Дубайскую войну прошла молодая девушка которая работала в клубе где занимаются...")
            put(Columns.PUBLISHED, "6 дней назад в 16:30")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 9500)
            put(Columns.SHARES, 210)
            put(Columns.VIEWS, 6200)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Нелегальные застройки")
            put(Columns.AUTHOR_ID, 11)
            put(Columns.CONTENT, "Молодой человек поселился жить в гараже и умер от выхлопных газов в закрытом помещении.")
            put(Columns.PUBLISHED, "Вчера в 10:00")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 4100)
            put(Columns.SHARES, 160)
            put(Columns.VIEWS, 2800)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
    }
}
