package com.ElOuedUniv.maktaba.data.repository

import com.ElOuedUniv.maktaba.R
import com.ElOuedUniv.maktaba.data.model.Category
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor() : CategoryRepository {

    private val _categoriesList = listOf(
        Category(
            id = "1",
            name = "Programming",
            description = "Books about software development and coding",
            iconRes = R.drawable.img_programming
        ),
        Category(
            id = "2",
            name = "Algorithms",
            description = "Books about algorithms and data structures",
            iconRes = R.drawable.img_algorithms
        ),
        Category(
            id = "3",
            name = "Databases",
            description = "Books about database design and management",
            iconRes = R.drawable.img_databases
        ),
        Category(
            id = "4",
            name = "Mobile Development",
            description = "Books about Android and mobile app development",
            iconRes = R.drawable.img_mobile
        ),
        Category(
            id = "5",
            name = "Artificial Intelligence",
            description = "Books about AI, machine learning, and data science",
            iconRes = R.drawable.img_ai
        )
    )

    private val categoriesFlow = MutableSharedFlow<List<Category>>(replay = 1).apply {
        tryEmit(_categoriesList)
    }

    override fun getAllCategories(): Flow<List<Category>> = flow {
        delay(2000)
        emitAll(categoriesFlow)
    }

    override fun getCategoryById(id: String): Category? {
        return _categoriesList.find { it.id == id }
    }
}