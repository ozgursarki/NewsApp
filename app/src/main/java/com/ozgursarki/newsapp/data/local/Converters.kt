package com.ozgursarki.newsapp.data.local

import androidx.room.TypeConverter
import com.ozgursarki.newsapp.model.everything.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}