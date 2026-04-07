package io.alron.vkeducationproject.data.source.local.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL(
            "ALTER TABLE app_details ADD COLUMN isInWishlist INTEGER NOT NULL DEFAULT 0"
        )
    }
}