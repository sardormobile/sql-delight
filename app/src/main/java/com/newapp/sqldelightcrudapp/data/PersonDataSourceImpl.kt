package com.newapp.sqldelightcrudapp.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.newapp.sqldelightcrudapp.MbAppDatabase
import crudapp.uzmbappdb.PersonEntity
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class PersonDataSourceImpl(
    db: MbAppDatabase
): PersonDataSource {

    private val queries = db.personEntityQueries

    override suspend fun getPersonById(id: Long): PersonEntity? {
        return withContext(IO) {
            queries.getPersonById(id).executeAsOneOrNull()
        }
    }

    override fun getAllPersons(): Flow<List<PersonEntity>> {
        return queries.getAllPerson().asFlow().mapToList(IO)
    }

    override suspend fun deletePersonById(id: Long) {
        withContext(IO) {
            queries.deletePersonById(id)
        }
    }

    override suspend fun insertPerson(firstName: String, lastName: String, id: Long?) {
        withContext(IO) {
            queries.insertPerson(id, firstName, lastName)
        }
    }

}